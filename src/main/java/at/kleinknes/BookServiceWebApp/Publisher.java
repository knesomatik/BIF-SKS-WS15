package at.kleinknes.BookServiceWebApp;

import javax.persistence.*;
import javax.xml.bind.annotation.*;


@Entity
@Table(name = "t_publisher")
@NamedQuery(name = "Publisher.selectAll", query = "SELECT n FROM Publisher n")
@XmlAccessorType(XmlAccessType.FIELD)
public class Publisher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlTransient
	private Long pubID = null;
	@XmlAttribute
	private String Name = null;
	@XmlAttribute
	private Long PostCode = null;
	@XmlAttribute
	private String CountryCode = null;

	public Publisher() {

	}

	public Publisher(String first, Long newAd, String newTel) {
		Name = first;
		PostCode = newAd;
		CountryCode = newTel;
	}
	
	public Boolean eqauls(Publisher pub) {
        return this.Name.equals(pub.getName()) && this.PostCode.equals(pub.getPost()) && this.CountryCode.equals(pub.getCode());
    }

	public Long getID() {
		return pubID;
	}

	public void setID(Long newID) {
		pubID = newID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String newTitle) {
		Name = newTitle;
	}

	public Long getPost() {
		return PostCode;
	}

	public void setPost(Long newTitle) {
		PostCode = newTitle;
	}

	public String getCode() {
		return CountryCode;
	}

	public void setCode(String newNum) {
		CountryCode = newNum;
	}


}
