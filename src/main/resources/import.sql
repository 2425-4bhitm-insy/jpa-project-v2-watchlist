-- Insert test data for Media
INSERT INTO Media (mediaId, duration, releaseDate, rating, edition, name, description, mediaType) VALUES
                                                                                                    (nextval('media_seq'), 120, '2023-01-01', 5, 1, 'Movie 1', 'Description for Movie 1', 'MOVIE'),
                                                                                                    (nextval('media_seq'), 45, '2023-02-01', 4, 1, 'Series 1', 'Description for Series 1', 'SERIES'),
                                                                                                    (nextval('media_seq'), 60, '2023-03-01', 3, 1, 'Episode 1', 'Description for Episode 1', 'EPISODE');

-- Insert test data for Person
INSERT INTO Person (personId, firstName, lastName, email) VALUES
                                                              (nextval('person_seq'), 'John', 'Doe', 'john.doe@example.com'),
                                                              (nextval('person_seq'), 'Jane', 'Smith', 'jane.smith@example.com'),
                                                              (nextval('person_seq'), 'Alice', 'Johnson', 'alice.johnson@example.com');

-- Insert test data for Tag
INSERT INTO Tag (tagId, name) VALUES
                                  (nextval('tag_seq'), 'Action'),
                                  (nextval('tag_seq'), 'Drama'),
                                  (nextval('tag_seq'), 'Comedy');

-- Insert test data for Media and Person relationships
INSERT INTO media_directors (mediaId, personId) VALUES
                                                    ((SELECT mediaId FROM Media WHERE name = 'Movie 1'), (SELECT personId FROM Person WHERE firstName = 'John' AND lastName = 'Doe')),
                                                    ((SELECT mediaId FROM Media WHERE name = 'Series 1'), (SELECT personId FROM Person WHERE firstName = 'Jane' AND lastName = 'Smith'));

INSERT INTO media_actors (mediaId, personId) VALUES
                                                 ((SELECT mediaId FROM Media WHERE name = 'Movie 1'), (SELECT personId FROM Person WHERE firstName = 'Alice' AND lastName = 'Johnson')),
                                                 ((SELECT mediaId FROM Media WHERE name = 'Series 1'), (SELECT personId FROM Person WHERE firstName = 'John' AND lastName = 'Doe'));

INSERT INTO media_producers (mediaId, personId) VALUES
                                                    ((SELECT mediaId FROM Media WHERE name = 'Movie 1'), (SELECT personId FROM Person WHERE firstName = 'Jane' AND lastName = 'Smith')),
                                                    ((SELECT mediaId FROM Media WHERE name = 'Episode 1'), (SELECT personId FROM Person WHERE firstName = 'Alice' AND lastName = 'Johnson'));

INSERT INTO media_authors (mediaId, personId) VALUES
                                                  ((SELECT mediaId FROM Media WHERE name = 'Series 1'), (SELECT personId FROM Person WHERE firstName = 'Alice' AND lastName = 'Johnson')),
                                                  ((SELECT mediaId FROM Media WHERE name = 'Episode 1'), (SELECT personId FROM Person WHERE firstName = 'John' AND lastName = 'Doe'));

-- Insert test data for Media and Tag relationships
INSERT INTO media_tags (mediaId, tagId) VALUES
                                            ((SELECT mediaId FROM Media WHERE name = 'Movie 1'), (SELECT tagId FROM Tag WHERE name = 'Action')),
                                            ((SELECT mediaId FROM Media WHERE name = 'Series 1'), (SELECT tagId FROM Tag WHERE name = 'Drama')),
                                            ((SELECT mediaId FROM Media WHERE name = 'Episode 1'), (SELECT tagId FROM Tag WHERE name = 'Comedy'));



INSERT INTO Media (mediaId, duration, releaseDate, rating, edition, name, description, mediaType) VALUES
(nextval('media_seq'), 90, '2023-01-01', 5, 1, 'Series', 'Series all episodes', 'SERIES'),
(nextval('media_seq'), 90, '2023-01-01', 5, 1, 'Episode ONE', 'Series episode 1', 'EPISODE'),
(nextval('media_seq'), 90, '2023-01-01', 5, 1, 'Episode TWO', 'Series episode 1', 'EPISODE'),
(nextval('media_seq'), 90, '2023-01-01', 5, 1, 'Episode THREE', 'Series episode 1', 'EPISODE'),
(nextval('media_seq'), 90, '2023-01-01', 5, 1, 'Episode FOUR', 'Series episode 1', 'EPISODE');

INSERT INTO MediaCollection (mediaCollectionId, parentMediaId, subMediaId, ordering) VALUES
(nextval('mediacollection_seq'), (SELECT mediaId FROM Media WHERE name = 'Series'), (SELECT mediaId FROM Media WHERE name = 'Episode ONE'), 1),
(nextval('mediacollection_seq'), (SELECT mediaId FROM Media WHERE name = 'Series'), (SELECT mediaId FROM Media WHERE name = 'Episode TWO'), 2),
(nextval('mediacollection_seq'), (SELECT mediaId FROM Media WHERE name = 'Series'), (SELECT mediaId FROM Media WHERE name = 'Episode THREE'), 3),
(nextval('mediacollection_seq'), (SELECT mediaId FROM Media WHERE name = 'Series'), (SELECT mediaId FROM Media WHERE name = 'Episode FOUR'), 4);

