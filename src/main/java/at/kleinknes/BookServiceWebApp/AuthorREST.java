package at.kleinknes.BookServiceWebApp;

/**
 * Created by fekle on 12/11/15.
 */

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@Path("/rest/author")
<<<<<<< HEAD
@Consumes({"*/*"})
@Produces({"application/json"})

=======
@Consumes("*/*")
@Produces("application/json")
>>>>>>> 4ea4b75e1cc830f55657c12a80416b08abf8a0ee
public class AuthorREST {

	@Inject
	private AuthorService authorService;

	@GET
<<<<<<< HEAD
=======
	@Path("/")
>>>>>>> 4ea4b75e1cc830f55657c12a80416b08abf8a0ee
	public List<Author> getAuthors() {
		return authorService.getAllAuthors();
	}

	@GET
	@Path("/{id}")
	public Author getAuthor(@PathParam("id") Long id) {
		return authorService.getAuthor(id);
	}

	@PUT
	@Path("/")
<<<<<<< HEAD
	public Author addAuthor(@FormParam("firstname") String firstname, @FormParam("lastname") String lastname) {
		return authorService.addAuthor(firstname, lastname);
=======
	public Author addAuthor(@FormParam("firstname") String firstName, @FormParam("lastname") String lastName) {
		System.err.println("\nAUTHOR:\n" + firstName + " " + lastName + "\nAUTHOREND\n");
		return authorService.addAuthor(firstName, lastName);
>>>>>>> 4ea4b75e1cc830f55657c12a80416b08abf8a0ee
	}

	@POST
	@Path("/{id}")
	public Author updateAuthor(@PathParam("id") Long id, @QueryParam("firstname") String firstname, @QueryParam("secondname") String secondname) {
		return authorService.updateAuthor(id, firstname, secondname);
	}

	@DELETE
	@Path("/{id}")
	public Author removeAuthor(@PathParam("id") Long id) {
		return authorService.removeAuthor(id);
	}

}
