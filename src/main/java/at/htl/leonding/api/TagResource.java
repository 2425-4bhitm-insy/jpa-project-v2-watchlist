package at.htl.leonding.api;

import at.htl.leonding.entities.Tag;
import at.htl.leonding.repository.TagRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class TagResource {
    @Inject
    TagRepository tagRepository;

    @GET
    @Path("/{id:[0-9]+}")
    public Response getAll(@PathParam("id") Long id) {
        if (id == null || id == 0) {
            return Response.ok(tagRepository.listAll()).build();
        }
        return Response.ok(tagRepository.findById(id)).build();
    }

    @POST
    @Transactional
    public Response create(Tag tag) {
        tagRepository.persist(tag);
        return Response.ok(tag).build();
    }

    @DELETE
    @Path("/{id:[0-9]+}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        tagRepository.deleteById(id);
        return Response.noContent().build();
    }
}
