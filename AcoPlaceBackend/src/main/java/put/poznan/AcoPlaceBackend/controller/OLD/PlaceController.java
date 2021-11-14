package put.poznan.AcoPlaceBackend.controller.OLD;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import put.poznan.AcoPlaceBackend.model.OLD.Place;
import put.poznan.AcoPlaceBackend.service.OLD.PlaceService;

import java.util.List;

@RestController
@CrossOrigin()//tu mozna dac  z jakieg hosta pozniej
public class PlaceController {
    private final PlaceService placeService;

    @GetMapping("/places")
    public List<Place> getAllPlaces(){
        return placeService.getAllPlaces();
    }

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }
}
