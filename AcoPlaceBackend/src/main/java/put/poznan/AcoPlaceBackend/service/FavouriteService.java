package put.poznan.AcoPlaceBackend.service;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import put.poznan.AcoPlaceBackend.exception.ResourceNotFoundException;
import put.poznan.AcoPlaceBackend.model.Announcement;
import put.poznan.AcoPlaceBackend.model.Favourite;
import put.poznan.AcoPlaceBackend.model.WebUser;
import put.poznan.AcoPlaceBackend.repository.AnnouncementRepository;
import put.poznan.AcoPlaceBackend.repository.FavouriteRepository;
import put.poznan.AcoPlaceBackend.repository.UserRepository;

@Service
public class FavouriteService {
    private final FavouriteRepository favouriteRepository;
    private final UserRepository userRepository;
    private final AnnouncementRepository announcementRepository;

    public FavouriteService(FavouriteRepository favouriteRepository, UserRepository userRepository,
                            AnnouncementRepository announcementRepository) {
        this.favouriteRepository = favouriteRepository;
        this.userRepository = userRepository;
        this.announcementRepository = announcementRepository;
    }

    public Favourite setFavouriteAnnouncement(Integer id) {
        String username= SecurityContextHolder.getContext().getAuthentication().getName();
        WebUser webUser = userRepository.findByUserName(username).orElseThrow(() -> new ResourceNotFoundException("user with name="+username+" not found"));
        Announcement announcement = announcementRepository.findAnnouncementById(id).orElseThrow(() -> new ResourceNotFoundException("Announcement with id="+id+" not found"));
        //check if it does not already exist
        if( favouriteRepository.getFavouriteByAnnouncementIdAndUserId(webUser.getId(), id) == null){
            Favourite favourite = new Favourite();
            favourite.setAnnouncement(announcement);
            favourite.setWebUserId(webUser.getId());
            return favouriteRepository.save(favourite);
        } else {
            return null;
        }

    }
}
