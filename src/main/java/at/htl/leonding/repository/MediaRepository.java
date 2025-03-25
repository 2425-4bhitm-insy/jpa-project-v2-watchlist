package at.htl.leonding.repository;

import at.htl.leonding.entities.Media;

public class MediaRepository extends BetterRepository<Media> {
	public MediaRepository() {
		super(Media.class);
	}
}
