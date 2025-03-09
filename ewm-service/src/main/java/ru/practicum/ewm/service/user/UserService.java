package ru.practicum.ewm.service.user;

import ru.practicum.ewm.dto.user.NewUserRequest;
import ru.practicum.ewm.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers(List<Long> ids, int from, int size);
    User createUser(NewUserRequest userRequest);
    void deleteUser(Long userId);
}