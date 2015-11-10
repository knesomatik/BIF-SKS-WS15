package at.kleinknes.BookServiceWebApp;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class BookService {
	@PersistenceContext
	private EntityManager em;
	
	@Inject
	private PublisherService pubService;
	private List<Publisher> pubList;
	
	@Inject
	private AuthorService authService;
	private List<Author> authList;

	public String saveBooks(List<Book> books) {
		
		if(authList == null){
			authList = authService.getAllAuthors();
		}
		
		if(pubList == null){
			pubList = pubService.getAllPublishers();
		}
		
		if(checkDB(books)){
			books.forEach(em::persist);
			return "Everything OK";
		}
		else{
			return "ERROR inserting Books in DB";
		}
	}


	public List<Book> getAllBooks() {
		return em.createNamedQuery("Book.selectAll", Book.class).getResultList();
	}

	public List<Book> searchBooks(String title) {
		return em.createNamedQuery("Book.searchAll", Book.class).setParameter("search", "%" + title + "%").getResultList();
	}
	
	public Boolean checkDB(List<Book> books) {
        Boolean goOn = true;
        Long ID = 0L;
        int index = 0;
        for (Book b : books) {
        	
        	 for (Publisher pubDB : pubList) {
                 if (pubDB.eqauls(b.getPublisher())) {
                	 ID = pubDB.getID();
                 }
                 else{
                	 ID = 0L;
                 }
             }
        	
            if (ID == 0L) {
            	goOn = false;
                break;
            } else {
                b.getPublisher().setID(ID);
            }
            for (Author auth : b.getAuthors()) {
            	ID = authCheck(auth);
                if (ID == 0L) {
                	goOn = false;
                    break;
                } else {
                    b.getAuthors().get(index).setID(ID);
                }
                index++;
            }
            index = 0;
        }
        return goOn;
    }

    private Long authCheck(Author auth) {
        Long found = 0L;

        for (Author authDB : authList) {
            if (authDB.eqauls(auth)) {
                found = authDB.getID();
                break;
            }
        }
        return found;
    }
}
