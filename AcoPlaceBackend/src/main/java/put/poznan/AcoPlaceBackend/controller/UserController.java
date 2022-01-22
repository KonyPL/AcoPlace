package put.poznan.AcoPlaceBackend.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import put.poznan.AcoPlaceBackend.model.WebUser;
import put.poznan.AcoPlaceBackend.service.UserService;

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

    @GetMapping("/user/current")
    public WebUser getCurrentUser(){

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println("GET USER CALLED, user name="+username);
        return userService.finByUserName(username);
    }
}
