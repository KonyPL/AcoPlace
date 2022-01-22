package put.poznan.AcoPlaceBackend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import put.poznan.AcoPlaceBackend.model.AuthenticationResponse;
import put.poznan.AcoPlaceBackend.model.LoginRequest;
import put.poznan.AcoPlaceBackend.model.RegisterRequest;
import put.poznan.AcoPlaceBackend.service.AuthService;

@RestController
@RequestMapping("/api/auth")
//@CrossOrigin()
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody RegisterRequest registerRequest) {
        System.out.println("JESTEM W SIGNUP");
        authService.signup(registerRequest);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {
        System.out.println("jestem w login component");
        return authService.login(loginRequest);
    }

}
