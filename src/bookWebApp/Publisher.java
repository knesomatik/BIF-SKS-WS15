package bookWebApp;

import javax.persistence.*;

@Entity
@Table(name = "t_publisher")
@NamedQuery(name = "Publisher.selectAll", query = "SELECT n FROM Publisher n")
public class Publisher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pubID = null;
	private String name = null;
	private String address = null;
	private Long telNum = null;

	public Publisher() {

	}

	public Publisher(Long newID, String first, String newAd, Long newTel) {
		pubID = newID;
		name = first;
		address = newAd;
		telNum = newTel;
	}

	public Long getID() {
		return pubID;
	}

	public void setID(Long newID) {
		pubID = newID;
	}

	public String getName() {
		return name;
	}

	public void setName(String newTitle) {
		name = newTitle;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String newTitle) {
		address = newTitle;
	}

	public Long getTelNum() {
		return telNum;
	}

	public void setTelNum(Long newNum) {
		telNum = newNum;
	}


}
