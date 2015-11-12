package at.kleinknes.BookServiceWebApp;


import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/BookServlet")
@SuppressWarnings("serial")
public class BookServlet extends HttpServlet {

	@Inject
	private BookService bookService;

	@Inject
	private AuthorService authService;

	private List<Book> newBooks;
	private List<Author> authors;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		newBooks = bookService.getAllBooks();
		/*
		authors = authService.getAllAuthors();
		long range = 1234567L;
		Random r = new Random();
		long id = (long) (r.nextDouble() * range);
		Book book = new Book();
		book.setTitle("Test" + id);
		book.setISBN("1234567");
		book.setPages(400);
		Author newAuthor = new Author("Konstantin", "Knes", "Lacknergasse 34", 6509999999L);
		Author newAuthor2 = new Author("Daniel", "Lackner", "Lacknergasse 35", 6508888888L);
		authors.add(newAuthor);
		authors.add(newAuthor2);
		book.setAuthors(authors);
		Publisher newPub = new Publisher("ViennaBookCompany", "Lacknergasse 40", 6509999999L);
		book.setPublisher(newPub);
		newBooks.add(book);

		bookService.saveBooks(newBooks);
		*/
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<body>");

		for (Book n : newBooks) {
			out.println("<br>");
			out.println(n.getTitle());
		}

		out.println("</body>");
		out.println("</html>");


	}

}
