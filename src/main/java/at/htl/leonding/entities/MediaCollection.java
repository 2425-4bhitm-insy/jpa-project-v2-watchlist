package at.htl.leonding.entities;

import jakarta.persistence.*;

@Entity
public class MediaCollection {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	Long mediaCollectionId;

	@ManyToOne()
	@JoinColumn(name = "mediaID", nullable = false)
	Media parentMedia;

	@ManyToOne()
	@JoinColumn(name = "mediaID", nullable = false)
	Media subMedia;


	int ordering;
}
