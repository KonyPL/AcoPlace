package put.poznan.AcoPlaceBackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import put.poznan.AcoPlaceBackend.criteria.AnnouncementSearchCriteria;
import put.poznan.AcoPlaceBackend.dto.AnnouncementDto;
import put.poznan.AcoPlaceBackend.exception.ResourceNotFoundException;
import put.poznan.AcoPlaceBackend.model.Announcement;
import put.poznan.AcoPlaceBackend.model.AnnouncementCreateDto;
import put.poznan.AcoPlaceBackend.repository.HouseDetailsRepository;
import put.poznan.AcoPlaceBackend.repository.UserRepository;
import put.poznan.AcoPlaceBackend.service.AnnouncementService;
import put.poznan.AcoPlaceBackend.service.HouseDetailsService;
import put.poznan.AcoPlaceBackend.model.Favourite;
import put.poznan.AcoPlaceBackend.service.AnnouncementService;
import put.poznan.AcoPlaceBackend.service.FavouriteService;


import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin()//tu mozna dac  z jakieg hosta pozniej
public class AnnouncementController {
    private final AnnouncementService announcementService;
    private final FavouriteService favouriteService;

    public AnnouncementController(AnnouncementService announcementService, FavouriteService favouriteService) {
        this.announcementService = announcementService;
        this.favouriteService = favouriteService;
    }



    @GetMapping("/free/announcement/{id}")
    public Announcement getAdvertisementById(@PathVariable Integer id){
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
            @RequestParam(required = false) Optional<Integer> internetSpeed,
            @RequestParam(required = false) Optional<String> city,
            @RequestParam(required = false) Optional<String> country,
            @RequestParam(required = false) Optional<String> state,
            @RequestParam(required = false) Optional<String> district
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
                .city(city.orElseGet(() -> null))
                .country(country.orElseGet(() -> null))
                .state(state.orElseGet(() -> null))
                .district(district.orElseGet(() -> null))
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

    @GetMapping("/announcements/active")
    public List<Announcement> getAllActiveAnnouncementsForCurrentUser(){
        return announcementService.getActiveForCurrentUser();
    }

    @GetMapping("/announcements/inactive")
    public List<Announcement> getAllInactiveAnnouncementsForCurrentUser(){
        return announcementService.getInactiveForCurrentUser();
    }


    @PostMapping("/addAnnouncementByDto")
    public Integer createAnnouncementByDto(@RequestBody AnnouncementCreateDto announcementCreateDto) {
        System.out.println("add create DTO="+announcementCreateDto.toString());

       Announcement announcement = announcementService.createAnnouncementByDto(announcementCreateDto);
    return announcement.getId();
    }


    //updateAnnouncementByDto

    @PostMapping("/updateAnnouncementByDto")
    public Announcement updateAnnouncementByDto(@RequestBody AnnouncementCreateDto announcementCreateDto) {
        System.out.println("add EDIT DTO="+announcementCreateDto.toString());
        return announcementService.updateAnnouncementByDto(announcementCreateDto);}

    @GetMapping("/announcement/favourite/{id}")
    public Favourite addFavouriteAnnouncementToCurrentUser(@PathVariable Integer id){
        return  favouriteService.setFavouriteAnnouncement(id);
    }

   @GetMapping("/announcements/favourite")
    public List<Announcement> getAllFavouriteAnnouncementsIdForCurrentUser(){
        return announcementService.getFavouriteForCurrentUser();

    }

    @GetMapping("/announcement/announcementDto/{id}")
    public AnnouncementCreateDto getAdvertisementDtoById(@PathVariable Integer id){
        return announcementService.getAnnouncementDtoById(id);
    }

    @GetMapping("/announcements/getActiveByAdId/{id}")
    public List<Announcement> getAllActiveForUserByAnnouncmentId(@PathVariable Integer id){
        System.out.println("JESTEM W GET BY ID");
        return announcementService.getActiveForUserByAnnouncementId(id);


    }

}
