package at.htl.leonding.api;

import at.htl.leonding.entities.Person;
import at.htl.leonding.entities.PersonType;
import at.htl.leonding.repository.PersonRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
@Path("/person")
public class PersonResource {
    @Inject
    PersonRepository personRepository;

    @GET
    @Path("{id:[0-9]+}")
    @Produces("application/json")
    public Response getAll(@PathParam("id") Long id) {
        if (id == null || id == 0) {
            return Response.ok(personRepository.listAll()).build();
        }
        return Response.ok(personRepository.findById(id)).build();
    }

    @POST
    @Transactional
    @Consumes("application/json")
    @Produces("application/json")
    public Response create(Person person) {
        personRepository.persist(person);
        return Response.ok(person).build();
    }

    @DELETE
    @Path("{id:[0-9]+}")
    @Transactional
    @Produces("application/json")
    public Response delete(@PathParam("id") Long id) {
        return Response.ok(personRepository.deleteById(id)).build();
    }

    @GET
    @Path("/mostRelevant/{job}")
    public Response mostRelevantActor(@PathParam("job")PersonType pt) {
        return Response.ok(personRepository.getMostRelevant(pt)).build();
    }
}
