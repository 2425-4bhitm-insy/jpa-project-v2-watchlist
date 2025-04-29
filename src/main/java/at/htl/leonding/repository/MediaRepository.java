package at.htl.leonding.repository;

import at.htl.leonding.entities.Media;
import at.htl.leonding.entities.MediaType;
import at.htl.leonding.entities.Person;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class MediaRepository extends BetterRepository<Media> {
    public MediaRepository() {
        super(Media.class);
    }

    public List<Person> getAllByMediaType(MediaType mediaType) {
        return getEntityManager().createQuery(
                """
                                SELECT DISTINCT p FROM Media m
                                LEFT JOIN Person p ON p MEMBER OF m.actors
                                or p MEMBER OF m.authors
                                or p MEMBER OF m.directors
                                or p MEMBER OF m.producers
                                WHERE m.mediaType = :mediaType
                        """, Person.class)
                                 .setParameter("mediaType", mediaType)
                                 .getResultList();
    }

    public Double getAverageRatingByPerson(Long personId) {
        return getEntityManager().createQuery(
                """
                        SELECT AVG(m.rating) FROM Media m
                        LEFT JOIN m.actors a
                        LEFT JOIN m.directors d
                        LEFT JOIN m.producers p
                        LEFT JOIN m.authors au
                        WHERE a.personId = :personId
                        OR d.personId = :personId
                        OR p.personId = :personId
                        OR au.personId = :personId
                        """, Double.class)
                                 .setParameter("personId", personId)
                                 .getSingleResult();
    }
}
