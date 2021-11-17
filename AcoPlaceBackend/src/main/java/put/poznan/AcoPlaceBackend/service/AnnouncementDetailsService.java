package put.poznan.AcoPlaceBackend.service;

import org.springframework.stereotype.Service;
import put.poznan.AcoPlaceBackend.model.AnnouncementDetails;
import put.poznan.AcoPlaceBackend.repository.AnnouncementDetailsRepository;

import java.util.List;

@Service
public class AnnouncementDetailsService {

    private final AnnouncementDetailsRepository announcementDetailsRepository;

    public AnnouncementDetailsService(AnnouncementDetailsRepository announcementDetailsRepository) {
        this.announcementDetailsRepository = announcementDetailsRepository;
    }

    public List<AnnouncementDetails> getAllAnnouncementDetails(){
        return announcementDetailsRepository.findAll();
    }

    public AnnouncementDetails getAnnouncementDetailsById(long id){
        return announcementDetailsRepository.getById(id);
    }
}
