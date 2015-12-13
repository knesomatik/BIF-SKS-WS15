package at.kleinknes.BookServiceWebApp;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService(name = "BookWS", serviceName = "BookWebService", portName = "BookWebServicePort")
public class BookWS {

	@Inject
	private BookService bookService;

	@WebMethod
	public String saveBooks(@WebParam(name = "book") List<Book> books) {
		return bookService.saveBooks(books);
	}

	@WebMethod
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}

	@WebMethod
	public List<Book> searchBooks(String title) {
		return bookService.search(title);
	}
}
