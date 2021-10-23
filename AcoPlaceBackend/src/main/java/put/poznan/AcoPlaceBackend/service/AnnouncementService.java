package put.poznan.AcoPlaceBackend.service;

import org.springframework.stereotype.Service;
import put.poznan.AcoPlaceBackend.model.Announcement;
import put.poznan.AcoPlaceBackend.repository.AnnouncementRepositoy;

import java.util.List;

@Service
public class AnnouncementService {
    private  final AnnouncementRepositoy announcementRepositoy;

    public AnnouncementService(AnnouncementRepositoy announcementRepositoy) {
        this.announcementRepositoy = announcementRepositoy;
    }

    public List<Announcement> getAllAnouncements() {
        return announcementRepositoy.findAll();
    }


}
