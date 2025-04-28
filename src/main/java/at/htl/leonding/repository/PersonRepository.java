package at.htl.leonding.repository;

import at.htl.leonding.entities.Person;
import at.htl.leonding.entities.PersonType;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonRepository extends BetterRepository<Person> {
	public PersonRepository() {
		super(Person.class);
	}

	public Person getMostRelevant(PersonType pt) {
		String query = """
        SELECT p
        FROM Person p
        JOIN %s r ON p.personId = r.personId
        JOIN Media m ON r.mediaId = m.mediaId
        WHERE r.personType = :personType
        GROUP BY p.personId
        ORDER BY SUM(m.duration) DESC
    """.formatted(pt);

		return getEntityManager()
				.createQuery(query, Person.class)
				.setParameter("personType", pt)
				.setMaxResults(1)
				.getResultStream()
				.findFirst()
				.orElse(null);
	}
}
