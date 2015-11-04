package at.kleinknes.BookServiceWebApp;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "t_book")
@NamedQueries({
		@NamedQuery(name = "Book.selectAll", query = "SELECT n FROM Book n"),
		//@NamedQuery(name = "Book.searchAll", query = "SELECT n FROM Book n WHERE lower(n.title) LIKE lower(:search)")
})
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Book_ID")
	private Long bookID = null;
	@Column(name = "Title")
	private String title = null;
	@Column(name = "ReleaseDate")
	private LocalDate pubYear = null;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AUTH_ID")
	private Publisher myBooks;

	public Book() {

	}

	public Book(String first, LocalDate sec) {
		title = first;
		pubYear = sec;
	}

	public Book(Long newsDD, String first, LocalDate sec) {
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

	public LocalDate getDate() {
		return pubYear;
	}

	public void setDate(LocalDate newText) {
		pubYear = newText;
	}

}
