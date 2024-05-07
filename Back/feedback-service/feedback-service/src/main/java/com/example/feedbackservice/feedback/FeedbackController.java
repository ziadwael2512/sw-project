package com.example.feedbackservice.feedback;


import com.example.feedbackservice.feedback.dto.FeedbackAddRequest;
import com.example.feedbackservice.feedback.dto.FeedbackPaginationResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
@Validated
@RequiredArgsConstructor
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService; // Optional, if you have service layer

    @GetMapping
    public ResponseEntity<FeedbackPaginationResponse> getAllFeedback(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                                     @RequestParam(value = "limit", defaultValue = "100") Integer limit) {
        FeedbackPaginationResponse response = feedbackService.getAllFeedback(PageRequest.of(page, limit));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createFeedback(@Valid @RequestBody FeedbackAddRequest feedbackAddRequest) {
        feedbackService.saveFeedback(feedbackAddRequest);
        return new ResponseEntity<>("Feedback created.", HttpStatus.CREATED);
    }
}
