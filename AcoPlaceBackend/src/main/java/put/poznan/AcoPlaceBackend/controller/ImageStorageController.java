package put.poznan.AcoPlaceBackend.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import put.poznan.AcoPlaceBackend.model.AnnouncementDetails;
import put.poznan.AcoPlaceBackend.model.ImageStorage;
import put.poznan.AcoPlaceBackend.service.AnnouncementDetailsService;
import put.poznan.AcoPlaceBackend.service.AuthService;
import put.poznan.AcoPlaceBackend.service.ImageStorageService;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin()
public class ImageStorageController {

    private final AuthService authService;
    private final ImageStorageService imageStorageService;
//
    public ImageStorageController(AuthService authService, ImageStorageService imageStorageService) {
        this.authService = authService;
        this.imageStorageService = imageStorageService;
    }

    @GetMapping("/announcementImages")
    public List<String> getAllAnnouncementImages(@RequestParam Integer id) {
        System.out.println("SECURITY CONTEX HOLDER" + SecurityContextHolder.getContext().getAuthentication().getName());
        System.out.println("user FROM auth service"+authService.getCurrentUser().get().toString());
        return imageStorageService.getAllAnnouncementImages(id);
    }

    @PostMapping("/addImages")
    public List<ImageStorage> addImages(@RequestBody List<ImageStorage> imageList)
    {
        List<ImageStorage> returnlist = new ArrayList<ImageStorage>();
        for (ImageStorage image : imageList){
            returnlist.add(imageStorageService.saveImage(image));
        }
        return returnlist;
    }
}
