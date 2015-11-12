package at.kleinknes.BookServiceWebApp;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class AuthorService {
	@PersistenceContext
	private EntityManager em;

	public List<Author> getAllAuthors() {
		addAuthor("test", "test");

		return em.createNamedQuery("Author.selectAll", Author.class).getResultList();
	}

	public Author getAuthor(Long id) {
		return em.find(Author.class, id);
	}

	public Author addAuthor(String firstname, String secondname) {
		Author a = new Author();
		a.setFirstName(firstname);
		a.setSecondName(secondname);
		em.persist(a);
		return a;
	}

	public Author updateAuthor(Long id, String firstname, String secondname) {
		Author a = em.find(Author.class, id);
		a.setFirstName(firstname);
		a.setSecondName(secondname);
		em.persist(a);
		return a;
	}

	public Author removeAuthor(Long id) {
		Author a = em.find(Author.class, id);
		em.remove(a);
		return a;
	}
}
