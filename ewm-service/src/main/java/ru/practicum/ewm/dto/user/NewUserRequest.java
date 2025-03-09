package ru.practicum.ewm.dto.user;

import jakarta.validation.constraints.*;
import lombok.Data;


@Data
public class NewUserRequest {
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 250, message = "Name length must be between 2 and 250")
    private String name;

    @NotNull(message = "Email cannot be null")
    @Email(message = "Email should be valid")
    @Size(min = 6, max = 254, message = "Email length must be between 6 and 254")
    private String email;
}