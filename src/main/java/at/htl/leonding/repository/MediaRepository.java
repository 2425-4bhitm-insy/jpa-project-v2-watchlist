package at.htl.leonding.repository;

import at.htl.leonding.entities.Media;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MediaRepository extends BetterRepository<Media> {
	public MediaRepository() {
		super(Media.class);
	}
}
