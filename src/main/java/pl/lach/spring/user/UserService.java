package pl.lach.spring.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.lach.spring.exception.NotUniquePeselException;

import java.net.URI;
import java.util.List;
import java.util.Optional;
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

    UserDto save(UserDto userDto) {
        Optional<User> user = userRepository.findByPesel(userDto.getPesel());
        user.ifPresent(u -> {
            throw new NotUniquePeselException();
        });
        User save = userRepository.save(UserMapper.toEntity(userDto));
        return UserMapper.toDto(save);
    }
}
