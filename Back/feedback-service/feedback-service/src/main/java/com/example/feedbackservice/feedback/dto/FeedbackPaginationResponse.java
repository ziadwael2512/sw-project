package com.example.feedbackservice.feedback.dto;

import com.example.feedbackservice.common.responses.PaginationResponse;
import com.example.feedbackservice.feedback.Feedback;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackPaginationResponse extends PaginationResponse {
    private List<Feedback> feedbacks;
}
