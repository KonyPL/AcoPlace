package put.poznan.AcoPlaceBackend.service.OLD;

import org.springframework.stereotype.Service;
import put.poznan.AcoPlaceBackend.model.OLD.Place;
import put.poznan.AcoPlaceBackend.repository.OLD.PlaceRepository;

import java.util.List;

@Service
public class PlaceService {

    private final PlaceRepository placeRepository;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public List<Place> getAllPlaces(){
        return placeRepository.findAll();
    }
}
