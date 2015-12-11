package at.kleinknes.BookServiceWebApp;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class AuthorService {
	@PersistenceContext
	private EntityManager em;

	@Inject
	private PublisherService pubService;

	@Inject
	private AuthorService authService;

	private void checkValue(Object o) throws Exception {
		if (o != null && !o.equals(0) && !o.equals("")) return;
		throw new Exception();
	}

	public boolean verifyAuthor(Author author) {

		try {
			checkValue(author.getFirstname());
			checkValue(author.getLastname());

			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public Author findFirst(String firstname, String lastname) {
		Author data = null;
		try {
			data = em.createNamedQuery("Author.findFirst", Author.class).setParameter("firstname", firstname).setParameter("lastname", lastname).getResultList().get(0);
		} catch (Exception ex) {
			ex.printStackTrace();
			System.err.println("Author not found: " + firstname + " " + lastname);
		}
		return data;
	}

	public List<Author> getAllAuthors() {
		return em.createNamedQuery("Author.selectAll", Author.class).getResultList();
	}

	public Author getAuthor(Long id) {
		return em.find(Author.class, id);
	}

	public Author addAuthor(String firstname, String lastna) {
		Author a = new Author();
		a.setFirstname(firstname);
		a.setLastname(lastna);
		em.persist(a);
		return a;
	}

	public Author updateAuthor(Long id, String firstname, String secondname) {
		Author a = em.find(Author.class, id);
		a.setFirstname(firstname);
		a.setLastname(secondname);
		em.persist(a);
		return a;
	}

	public Author removeAuthor(Long id) {
		Author a = em.find(Author.class, id);
		em.remove(a);
		return a;
	}
}
