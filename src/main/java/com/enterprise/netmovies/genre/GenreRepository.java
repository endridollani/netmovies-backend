package com.enterprise.netmovies.genre;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface GenreRepository extends MongoRepository<Genre, String> {
}
