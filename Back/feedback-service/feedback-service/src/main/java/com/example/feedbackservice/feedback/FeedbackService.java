package com.example.feedbackservice.feedback;

import com.example.feedbackservice.feedback.dto.FeedbackAddRequest;
import com.example.feedbackservice.feedback.dto.FeedbackPaginationResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    public Feedback saveFeedback(@Valid FeedbackAddRequest request) {
        Feedback feedback = Feedback.builder()
                .bookId(request.getBookId())
                .userId(request.getUserId())
                .comment(request.getComment())
                .build();
        log.info("Saving feedback..." + feedback);
        return feedbackRepository.save(feedback);
    }

    public FeedbackPaginationResponse getAllFeedback(Pageable pageable) {
        log.info("getting feedback...");
        Page<Feedback> feedbackPages = feedbackRepository.findAll(pageable);
        log.info("got feedback..." + feedbackPages.getContent());

        FeedbackPaginationResponse response = new FeedbackPaginationResponse();
        response.setFeedbacks(feedbackPages.getContent());

        response.setFirst(feedbackPages.isFirst());
        response.setLast(feedbackPages.isLast());
        response.setPageNumber(feedbackPages.getNumber());
        response.setNumberOfElements(feedbackPages.getNumberOfElements());
        response.setTotalPages(feedbackPages.getTotalPages());
        response.setTotalElements(feedbackPages.getTotalElements());
        return response;
    }
}
