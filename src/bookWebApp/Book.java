package bookWebApp;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="t_book")
@NamedQuery(name="Book.selectAll", query="SELECT n FROM Book n")
public class Book 
{
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long bookID = null;
	private String title = null;
	private Date pubYear = null;
	
	public Book()
	{
		
	}
	
	public Book(String first, Date sec)
	{
		title = first;
		pubYear = sec;
	}
	
	public Book(Long newsDD, String first, Date sec)
	{
		bookID = newsDD;
		title = first;
		pubYear = sec;
	}
	
	public Long getID()
	{
		return bookID;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public Date getDate()
	{
		return pubYear;
	}
	
	public void setID(Long newID)
	{
		bookID = newID;
	}
	
	public void setTitle(String newTitle)
	{
		title = newTitle;
	}
	
	public void setDate(Date newText)
	{
		pubYear = newText;
	}
	
}