package put.poznan.AcoPlaceBackend.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import put.poznan.AcoPlaceBackend.model.AnnouncementDetails;
import put.poznan.AcoPlaceBackend.service.AnnouncementDetailsService;
import put.poznan.AcoPlaceBackend.service.AuthService;

import java.util.List;

@RestController
@CrossOrigin()//tu mozna dac  z jakieg hosta pozniej
public class AnnouncementDetailsController {

    private  final AuthService authService;
    private final AnnouncementDetailsService announcementDetailsService;

    public AnnouncementDetailsController(AuthService authService, AnnouncementDetailsService announcementDetailsService) {
        this.authService = authService;
        this.announcementDetailsService = announcementDetailsService;
    }

    @GetMapping("/announcementDetailsAll")
    public List<AnnouncementDetails> getAllAnnouncementDetails() {
        System.out.println("SECURITY CONTEX HOLDER" + SecurityContextHolder.getContext().getAuthentication().getName());
        System.out.println("user FROM auth service"+authService.getCurrentUser().get().toString());
        return announcementDetailsService.getAllAnnouncementDetails();
    }

    @GetMapping("/announcementDetails/{id}")
    public AnnouncementDetails getAnnouncementDetailsById(@PathVariable Integer id) {
        return announcementDetailsService.getAnnouncementDetailsById(id);
    }

    @PostMapping("/addAnnouncementDetails")
    public AnnouncementDetails createAnnouncementDetails(@RequestBody AnnouncementDetails announcementDetails)
    {
        return announcementDetailsService.saveAnnouncementDetails(announcementDetails);
    }
}
