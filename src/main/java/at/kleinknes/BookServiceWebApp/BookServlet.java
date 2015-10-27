package at.kleinknes.BookServiceWebApp;


import org.hibernate.Session;
import org.hibernate.Transaction;

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
	@PersistenceContext
	private EntityManager em;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		long range = 1234567L;
		Random r = new Random();
		long id = (long) (r.nextDouble() * range);
		Author author = new Author();
		author.setFirstName("Felix");
		author.setSecondName("Klein " + id);
		author.setID(id);

		Session session = (Session) em.getDelegate();
		Transaction tx = null;
		tx = session.getTransaction();
		tx.begin();

		try {
			session.persist(author);

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}

		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<body>");

		List<Author> list = em.createNamedQuery("Author.selectAll", Author.class).getResultList();

		for (Author n : list) {
			out.println("<br>");
			out.println(n.getFirstName());
			out.println(n.getSecondName());
		}

		out.println("</body>");
		out.println("</html>");


	}

}
