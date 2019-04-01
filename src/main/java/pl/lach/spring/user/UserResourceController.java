package pl.lach.spring.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserResourceController {

    private UserService userService;

    public UserResourceController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(path = "")
    public List<UserDto> findAll(@RequestParam(required = false) String lastName) {
        if (lastName == null)
            return userService.findAll();
        else return userService.findAllByLastNameContainingIgnoreCase(lastName);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable Long id) {
        Optional<UserDto> userDto = userService.findById(id);
        return userDto.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{userId}/assignments")
    public List<UserAssignmentDto> findAllAssignment(@PathVariable Long userId) {
        return userService.getAllAssignmentForUser(userId);
    }

    @PostMapping("")
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto) {
        if (userDto.getId() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Obiekt nie może mieć ustawionego id");
        }
        UserDto savedUser = userService.save(userDto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).body(savedUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@PathVariable Long id, @RequestBody UserDto userDto) {
        if (!id.equals(userDto.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Obiekt musi mieć takie samo id jak podane w ścieżce");
        }
        UserDto savedUser = userService.update(userDto);
        return ResponseEntity.ok(savedUser);
    }
}
