package put.poznan.AcoPlaceBackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import put.poznan.AcoPlaceBackend.criteria.AnnouncementSearchCriteria;
import put.poznan.AcoPlaceBackend.dto.AnnouncementDto;
import put.poznan.AcoPlaceBackend.model.Announcement;
import put.poznan.AcoPlaceBackend.service.AnnouncementService;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin()//tu mozna dac  z jakieg hosta pozniej
public class AnnouncementController {
    private final AnnouncementService announcementService;


    public AnnouncementController(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    @GetMapping("/announcement/{id}")
    public Announcement getAdvertisementById(@PathVariable long id){
        return announcementService.getAnnouncementById(id);
    }

    @GetMapping("/free/searchAnnouncement")
    public ResponseEntity<List<AnnouncementDto>> searchAnnouncement(
            @RequestParam(required = false) Optional<Double> priceMin,
            @RequestParam(required = false) Optional<Double> priceMax,
            @RequestParam(required = false) Optional<Date> availableFrom,
            @RequestParam(required = false) Optional<String> title,
            @RequestParam(required = false) Optional<String> propertyType,
            @RequestParam(required = false) Optional<Integer> livingSpace,
            @RequestParam(required = false) Optional<String> mustHave,
            @RequestParam(required = false) Optional<Integer> internetSpeed
    )
    {
        AnnouncementSearchCriteria searchCriteria = AnnouncementSearchCriteria.builder()
                .priceMin(priceMin.orElseGet(() -> null))
                .priceMax(priceMax.orElseGet(() -> null))
                .availableFrom(availableFrom.orElseGet(() -> null))
                .title(title.orElseGet(() -> null))
                .propertyType(propertyType.orElseGet(() -> null))
                .livingSpace(livingSpace.orElseGet(() -> null))
                .internetSpeed(internetSpeed.orElseGet(() -> null))
                .mustHave(mustHave.orElseGet(() -> null))
                .build();
        List<AnnouncementDto> announcements = this.announcementService.searchAnnouncements(searchCriteria);
        return new ResponseEntity<>(announcements, HttpStatus.OK);
    }


    @PostMapping("/addAnnouncement")
    public Announcement createAnnouncement(@RequestBody Announcement announcement) {
        System.out.println(announcement.toString());
        announcement.setPublicationDate((new Date(System.currentTimeMillis())));
        return announcementService.saveAnnouncement(announcement);
    }

    @GetMapping("/free/announcements")
    public List<Announcement> getAllAnnouncements(){
        return announcementService.getAll();
    }

}
