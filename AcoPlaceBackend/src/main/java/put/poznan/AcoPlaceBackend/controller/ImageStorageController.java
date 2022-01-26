package put.poznan.AcoPlaceBackend.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import put.poznan.AcoPlaceBackend.dto.ImageStorageDto;
import put.poznan.AcoPlaceBackend.model.Announcement;
import put.poznan.AcoPlaceBackend.model.AnnouncementDetails;
import put.poznan.AcoPlaceBackend.model.ImageStorage;
import put.poznan.AcoPlaceBackend.repository.AnnouncementRepository;
import put.poznan.AcoPlaceBackend.service.AnnouncementDetailsService;
import put.poznan.AcoPlaceBackend.service.AnnouncementService;
import put.poznan.AcoPlaceBackend.service.AuthService;
import put.poznan.AcoPlaceBackend.service.ImageStorageService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin()
public class ImageStorageController {

    private final AuthService authService;
    private final ImageStorageService imageStorageService;
    private final AnnouncementRepository announcementRepository;
//
    public ImageStorageController(AuthService authService, ImageStorageService imageStorageService, AnnouncementRepository announcementRepository) {
        this.authService = authService;
        this.imageStorageService = imageStorageService;
        this.announcementRepository = announcementRepository;
    }

    @GetMapping("/free/announcementImages")
    public List<String> getAllAnnouncementImages(@RequestParam Integer id) {
        return imageStorageService.getAllAnnouncementImages(id);
    }

    @GetMapping("/free/announcementImage")
    public String getOneAnnouncementImage(@RequestParam Integer id) {
        try {
            return imageStorageService.getOneAnnouncementImage(id);
        }catch (IndexOutOfBoundsException noRecords){
            return null;
        }
    }

    @PostMapping("/announcement/{id}/addImages")
    public List<ImageStorageDto> addImages(@PathVariable Integer id, @RequestBody List<ImageStorage> imageList)
    {
        Optional<Announcement> announcement = announcementRepository.findAnnouncementById(id);
        if(announcement.isPresent()){
            List<ImageStorageDto> returnlist = new ArrayList<ImageStorageDto>();
            for (ImageStorage image : imageList){
                image.setAnnouncement(announcement.get());
                returnlist.add(new ImageStorageDto().makeFromModel(imageStorageService.saveImage(image)));
            }
            return returnlist;
        }
        return null;
    }
}
