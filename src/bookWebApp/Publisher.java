package bookWebApp;

import javax.persistence.*;

@Entity
<<<<<<< HEAD
@Table(name="t_publisher")
@NamedQuery(name="Publisher.selectAll", query="SELECT n FROM Publisher n")
public class Publisher 
{
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Pub_id")
=======
@Table(name = "t_publisher")
@NamedQuery(name = "Publisher.selectAll", query = "SELECT n FROM Publisher n")
public class Publisher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
>>>>>>> c936f2cf73e43644b9543f24541f79cbfaa247b4
	private Long pubID = null;
	@Column(name="Name")
	private String name = null;
	@Column(name="Address")
	private String address = null;
	@Column(name="TelNum")
	private Long telNum = null;
<<<<<<< HEAD
	@OneToMany(mappedBy="myPublisher")
	private List<Author> authors;
	
	public Publisher()
	{
		
=======

	public Publisher() {

>>>>>>> c936f2cf73e43644b9543f24541f79cbfaa247b4
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
