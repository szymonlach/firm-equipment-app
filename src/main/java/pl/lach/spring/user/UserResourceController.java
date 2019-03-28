package pl.lach.spring.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

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
}
