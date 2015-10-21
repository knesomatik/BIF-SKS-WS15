package bookWebApp;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@Generated(value = "Dali", date = "2015-10-21T02:41:48.596+0200")
@StaticMetamodel(Book.class)
public class Book_ {
	public static volatile SingularAttribute<Book, String> title;
	public static volatile SingularAttribute<Book, Long> bookID;
	public static volatile SingularAttribute<Book, Date> pubYear;
}
