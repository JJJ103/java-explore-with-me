package ru.practicum.ewm.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError handleNotFoundException(NotFoundException e) {
        return new ApiError(
                "NOT_FOUND",
                "The required object was not found.",
                e.getMessage(),
                System.currentTimeMillis()
        );
    }

    @ExceptionHandler(ConflictException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ApiError handleConflictException(ConflictException e) {
        return new ApiError(
                "CONFLICT",
                "Integrity constraint has been violated.",
                e.getMessage(),
                System.currentTimeMillis()
        );
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleBadRequestException(BadRequestException e) {
        return new ApiError(
                "BAD_REQUEST",
                "Incorrectly made request.",
                e.getMessage(),
                System.currentTimeMillis()
        );
    }

    @ExceptionHandler(EventDateTooEarlyException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ApiError handleEventDateTooEarly(EventDateTooEarlyException e) {
        return new ApiError(
                "CONFLICT",
                "For the requested operation the conditions are not met.",
                e.getMessage(),
                System.currentTimeMillis()
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleValidationException(MethodArgumentNotValidException e) {
        String errorMessage = e.getBindingResult().getFieldErrors().stream()
                .map(error -> String.format("Field: %s. Error: %s. Value: %s",
                        error.getField(),
                        error.getDefaultMessage(),
                        error.getRejectedValue() == null ? "null" : error.getRejectedValue()))
                .collect(Collectors.joining(", "));

        return new ApiError(
                "BAD_REQUEST",
                "Incorrectly made request.",
                errorMessage,
                System.currentTimeMillis()
        );
    }
}