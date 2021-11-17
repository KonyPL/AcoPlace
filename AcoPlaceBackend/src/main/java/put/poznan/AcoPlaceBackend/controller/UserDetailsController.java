package put.poznan.AcoPlaceBackend.controller;

import org.springframework.web.bind.annotation.*;
import put.poznan.AcoPlaceBackend.model.UserDetails;
import put.poznan.AcoPlaceBackend.service.UserDetailsService;

import java.util.List;

@RestController
@CrossOrigin()
public class UserDetailsController {
    private final UserDetailsService userDetailsService;

    public UserDetailsController(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("/userDetailsAll")
    public List<UserDetails> getAllUserDetails(){
        return userDetailsService.getAllUserDetails();
    }

    @GetMapping("/userDetails/{id}")
    public  UserDetails getUserDetailsById(long id){
        return userDetailsService.getUserById(id);
    }

    @PostMapping("/addUserDetails/")
    public UserDetails createUserDetails(@RequestBody UserDetails userDetails){
        return userDetailsService.saveUserDetails(userDetails);
    }
}
