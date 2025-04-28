package at.htl.leonding.api;

import at.htl.leonding.entities.Media;
import at.htl.leonding.repository.MediaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
@Path("/media")
public class MediaResource {

    @Inject
    MediaRepository mediaRepository;

    @GET
    @Path("/{id:[0-9]+}")
    public Response getAll(@PathParam("id") Long id) {
        if (id == null) {
            return Response.ok(mediaRepository.listAll()).build();
        }
        return Response.ok(mediaRepository.findById(id)).build();
    }

    @POST
    @Transactional
    public Response create(Media media) {
        mediaRepository.persist(media);
        return Response.ok(media).build();
    }

    @DELETE
    @Path("/{id:[0-9]+}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        return Response.ok(mediaRepository.deleteById(id)).build();
    }

    @GET
    @Path("/type/{mediaType}")
    public Response getAllByMediaType(@PathParam("mediaType") String mediaType) {
        return Response.ok(mediaRepository.getAllByMediaType(mediaType)).build();
    }

    @GET
    @Path("/averageRating/{personId}")
    public Response getAverageRatingByPerson(@PathParam("personId") Long personId) {
        return Response.ok(mediaRepository.getAverageRatingByPerson(personId)).build();
    }
}