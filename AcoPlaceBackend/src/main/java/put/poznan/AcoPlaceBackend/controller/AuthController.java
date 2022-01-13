package put.poznan.AcoPlaceBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import put.poznan.AcoPlaceBackend.exception.ResourceNotFoundException;
import put.poznan.AcoPlaceBackend.model.*;
import put.poznan.AcoPlaceBackend.repository.UserRepository;

import java.util.Collections;

@CrossOrigin()
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signin")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto){
        System.out.println("LOGIN DTO="+loginDto.toString());
        System.out.println("SECURITY CONTEXT HOLDER NAME before setting authentacion="+ SecurityContextHolder.getContext().getAuthentication().getName());

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.out.println("securitynname after setting authentication="+SecurityContextHolder.getContext().getAuthentication().getName());
        return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto){

      /*  // add check for username exists in a DB
        if(userRepository.existsByUsername(signUpDto.getUsername())){
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }

        // add check for email exists in DB
        if(userRepository.existsByEmail(signUpDto.getEmail())){
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }*/

        // create user object
        WebUser user = new WebUser();
        user.setName(signUpDto.getName());
        user.setUsername(signUpDto.getUsername());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));

        user.setRole("USER");

        userRepository.save(user);

        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);

    }

    @GetMapping("/currentUserName")
    UserNameDto getCurrentUserName(){
        //String nameOrEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        //Authentication auth = httpServletRequest.getUserPrincipal();

        System.out.println("Jestem w userNameDto pobrane username"+SecurityContextHolder.getContext().getAuthentication().getName());
        UserNameDto userNameDto= new UserNameDto(SecurityContextHolder.getContext().getAuthentication().getName());
        return userNameDto;
    }

    @GetMapping("/currentUserObject")
    WebUser getCurrentUserObject(){
        //String nameOrEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println("SECURITY CONTEXT HOLDER NAME="+ SecurityContextHolder.getContext().getAuthentication().getName());

        return userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()).orElseThrow(() -> new ResourceNotFoundException("user not found"));
    }

    @GetMapping("/currentUserRole")
    String getCurrentUserRole(){
        System.out.println("SECURITY CONTEXT HOLDER NAME="+ SecurityContextHolder.getContext().getAuthentication().getName());

        WebUser webUser = userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()).orElseThrow(() -> new ResourceNotFoundException("user not found"));
    return webUser.getRole();
    }

    @GetMapping("/isLoggedIn")
    public boolean isLoggedIn() {
        System.out.println("SECURITY CONTEXT HOLDER NAME="+ SecurityContextHolder.getContext().getAuthentication().getName());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return !(authentication instanceof AnonymousAuthenticationToken) && authentication.isAuthenticated();
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logoutUser(){
        System.out.println("SECURITY CONTEXT HOLDER NAME before logout="+ SecurityContextHolder.getContext().getAuthentication().getName());

        SecurityContextHolder.getContext().setAuthentication(null);
        System.out.println("SECURITY CONTEXT HOLDER NAME after logoue="+ SecurityContextHolder.getContext().getAuthentication().getName().toString());

        return new ResponseEntity<>("Log out successfully!.", HttpStatus.OK);
    }
}

