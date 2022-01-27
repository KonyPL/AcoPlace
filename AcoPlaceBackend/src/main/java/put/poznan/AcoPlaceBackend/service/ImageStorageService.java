package put.poznan.AcoPlaceBackend.service;

import org.springframework.stereotype.Service;
import put.poznan.AcoPlaceBackend.exception.ResourceNotFoundException;
import put.poznan.AcoPlaceBackend.model.ImageStorage;
import put.poznan.AcoPlaceBackend.repository.ImageStorageRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class ImageStorageService {

    private final ImageStorageRepository imageStorageRepository;

    public ImageStorageService(ImageStorageRepository imageStorageRepository) {
        this.imageStorageRepository = imageStorageRepository;
    }

    public List<String> getAllAnnouncementImages(Integer announcementId){
        return imageStorageRepository.findAllByAnnouncementId(announcementId);
    }

    public String getOneAnnouncementImage(Integer announcementId) throws IndexOutOfBoundsException {
        return imageStorageRepository.findAllByAnnouncementId(announcementId).get(0);
    }

    public void deleteImageById(Integer imageId){
        imageStorageRepository.deleteById(imageId);
    }

    public ImageStorage saveImage(ImageStorage imageStorage){
        return imageStorageRepository.save(imageStorage);
    }

    public List<ImageStorage> getAllAnnouncementImagesFullInfo(Integer id) {
        return imageStorageRepository.findAllFullInfoByAnnouncementId(id);
    }
}
