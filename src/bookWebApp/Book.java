package bookWebApp;

import javax.persistence.*;
import java.util.Date;

@Entity
<<<<<<< HEAD
@Table(name="t_book")
@NamedQuery(name="Book.selectAll", query="SELECT n FROM Book n")
public class Book 
{
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Book_ID")
=======
@Table(name = "t_book")
@NamedQuery(name = "Book.selectAll", query = "SELECT n FROM Book n")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
>>>>>>> c936f2cf73e43644b9543f24541f79cbfaa247b4
	private Long bookID = null;
	@Column(name="Title")
	private String title = null;
	@Column(name="ReleaseDate")
	private Date pubYear = null;
<<<<<<< HEAD
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="AUTH_ID")
	private Publisher myBooks;
	
	public Book()
	{
		
=======

	public Book() {

>>>>>>> c936f2cf73e43644b9543f24541f79cbfaa247b4
	}

	public Book(String first, Date sec) {
		title = first;
		pubYear = sec;
	}

	public Book(Long newsDD, String first, Date sec) {
		bookID = newsDD;
		title = first;
		pubYear = sec;
	}

	public Long getID() {
		return bookID;
	}

	public void setID(Long newID) {
		bookID = newID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String newTitle) {
		title = newTitle;
	}

	public Date getDate() {
		return pubYear;
	}

	public void setDate(Date newText) {
		pubYear = newText;
	}

}
