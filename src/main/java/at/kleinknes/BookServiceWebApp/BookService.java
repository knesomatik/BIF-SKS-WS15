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
		if (o != null && !o.equals(0) && !o.equals("")) return;
		throw new Exception();
	}

	public boolean verifyBook(Book book) {

		try {
			checkValue(book.getAuthors());
			checkValue(book.getID());
			checkValue(book.getTitle());
			checkValue(book.getPublisher());

			if (!publisherService.verifyPublisher(book.getPublisher())) return false;
			if (publisherService.getPublisher(book.getPublisher().getID()) == null) return false;

			for (Author author : book.getAuthors()) {
				if (!authorService.verifyAuthor(author)) return false;

				if (authorService.getAuthor(author.getID()) == null) return false;
			}

			return true;
		} catch (Exception ex) {
			return false;
		}

	}

	public String saveBooks(List<Book> books) {

		try {
			for (Book book : books) {
				if (!verifyBook(book)) return "invalid data";
			}

			books.forEach(em::persist);
		}catch (Exception e){
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
