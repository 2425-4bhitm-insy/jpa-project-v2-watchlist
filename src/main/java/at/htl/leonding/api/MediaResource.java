package at.htl.leonding.api;

import at.htl.leonding.entities.Media;
import at.htl.leonding.repository.MediaRepository;
import io.quarkus.panache.common.Parameters;
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
        mediaRepository.deleteById(id);
        return Response.noContent().build();
    }
}