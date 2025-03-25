package at.htl.leonding.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tag {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long tagId;
	private String name;

	public Tag() {
	}

	public Tag(Long tagId, String name) {
		this.tagId = tagId;
		this.setName(name);
	}

	public Long getTagId() {
		return tagId;
	}

	public String getName() {
		return name;
	}

	public Tag setName(String name) {
		this.name = name;
		return this;
	}
}
