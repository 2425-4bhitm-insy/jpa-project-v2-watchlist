package at.htl.leonding.repository;

import at.htl.leonding.entities.Person;

public class PersonRepository extends BetterRepository<Person> {
	public PersonRepository() {
		super(Person.class);
	}
}
