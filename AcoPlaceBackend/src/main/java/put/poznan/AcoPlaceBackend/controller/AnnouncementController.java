package put.poznan.AcoPlaceBackend.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import put.poznan.AcoPlaceBackend.model.Announcement;
import put.poznan.AcoPlaceBackend.repository.AnnouncementRepository;
import put.poznan.AcoPlaceBackend.service.AnnouncementService;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin()//tu mozna dac  z jakieg hosta pozniej
public class AnnouncementController {
    private final AnnouncementService announcementService;

    private final AnnouncementRepository announcementRepository;


    public AnnouncementController(AnnouncementService announcementService, AnnouncementRepository announcementRepository) {
        this.announcementService = announcementService;
        this.announcementRepository = announcementRepository;
    }

    @GetMapping("/announcements")
    public List<Announcement> getAllAdvertisements() {
        System.out.println("SECURITY CONTEXT HOLDER NAME="+ SecurityContextHolder.getContext().getAuthentication().getName());
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
        System.out.println("E");
        return  announcementService.searchAnnouncementsByParams(allParams);
    }


    @PostMapping("/addAnnouncement")
    public Announcement createAnnouncement(@RequestBody Announcement announcement) {
        System.out.println("SECURITY CONTEXT HOLDER NAME="+ SecurityContextHolder.getContext().getAuthentication().getName());

        System.out.println(announcement.toString());
        announcement.setPublicationDate((new Date(System.currentTimeMillis())));
        return announcementService.saveAnnouncement(announcement);
    }

    @GetMapping("/admin/delete/{id}") // tu dac delete i porzadnie
    public void deleteAnnpicnement(@PathVariable long id){
         announcementRepository.deleteById(id);
    }
}
