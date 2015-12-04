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
		@NamedQuery(name = "Author.selectAll", query = "SELECT n FROM Author n")
})
@XmlAccessorType(XmlAccessType.FIELD)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@XmlRootElement(name="author")
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

	public Author(String first, String sec) {
		firstname = first;
		lastname = sec;
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
	}
}
