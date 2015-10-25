package at.kleinknes.BookServiceWebApp;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "Dali", date = "2015-10-22T00:22:11.208+0200")
@StaticMetamodel(Publisher.class)
public class Publisher_ {
	public static volatile SingularAttribute<Publisher, Long> pubID;
	public static volatile SingularAttribute<Publisher, String> name;
	public static volatile SingularAttribute<Publisher, String> address;
	public static volatile SingularAttribute<Publisher, Long> telNum;
	public static volatile ListAttribute<Publisher, Author> authors;
}
