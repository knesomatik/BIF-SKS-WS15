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
}
