package bookWebApp;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

<<<<<<< HEAD
@Generated(value="Dali", date="2015-10-22T00:31:57.945+0200")
=======
@Generated(value = "Dali", date = "2015-10-21T02:41:48.596+0200")
>>>>>>> c936f2cf73e43644b9543f24541f79cbfaa247b4
@StaticMetamodel(Book.class)
public class Book_ {
	public static volatile SingularAttribute<Book, Long> bookID;
	public static volatile SingularAttribute<Book, String> title;
	public static volatile SingularAttribute<Book, Date> pubYear;
	public static volatile SingularAttribute<Book, Publisher> myBooks;
}
