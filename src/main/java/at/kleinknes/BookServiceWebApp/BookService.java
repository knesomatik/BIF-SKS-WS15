package at.kleinknes.BookServiceWebApp;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class BookService {
	@PersistenceContext
	private EntityManager em;

	@Inject
	private PublisherService publisherService;

	@Inject
	private AuthorService authorService;

	public void verifyBook(Book book) throws Exception {
		Common.checkValue(book.getIsbn(), "book isbn");
		Common.checkValue(book.getTitle(), "book title");
		Common.checkValue(book.getSubtitle(), "book subtitle");
		Common.checkValue(book.getDescription(), "book description");
		Common.checkValue(book.getPages(), "book pages");
		Common.checkValue(book.getLanguage(), "book language");
		Common.checkValue(book.getPublisher(), "book publisher");
		Common.checkValue(book.getAuthors(), "book authors");

		publisherService.verifyPublisher(book.getPublisher());
		publisherService.CheckAndLook(book.getPublisher(), true);


		for (Author author : book.getAuthors()) {
			authorService.CheckAndLook(author, true);
		}
	}

	public Book findFirst(String title) {
		Book data = null;
		try {
			data = em.createNamedQuery("Book.searchAll", Book.class).setParameter("search", title).getResultList().get(0);
		} catch (Exception ex) {
			System.err.println("Book not found: " + title);
		}
		return data;
	}

	public void CheckAndLook(Book book, boolean should) throws Exception {
		verifyBook(book);

		Book find = findFirst(book.getTitle());

		if (find == null) {
			System.out.println("BOOK NOT FOUND WHAT");
			if (!should) {
				return;
			}
			throw new Exception("book does not exist");
		}

		System.out.println("BOOK IS FOUND");

		if (find.equals(book)) {
			if (!should) throw new Exception("book already exists");
			return;
		}

		if (should) throw new Exception("book does not exists");
	}


	public String saveBooks(List<Book> books) {

		try {
			for (Book book : books) {

				CheckAndLook(book, false);

				List<Author> dbAuthors = new ArrayList<>();

				for (Author author : book.getAuthors()) {
					dbAuthors.add(authorService.findFirst(author.getFirstname(), author.getLastname()));
				}

				book.setAuthors(dbAuthors);

				book.setPublisher(publisherService.findFirst(book.getPublisher().getName()));

				em.persist(book);

			}
		} catch (Exception e) {
			return "error " + e.getMessage();
		}

		return "success";
	}


	public List<Book> getAllBooks() {
		List<Book> data = null;
		try {
			data = em.createNamedQuery("Book.selectAll", Book.class).getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return data;
	}

	public List<Book> searchBooks(String title) {
		return em.createNamedQuery("Book.searchAll", Book.class).setParameter("search", "%" + title + "%").getResultList();
	}

}
