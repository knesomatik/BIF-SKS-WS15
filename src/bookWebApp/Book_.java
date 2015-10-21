package bookWebApp;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-10-22T00:31:57.945+0200")
@StaticMetamodel(Book.class)
public class Book_ {
	public static volatile SingularAttribute<Book, Long> bookID;
	public static volatile SingularAttribute<Book, String> title;
	public static volatile SingularAttribute<Book, Date> pubYear;
	public static volatile SingularAttribute<Book, Publisher> myBooks;
}
