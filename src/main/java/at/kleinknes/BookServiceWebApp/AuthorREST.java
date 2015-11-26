package at.kleinknes.BookServiceWebApp;

/**
 * Created by fekle on 12/11/15.
 */

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.util.List;

@Path("/rest/author")
@Consumes({"application/json"})
@Produces({"application/json"})

public class AuthorREST {

	@Inject
	private AuthorService authorService;

	@GET
	//@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Author> getAuthors() {
		return authorService.getAllAuthors();
	}

	@GET
	@Path("/{id}")
	//@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Author getAuthor(@PathParam("id") Long id) {
		return authorService.getAuthor(id);
	}

	@PUT
	@Path("/")
	public Author addAuthor(@QueryParam("firstname") String firstname, @QueryParam("secondname") String secondname) {
		return authorService.addAuthor(firstname, secondname);
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
