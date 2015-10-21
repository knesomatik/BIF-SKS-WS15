package bookWebApp;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="t_publisher")
@NamedQuery(name="Publisher.selectAll", query="SELECT n FROM Publisher n")
public class Publisher 
{
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Pub_id")
	private Long pubID = null;
	@Column(name="Name")
	private String name = null;
	@Column(name="Address")
	private String address = null;
	@Column(name="TelNum")
	private Long telNum = null;
	@OneToMany(mappedBy="myPublisher")
	private List<Author> authors;
	
	public Publisher()
	{
		
	}
	
	public Publisher(Long newID, String first, String newAd, Long newTel)
	{
		pubID = newID;
		name = first;
		address = newAd;
		telNum = newTel;
	}
	
	public Long getID()
	{
		return pubID;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public Long getTelNum()
	{
		return telNum;
	}
	
	public void setID(Long newID)
	{
		pubID = newID;
	}
	
	public void setName(String newTitle)
	{
		name = newTitle;
	}
	
	public void setAddress(String newTitle)
	{
		address = newTitle;
	}
	
	public void setTelNum(Long newNum)
	{
		telNum = newNum;
	}

	
}