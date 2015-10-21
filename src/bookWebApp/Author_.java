package bookWebApp;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

<<<<<<< HEAD
@Generated(value="Dali", date="2015-10-22T00:31:18.180+0200")
=======
@Generated(value = "Dali", date = "2015-10-21T02:57:40.136+0200")
>>>>>>> c936f2cf73e43644b9543f24541f79cbfaa247b4
@StaticMetamodel(Author.class)
public class Author_ {
	public static volatile SingularAttribute<Author, Long> authID;
	public static volatile SingularAttribute<Author, String> firstname;
	public static volatile SingularAttribute<Author, String> secondname;
	public static volatile SingularAttribute<Author, Date> bDay;
	public static volatile SingularAttribute<Author, String> address;
	public static volatile SingularAttribute<Author, Long> telNum;
	public static volatile SingularAttribute<Author, Publisher> myPublisher;
	public static volatile ListAttribute<Author, Book> books;
}
