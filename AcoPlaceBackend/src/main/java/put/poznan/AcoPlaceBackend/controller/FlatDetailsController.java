package put.poznan.AcoPlaceBackend.controller;

import org.springframework.web.bind.annotation.*;
import put.poznan.AcoPlaceBackend.model.FlatDetails;
import put.poznan.AcoPlaceBackend.service.FlatDetailsService;

import java.util.List;

@RestController
@CrossOrigin()
public class FlatDetailsController {
    private final FlatDetailsService flatDetailsService;

    public FlatDetailsController(FlatDetailsService flatDetailsService) {
        this.flatDetailsService = flatDetailsService;
    }

    @GetMapping("/flatDetailsAll")
    public List<FlatDetails> getAllFlatDetails(){
        return flatDetailsService.getAllFlatDetails();
    }

    @GetMapping("/flatDetails/{id}")
    public FlatDetails getFlatDetailsById(long id){
        return flatDetailsService.getFlatById(id);
    }

    @PostMapping("/addFlatDetails")
    public FlatDetails createFlatDetails(@RequestBody FlatDetails flatDetails){
        return  flatDetailsService.saveFlatDetails(flatDetails);
    }
}
