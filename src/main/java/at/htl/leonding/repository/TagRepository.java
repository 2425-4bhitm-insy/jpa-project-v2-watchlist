package at.htl.leonding.repository;

import at.htl.leonding.entities.Tag;

public class TagRepository extends BetterRepository<Tag> {
	public TagRepository() {
		super(Tag.class);
	}
}
