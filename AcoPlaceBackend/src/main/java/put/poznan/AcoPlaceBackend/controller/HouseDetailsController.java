package put.poznan.AcoPlaceBackend.controller;

import org.springframework.web.bind.annotation.*;
import put.poznan.AcoPlaceBackend.model.HouseDetails;
import put.poznan.AcoPlaceBackend.service.HouseDetailsService;

import java.util.List;

@RestController
@CrossOrigin()//tu mozna dac  z jakieg hosta pozniej
public class HouseDetailsController {
    private final HouseDetailsService houseDetailsService;

    public HouseDetailsController(HouseDetailsService houseDetailsService) {
        this.houseDetailsService = houseDetailsService;
    }

    @GetMapping("/houseDetailsAll")
    public List<HouseDetails> getAllHouseDetails(){
        return houseDetailsService.getAllHouseDetails();
    }

    @GetMapping("/free/houseDetails/{id}")
    public HouseDetails getHouseDetailsById(@PathVariable long id){
        return houseDetailsService.getHouseDetailsById(id);
    }


    @GetMapping("/free/houseDetails/announcement/{id}")
    public HouseDetails getHouseDetailsByAnnouncementId(@PathVariable long id) {
        return houseDetailsService.getHouseDetailsByAnnouncementId(id);
    }

    @PostMapping("addHouseDetails")
    public HouseDetails createHouseDetails(@RequestBody HouseDetails houseDetails){
        return houseDetailsService.saveHouseDetails(houseDetails);
    }
}
