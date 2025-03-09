package ru.practicum.ewm.dto;

import ru.practicum.ewm.dto.event.EventShortDto;

import java.util.Set;

public class CompilationDto {
    private Long id;
    private Set<EventShortDto> events;
    private Boolean pinned;
    private String title;
}