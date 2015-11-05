package at.kleinknes.BookServiceWebApp;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class BookService {
	@PersistenceContext
	private EntityManager em;

	public boolean saveBooks(Object book) {

		List<Book> books;

		if (book instanceof Book) {
			// we have only on book
			books = new ArrayList<>();
			books.add((Book) book);
		} else if (book instanceof List) {
			// we have a list of books
			books = (List<Book>) book;
		} else {
			// invalid data
			return false;
		}

		for (Book n : books) {
			if (n.getTitle() == null) return false;
			if (n.getDate() == null) return false;
		}


		Session session = (Session) em.getDelegate();
		Transaction tx = session.beginTransaction();

		try {
			session.persist(book);
		} catch (Exception e) {
			tx.rollback();
			return false;
		}

		tx.commit();

		return true;
	}


	public List<Book> getAllBooks() {
		return em.createNamedQuery("Book.selectAll", Book.class).getResultList();
	}

	public List<Book> searchBooks(String title) {
		return em.createNamedQuery("Book.searchAll", Book.class).setParameter("search", "%" + title + "%").getResultList();
	}

}
