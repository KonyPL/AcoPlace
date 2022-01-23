package put.poznan.AcoPlaceBackend.service;

import org.springframework.stereotype.Service;
import put.poznan.AcoPlaceBackend.exception.ResourceNotFoundException;
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

    public AnnouncementDetails getAnnouncementDetailsById(Integer id){

        return announcementDetailsRepository.findAnnouncementDetailsById(id).orElseThrow(() -> new ResourceNotFoundException("AnnouncmentDetails with id:" + id + " not found in database"));
        //return announcementDetailsRepository.findAnnouncementById(id).orElseThrow(() -> new ResourceNotFoundException("AnnouncmentDetails with id:" + id + " not found in database"));

    }

    public AnnouncementDetails saveAnnouncementDetails(AnnouncementDetails announcementDetails){
        return announcementDetailsRepository.save(announcementDetails);
    }
}
