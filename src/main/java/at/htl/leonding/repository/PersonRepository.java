package at.htl.leonding.repository;

import at.htl.leonding.entities.Person;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class PersonRepository extends BetterRepository<Person> {
	public PersonRepository() {
		super(Person.class);
	}

	public Person getMostRelevantActor() {
		return super.listAll().stream()
				.filter(this::isActor) // Step 2: Filter for actors
				.sorted((a, b) -> Integer.compare(getMediaCountForActor(b), getMediaCountForActor(a))) // Step 3: Sort by relevance
				.findFirst() // Step 4: Get the most relevant actor
				.orElse(null); // Return null if no actor is found
	}

	private boolean isActor(Person person) {
		return getEntityManager()
				.createQuery("SELECT COUNT(a) FROM Actor a WHERE a.personId = :personId", Long.class)
				.setParameter("personId", person.getPersonId())
				.getSingleResult() > 0;
	}

	private int getMediaCountForActor(Person person) {
		return getEntityManager()
				.createQuery("SELECT COUNT(a.mediaId) FROM Actor a WHERE a.personId = :personId", Long.class)
				.setParameter("personId", person.getPersonId())
				.getSingleResult()
				.intValue();
	}
}
