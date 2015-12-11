package at.kleinknes.BookServiceWebApp;

import javax.persistence.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "t_author")
@NamedQueries({
		@NamedQuery(name = "Author.selectAll", query = "SELECT n FROM Author n"),
		@NamedQuery(name = "Author.findFirst", query = "SELECT n FROM Author n WHERE lower(n.firstname) LIKE lower(:firstname) AND lower(n.lastname) LIKE lower(:lastname))")

})

@XmlAccessorType(XmlAccessType.FIELD)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@XmlRootElement(name = "author")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlAttribute
	private Long authID = null;
	@XmlAttribute
	private String firstname = null;
	@XmlAttribute
	private String lastname = null;

	public Author() {

	}

<<<<<<< HEAD
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
=======
	public Author(String name) {


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

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
>>>>>>> 4ea4b75e1cc830f55657c12a80416b08abf8a0ee
	}
}
