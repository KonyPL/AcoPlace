package put.poznan.AcoPlaceBackend.service;

import org.springframework.stereotype.Service;
import put.poznan.AcoPlaceBackend.model.HouseDetails;
import put.poznan.AcoPlaceBackend.repository.HouseDetailsRepository;

import java.util.List;

@Service
public class HouseDetailsService {
    private final HouseDetailsRepository houseDetailsRepository;

    public HouseDetailsService(HouseDetailsRepository houseDetailsRepository) {
        this.houseDetailsRepository = houseDetailsRepository;
    }

    public List<HouseDetails> getAllHouseDetails(){
        return houseDetailsRepository.findAll();
    }

    public HouseDetails getHouseDetailsById(long id){
        return houseDetailsRepository.getById(id);
    }
}
