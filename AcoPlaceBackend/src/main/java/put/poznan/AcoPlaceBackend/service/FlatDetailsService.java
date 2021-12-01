package put.poznan.AcoPlaceBackend.service;

import org.springframework.stereotype.Service;
import put.poznan.AcoPlaceBackend.model.FlatDetails;
import put.poznan.AcoPlaceBackend.repository.FlatDetailsRepository;

import java.util.List;

@Service
public class FlatDetailsService {
    private final FlatDetailsRepository flatDetailsRepository;

    public FlatDetailsService(FlatDetailsRepository flatDetailsRepository) {
        this.flatDetailsRepository = flatDetailsRepository;
    }

    public List<FlatDetails> getAllFlatDetails(){
        return flatDetailsRepository.findAll();
    }

    public FlatDetails getFlatById(long id){
        return flatDetailsRepository.getById(id);
    }

    public FlatDetails saveFlatDetails( FlatDetails flatDetails){
        return flatDetailsRepository.save(flatDetails);
    }

    public FlatDetails getFlatByAnnouncementId(long id) {
        return  flatDetailsRepository.findByAnnouncementId(id);
    }
}
