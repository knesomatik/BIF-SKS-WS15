package at.kleinknes.BookServiceWebApp;

import javax.ejb.Stateless;
import javax.ws.rs.core.Response;
import java.util.concurrent.Callable;
import java.util.function.Consumer;

/**
 * Created by fekle on 12/12/15.
 */
@Stateless
public class Common {
	public static void checkValue(Object o, String name) throws Exception {
		if (o != null && !o.equals(0) && !o.equals("")) {
			System.out.println("PASS: " + name + "=" + o.toString());
			return;
		}
		System.err.println("FAIL: " + name);
		throw new Exception("invalid value for " + name);
	}

}
