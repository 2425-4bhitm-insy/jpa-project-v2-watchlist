package at.htl.leonding.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Tag {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long tagId;
	private String name;

	@JsonIgnore
	@ManyToMany(mappedBy = "tags")
	public Set<Media> media = new HashSet<>();

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
