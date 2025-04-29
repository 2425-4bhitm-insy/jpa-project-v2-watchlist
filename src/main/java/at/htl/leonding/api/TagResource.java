package at.htl.leonding.api;

import at.htl.leonding.entities.Media;
import at.htl.leonding.entities.Tag;
import at.htl.leonding.repository.TagRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.HashSet;
import java.util.Set;

@ApplicationScoped
@Path("/tag")
public class TagResource {
    @Inject
    TagRepository tagRepository;

    @GET
    @Path("/{id:[0-9]+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@PathParam("id") Long id) {
        if (id == null || id == 0) {
            return Response.ok(tagRepository.listAll()).build();
        }
        return Response.ok(tagRepository.findById(id)).build();
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Tag tag) {
        tagRepository.persist(tag);
        return Response.ok(tag).build();
    }

    @DELETE
    @Path("/{id:[0-9]+}")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id) {
        Set<Media> media = new HashSet<>(tagRepository.findById(id).media);
        tagRepository.findById(id).media.clear();
        media.forEach(m -> m.getTags().clear());
        tagRepository.flush();
        return Response.ok(tagRepository.deleteById(id)).build();
    }
}
