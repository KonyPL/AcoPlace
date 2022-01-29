package put.poznan.AcoPlaceBackend.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import put.poznan.AcoPlaceBackend.exception.ResourceNotFoundException;
import put.poznan.AcoPlaceBackend.model.UserDetails;
import put.poznan.AcoPlaceBackend.model.WebUser;
import put.poznan.AcoPlaceBackend.repository.UserDetailsRepository;
import put.poznan.AcoPlaceBackend.repository.UserRepository;

import java.util.List;

@Service
public class UserDetailsService {

    private final UserDetailsRepository userDetailsRepository;
    private final UserRepository userRepository;

    public UserDetailsService(UserDetailsRepository userDetailsRepository, UserRepository userRepository) {
        this.userDetailsRepository = userDetailsRepository;
        this.userRepository = userRepository;
    }

    public List<UserDetails> getAllUserDetails(){
        return userDetailsRepository.findAll();
    }

    public UserDetails getUserById(long id){
        return userDetailsRepository.getById(id);
    }

    public UserDetails saveUserDetails(UserDetails userDetails){
        return userDetailsRepository.save(userDetails);
    }

    public UserDetails getCurrentUserDetails() {

        String username= SecurityContextHolder.getContext().getAuthentication().getName();
        WebUser currentWebUser = userRepository.findByUserName(username).orElseThrow(() -> new ResourceNotFoundException("user with name="+username+" not found"));
        return userDetailsRepository.findByWebUserId(currentWebUser.getId());
    }

    public String getUserProfilePictureById(Integer id){
        UserDetails userDetails = userDetailsRepository.findByWebUserId(id);
        return userDetails.getB64image();
    }

}
