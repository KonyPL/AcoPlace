package put.poznan.AcoPlaceBackend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import put.poznan.AcoPlaceBackend.model.Owner;
import put.poznan.AcoPlaceBackend.service.OwnerService;

import java.util.List;

@RestController
@CrossOrigin()//tu mozna dac  z jakieg hosta pozniej
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("/owners")
    public List<Owner> getAllOwners(){
        return ownerService.getAllOwners();
    }


}
