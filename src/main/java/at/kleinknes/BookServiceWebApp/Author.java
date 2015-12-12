package at.kleinknes.BookServiceWebApp;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.util.Objects;


@Entity
@Table(name = "author")
@NamedQueries({
		@NamedQuery(name = "Author.selectAll", query = "SELECT n FROM Author n"),
		@NamedQuery(name = "Author.findFirst", query = "SELECT n FROM Author n WHERE lower(n.firstname) LIKE lower(:firstname) AND lower(n.lastname) LIKE lower(:lastname))")

})

@XmlAccessorType(XmlAccessType.FIELD)
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlAttribute
	private Long authID = null;
	@XmlAttribute
	private String firstname = null;
	@XmlAttribute
	private String lastname = null;
	@XmlAttribute
	private String birthdate = null;

	public Author() {

	}

	public Author(String first, String sec) {
		firstname = first;
		lastname = sec;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Long getAuthID() {
		return authID;
	}

	public void setAuthID(Long authID) {
		this.authID = authID;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Author author = (Author) o;

		if (getFirstname() != null ? !getFirstname().equals(author.getFirstname()) : author.getFirstname() != null)
			return false;
		if (getLastname() != null ? !getLastname().equals(author.getLastname()) : author.getLastname() != null)
			return false;
		return getBirthdate() != null ? getBirthdate().equals(author.getBirthdate()) : author.getBirthdate() == null;

	}

	@Override
	public int hashCode() {
		int result = getFirstname() != null ? getFirstname().hashCode() : 0;
		result = 31 * result + (getLastname() != null ? getLastname().hashCode() : 0);
		result = 31 * result + (getBirthdate() != null ? getBirthdate().hashCode() : 0);
		return result;
	}
}
