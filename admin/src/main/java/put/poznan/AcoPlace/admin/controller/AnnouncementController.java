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
@CrossOrigin()
public class AnnouncementController {
    private final AnnouncementService announcementService;


    public AnnouncementController(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }


    @RequestMapping("/allAnnouncements")
    public String viewAllMealsByUser(Model model){
        List<Announcement> listAnnouncements = announcementService.getAllAnnouncements();
        model.addAttribute("listAnnouncements",listAnnouncements);
        return "all_announcements";
    }

    @RequestMapping(value = "/announcement/delete/{id}")
    public String deleteMeal(@PathVariable(name="id") int id){

        announcementService.deleteById(id);
        return "redirect:/allAnnouncements";


    }


}
