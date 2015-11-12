package at.kleinknes.BookServiceWebApp;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PublisherService {
	@PersistenceContext
	private EntityManager em;

	public List<Publisher> getAllPublishers() {
		return em.createNamedQuery("Publisher.selectAll", Publisher.class).getResultList();
	}

	public Publisher getPublisher(Long id) {
		return em.find(Publisher.class, id);
	}

	public Publisher addPublisher(String name, Long postcode, String countrycode) {
		Publisher a = new Publisher();
		a.setName(name);
		a.setPost(postcode);
		a.setCode(countrycode);
		em.persist(a);
		return a;
	}

	public Publisher updatePublisher(Long id, String name, Long postcode, String countrycode) {
		Publisher a = em.find(Publisher.class, id);
		a.setName(name);
		a.setPost(postcode);
		a.setCode(countrycode);
		em.persist(a);
		return a;
	}

	public Publisher removePublisher(Long id) {
		Publisher a = em.find(Publisher.class, id);
		em.remove(a);
		return a;
	}
}
