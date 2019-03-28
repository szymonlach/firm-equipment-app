package pl.lach.spring.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    List<UserDto> findAll() {
        return userRepository.findAll().stream().map(UserMapper::toDto).collect(Collectors.toList());
    }

    List<UserDto> findAllByLastNameContainingIgnoreCase(String lastName) {
        return userRepository.findAllByLastNameContainingIgnoreCase(lastName).stream().map(UserMapper::toDto).collect(Collectors.toList());
    }
}
