package at.kleinknes.BookServiceWebApp;

import java.net.URI;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;


@Path("/authors")
@Transactional
public class AuthorResource {
	
	@PersistenceContext
	EntityManager em;
	@Context
	UriInfo ui;
	@Inject
	AuthorService authService;
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response createNews(Author news) {
		em.persist(news);
		
		URI newsURI = ui
			.getAbsolutePathBuilder()
			.path(news.getID().toString())
			.build();
		
		return Response
			.created(newsURI)
			.build();
	}
	
	@PUT
	@Path("/{authID}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public void updateNews(@PathParam("authID") Long authID, Author newsNew) {
		Author newsOld = em.find(Author.class, authID);
		
		if (newsOld != null) {
			newsOld.setFirstName(newsNew.getFirstName());
			newsOld.setSecondName(newsNew.getSecondName());
		}
		else {
			throw new WebApplicationException(Status.NOT_FOUND);
		}		
	}
	
	@GET
	@Path("/{authID}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getNewsAsString(@PathParam("authID") Long authID) {
		Author news = em.find(Author.class, authID);
		return (news != null ? news.toString() : null);
	}
	
	@GET
	@Path("/{authID}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Author getNewsAsJSONXML(@PathParam("authID") Long authID) {
		return em.find(Author.class, authID);
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Author> getAllNews() {
		return authService.getAllAuthors();
	}
}
