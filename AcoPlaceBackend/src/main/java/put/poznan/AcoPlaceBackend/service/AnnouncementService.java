package put.poznan.AcoPlaceBackend.service;

import org.springframework.stereotype.Service;
import put.poznan.AcoPlaceBackend.exception.ResourceNotFoundException;
import put.poznan.AcoPlaceBackend.model.Announcement;
import put.poznan.AcoPlaceBackend.repository.AnnouncementDetailsRepository;
import put.poznan.AcoPlaceBackend.repository.AnnouncementRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class AnnouncementService {

    private final AnnouncementRepository announcementRepository;
    private final AnnouncementDetailsRepository announcementDetailsRepository;

    public AnnouncementService(AnnouncementRepository announcementRepository, AnnouncementDetailsRepository announcementDetailsRepository) {
        this.announcementRepository = announcementRepository;
        this.announcementDetailsRepository = announcementDetailsRepository;
    }

    public Announcement getAnnouncementById(long id) {
        // return advertisementRepository.getById(id);
        return announcementRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Advertisement with id:" + id + " not found in database"));
    }

    public List<Announcement> getAllAnnouncements() {
        return announcementRepository.findAll();
    }

    public List<Announcement> searchAnnouncementsByParams(Map<String, String> allParams) {


        String priceMin = "0";
        String priceMax = "0";
        String propertyType = "0";
        String shower = "0";
        String oven = "0";
        for (Map.Entry<String, String> entry : allParams.entrySet()) {
            if (entry.getKey().equals("priceMin")) priceMin = entry.getValue();
            if (entry.getKey().equals("priceMax")) priceMax = entry.getValue();
            if (entry.getKey().equals("propertyType")) propertyType = entry.getValue();
            if (entry.getKey().equals("shower")) shower = entry.getValue();
            if (entry.getKey().equals("oven")) oven = entry.getValue();
        }
        System.out.println(priceMax);
        System.out.println(priceMin);
        System.out.println(propertyType);
        System.out.println(oven);
        System.out.println(shower);
        List<Integer> idFromAnnouncements = announcementRepository.findAllByParams(Integer.valueOf(priceMin), Integer.valueOf(priceMax), propertyType);
        List<Integer> idFromAnnouncementsDetailsRepository = announcementDetailsRepository.findAllByParams(Boolean.valueOf(shower),Boolean.valueOf(oven));
        //znalezieneie wspolnych id
        List<Integer> finalIdList = new ArrayList<>();
        for (Integer idFromAnnouncement : idFromAnnouncements) {
            if (idFromAnnouncementsDetailsRepository.contains(idFromAnnouncement)) finalIdList.add(idFromAnnouncement);
        }
        System.out.println("idFromAnnouncementsSize="+finalIdList.size());
        System.out.println("idFrAnnounceementsDetailsIdSize="+finalIdList.size());
        System.out.println("finalListIdSize="+finalIdList.size());
        List<Announcement> matchingAnnouncements = new ArrayList<>();
        for( Integer id: finalIdList){
           matchingAnnouncements.add( announcementRepository.findById((long)id).orElseThrow(() ->new ResourceNotFoundException("announcement with id="+id+"not found")));
        }
        for(Announcement announcement: matchingAnnouncements){
            System.out.println(announcement.toString());
        }
        System.out.println("==========================PRINTUJEMY MAPE ====================");

        for (Map.Entry<String, String> entry : allParams.entrySet()) {
            System.out.println("KEY="+entry.getKey()+"|  value="+entry.getValue());
        }

        return matchingAnnouncements;

    }

    public Announcement saveAnnouncement(Announcement announcement) {
        return announcementRepository.save(announcement);
    }
}
