package put.poznan.AcoPlaceBackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import put.poznan.AcoPlaceBackend.model.Flatmate;
import put.poznan.AcoPlaceBackend.service.FlatmateService;

import java.util.List;

@RestController
public class FlatmateController {

    private final FlatmateService flatmateService;

    public FlatmateController(FlatmateService flatmateService) {
        this.flatmateService = flatmateService;
    }

    @GetMapping("/flatmates")
    public List<Flatmate> getAllFlatmates(){
        return flatmateService.getAllFlatmates();
    }


}
