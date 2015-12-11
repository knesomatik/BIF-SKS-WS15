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
	private AuthorService authService;

	private void checkValue(Object o) throws Exception {
		if (o != null && !o.equals(0) && !o.equals("")) return;
		throw new Exception();
	}

	public boolean verifyPublisher(Publisher publisher) {

		try {
<<<<<<< HEAD
			checkValue(publisher.getCountrycode());
=======
>>>>>>> 4ea4b75e1cc830f55657c12a80416b08abf8a0ee
			checkValue(publisher.getName());
			System.err.println("PUBLISHER NAME:" + publisher.getName());
			checkValue(publisher.getPostcode());
			System.err.println("PUBLISHER CODE:" + publisher.getPostcode());

			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public List<Publisher> getAllPublishers() {
		return em.createNamedQuery("Publisher.selectAll", Publisher.class).getResultList();
	}

	public Publisher getPublisher(Long id) {
		return em.find(Publisher.class, id);
	}

	public Publisher findFirst(String name) {
<<<<<<< HEAD
		Publisher data = null;
		try {
			data = em.createNamedQuery("Publisher.findFirst", Publisher.class).setParameter("name", name).getResultList().get(0);
		} catch (Exception ex) {
			System.err.println("Publisher not found: " + name);
		}

		return data;
	}

	public Publisher addPublisher(String name, Long postcode, String countrycode) {
=======
		return em.createNamedQuery("Publisher.findFirst", Publisher.class).setParameter("queryname", name).getResultList().get(0);
	}


	public Publisher addPublisher(String name) {
		Publisher a = new Publisher();
		a.setName(name);
		a.setPostcode("123");
		a.setCountrycode("123");
		em.persist(a);
		return a;
	}

	public Publisher addPublisher(String name, String postcode, String countrycode) {
>>>>>>> 4ea4b75e1cc830f55657c12a80416b08abf8a0ee
		Publisher a = new Publisher();
		a.setName(name);
		a.setPostcode(postcode);
		a.setCountrycode(countrycode);
		em.persist(a);
		return a;
	}

	public Publisher updatePublisher(Long id, String name, String postcode, String countrycode) {
		Publisher a = em.find(Publisher.class, id);
		a.setName(name);
		a.setPostcode(postcode);
		a.setCountrycode(countrycode);
		em.persist(a);
		return a;
	}

	public Publisher removePublisher(Long id) {
		Publisher a = em.find(Publisher.class, id);
		em.remove(a);
		return a;
	}
}
