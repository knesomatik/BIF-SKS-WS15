package at.kleinknes.BookServiceWebApp;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.util.Objects;


@Entity
@Table(name = "publisher")
@NamedQueries({
		@NamedQuery(name = "Publisher.selectAll", query = "SELECT n FROM Publisher n"),
		@NamedQuery(name = "Publisher.findFirst", query = "SELECT n FROM Publisher n WHERE lower(n.name) LIKE lower(:name)")
})
@XmlAccessorType(XmlAccessType.FIELD)
public class Publisher {

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Publisher publisher = (Publisher) o;

		if (getName() != null ? !getName().equals(publisher.getName()) : publisher.getName() != null) return false;
		if (getPostcode() != null ? !getPostcode().equals(publisher.getPostcode()) : publisher.getPostcode() != null)
			return false;
		return getCountrycode() != null ? getCountrycode().equals(publisher.getCountrycode()) : publisher.getCountrycode() == null;

	}

	@Override
	public int hashCode() {
		int result = getName() != null ? getName().hashCode() : 0;
		result = 31 * result + (getPostcode() != null ? getPostcode().hashCode() : 0);
		result = 31 * result + (getCountrycode() != null ? getCountrycode().hashCode() : 0);
		return result;
	}

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlAttribute
	private Long pubID = null;
	@XmlAttribute
	private String name = null;
	@XmlAttribute
	private Long postcode = null;
	@XmlAttribute
	private String countrycode = null;

	public Publisher() {

	}

	public Long getPubID() {
		return pubID;
	}

	public void setPubID(Long pubID) {
		this.pubID = pubID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPostcode() {
		return postcode;
	}

	public void setPostcode(Long postcode) {
		this.postcode = postcode;
	}

	public String getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

}
