package bookWebApp;

import javax.persistence.*;

@Entity
@Table(name="t_book")
@NamedQuery(name="Book.selectAll", query="SELECT n FROM Book n")
public class Book 
{
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long newsID = null;
	private String title = null;
	private String text = null;
	
	public Book()
	{
		
	}
	
	public Book(String first, String sec)
	{
		title = first;
		text = sec;
	}
	
	public Book(Long newsDD, String first, String sec)
	{
		newsID = newsDD;
		title = first;
		text = sec;
	}
	
	public Long getID()
	{
		return newsID;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public String getText()
	{
		return text;
	}
	
	public void setID(Long newID)
	{
		newsID = newID;
	}
	
	public void setTitle(String newTitle)
	{
		title = newTitle;
	}
	
	public void setText(String newText)
	{
		text = newText;
	}
	
}