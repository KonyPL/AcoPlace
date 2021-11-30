package put.poznan.AcoPlaceBackend.service;

import org.springframework.stereotype.Service;
import put.poznan.AcoPlaceBackend.exception.ResourceNotFoundException;
import put.poznan.AcoPlaceBackend.model.RoomDetails;
import put.poznan.AcoPlaceBackend.repository.RoomDetailsRepository;

import java.util.List;

@Service
public class RoomDetailsService {
    private final RoomDetailsRepository roomDetailsRepository;

    public RoomDetailsService(RoomDetailsRepository roomDetailsRepository) {
        this.roomDetailsRepository = roomDetailsRepository;
    }

    public List<RoomDetails> getAllRoomDetails() {
        return roomDetailsRepository.findAll();
    }

    public RoomDetails getRoomDetailsById(long id){
        return roomDetailsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("RoomDetails with id:" + id + " not found in database"));
    }

    public RoomDetails getRoomDetailsByAnnouncementId(long id){
        return roomDetailsRepository.findByAnnouncementId(id);
    }

    public RoomDetails saveRoomDetails(RoomDetails roomDetails){
        return roomDetailsRepository.save(roomDetails);
    }
}
