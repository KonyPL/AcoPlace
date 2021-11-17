package put.poznan.AcoPlaceBackend.controller;

import org.springframework.web.bind.annotation.*;
import put.poznan.AcoPlaceBackend.model.UserPreferences;
import put.poznan.AcoPlaceBackend.service.UserPreferencesService;

import java.util.List;

@RestController
@CrossOrigin()
public class UserPreferencesController {
    private final UserPreferencesService userPreferencesService;

    public UserPreferencesController(UserPreferencesService userPreferencesService) {
        this.userPreferencesService = userPreferencesService;
    }

    @GetMapping("/userPreferencesAll")
    public List<UserPreferences> getAllUserPreferences(){
        return userPreferencesService.getAllUserPreferences();
    }

    @GetMapping("/userPreferences/{id}")
    public UserPreferences getUserPreferencesById(@PathVariable long id)
    {
        return userPreferencesService.getUserPreferencesById(id);
    }

    @PostMapping("/addUserPreferences")
    public UserPreferences createUserPreferences(@RequestBody UserPreferences userPreferences)
    {
        return userPreferencesService.saveUserPreferences(userPreferences);
    }
}
