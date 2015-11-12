package at.kleinknes.BookServiceWebApp;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AuthorService {
    @PersistenceContext
    private EntityManager em;

    public List<Author> getAllAuthors() {
        return em.createNamedQuery("Author.selectAll", Author.class).getResultList();
    }
}
