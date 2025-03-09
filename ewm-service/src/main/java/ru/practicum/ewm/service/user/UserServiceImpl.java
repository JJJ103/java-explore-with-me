package ru.practicum.ewm.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.practicum.ewm.dto.user.NewUserRequest;
import ru.practicum.ewm.exceptions.ConflictException;
import ru.practicum.ewm.exceptions.NotFoundException;
import ru.practicum.ewm.mapper.UserMapper;
import ru.practicum.ewm.model.User;
import ru.practicum.ewm.repository.UserRepository;
import ru.practicum.ewm.service.user.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<User> getUsers(List<Long> ids, int from, int size) {
        PageRequest page = PageRequest.of(from / size, size);

        if (ids != null && !ids.isEmpty()) {
            return userRepository.findAllById(ids);
        }
        return userRepository.findAll(page).getContent();
    }

    @Override
    public User createUser(NewUserRequest userRequest) {
        try {
            return userRepository.save(UserMapper.toUser(userRequest));
        } catch (DataIntegrityViolationException e) {
            throw new ConflictException("Field: email. Error: Email already exists. Value " + userRequest.getEmail());
        }
    }

    @Override
    public void deleteUser(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new NotFoundException("User with id=" + userId + " not found");
        }
        userRepository.deleteById(userId);
    }
}