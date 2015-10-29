package at.kleinknes.BookServiceWebApp;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

//@Stateless
@WebService(
		name = "BookWS",
		serviceName = "BookWebService")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
public class BookWS {

	@Inject
	private BookService bookService;

	@WebMethod
	public boolean saveBook(Book book) {
		return bookService.saveBooks(book);
	}

	@WebMethod
	public boolean saveBooks(List<Book> books) {
		return bookService.saveBooks(books);
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
