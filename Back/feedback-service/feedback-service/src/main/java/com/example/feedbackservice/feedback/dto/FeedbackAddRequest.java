package com.example.feedbackservice.feedback.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class FeedbackAddRequest {
    @NotBlank(message = "bookId is mandatory.")
    private Long bookId;

    @NotBlank(message = "userId is mandatory.")
    private Long userId;

    @NotBlank(message = "comment is mandatory.")
    private String comment;
}
