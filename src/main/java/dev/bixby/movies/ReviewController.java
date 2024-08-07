package dev.bixby.movies;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// since this request happens within the movies page we can requuest that the
// data
// be sent to the /movies endpoint instead of creating a new one just for the
// review
@RequestMapping("/api/v1/reviews")

public class ReviewController {

  @Autowired
  private ReviewService reviewService;

  @PostMapping
  public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {
    Review review = reviewService.createReview(payload.get("reviewBody"), payload.get("imdbId"));
    if (review == null) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<>(review, HttpStatus.CREATED);
  }
}
