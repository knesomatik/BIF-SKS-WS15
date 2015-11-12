package at.kleinknes.BookServiceWebApp;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

import java.util.List;

@Entity
@Table(name = "t_book")
@XmlRootElement(name = "book")
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
		@NamedQuery(name = "Book.selectAll", query = "SELECT n FROM Book n"),
		@NamedQuery(name = "Book.searchAll", query = "SELECT n FROM Book n WHERE lower(n.title) LIKE lower(:search)")
})
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlTransient
	private Long bookID = null;
	@XmlAttribute
	private String isbn = null;
	@XmlAttribute
	private String title = null;
	@XmlAttribute
	private String subtitle = null;
	@XmlAttribute
	private String description = null;
    @XmlAttribute
    private int pages;
    @XmlAttribute
	private String language = null;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
            name="t_book_author",
            joinColumns ={@JoinColumn(name="Book_ID", referencedColumnName="bookID")},
            inverseJoinColumns = {@JoinColumn(name = "Author_ID",referencedColumnName = "authID")}
    )
    @XmlElementWrapper(name = "authors")
    @XmlElement(name = "author")
    private List<Author> authors;
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="PUB_ID")
    @XmlElement
    private Publisher publisher;
	
	public Book() {

	}

	public Book(String first) {
		title = first;
	}

	public Book(String newsDD, String first) {
		isbn = newsDD;
		title = first;
	}
	
	public Book(String newsDD, String first, int temp) {
		isbn = newsDD;
		title = first;
		pages = temp;
	}
	
	public Book(Long ID, String newsDD, String first) {
		bookID = ID;
		isbn = newsDD;
		title = first;
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
	
	public String getSub() {
		return subtitle;
	}

	public void setSub(String newTitle) {
		subtitle = newTitle;
	}
	
	public String getDes() {
		return description;
	}

	public void setDes(String newTitle) {
		description = newTitle;
	}
	
	public String getLang() {
		return language;
	}

	public void setLang(String newTitle) {
		language = newTitle;
	}
	
	public String getISBN() {
		return isbn;
	}

	public void setISBN(String newISBN) {
		isbn = newISBN;
	}
	
	public int getPages(){
		return pages;
	}
	
	public void setPages(int newPages) {
		pages = newPages;
	}
	
	/*
	public Date getDate() {
		return pubYear;
	}

	public void setDate(Date newText) {
		pubYear = newText;
	}
	*/
	public Publisher getPublisher(){
		return publisher;
	}
	
	public void setPublisher(Publisher newPublisher){
		publisher = newPublisher;
	}
	
	public List<Author> getAuthors(){
		return authors;
	}
	
	public void setAuthors(List<Author> newAuthors){
		authors = newAuthors;
	}
	
	public void addAuthor(Author auth){
		authors.add(auth);
	}

}
