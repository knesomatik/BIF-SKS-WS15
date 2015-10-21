package bookWebApp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_book")
@NamedQuery(name = "Book.selectAll", query = "SELECT n FROM Book n")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Book_ID")
	private Long bookID = null;
	@Column(name="Title")
	private String title = null;
	@Column(name="ReleaseDate")
	private Date pubYear = null;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="AUTH_ID")
	private Publisher myBooks;

	public Book()
	{

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
