package put.poznan.AcoPlaceBackend.service.OLD;

import org.springframework.stereotype.Service;
import put.poznan.AcoPlaceBackend.model.OLD.WebUser;
import put.poznan.AcoPlaceBackend.repository.OLD.UserRepository;

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
}
