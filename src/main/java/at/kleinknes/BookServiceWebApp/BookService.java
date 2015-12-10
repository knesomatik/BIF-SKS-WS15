package at.kleinknes.BookServiceWebApp;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class BookService {
	@PersistenceContext
	private EntityManager em;

	@Inject
	private PublisherService publisherService;

	@Inject
	private AuthorService authorService;


	private void checkValue(Object o) throws Exception {
		if (o != null && !o.equals(0) && !o.equals("")) {
			return;
		}
		System.err.println("BOOK CHECK: MISSING VALUES");
		throw new Exception("BOOK CHECK: MISSING VALUES");
	}

	public boolean verifyBook(Book book) {

		try {
			System.err.println("Trying book");
			checkValue(book.getAuthors());
			System.err.println("Authors" + book.getAuthors().toString());
			checkValue(book.getTitle());
			System.err.println("Title" + book.getTitle());
			checkValue(book.getPublisher());
			System.err.println("Publisher" + book.getPublisher().toString());

			if (!publisherService.verifyPublisher(book.getPublisher())) {
				System.err.println("BOOK IMPORT: PUBLISHER INVALID");
				return false;
			}

			if (publisherService.findFirst(book.getPublisher().getName()) == null) {
				System.err.println("BOOK IMPORT: PUBLISHER ID NULL");
				return false;
			}

			for (Author author : book.getAuthors()) {
				if (!authorService.verifyAuthor(author)) {
					System.err.println("BOOK IMPORT: AUTHOR INVALID");
					return false;
				}

				if (authorService.getAuthor(author.getAuthID()) == null) {
					System.err.println("BOOK IMPORT: AUTHOR ID NULL");
					return false;
				}
			}

			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			System.err.println("BOOK IMPORT: " + ex.getMessage());
			return false;
		}

	}

	public String saveBooks(List<Book> books) {

		try {
			for (Book book : books) {
				if (!verifyBook(book)) return "invalid data";
			}

			books.forEach(em::persist);
		} catch (Exception e) {
			return "error " + e.getMessage();
		}

		return "success";
	}


	public List<Book> getAllBooks() {
		return em.createNamedQuery("Book.selectAll", Book.class).getResultList();
	}

	public List<Book> searchBooks(String title) {
		return em.createNamedQuery("Book.searchAll", Book.class).setParameter("search", "%" + title + "%").getResultList();
	}

}
