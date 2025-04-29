package at.htl.leonding.api;

import at.htl.leonding.entities.Media;
import at.htl.leonding.repository.MediaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
@Path("/media")
public class MediaResource {

    @Inject
    MediaRepository mediaRepository;

    @GET
    @Path("/{id:[0-9]+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@PathParam("id") Long id) {
        if (id == null || id == 0) {
            return Response.ok(mediaRepository.listAll()).build();
        }
        return Response.ok(mediaRepository.findById(id)).build();
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Media media) {
        mediaRepository.persist(media);
        return Response.ok(media).build();
    }

    @DELETE
    @Path("/{id:[0-9]+}")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id) {
        return Response.ok(mediaRepository.deleteById(id)).build();
    }

    @GET
    @Path("/type/{mediaType}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllByMediaType(@PathParam("mediaType") at.htl.leonding.entities.MediaType mediaType) {
        return Response.ok(mediaRepository.getAllByMediaType(mediaType)).build();
    }

    @GET
    @Path("/averageRating/{personId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAverageRatingByPerson(@PathParam("personId") Long personId) {
        return Response.ok(mediaRepository.getAverageRatingByPerson(personId)).build();
    }
}