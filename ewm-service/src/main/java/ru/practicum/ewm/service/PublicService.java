package ru.practicum.ewm.service;


import org.springframework.stereotype.Service;

import ru.practicum.ewm.repository.EventRepository;
import ru.practicum.stats.client.StatsClient;


@Service
public class PublicService {
    private final EventRepository eventRepository;
    private final StatsClient statsClient;

    public PublicService(EventRepository eventRepository, StatsClient statsClient) {
        this.eventRepository = eventRepository;
        this.statsClient = statsClient;
    }
}