package put.poznan.AcoPlaceBackend.service.OLD;

import org.springframework.stereotype.Service;
import put.poznan.AcoPlaceBackend.exception.ResourceNotFoundException;
import put.poznan.AcoPlaceBackend.model.OLD.Announcement;
import put.poznan.AcoPlaceBackend.repository.OLD.AnnouncementRepositoy;

import java.util.List;

@Service
public class AnnouncementService {
    private final AnnouncementRepositoy announcementRepositoy;

    public AnnouncementService(AnnouncementRepositoy announcementRepositoy) {
        this.announcementRepositoy = announcementRepositoy;
    }

    public List<Announcement> getAllAnouncements() {
        return announcementRepositoy.findAll();
    }

    public Announcement getAnnouncementById(long id) {
        return announcementRepositoy.findById(id).orElseThrow(() -> new ResourceNotFoundException("anouncment not found for id:"+id));
    }

    public Announcement saveAnnouncement(Announcement announcement){
        return announcementRepositoy.save(announcement);
    }

}
