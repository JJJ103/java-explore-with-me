package ru.practicum.ewm.exceptions;

public class EventDateTooEarlyException extends RuntimeException {
    public EventDateTooEarlyException(String message) {
        super(message);
    }
}