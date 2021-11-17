package put.poznan.AcoPlaceBackend.service;

import org.springframework.stereotype.Service;
import put.poznan.AcoPlaceBackend.model.UserDetails;
import put.poznan.AcoPlaceBackend.repository.UserDetailsRepository;

import java.util.List;

@Service
public class UserDetailsService {

    private final UserDetailsRepository userDetailsRepository;

    public UserDetailsService(UserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }

    public List<UserDetails> getAllUserDetails(){
        return userDetailsRepository.findAll();
    }

    public UserDetails getUserById(long id){
        return userDetailsRepository.getById(id);
    }
}
