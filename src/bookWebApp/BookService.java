package bookWebApp;

import java.util.*;

import javax.ejb.*;
import javax.persistence.*;

@Stateless
//@TransactionManagement(TransactionManagementType.CONTAINER)
public class BookService 
{
	@PersistenceContext
	private EntityManager em;
	
	//@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void removeNews(Long id)
	{
		Book newS = em.find(Book.class, id);
		em.remove(newS);
	}
	
	
	public List<Book> getAllNews()
	{
		/*List<News> news = Arrays.asList(new News("title1", "text1"), 
										new News ("title2","text2"), 
										new News ("title3","text3"));
		return news;
		*/
		
		/*
		News n = new News();
		em.persist(n);
		n.setText("bla bla bla");
		//em.detach(n);
		
		News n2 = new News();
		em.persist(n2);
		*/
		return em.createNamedQuery("Book.selectAll", Book.class).getResultList();
	}
	
	public void alterText(String first)
	{
		List<Book> list = em.createNamedQuery("Book.selectAll", Book.class).getResultList();
		
		int count = 0;
		for(Book n : list)
		{
			n.setTitle(first+count);
			count++;
		}
	}
	
	
}
