package at.kleinknes.BookServiceWebApp;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService(
		name = "BookWS",
		serviceName = "BookWebService",
		portName = "BookWebServicePort")
public class BookWS{

	@Inject
	private BookService bookService;

	@WebMethod
	public boolean saveBooks(@WebParam(name = "book") List<Book> books) {
		bookService.saveBooks(books);
		return true;
	}

	@WebMethod
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}

	@WebMethod
	public List<Book> searchBooks(String title) {
		return bookService.searchBooks(title);
	}
}
