package dev.bixby.movies;

import java.util.List;
import java.util.Optional;

// import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// where most of our business logic will go 
//uses the repository class and talks to the db and get s a list of hte movies and returns 
@Service
public class MovieService {

  // reference of movie reposity
  @Autowired // used to initialize this bit of code so that the we can get allMovies
  private MovieRepository movieRepository;

  public List<Movie> allMovies() {
    return movieRepository.findAll();
  }

  public Optional<Movie> singleMovie(String imdbId) {
    return movieRepository.findMovieByImdbId(imdbId);
  }

}
