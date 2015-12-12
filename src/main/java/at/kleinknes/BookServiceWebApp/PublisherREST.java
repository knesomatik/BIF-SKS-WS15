package at.kleinknes.BookServiceWebApp;

/**
 * Created by fekle on 12/11/15.
 */

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/rest/publisher")
@Consumes({"*/*"})
@Produces({"application/json"})

public class PublisherREST {

	@Inject
	private PublisherService publisherService;

	@GET
	public Response getPublishers() {
		try {
			List<Publisher> ad = publisherService.getAllPublishers();
			return Response.ok().entity(ad).build();
		} catch (Exception ex) {
			return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();
		}
	}

	@GET
	@Path("/{id}")
	public Response getPublisher(@PathParam("id") Long id) {
		try {
			Publisher ad = publisherService.getPublisher(id);
			return Response.ok().entity(ad).build();
		} catch (Exception ex) {
			return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();
		}
	}

	@PUT
	@Path("/")
	public Response addPublisher(Publisher publisher) {
		try {
			Publisher ad = publisherService.addPublisher(publisher);
			return Response.ok().entity(ad).build();
		} catch (Exception ex) {
			return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();
		}
	}

	@POST
	@Path("/{id}")
	public Response updatePublisher(Publisher publisher) {
		try {
			Publisher ad = publisherService.updatePublisher(publisher);
			return Response.ok().entity(ad).build();
		} catch (Exception ex) {
			return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();
		}
	}

	@DELETE
	@Path("/{id}")
	public Response removePublisher(@PathParam("id") Long id) {
		try {
			Publisher ad = publisherService.removePublisher(id);
			return Response.ok().entity(ad).build();
		} catch (Exception ex) {
			return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();
		}
	}

}
