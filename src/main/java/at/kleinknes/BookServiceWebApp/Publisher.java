package at.kleinknes.BookServiceWebApp;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;


@Entity
@Table(name = "t_publisher")
@NamedQueries({
		@NamedQuery(name = "Publisher.selectAll", query = "SELECT n FROM Publisher n"),
<<<<<<< HEAD
		@NamedQuery(name = "Publisher.findFirst", query = "SELECT n FROM Publisher n WHERE lower(n.name) LIKE lower(:name)")
=======
		@NamedQuery(name = "Publisher.findFirst", query = "SELECT n FROM Publisher n WHERE lower(n.name) LIKE lower(:queryname)")
>>>>>>> 4ea4b75e1cc830f55657c12a80416b08abf8a0ee
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
<<<<<<< HEAD
	private Long postcode = null;
=======
	private String postcode = null;
>>>>>>> 4ea4b75e1cc830f55657c12a80416b08abf8a0ee
	@XmlAttribute
	private String countrycode = null;

	public Publisher() {

	}

<<<<<<< HEAD
=======
	public Publisher(String whatl) {

	}


>>>>>>> 4ea4b75e1cc830f55657c12a80416b08abf8a0ee
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

<<<<<<< HEAD
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
=======
	public String getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
>>>>>>> 4ea4b75e1cc830f55657c12a80416b08abf8a0ee
	}
}
