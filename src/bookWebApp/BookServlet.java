package bookWebApp;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/BookServlet")
@SuppressWarnings("serial")
public class BookServlet extends HttpServlet {

	@Inject
	private BookService bookService;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<body>");

		bookService.alterText("Title");

		bookService.getAllBooks().forEach(book -> {
			out.println("<h1>" + book.getTitle() + "</h1>");
			out.println("<p>" + book.getDate() + "</p>");
		});

		out.println("</body>");
		out.println("</html>");
	}

}
