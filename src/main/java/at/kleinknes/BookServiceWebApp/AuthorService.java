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
			checkValue(author.getID());
			checkValue(author.getFirstName());
			checkValue(author.getSecondName());

			return true;
		} catch (Exception ex) {
			return false;
		}
	}


	public List<Author> getAllAuthors() {
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
