package at.htl.leonding.entities;

import jakarta.persistence.*;

@Entity
public class MediaCollection {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	Long mediaCollectionId;

	@ManyToOne()
	@JoinColumn(name = "parentMediaID", nullable = false)
	Media parentMedia;

	@ManyToOne()
	@JoinColumn(name = "subMediaID", nullable = false)
	Media subMedia;


	int ordering;
}
