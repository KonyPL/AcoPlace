package put.poznan.AcoPlaceBackend.controller;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import put.poznan.AcoPlaceBackend.model.WebUser;
import put.poznan.AcoPlaceBackend.service.UserService;

import java.util.List;

@RestController
@CrossOrigin()
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<WebUser> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/user/getuser") ///user/getuser
    public WebUser getUser(){
        System.out.println("NAME="+SecurityContextHolder.getContext().getAuthentication().getName());
        return userService.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}
