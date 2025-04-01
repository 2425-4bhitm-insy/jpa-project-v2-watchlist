package at.htl.leonding.repository;

import at.htl.leonding.entities.Person;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonRepository extends BetterRepository<Person> {
	public PersonRepository() {
		super(Person.class);
	}
}
