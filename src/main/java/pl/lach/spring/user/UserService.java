package pl.lach.spring.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lach.spring.assignment.AssignmentDto;
import pl.lach.spring.assignment.AssignmentMapper;

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
        return mapUser(userDto);
    }

    UserDto update(UserDto userDto) {
        Optional<User> user = userRepository.findByPesel(userDto.getPesel());
        user.ifPresent(u -> {
            if (!userDto.getPesel().equals(u.getPesel()))
                throw new NotUniquePeselException();
        });
        return mapUser(userDto);

    }

    Optional<UserDto> findById(Long id) {
        return userRepository.findById(id).map(UserMapper::toDto);
    }


    List<AssignmentDto> getAllAssignmentForUser(Long id){
        Optional<User> user = userRepository.findById(id);
        return user.map(User::getAssignments).orElseThrow(UserNotFoundException::new)
                .stream()
                .map(AssignmentMapper::toDto)
                .collect(Collectors.toList());
    }

    private UserDto mapUser(UserDto userDto) {
        User save = userRepository.save(UserMapper.toEntity(userDto));
        return UserMapper.toDto(save);
    }

}
