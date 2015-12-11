package at.kleinknes.BookServiceWebApp;

/**
 * Created by fekle on 12/11/15.
 */

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@Path("/rest/publisher")
<<<<<<< HEAD
@Consumes({"*/*"})
@Produces({"application/json"})

=======
@Consumes("*/*")
@Produces("application/json")
>>>>>>> 4ea4b75e1cc830f55657c12a80416b08abf8a0ee
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
<<<<<<< HEAD
	public Publisher addPublisher(@FormParam("name") String name, @FormParam("postcode") String postcode, @FormParam("countrycode") String countrycode) {
		return publisherService.addPublisher(name, Long.valueOf(postcode), countrycode);
=======
	public Publisher addPublisher(@FormParam("name") String theName) {
		System.err.println("\nPUBLISHER:\n" + theName + "\nPUBLISHEREND\n");
		return publisherService.addPublisher(theName);
>>>>>>> 4ea4b75e1cc830f55657c12a80416b08abf8a0ee
	}

	@POST
	@Path("/{id}")
	public Publisher updatePublisher(@PathParam("id") Long id, @QueryParam("name") String name, @QueryParam("postcode") String postcode, @QueryParam("countrycode") String countrycode) {
		return publisherService.updatePublisher(id, name, postcode, countrycode);
	}

	@DELETE
	@Path("/{id}")
	public Publisher removePublisher(@PathParam("id") Long id) {
		return publisherService.removePublisher(id);
	}

}
