package com.enterprise.netmovies.show;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShowRepository extends MongoRepository<Show, String> {
}
