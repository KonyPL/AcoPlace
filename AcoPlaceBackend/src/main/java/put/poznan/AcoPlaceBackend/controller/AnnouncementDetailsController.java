package put.poznan.AcoPlaceBackend.controller;

import org.springframework.web.bind.annotation.*;
import put.poznan.AcoPlaceBackend.model.AnnouncementDetails;
import put.poznan.AcoPlaceBackend.service.AnnouncementDetailsService;

import java.util.List;

@RestController
@CrossOrigin()//tu mozna dac  z jakieg hosta pozniej
public class AnnouncementDetailsController {

    private final AnnouncementDetailsService announcementDetailsService;

    public AnnouncementDetailsController(AnnouncementDetailsService announcementDetailsService) {
        this.announcementDetailsService = announcementDetailsService;
    }

    @GetMapping("/announcementDetailsAll")
    public List<AnnouncementDetails> getAllAnnouncementDetails() {
        return announcementDetailsService.getAllAnnouncementDetails();
    }

    @GetMapping("/announcementDetails/{id}")
    public AnnouncementDetails getAnnouncementDetailsById(@PathVariable long id) {
        return announcementDetailsService.getAnnouncementDetailsById(id);
    }

    @PostMapping("/addAnnouncementDetails")
    public AnnouncementDetails createAnnouncementDetails(@RequestBody AnnouncementDetails announcementDetails)
    {
        return announcementDetailsService.saveAnnouncementDetails(announcementDetails);
    }
}
