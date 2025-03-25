package at.htl.leonding.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Media {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long mediaId;
	private int length;
	private LocalDate releaseDate;
	private int rating;
	private int edition;
	private String name;
	private String description;

	@Enumerated(EnumType.STRING)
	private MediaType mediaType;

	@ManyToMany()
	@JoinTable(joinColumns = {@JoinColumn(name = "mediaId")}, inverseJoinColumns = {@JoinColumn(name = "mediaId")})
	private List<Media> subMedia;

	@ManyToMany()
	@JoinTable(joinColumns = {@JoinColumn(name = "mediaId")}, inverseJoinColumns = {@JoinColumn(name = "tagId")})
	private List<Tag> tags;

	@ManyToMany()
	@JoinTable(joinColumns = {@JoinColumn(name = "mediaId")}, inverseJoinColumns = {@JoinColumn(name = "personId")})
	private List<Person> directors;

	@ManyToMany()
	@JoinTable(joinColumns = {@JoinColumn(name = "mediaId")}, inverseJoinColumns = {@JoinColumn(name = "personId")})
	private List<Person> producers;

	@ManyToMany()
	@JoinTable(joinColumns = {@JoinColumn(name = "mediaId")}, inverseJoinColumns = {@JoinColumn(name = "personId")})
	private List<Person> actors;

	@ManyToMany()
	@JoinTable(joinColumns = {@JoinColumn(name = "mediaId")}, inverseJoinColumns = {@JoinColumn(name = "personId")})
	private List<Person> authors;

	public Media() {
	}

	public Media(Long mediaId, int length, LocalDate releaseDate, int rating, int edition, String name,
	             String description, MediaType mediaType) {
		this.mediaId = mediaId;
		this.setLength(length);
		this.setReleaseDate(releaseDate);
		this.setRating(rating);
		this.setEdition(edition);
		this.setName(name);
		this.setDescription(description);
		this.setMediaType(mediaType);
	}

	public Media(String description) {
		this.setDescription(description);
	}

	public int getLength() {
		return length;
	}

	public Media setLength(int length) {
		this.length = length;
		return this;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public Media setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
		return this;
	}

	public int getRating() {
		return rating;
	}

	public Media setRating(int rating) {
		this.rating = rating;
		return this;
	}

	public int getEdition() {
		return edition;
	}

	public Media setEdition(int edition) {
		this.edition = edition;
		return this;
	}

	public String getName() {
		return name;
	}

	public Media setName(String name) {
		this.name = name;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public Media setDescription(String description) {
		this.description = description;
		return this;
	}

	public MediaType getMediaType() {
		return mediaType;
	}

	public Media setMediaType(MediaType mediaType) {
		this.mediaType = mediaType;
		return this;
	}
}
