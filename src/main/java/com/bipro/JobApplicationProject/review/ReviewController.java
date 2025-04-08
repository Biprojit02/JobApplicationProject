package com.bipro.JobApplicationProject.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
    ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReview(@PathVariable Long companyId){
        return ResponseEntity.ok(reviewService.getAllReview(companyId));
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable Long companyId, @RequestBody Review review){
         boolean isReviewSaved = reviewService.addReview(companyId, review);
         if(isReviewSaved){
            return new ResponseEntity<>("Review added successfully", HttpStatus.OK);
         }
         else{
            return new ResponseEntity<>("Review not added", HttpStatus.NOT_FOUND);
         }
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long companyId, @PathVariable Long reviewId){
        return new ResponseEntity<>(reviewService.getReview(companyId, reviewId), HttpStatus.OK);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId,
                                               @PathVariable Long reviewId,
                                               @RequestBody Review review){
        boolean isUpdatedReview = reviewService.updateReview(companyId, reviewId, review);
        if(isUpdatedReview){
            return new ResponseEntity<>("Review Updated Successfully", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Review not updated", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId,
                             @PathVariable Long reviewId){
        boolean isReviewDeleted = reviewService.deleteReview(companyId, reviewId);
        if(!isReviewDeleted){
            return new ResponseEntity<>("Review Deleted Successfully", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Review Not Found", HttpStatus.OK);
        }
    }
    // 5:59:15
}
