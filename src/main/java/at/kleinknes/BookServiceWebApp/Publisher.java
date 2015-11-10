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
	private String PubName = null;
	@XmlAttribute
	private String PubAddress = null;
	@XmlAttribute
	private Long PubTelNum = null;

	public Publisher() {

	}

	public Publisher(String first, String newAd, Long newTel) {
		PubName = first;
		PubAddress = newAd;
		PubTelNum = newTel;
	}
	
	public Boolean eqauls(Publisher pub) {
        return this.PubName.equals(pub.PubName) && this.PubAddress.equals(pub.PubAddress) && this.PubTelNum.equals(pub.getTelNum());
    }

	public Long getID() {
		return pubID;
	}

	public void setID(Long newID) {
		pubID = newID;
	}

	public String getName() {
		return PubName;
	}

	public void setName(String newTitle) {
		PubName = newTitle;
	}

	public String getAddress() {
		return PubAddress;
	}

	public void setAddress(String newTitle) {
		PubAddress = newTitle;
	}

	public Long getTelNum() {
		return PubTelNum;
	}

	public void setTelNum(Long newNum) {
		PubTelNum = newNum;
	}


}
