package at.kleinknes.BookServiceWebApp;

/**
 * Created by fekle on 12/11/15.
 */

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@Path("/rest/publisher")
@Consumes({"*/*"})
@Produces({"application/json"})

public class PublisherREST {

	@Inject
	private PublisherService publisherService;

	@GET
	@Path("/")
	public List<Publisher> getPublishers() {
		return publisherService.getAllPublishers();
	}

	@GET
	@Path("/{id}")
	public Publisher getPublisher(@PathParam("id") Long id) {
		return publisherService.getPublisher(id);
	}

	@PUT
	@Path("/")
	public Publisher addPublisher(@FormParam("name") String name, @FormParam("postcode") String postcode, @FormParam("countrycode") String countrycode) {
		return publisherService.addPublisher(name, Long.valueOf(postcode), countrycode);
	}

	@POST
	@Path("/{id}")
	public Publisher updatePublisher(@PathParam("id") Long id, @QueryParam("name") String name, @QueryParam("postcode") Long postcode, @QueryParam("countrycode") String countrycode) {
		return publisherService.updatePublisher(id, name, postcode, countrycode);
	}

	@DELETE
	@Path("/{id}")
	public Publisher removePublisher(@PathParam("id") Long id) {
		return publisherService.removePublisher(id);
	}

}
