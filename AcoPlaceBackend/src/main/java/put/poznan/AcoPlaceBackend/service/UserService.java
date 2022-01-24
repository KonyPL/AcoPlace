package put.poznan.AcoPlaceBackend.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import put.poznan.AcoPlaceBackend.dto.UserProfileDto;
import put.poznan.AcoPlaceBackend.exception.ResourceNotFoundException;
import put.poznan.AcoPlaceBackend.model.UserDetails;
import put.poznan.AcoPlaceBackend.model.WebUser;
import put.poznan.AcoPlaceBackend.repository.UserDetailsRepository;
import put.poznan.AcoPlaceBackend.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserDetailsRepository userDetailsRepository;

    public UserService(UserRepository userRepository, UserDetailsRepository userDetailsRepository) {
        this.userRepository = userRepository;
        this.userDetailsRepository = userDetailsRepository;
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

    public WebUser finByUserName(String username) {
        return userRepository.findByUserName(username).orElseThrow(() -> new ResourceNotFoundException("user with name="+username+"not found"));
    }

    public UserProfileDto findCurrentUserProfileDto() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println("GET USER CALLED, user name="+username);
        WebUser webUser = userRepository.findByUserName(username).orElseThrow(() -> new ResourceNotFoundException("user with name="+username+"not found"));
        UserDetails userDetails = userDetailsRepository.findByWebUserId(webUser.getId());
        //mapowanie do userProfile dot
        UserProfileDto userProfileDto = new UserProfileDto();
        userProfileDto.setId(webUser.getId());
        userProfileDto.setUserName(webUser.getUserName());
        userProfileDto.setEmail(webUser.getEmail());
        userProfileDto.setFirstName(userDetails.getFirstName());
        userProfileDto.setLastName(userDetails.getLastName());
        userProfileDto.setPhoneNumber(userDetails.getPhoneNumber());
        userProfileDto.setCountryCode(userDetails.getCountryCode());
        userProfileDto.setAbout(userDetails.getAbout());

        return userProfileDto;
    }

    public UserProfileDto updateUserByDto(UserProfileDto userProfileDto) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        WebUser webUser = userRepository.findByUserName(username).orElseThrow(() -> new ResourceNotFoundException("user with name="+username+"not found"));
        UserDetails userDetails = userDetailsRepository.findByWebUserId(webUser.getId());
        webUser.setEmail(userProfileDto.getEmail());
        webUser.setUserName(userProfileDto.getUserName());
        userRepository.save(webUser);

        userDetails.setFirstName(userProfileDto.getFirstName());
        userDetails.setLastName(userProfileDto.getLastName());
        userDetails.setPhoneNumber(userProfileDto.getPhoneNumber());
        userDetails.setCountryCode(userProfileDto.getCountryCode());
        userDetails.setAbout(userProfileDto.getAbout());
        userDetailsRepository.save(userDetails);

        return userProfileDto;
    }
}
