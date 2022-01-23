package put.poznan.AcoPlaceBackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import put.poznan.AcoPlaceBackend.criteria.AnnouncementSearchCriteria;
import put.poznan.AcoPlaceBackend.dto.AnnouncementDto;
import put.poznan.AcoPlaceBackend.exception.ResourceNotFoundException;
import put.poznan.AcoPlaceBackend.model.Announcement;
import put.poznan.AcoPlaceBackend.model.WebUser;
import put.poznan.AcoPlaceBackend.repository.AnnouncementDetailsRepository;
import put.poznan.AcoPlaceBackend.repository.AnnouncementRepository;
import put.poznan.AcoPlaceBackend.repository.FavouriteRepository;
import put.poznan.AcoPlaceBackend.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class AnnouncementService {

    private final AnnouncementRepository announcementRepository;
    private final AnnouncementDetailsRepository announcementDetailsRepository;
    private final UserRepository userRepository;
    private final FavouriteRepository favouriteRepository;


    public Announcement getAnnouncementById(Integer id) {
        // return advertisementRepository.getById(id);
        return announcementRepository.findAnnouncementById(id).orElseThrow(() -> new ResourceNotFoundException("Advertisement with id:" + id + " not found in database"));
    }

    public List<AnnouncementDto> searchAnnouncements(AnnouncementSearchCriteria searchCriteria) {
        return announcementRepository.findAnnouncements(searchCriteria);
    }

    public List<Announcement> getAll() {
        return announcementRepository.findAll();
    }

    public Announcement saveAnnouncement(Announcement announcement) {
        return announcementRepository.save(announcement);
    }

    public List<Announcement> getActiveForCurrentUser() {
        String username= SecurityContextHolder.getContext().getAuthentication().getName();
        WebUser webUser = userRepository.findByUserName(username).orElseThrow(() -> new ResourceNotFoundException("user with name="+username+"nor found"));
       return announcementRepository.getActiveForUser(webUser.getId());

       // return announcementRepository.getActiveForUser();
    }

    public List<Announcement> getInactiveForCurrentUser() {
        String username= SecurityContextHolder.getContext().getAuthentication().getName();
        WebUser webUser = userRepository.findByUserName(username).orElseThrow(() -> new ResourceNotFoundException("user with name="+username+"nor found"));
        return announcementRepository.getInactiveForUser(webUser.getId());
    }

    public List<Announcement> getFavouriteForCurrentUser() {
        String username= SecurityContextHolder.getContext().getAuthentication().getName();
        WebUser webUser = userRepository.findByUserName(username).orElseThrow(() -> new ResourceNotFoundException("user with name="+username+"nor found"));
        List<Integer> favouriteIdList = favouriteRepository.getAllAnnouncementIdForCurrentUser(webUser.getId());
        List<Announcement> announcementList = new ArrayList<>();
        for (int id: favouriteIdList) {
            announcementList.add( announcementRepository.findAnnouncementById(id).orElseThrow(()-> new ResourceNotFoundException("Announcement with id="+id+"not found")));
        }
        return announcementList;
        //@Query(value="SELECT announcement_details.announcement_id FROM announcement_details WHERE shower=?1  AND oven=?2",nativeQuery = true)
    }
}
