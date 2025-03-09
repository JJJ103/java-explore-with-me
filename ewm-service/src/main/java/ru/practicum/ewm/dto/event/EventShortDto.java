package ru.practicum.ewm.dto.event;

import lombok.Data;
import ru.practicum.ewm.dto.CategoryDto;
import ru.practicum.ewm.dto.user.UserShortDto;

@Data
public class EventShortDto {
    private Long id;
    private String annotation;
    private CategoryDto category;
    private Long confirmedRequests;
    private String eventDate;
    private UserShortDto initiator;
    private Boolean paid;
    private String title;
    private Long views;
}