package pl.lach.spring.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
