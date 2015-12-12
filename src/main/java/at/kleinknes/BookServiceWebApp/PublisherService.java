package at.kleinknes.BookServiceWebApp;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PublisherService {
	@PersistenceContext
	private EntityManager em;

	@Inject
	private PublisherService pubService;

	@Inject
	private AuthorService authService;

	public void verifyPublisher(Publisher publisher) throws Exception {
		Common.checkValue(publisher.getName(), "publisher name");
		Common.checkValue(publisher.getPostcode(), "publisher postcode");
		Common.checkValue(publisher.getCountrycode(), "publisher contrycode");
	}

	public void CheckAndLook(Publisher publisher, boolean should) throws Exception {
		verifyPublisher(publisher);

		Publisher find = findFirst(publisher.getName());

		if (find == null) {
			if (!should) {
				return;
			}
			throw new Exception("publisher does not exist");
		}

		if (find.equals(publisher)) {
			if (should) return;
			throw new Exception("publisher already exists");
		}

		if (should) throw new Exception("publisher does not exist");
	}

	public List<Publisher> getAllPublishers() {
		return em.createNamedQuery("Publisher.selectAll", Publisher.class).getResultList();
	}

	public Publisher getPublisher(Long id) {
		return em.find(Publisher.class, id);
	}

	public Publisher findFirst(String name) {
		Publisher data = null;
		try {
			data = em.createNamedQuery("Publisher.findFirst", Publisher.class).setParameter("name", name).getResultList().get(0);
		} catch (Exception ex) {
			System.err.println("Publisher not found: " + name);
		}
		return data;
	}

	public Publisher addPublisher(Publisher pub) throws Exception {
		CheckAndLook(pub, false);
		em.persist(pub);
		return pub;
	}

	public Publisher updatePublisher(Publisher pub) throws Exception {
		CheckAndLook(pub, true);
		em.persist(pub);
		return pub;
	}

	public Publisher removePublisher(Long id) throws Exception {
		Publisher a = em.find(Publisher.class, id);
		em.remove(a);
		return a;
	}
}
