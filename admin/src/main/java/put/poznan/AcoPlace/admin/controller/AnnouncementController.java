package put.poznan.AcoPlace.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import put.poznan.AcoPlace.admin.model.Announcement;
import put.poznan.AcoPlace.admin.repository.AnnouncementRepository;
import put.poznan.AcoPlace.admin.service.AnnouncementService;


import java.sql.Date;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin()
public class AnnouncementController {
    private final AnnouncementService announcementService;


    public AnnouncementController(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }


    @RequestMapping("/allAnnouncements")
    public String viewAllAnnouncements(Model model) {
        List<Announcement> listAnnouncements = announcementService.getAllAnnouncements();
        model.addAttribute("listAnnouncements", listAnnouncements);
        return "all_announcements";
    }

    @RequestMapping(value = "/announcement/delete/{id}")
    public String deleteAnnouncement(@PathVariable(name = "id") int id) {

        announcementService.deleteById(id);
        return "redirect:/allAnnouncements";
    }


    @RequestMapping(value = "/announcement/showById/{id}")
    public String announcement(Model model, @PathVariable(name = "id") int id) {
        Announcement announcement = announcementService.findById(id);
        model.addAttribute("announcement", announcement);

        return "announcement";
    }


    @RequestMapping("findByTitle")
    public String findAnnouncementsByTitle(Model model) {
        Announcement announcement = new Announcement();
        model.addAttribute("announcement", announcement);
        return "findAnnouncements";
    }


    @GetMapping("/announcementFind")
    public String processFindForm(String title, Model model){
        System.out.println("JESTEM W procces find gorm i title="+title);

        // find owners by last name
        List<Announcement> results = announcementService.findByTitleLike("%"+ title + "%");
                //ownerService.findAllByLastNameLike("%"+ owner.getLastName() + "%");


            // multiple owners found
            model.addAttribute("selections", results);
            return "announcementList";
        }

    @RequestMapping("findById")
    public String findAnnouncementByID(Model model) {
        Announcement announcement = new Announcement();
        model.addAttribute("announcement", announcement);
        return "findAnnouncementsById";
    }


    @GetMapping("/announcementFindById")
    public String processFindFormById(String id, Model model){
        System.out.println("JESTEM W procces find gorm i title="+id);

        // find owners by last name
        Announcement announcement = announcementService.findById(Integer.valueOf(id));
                //announcementService.findByTitleLike("%"+ title + "%");
        //ownerService.findAllByLastNameLike("%"+ owner.getLastName() + "%");

        if(announcement!=null){
        model.addAttribute("announcement", announcement);
        return "announcement";}
        else return "notFound";
    }

}
