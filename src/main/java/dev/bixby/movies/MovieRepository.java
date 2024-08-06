package dev.bixby.movies;

import java.util.Optional;

// data access layer for our api, it does the job odf actually talking to the db and getting the data back
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface MovieRepository extends MongoRepository<Movie, ObjectId> {

  Optional<Movie> findMovieByImdbId(String imdbId);

}