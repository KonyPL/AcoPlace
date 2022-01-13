package  put.poznan.AcoPlace.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import put.poznan.AcoPlace.admin.model.Announcement;
import put.poznan.AcoPlace.admin.repository.AnnouncementRepository;
import put.poznan.AcoPlace.admin.service.AnnouncementService;


import java.sql.Date;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin()//tu mozna dac  z jakieg hosta pozniej
public class AnnouncementController {
    private final AnnouncementService announcementService;


    public AnnouncementController(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }


    @RequestMapping("/allAnnouncements")
    public String viewAllMealsByUser(Model model){
       // List<Meal> listMeals=mealService.findAllMealsByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        List<Announcement> listAnnouncements = announcementService.getAllAnnouncements();
        model.addAttribute("listAnnouncements",listAnnouncements);

        return "all_announcements";
    }

    //==============================NIE PATRZYMY NA TO========================================================================
    /*@GetMapping("/rest/announcements")
    public List<Announcement> getAllAdvertisements() {
        return announcementService.getAllAnnouncements();
    }

    @GetMapping("/rest/announcement/{id}")
    public Announcement getAdvertisementById(@PathVariable long id){
        return announcementService.getAnnouncementById(id);
    }

    @PostMapping("/rest/addAnnouncement")
    public Announcement createAnnouncement(@RequestBody Announcement announcement) {
        System.out.println(announcement.toString());
        announcement.setPublicationDate((new Date(System.currentTimeMillis())));
        return announcementService.saveAnnouncement(announcement);
    }*/

  /*  @GetMapping("/admin/delete/{id}") // tu dac delete i porzadnie
    public void deleteAnnpicnement(@PathVariable long id){
         announcementRepository.deleteById(id);
    }*/
}
