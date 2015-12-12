package at.kleinknes.BookServiceWebApp;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
@XmlRootElement(name = "book")
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
		@NamedQuery(name = "Book.selectAll", query = "SELECT n FROM Book n"),
		@NamedQuery(name = "Book.searchAll", query = "SELECT n FROM Book n WHERE lower(n.title) LIKE lower(:search)")
})
public class Book implements Cloneable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlAttribute
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
			name = "book_author",
			joinColumns = {@JoinColumn(name = "bookID", referencedColumnName = "bookID")},
			inverseJoinColumns = {@JoinColumn(name = "authID", referencedColumnName = "authID")}
	)
	@XmlElementWrapper(name = "authors")
	@XmlElement(name = "author")
	private List<Author> authors;

	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
	@JoinColumn(name = "pubID")
	@XmlElement
	private Publisher publisher;

	public Book() {

	}

	public Long getBookID() {
		return bookID;
	}

	public void setBookID(Long bookID) {
		this.bookID = bookID;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Book book = (Book) o;

		try {

			if (getAuthors().size() != book.getAuthors().size()) return false;


			List<Author> myAuthors = new ArrayList<>();
			List<Author> theirAuthors = new ArrayList<>();

			Integer matches = 0;

			for (int i = 0; i < getAuthors().size(); i++) {
				for (int j = 0; j < book.getAuthors().size(); j++) {
					if (getAuthors().get(i).equals(book.getAuthors().get(j))) {
						myAuthors.add(getAuthors().get(i));
						theirAuthors.add(book.getAuthors().get(j));
						matches++;
					}
				}
			}

			if (myAuthors.size() != matches) return false;
			if (theirAuthors.size() != matches) return false;
			if (matches != getAuthors().size()) return false;

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		if (getPages() != book.getPages()) return false;
		if (getIsbn() != null ? !getIsbn().equals(book.getIsbn()) : book.getIsbn() != null) return false;
		if (getTitle() != null ? !getTitle().equals(book.getTitle()) : book.getTitle() != null) return false;
		if (getSubtitle() != null ? !getSubtitle().equals(book.getSubtitle()) : book.getSubtitle() != null)
			return false;
		if (getDescription() != null ? !getDescription().equals(book.getDescription()) : book.getDescription() != null)
			return false;
		if (getLanguage() != null ? !getLanguage().equals(book.getLanguage()) : book.getLanguage() != null)
			return false;
		return getPublisher() != null ? getPublisher().equals(book.getPublisher()) : book.getPublisher() == null;

	}

	@Override
	public int hashCode() {
		int result = getIsbn() != null ? getIsbn().hashCode() : 0;
		result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
		result = 31 * result + (getSubtitle() != null ? getSubtitle().hashCode() : 0);
		result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
		result = 31 * result + getPages();
		result = 31 * result + (getLanguage() != null ? getLanguage().hashCode() : 0);
		result = 31 * result + (getAuthors() != null ? getAuthors().hashCode() : 0);
		result = 31 * result + (getPublisher() != null ? getPublisher().hashCode() : 0);
		return result;
	}

	protected Book clone() throws CloneNotSupportedException {
		return (Book) super.clone();
	}
}
