package put.poznan.AcoPlaceBackend.service;

import org.springframework.stereotype.Service;
import put.poznan.AcoPlaceBackend.model.Place;
import put.poznan.AcoPlaceBackend.repository.PlaceRepository;

import java.util.List;

@Service
public class PlaceService {

    private final PlaceRepository placeRepository;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    private List<Place> getAllPlaces(){
        return placeRepository.findAll();
    }
}
