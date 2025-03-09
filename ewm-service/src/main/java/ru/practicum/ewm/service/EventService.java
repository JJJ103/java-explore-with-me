package ru.practicum.ewm.service;

import ru.practicum.ewm.dto.event.EventFullDto;
import ru.practicum.ewm.dto.event.NewEventDto;
import ru.practicum.ewm.dto.event.UpdateEventAdminRequest;

import java.util.List;

public interface EventService {
    EventFullDto createEvent(Long userId, NewEventDto newEventDto);

    List<EventFullDto> searchEvents(List<Long> users, List<String> states, List<Long> categories,
                                    String rangeStart, String rangeEnd, int from, int size);

    EventFullDto updateAdminEvent(Long eventId, UpdateEventAdminRequest updateRequest);
}
