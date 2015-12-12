package at.kleinknes.BookServiceWebApp;

/**
 * Created by fekle on 12/11/15.
 */

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/rest/author")
@Consumes({"*/*"})
@Produces({"application/json"})

public class AuthorREST {

	@Inject
	private AuthorService authorService;

	@GET
	public Response getAuthors() {
		try{
			List<Author> ad = authorService.getAllAuthors();
			return Response.ok().entity(ad).build();
		}catch (Exception ex){
			return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();
		}
	}

	@GET
	@Path("/{id}")
	public Response getAuthor(@PathParam("id") Long id) {
		try{
			Author ad = authorService.getAuthor(id);
			return Response.ok().entity(ad).build();
		}catch (Exception ex){
			return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();
		}
	}

	@PUT
	@Path("/")
	public Response addAuthor(Author author) {
		try{
			Author ad = authorService.addAuthor(author);
			return Response.ok().entity(ad).build();
		}catch (Exception ex){
			return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();
		}
	}

	@POST
	@Path("/{id}")
	public Response updateAuthor(Author author) {
		try{
			Author ad = authorService.updateAuthor(author);
			return Response.ok().entity(ad).build();
		}catch (Exception ex){
			return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();
		}
	}

	@DELETE
	@Path("/{id}")
	public Response removeAuthor(@PathParam("id") Long id) {
		try{
			Author ad = authorService.removeAuthor(id);
			return Response.ok().entity(ad).build();
		}catch (Exception ex){
			return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();
		}
	}

}
