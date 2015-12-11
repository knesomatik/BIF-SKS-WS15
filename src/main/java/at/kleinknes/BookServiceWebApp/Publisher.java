package at.kleinknes.BookServiceWebApp;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;


@Entity
@Table(name = "t_publisher")
@NamedQueries({
		@NamedQuery(name = "Publisher.selectAll", query = "SELECT n FROM Publisher n"),
		@NamedQuery(name = "Publisher.findFirst", query = "SELECT n FROM Publisher n WHERE lower(n.name) LIKE lower(:name)")
})
@XmlAccessorType(XmlAccessType.FIELD)
public class Publisher {

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
