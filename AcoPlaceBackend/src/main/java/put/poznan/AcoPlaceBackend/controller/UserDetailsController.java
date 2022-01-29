package put.poznan.AcoPlaceBackend.controller;

import org.springframework.web.bind.annotation.*;
import put.poznan.AcoPlaceBackend.model.UserDetails;
import put.poznan.AcoPlaceBackend.service.UserDetailsService;
import put.poznan.AcoPlaceBackend.service.UserService;

import java.util.List;

@RestController
@CrossOrigin()
public class UserDetailsController {
    private final UserDetailsService userDetailsService;
    private final UserService userService;

    public UserDetailsController(UserDetailsService userDetailsService, UserService userService) {
        this.userDetailsService = userDetailsService;
        this.userService = userService;
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

    @GetMapping("/free/userDetails/{id}/profilePicture")
    public String getUserProfilePicture(@PathVariable Integer id){
        return userDetailsService.getUserProfilePictureById(id);
    }

    @GetMapping("/currentUserDetails")
    public UserDetails getCurrentUserDetails(){
        System.out.println("currentUserDetails called");
        UserDetails userDetails = userDetailsService.getCurrentUserDetails();
        System.out.println("zracam z currentUserDetails"+userDetails.toString());

        return userDetails;
    }
}
