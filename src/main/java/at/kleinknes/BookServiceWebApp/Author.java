package at.kleinknes.BookServiceWebApp;

import javax.persistence.*;
import javax.xml.bind.annotation.*;


@Entity
@Table(name = "t_author")
@NamedQuery(name = "Author.selectAll", query = "SELECT n FROM Author n")
@XmlAccessorType(XmlAccessType.FIELD)
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlTransient
	private Long authID = null;
	@XmlAttribute
	private String firstname = null;
	@XmlAttribute
	private String secondname = null;
	@XmlAttribute
	private String AuthAddress = null;
	@XmlAttribute
	private Long AuthTelNum = null;

	public Author() {

	}

	public Author(String first, String sec, String newAd, Long newTel) {
		firstname = first;
		secondname = sec;
		AuthAddress = newAd;
		AuthTelNum = newTel;
	}
	
	public Boolean eqauls(Author auth) {
        return this.firstname.equals(auth.firstname) && this.secondname.equals(auth.secondname) && this.AuthAddress.equals(auth.AuthAddress) && this.AuthTelNum.equals(auth.AuthTelNum);
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
	
	/*
	public Date getBday() {
		return bDay;
	}

	public void setBday(Date newText) {
		bDay = newText;
	}
	*/
	public String getAddress() {
		return AuthAddress;
	}

	public void setAddress(String newTitle) {
		AuthAddress = newTitle;
	}

	public Long getTelNum() {
		return AuthTelNum;
	}

	public void setTelNum(Long newNum) {
		AuthTelNum = newNum;
	}

}
