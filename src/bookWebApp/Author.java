package bookWebApp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_author")
@NamedQuery(name = "Author.selectAll", query = "SELECT n FROM Author n")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long authID = null;
	private String firstname = null;
	private String secondname = null;
	private Date bDay = null;
	private String address = null;
	private Long telNum = null;

	public Author() {

	}

	public Author(Long newID, String first, String sec, Date newBday, String newAd, Long newTel) {
		authID = newID;
		firstname = first;
		secondname = sec;
		bDay = newBday;
		address = newAd;
		telNum = newTel;
	}

	public Long getID() {
		return authID;
	}

	public void setID(Long newID) {
		authID = newID;
	}

	public String getFirstName() {
		return firstname;
	}

	public void setFirstName(String newTitle) {
		firstname = newTitle;
	}

	public String getSecondName() {
		return secondname;
	}

	public void setSecondName(String newTitle) {
		secondname = newTitle;
	}

	public Date getBday() {
		return bDay;
	}

	public void setBday(Date newText) {
		bDay = newText;
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
