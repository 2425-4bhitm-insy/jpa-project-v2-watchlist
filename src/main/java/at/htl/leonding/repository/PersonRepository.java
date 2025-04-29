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

		if (pt == PersonType.actors) {
			return getEntityManager()
					.createQuery("""
				   SELECT p
				   FROM  Media m
					   join Person p on p member of m.actors
				   group by p
				   order by sum(m.duration) desc
				   limit 1
				""", Person.class)
					.getSingleResult();
		}
		else if (pt == PersonType.authors) {
			return getEntityManager()
					.createQuery("""
				   SELECT p
				   FROM  Media m
					   join Person p on p member of m.authors
				   group by p
				   order by sum(m.duration) desc
				   limit 1
				""", Person.class)
					.getSingleResult();
		}
		else if (pt == PersonType.directors) {
			return getEntityManager()
					.createQuery("""
				   SELECT p
				   FROM  Media m
					   join Person p on p member of m.directors
				   group by p
				   order by sum(m.duration) desc
				   limit 1
				""", Person.class)
					.getSingleResult();
		}
		else if (pt == PersonType.producers) {
			return getEntityManager()
					.createQuery("""
				   SELECT p
				   FROM  Media m
					   join Person p on p member of m.producers
				   group by p
				   order by sum(m.duration) desc
				   limit 1
				""", Person.class)
					.getSingleResult();
		}
		return null;
	}
}
