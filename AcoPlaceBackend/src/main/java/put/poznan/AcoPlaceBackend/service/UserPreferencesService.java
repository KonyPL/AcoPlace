package put.poznan.AcoPlaceBackend.service;

import org.springframework.stereotype.Service;
import put.poznan.AcoPlaceBackend.model.UserPreferences;
import put.poznan.AcoPlaceBackend.repository.UserPreferencesRepository;

import java.util.List;

@Service
public class UserPreferencesService {
    private final UserPreferencesRepository userPreferencesRepository;

    public UserPreferencesService(UserPreferencesRepository userPreferencesRepository) {
        this.userPreferencesRepository = userPreferencesRepository;
    }

    public List<UserPreferences> getAllUserPreferences(){
        return userPreferencesRepository.findAll();
    }

    public UserPreferences getUserPreferencesById(long id){
        return userPreferencesRepository.getById(id);
    }
}
