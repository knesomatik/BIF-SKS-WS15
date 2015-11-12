package at.kleinknes.BookServiceWebApp;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PublisherService {
    @PersistenceContext
    private EntityManager em;

    public List<Publisher> getAllPublishers() {
        return em.createNamedQuery("Publisher.selectAll", Publisher.class).getResultList();
    }
}
