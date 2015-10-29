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

	public void removeNews(Long id) {
		Book newS = em.find(Book.class, id);
		em.remove(newS);
	}

	public boolean saveBooks(Object book) {

		List<Book> books;

		if (book instanceof Book) {
			// we have only on book
			books = new ArrayList<Book>();
			books.add((Book) book);
		} else if (book instanceof List) {
			// we have a list of books
			books = (List<Book>) book;
		} else {
			// invalid data
			return false;
		}

		for (Book n : books) {
			assert n.getTitle() != null;
			assert n.getDate() != null;
		}


		Session session = (Session) em.getDelegate();
		Transaction tx = null;
		tx = session.getTransaction();
		tx.begin();

		try {
			session.persist(book);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			return false;
		}

		return true;
	}


	public List<Book> getAllBooks() {
		return em.createNamedQuery("Book.selectAll", Book.class).getResultList();
	}

	public List<Book> searchBooks(String title) {
		return em.createNamedQuery("Book.searchAll", Book.class).setParameter("search", "%" + title + "%").getResultList();
	}

	public void alterText(String first) {
		List<Book> list = em.createNamedQuery("Book.selectAll", Book.class).getResultList();

		int count = 0;
		for (Book n : list) {
			n.setTitle(first + count);
			count++;
		}
	}


}
