package put.poznan.AcoPlaceBackend.service.OLD;

import put.poznan.AcoPlaceBackend.exception.ResourceNotFoundException;
import put.poznan.AcoPlaceBackend.model.Announcement;
import put.poznan.AcoPlaceBackend.repository.AnnouncementRepository;

import java.util.List;

//@Service
public class AnnouncementService {
    private final AnnouncementRepository announcementRepository;

    public AnnouncementService(AnnouncementRepository announcementRepository) {
        this.announcementRepository = announcementRepository;
    }

    public List<Announcement> getAllAnouncements() {
        return announcementRepository.findAll();
    }

    public Announcement getAnnouncementById(long id) {
        return announcementRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("anouncment not found for id:"+id));
    }

    public Announcement saveAnnouncement(Announcement announcement){
        return announcementRepository.save(announcement);
    }

}
