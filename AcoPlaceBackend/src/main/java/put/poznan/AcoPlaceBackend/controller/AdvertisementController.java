package put.poznan.AcoPlaceBackend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import put.poznan.AcoPlaceBackend.model.Advertisement;
import put.poznan.AcoPlaceBackend.model.OLD.Announcement;
import put.poznan.AcoPlaceBackend.service.AdvertisementService;

import java.util.List;

@RestController
@CrossOrigin()//tu mozna dac  z jakieg hosta pozniej
public class AdvertisementController {
    private final AdvertisementService advertisementService;

    public AdvertisementController(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

    @GetMapping("/advertisements")
    public List<Advertisement> getAllAdvertisements() {
        return advertisementService.getAllAdvertisements();
    }
    @GetMapping("/advertisement/{id}")
    public Advertisement getAdvertisementById(@PathVariable long id){
        return advertisementService.getAdvertisementById(id);
    }

}
