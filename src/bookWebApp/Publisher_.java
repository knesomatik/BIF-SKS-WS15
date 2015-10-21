package bookWebApp;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="Dali", date="2015-10-22T00:22:11.208+0200")
=======
@Generated(value = "Dali", date = "2015-10-21T02:59:59.574+0200")
>>>>>>> c936f2cf73e43644b9543f24541f79cbfaa247b4
@StaticMetamodel(Publisher.class)
public class Publisher_ {
	public static volatile SingularAttribute<Publisher, Long> pubID;
	public static volatile SingularAttribute<Publisher, String> name;
	public static volatile SingularAttribute<Publisher, String> address;
	public static volatile SingularAttribute<Publisher, Long> telNum;
	public static volatile ListAttribute<Publisher, Author> authors;
}
