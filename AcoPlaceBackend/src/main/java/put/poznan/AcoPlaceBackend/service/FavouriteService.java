package put.poznan.AcoPlaceBackend.service;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import put.poznan.AcoPlaceBackend.exception.ResourceNotFoundException;
import put.poznan.AcoPlaceBackend.model.Favourite;
import put.poznan.AcoPlaceBackend.model.WebUser;
import put.poznan.AcoPlaceBackend.repository.FavouriteRepository;
import put.poznan.AcoPlaceBackend.repository.UserRepository;

@Service
public class FavouriteService {
    private final FavouriteRepository favouriteRepository;
    private final UserRepository userRepository;

    public FavouriteService(FavouriteRepository favouriteRepository, UserRepository userRepository) {
        this.favouriteRepository = favouriteRepository;
        this.userRepository = userRepository;
    }

    public Favourite setFavouriteAnnouncement(Integer id) {
        String username= SecurityContextHolder.getContext().getAuthentication().getName();
        WebUser webUser = userRepository.findByUserName(username).orElseThrow(() -> new ResourceNotFoundException("user with name="+username+"nor found"));
        Favourite favourite = new Favourite();
        favourite.setAnnouncementId(id);
        favourite.setWebUserId(webUser.getId());
        return favouriteRepository.save(favourite);
    }
}
