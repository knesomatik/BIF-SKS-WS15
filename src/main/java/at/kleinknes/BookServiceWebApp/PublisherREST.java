package at.kleinknes.BookServiceWebApp;

/**
 * Created by fekle on 12/11/15.
 */

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@Path("/rest/publisher")
@Consumes({"application/json"})
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
	public Publisher addPublisher(@QueryParam("data") Publisher publisher) {
		return publisherService.addPublisher(publisher.getName(), publisher.getPost(), publisher.getCode());
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
