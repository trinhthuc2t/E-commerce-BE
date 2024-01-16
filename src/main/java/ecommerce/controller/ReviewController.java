package ecommerce.controller;

import ecommerce.entity.Review;
import ecommerce.repository.IReviewRepo;
import ecommerce.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/reviews")
public class ReviewController {
    @Autowired
    IReviewService reviewService;
    @GetMapping("/{id}")
    public ResponseEntity<Page<Review>>  findByProductId(@PathVariable Long id,
                                                         @RequestParam(value = "page", defaultValue = "0") int page,
                                                         @RequestParam(value = "size", defaultValue = "24") int size){
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "createdAt"));
        Page<Review> reviews = reviewService.findByProductId(id, pageable);
        return ResponseEntity.ok(reviews);
    }
    @GetMapping("/{id}/avgRate")
    public ResponseEntity<Double> avgRate(@PathVariable Long id){
        Double rate = reviewService.avgRate(id);
        return ResponseEntity.ok(rate);
    }
}
