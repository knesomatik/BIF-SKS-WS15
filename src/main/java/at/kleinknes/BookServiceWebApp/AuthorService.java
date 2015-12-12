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

	public void verifyAuthor(Author author) throws Exception{
		Common.checkValue(author.getFirstname(), "author firstname");
		Common.checkValue(author.getLastname(), "author lastname");
		Common.checkValue(author.getBirthdate(), "author birthdate");
	}

	public void CheckAndLook(Author author, boolean should) throws Exception{
		verifyAuthor(author);

		Author find = findFirst(author.getFirstname(), author.getLastname());

		if(find == null){
			if(!should){
				return;
			}
			throw new Exception("author does not exist");
		}

		if(find.equals(author)){
			if(!should) throw new Exception("author already exists");
			return;
		}

		if(should) throw new Exception("author does not exists");
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

	public Author addAuthor(Author a) throws Exception{
		CheckAndLook(a, false);
		em.persist(a);
		return a;
	}

	public Author updateAuthor(Author a) throws Exception{
		CheckAndLook(a, true);
		em.persist(a);
		return a;
	}

	public Author removeAuthor(Long id) throws Exception{
		Author a = em.find(Author.class, id);
		em.remove(a);
		return a;
	}
}
