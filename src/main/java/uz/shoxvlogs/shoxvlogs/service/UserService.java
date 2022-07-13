package uz.shoxvlogs.shoxvlogs.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import uz.shoxvlogs.shoxvlogs.intity.User;
import uz.shoxvlogs.shoxvlogs.repository.UserRepository;
import uz.shoxvlogs.shoxvlogs.service.dto.UserDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public Page<UserDTO> getAll(String key, Pageable pageable) {
        return userRepository.findAll(pageable).map(UserDTO::new);
    }

    public List<UserDTO> getAll() {
        return userRepository.findAll().stream().map(UserDTO::new).collect(Collectors.toList());
    }

    public List<User> getAllEntity() {
        return userRepository.findAll();
    }

    public Optional<UserDTO> getById(Long id) {
        return userRepository.findById(id).map(UserDTO::new);
    }

    public UserDTO create(User user) {
        if(user.getId() == null)
            return new UserDTO(userRepository.save(user));
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "user's id shoold be null");
    }

    public UserDTO update(User user) {
        if(user.getId() != null)
            return new UserDTO(userRepository.save(user));
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "user's id shoold not be null");

    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public Optional<UserDTO> getUserByLogin(String login) {
        return userRepository.findByLogin(login).map(UserDTO::new);
    }
}
