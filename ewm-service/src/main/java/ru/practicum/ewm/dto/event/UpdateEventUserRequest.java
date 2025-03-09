package ru.practicum.ewm.dto.event;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Size;
import lombok.Data;
import ru.practicum.ewm.model.Location;

@Data
public class UpdateEventUserRequest {
    @Size(min = 20, max = 2000)
    private String annotation;

    private Long category;

    @Size(min = 20, max = 7000)
    private String description;

    @Future
    private String eventDate;

    private Location location;

    private Boolean paid;

    private Long participantLimit;

    private Boolean requestModeration;

    private String stateAction; // SEND_TO_REVIEW или CANCEL_REVIEW

    @Size(min = 3, max = 120)
    private String title;
}