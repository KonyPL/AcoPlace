package put.poznan.AcoPlaceBackend.controller.OLD;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import put.poznan.AcoPlaceBackend.model.OLD.WebUser;
import put.poznan.AcoPlaceBackend.service.OLD.UserService;

import java.util.List;

@RestController
@CrossOrigin()//tu mozna dac  z jakieg hosta pozniej
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<WebUser> getAllUsers(){
        return userService.getAllUsers();
    }
}
