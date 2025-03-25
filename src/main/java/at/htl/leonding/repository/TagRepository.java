package at.htl.leonding.repository;

import at.htl.leonding.entities.Tag;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TagRepository extends BetterRepository<Tag> {
	public TagRepository() {
		super(Tag.class);
	}
}
