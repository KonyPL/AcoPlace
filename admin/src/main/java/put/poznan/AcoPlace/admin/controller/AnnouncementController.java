package put.poznan.AcoPlace.admin.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import put.poznan.AcoPlace.admin.model.AdminUser;
import put.poznan.AcoPlace.admin.model.Announcement;
import put.poznan.AcoPlace.admin.repository.AdminUserRepository;
import put.poznan.AcoPlace.admin.repository.AnnouncementRepository;
import put.poznan.AcoPlace.admin.service.AnnouncementService;


import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin()
public class AnnouncementController {
    private final AnnouncementService announcementService;
    private final AdminUserRepository adminUserRepository;

    public AnnouncementController(AnnouncementService announcementService, AdminUserRepository adminUserRepository) {
        this.announcementService = announcementService;
        this.adminUserRepository = adminUserRepository;
    }

    @RequestMapping("/allAnnouncements")
    public String viewAllAnnouncements(Model model) {
        List<Announcement> listAnnouncements = announcementService.getAllAnnouncements();
        model.addAttribute("listAnnouncements", listAnnouncements);
        return "all_announcements";
    }

    @RequestMapping("/allReportedAnnouncements")
    public String viewReportedAnnouncements(Model model) {
        List<Announcement> listAnnouncements = announcementService.getAllReportedAnnouncements();
        model.addAttribute("listAnnouncements", listAnnouncements);
        return "all_reported_announcements";
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
    @RequestMapping(value = "/announcement/unactive/showById/{id}")
    public String announcementUnactive(Model model, @PathVariable(name = "id") int id) {
        Announcement announcement = announcementService.findById(id);
        model.addAttribute("announcement", announcement);

        return "unactiveAnnouncement";
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
        Announcement announcement = new Announcement();
        try{
         announcement = announcementService.findById(Integer.parseInt(id));}
        catch (Exception e ){
            return "redirect:/notFound";
        }
                //announcementService.findByTitleLike("%"+ title + "%");
        //ownerService.findAllByLastNameLike("%"+ owner.getLastName() + "%");
        System.out.println(announcement.toString());
        if(announcement!=null){
        model.addAttribute("announcement", announcement);
        return "announcement";}
        else return "redirect:/notFound";
    }

    @RequestMapping("notFound")
    public String notFound() {

        return "notFoundTemplate";
    }

    @RequestMapping(value = "/announcement/reportById/{id}")
    public String announcementReport(Model model, @PathVariable(name = "id") int id) {
        Announcement announcement = announcementService.findById(id);
        model.addAttribute("announcement", announcement);

        return "announcementReport";
    }


    @RequestMapping(value="/saveAnnouncement")
    public String updateAnnouncement(@ModelAttribute("announcement") Announcement announcement){
        System.out.println("announcement from model attribute="+announcement.toString());
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        java.util.Date date = new java.util.Date();
        String dateStr = formatter.format(date);
        announcement.setReportedTime(dateStr);
        announcement.setReported(true);
        AdminUser adminUser = adminUserRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        announcement.setAdmin(adminUser.getFirstName()+" "+adminUser.getLastName()+" "+adminUser.getEmail());
        announcementService.saveAnnouncement(announcement);

        return "redirect:/allAnnouncements";
    }

    @RequestMapping(value = "/announcement/editById/{id}")
    public String announcementEdit(Model model, @PathVariable(name = "id") int id) {
        Announcement announcement = announcementService.findById(id);
        model.addAttribute("announcement", announcement);

        return "announcementEdit";
    }

    @RequestMapping(value="/saveAnnouncementEdited")
    public String updateAnnouncementEdited(@ModelAttribute("announcement") Announcement announcement){
        System.out.println("announcement from model attribute="+announcement.toString());
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        java.util.Date date = new java.util.Date();
        String dateStr = formatter.format(date);
        announcement.setReportedTime(dateStr);
        announcement.setEdited(true);
        AdminUser adminUser = adminUserRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        announcement.setAdmin(adminUser.getFirstName()+" "+adminUser.getLastName()+" "+adminUser.getEmail());
        announcementService.saveAnnouncement(announcement);

        return "redirect:/allAnnouncements";
    }


    @RequestMapping(value = "/clearFlags/{id}")
    public String clearFlags(@PathVariable(name = "id") int id) {
        Announcement announcement = announcementService.findById(id);
        announcement.setReported(false);
        announcement.setReason(null);
        announcement.setDescription(null);
        announcement.setAdmin(null);
        announcement.setReportedTime(null);
        announcement.setEdited(false);
        announcement.setActive(true);
        announcementService.saveAnnouncement(announcement);
        return "redirect:/allReportedAnnouncements";
    }


    @RequestMapping("/allUnactiveAnnouncements")
    public String viewUnactiveAnnouncements(Model model) {
        List<Announcement> listAnnouncements = announcementService.getAllUnactiveReportedAnnouncements();// TODO porzadnie zrobic
        model.addAttribute("listAnnouncements", listAnnouncements);
        return "all_unactive_announcements";
    }

    @RequestMapping(value = "/active/{id}")
    public String active(@PathVariable(name = "id") int id) {
        Announcement announcement = announcementService.findById(id);
        announcement.setActive(true);
        announcementService.saveAnnouncement(announcement);
        return "redirect:/allUnactiveAnnouncements";
    }

}
