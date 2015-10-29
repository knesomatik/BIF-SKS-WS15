package at.kleinknes.BookServiceWebApp;


import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

@WebServlet("/BookServlet")
@SuppressWarnings("serial")
public class BookServlet extends HttpServlet {

	@Inject
	private BookService bookService;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		long range = 1234567L;
		Random r = new Random();
		long id = (long) (r.nextDouble() * range);
		Book book = new Book();
		book.setTitle("Test " + id);

		bookService.saveBooks(book);

		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<body>");

		List<Book> list = bookService.searchBooks("Test");

		for (Book n : list) {
			out.println("<br>");
			out.println(n.getTitle());
		}

		out.println("</body>");
		out.println("</html>");


	}

}
