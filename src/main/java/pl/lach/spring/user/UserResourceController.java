package pl.lach.spring.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserResourceController {

    private UserService userService;

    public UserResourceController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("")
    public List<UserDto> findAll() {
        return userService.findAll();
    }
}
