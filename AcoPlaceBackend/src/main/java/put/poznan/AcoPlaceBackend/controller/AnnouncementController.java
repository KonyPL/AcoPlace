package put.poznan.AcoPlaceBackend.controller;

import org.springframework.web.bind.annotation.*;
import put.poznan.AcoPlaceBackend.model.Announcement;
import put.poznan.AcoPlaceBackend.service.AnnouncementService;

import java.sql.Date;
import java.util.List;

@RestController
@CrossOrigin()//tu mozna dac  z jakieg hosta pozniej
public class AnnouncementController {
    private final AnnouncementService announcementService;

    public AnnouncementController(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    @GetMapping("/announcements")
    public List<Announcement> getAllAdvertisements() {
        return announcementService.getAllAnnouncements();
    }

    @GetMapping("/announcement/{id}")
    public Announcement getAdvertisementById(@PathVariable long id){
        return announcementService.getAnnouncementById(id);
    }

    @PostMapping("/addAnnouncement")
    public Announcement createAnnouncement(@RequestBody Announcement announcement) {
        System.out.println(announcement.toString());
        announcement.setPublicationDate((new Date(System.currentTimeMillis())));
        return announcementService.saveAnnouncement(announcement);
    }
}
