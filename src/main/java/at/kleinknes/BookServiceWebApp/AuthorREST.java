package at.kleinknes.BookServiceWebApp;

/**
 * Created by fekle on 12/11/15.
 */

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/rest/author")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthorREST {

	@Inject
	private AuthorService authorService;

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Author> getAuthors() {
		return authorService.getAllAuthors();
	}

	@GET
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Author getAuthor(@PathParam("id") Long id) {
		return authorService.getAuthor(id);
	}

	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Author addAuthor(@QueryParam("author") Author author){
		return authorService.addAuthor(author.getFirstname(), author.getLastname());
	}

	@POST
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Author updateAuthor(@PathParam("id") Long id, @QueryParam("firstname") String firstname, @QueryParam("secondname") String secondname) {
		return authorService.updateAuthor(id, firstname, secondname);
	}

	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Author removeAuthor(@PathParam("id") Long id) {
		return authorService.removeAuthor(id);
	}

}
