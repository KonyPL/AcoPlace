package put.poznan.AcoPlaceBackend.service;

import org.springframework.stereotype.Service;
import put.poznan.AcoPlaceBackend.model.WebUser;
import put.poznan.AcoPlaceBackend.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<WebUser> getAllUsers() {
        return userRepository.findAll();
    }

    public WebUser getUserById(long id){
        return userRepository.getById(id);
    }

    public WebUser saveWebUser(WebUser webUser){
        return userRepository.save(webUser);
    }
}
