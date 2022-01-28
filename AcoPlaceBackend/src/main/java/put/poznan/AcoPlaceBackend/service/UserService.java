package put.poznan.AcoPlaceBackend.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import put.poznan.AcoPlaceBackend.dto.UserProfileDto;
import put.poznan.AcoPlaceBackend.exception.ResourceNotFoundException;
import put.poznan.AcoPlaceBackend.model.Announcement;
import put.poznan.AcoPlaceBackend.model.UserDetails;
import put.poznan.AcoPlaceBackend.model.WebUser;
import put.poznan.AcoPlaceBackend.repository.AnnouncementRepository;
import put.poznan.AcoPlaceBackend.repository.UserDetailsRepository;
import put.poznan.AcoPlaceBackend.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserDetailsRepository userDetailsRepository;
    private final AnnouncementRepository announcementRepository;

    public UserService(UserRepository userRepository, UserDetailsRepository userDetailsRepository,
            AnnouncementRepository announcementRepository) {
        this.userRepository = userRepository;
        this.userDetailsRepository = userDetailsRepository;
        this.announcementRepository = announcementRepository;
    }

    public List<WebUser> getAllUsers() {
        return userRepository.findAll();
    }

    public WebUser getUserById(long id) {
        return userRepository.getById(id);
    }

    public WebUser saveWebUser(WebUser webUser) {
        return userRepository.save(webUser);
    }

    public WebUser finByUserName(String username) {
        return userRepository.findByUserName(username)
                .orElseThrow(() -> new ResourceNotFoundException("user with name=" + username + "not found"));
    }

    public UserProfileDto findCurrentUserProfileDto() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println("GET USER CALLED, user name=" + username);
        WebUser webUser = userRepository.findByUserName(username)
                .orElseThrow(() -> new ResourceNotFoundException("user with name=" + username + "not found"));
        UserDetails userDetails = userDetailsRepository.findByWebUserId(webUser.getId());
        if (userDetails == null) {
            userDetails = new UserDetails();
            userDetails.setFirstName("FIRST NAME");
        }
        // mapowanie do userProfile dot
        UserProfileDto userProfileDto = new UserProfileDto();
        userProfileDto.setId(webUser.getId());
        userProfileDto.setUserName(webUser.getUserName());
        userProfileDto.setEmail(webUser.getEmail());
        userProfileDto.setFirstName(userDetails.getFirstName());
        userProfileDto.setLastName(userDetails.getLastName());
        userProfileDto.setPhoneNumber(userDetails.getPhoneNumber());
        userProfileDto.setCountryCode(userDetails.getCountryCode());
        userProfileDto.setAbout(userDetails.getAbout());
        userProfileDto.setB64image(userDetails.getB64image());

        return userProfileDto;
    }

    public UserProfileDto findUserProfileDtoByAnnouncementId(Integer id) {
        Announcement announcement = announcementRepository.findAnnouncementById(id)
                .orElseThrow(() -> new ResourceNotFoundException("announcement with" + id + "not found"));

        WebUser webUser = announcement.getWebUser();
        UserDetails userDetails = userDetailsRepository.findByWebUserId(webUser.getId());
        // mapowanie do userProfile dot
        UserProfileDto userProfileDto = new UserProfileDto();
        userProfileDto.setUserName(webUser.getUserName());
        userProfileDto.setId(webUser.getId());
        userProfileDto.setUserName(webUser.getUserName());
        userProfileDto.setEmail(webUser.getEmail());
        userProfileDto.setFirstName(userDetails.getFirstName());
        userProfileDto.setLastName(userDetails.getLastName());
        userProfileDto.setPhoneNumber(userDetails.getPhoneNumber());
        userProfileDto.setCountryCode(userDetails.getCountryCode());
        userProfileDto.setAbout(userDetails.getAbout());
        userProfileDto.setB64image(userDetails.getB64image());
        System.out.println("USERNAME FOUND " + userProfileDto.toString());
        return userProfileDto;
    }

    public UserProfileDto updateUserByDto(UserProfileDto userProfileDto) {
        System.out.println("USER PROFILE DTO w uupdete servie" + userProfileDto.toString());
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        WebUser webUser = userRepository.findByUserName(username)
                .orElseThrow(() -> new ResourceNotFoundException("user with name=" + username + "not found"));
        UserDetails userDetails = userDetailsRepository.findByWebUserId(webUser.getId());
        if (userDetails == null) {
            userDetails = new UserDetails();
            userDetails.setFirstName("FIRST NAME");
        }
        webUser.setEmail(userProfileDto.getEmail());
        webUser.setUserName(userProfileDto.getUserName());
        userRepository.save(webUser);

        userDetails.setFirstName(userProfileDto.getFirstName());
        userDetails.setLastName(userProfileDto.getLastName());
        userDetails.setPhoneNumber(userProfileDto.getPhoneNumber());
        userDetails.setCountryCode(userProfileDto.getCountryCode());
        userDetails.setAbout(userProfileDto.getAbout());
        userDetails.setB64image(userProfileDto.getB64image());
        userDetailsRepository.save(userDetails);

        return userProfileDto;
    }
}
