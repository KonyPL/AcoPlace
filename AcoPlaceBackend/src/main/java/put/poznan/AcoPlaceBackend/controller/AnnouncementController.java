package put.poznan.AcoPlaceBackend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import put.poznan.AcoPlaceBackend.model.Announcement;
import put.poznan.AcoPlaceBackend.service.AnnouncementService;

import java.util.List;

@RestController
@CrossOrigin()//tu mozna dac  z jakieg hosta pozniej
public class AnnouncementController {
    private final AnnouncementService announcementService;

    public AnnouncementController(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    @GetMapping("/annoucements")
    public List<Announcement> getAllAnnouncements(){
        return announcementService.getAllAnouncements();
    }

    @GetMapping("/announcement/{id}")
    public Announcement getAnnouncementById(@PathVariable long id)
    {
        return announcementService.getAnnouncementById(id);
    }
}
