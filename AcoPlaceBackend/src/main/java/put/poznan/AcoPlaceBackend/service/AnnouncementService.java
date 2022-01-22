package put.poznan.AcoPlaceBackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import put.poznan.AcoPlaceBackend.criteria.AnnouncementSearchCriteria;
import put.poznan.AcoPlaceBackend.dto.AnnouncementDto;
import put.poznan.AcoPlaceBackend.exception.ResourceNotFoundException;
import put.poznan.AcoPlaceBackend.model.Announcement;
import put.poznan.AcoPlaceBackend.repository.AnnouncementDetailsRepository;
import put.poznan.AcoPlaceBackend.repository.AnnouncementRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class AnnouncementService {

    private final AnnouncementRepository announcementRepository;
    private final AnnouncementDetailsRepository announcementDetailsRepository;

    public Announcement getAnnouncementById(long id) {
        // return advertisementRepository.getById(id);
        return announcementRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Advertisement with id:" + id + " not found in database"));
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
}
