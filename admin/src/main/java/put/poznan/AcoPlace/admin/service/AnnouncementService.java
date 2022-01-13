package  put.poznan.AcoPlace.admin.service;

import org.springframework.stereotype.Service;
import put.poznan.AcoPlace.admin.exception.ResourceNotFoundException;
import put.poznan.AcoPlace.admin.model.Announcement;
import put.poznan.AcoPlace.admin.repository.AnnouncementRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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


    public Announcement saveAnnouncement(Announcement announcement) {
        return announcementRepository.save(announcement);
    }
}
