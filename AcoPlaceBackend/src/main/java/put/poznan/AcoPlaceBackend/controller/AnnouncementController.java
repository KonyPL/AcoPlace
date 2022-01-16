package put.poznan.AcoPlaceBackend.controller;

import org.springframework.web.bind.annotation.*;
import put.poznan.AcoPlaceBackend.model.Announcement;
import put.poznan.AcoPlaceBackend.service.AnnouncementService;

import java.sql.Date;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/searchAnnouncement")
    public List<Announcement> searchAnnouncement(@RequestParam Map<String,String> allParams){
       /* System.out.println("DZIALAM");
        allParams.forEach((key, value) -> System.out.println(key + ":" + value));*/
        return  announcementService.searchAnnouncementsByParams(allParams);
    }


    @PostMapping("/addAnnouncement")
    public Announcement createAnnouncement(@RequestBody Announcement announcement) {
        System.out.println(announcement.toString());
        announcement.setPublicationDate((new Date(System.currentTimeMillis())));
        return announcementService.saveAnnouncement(announcement);
    }
}
