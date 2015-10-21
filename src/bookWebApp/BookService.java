package bookWebApp;

import java.util.*;

import javax.ejb.*;
import javax.persistence.*;

@Stateless
public class BookService 
{
	@PersistenceContext
	private EntityManager em;
	
	public void removeNews(Long id)
	{
		Book newS = em.find(Book.class, id);
		em.remove(newS);
	}
	
	
	public List<Book> getAllBooks()
	{
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
