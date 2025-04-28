package at.htl.leonding.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long personId;
	private String firstName;
	private String lastName;
	private String email;

	public Person() {
	}

	public Person(Long personId, String email, String lastName, String firstName) {
		this.email = email;
		this.lastName = lastName;
		this.firstName = firstName;
		this.personId = personId;
	}


	public Long getPersonId() {
		return personId;
	}

	private void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getFirstName() {
		return firstName;
	}

	private void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	private void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	private void setEmail(String email) {
		this.email = email;
	}
}
