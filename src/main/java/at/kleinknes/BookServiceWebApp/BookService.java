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
	public List<Book> find(String title) {

		List<Book> data = null;


		try {
			data = em.createNamedQuery("Book.find", Book.class).setParameter("search", title).getResultList();
		} catch (Exception ex) {
			System.err.println("Book not found: " + title + "	Cause: " + ex.getMessage());
		}


		return data;
	}

	public List<Book> search(String title) {

		List<Book> data = null;


		try {
			data = em.createNamedQuery("Book.find", Book.class).setParameter("search", "%" + title + "%").getResultList();
		} catch (Exception ex) {
			System.err.println("Book not found: " + title + "	Cause: " + ex.getMessage());
		}


		return data;
	}

	public void CheckAndLook(Book book, boolean should) throws Exception {
		verifyBook(book);

		List<Book> findlist = find(book.getTitle());

		if (findlist == null) {
			if (!should) {
				return;
			}
			throw new Exception("book does not exist");
		}

		for(Book find : findlist){
			if (find.equals(book)) {
				if (!should) throw new Exception("book already exists");
				return;
			}
		}

		if (should) throw new Exception("book does not exists");
	}


	public String saveBooks(List<Book> books) {

		try {
			for (Book book : books) {

				CheckAndLook(book, false);

				List<Author> dbAuthors = new ArrayList<>();

				for (Author author : book.getAuthors()) {
					Author find = authorService.find(author.getFirstname(), author.getLastname(), author.getBirthdate()).get(0);
					dbAuthors.add(find);
				}

				book.setAuthors(dbAuthors);

				System.out.println(book.getPublisher().getName());

				book.setPublisher(publisherService.find(book.getPublisher().getName(), book.getPublisher().getPostcode(), book.getPublisher().getCountrycode()).get(0));


				em.persist(book);


			}
		} catch (Exception e) {
		//	e.printStackTrace();
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

}
