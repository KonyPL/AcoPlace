package put.poznan.AcoPlaceBackend.service;

import org.springframework.stereotype.Service;
import put.poznan.AcoPlaceBackend.exception.ResourceNotFoundException;
import put.poznan.AcoPlaceBackend.model.Announcement;
import put.poznan.AcoPlaceBackend.repository.AnnouncementRepository;

import java.util.List;

@Service
public class AnnouncementService {

    private final AnnouncementRepository announcementRepository;

    public AnnouncementService(AnnouncementRepository announcementRepository) {
        this.announcementRepository = announcementRepository;
    }

    public Announcement getAnnouncementById(long id) {
        // return advertisementRepository.getById(id);
        return announcementRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Advertisement with id:" + id + " not found in database"));
    }

    public List<Announcement> getAllAnnouncements() {
        return announcementRepository.findAll();
    }
}
