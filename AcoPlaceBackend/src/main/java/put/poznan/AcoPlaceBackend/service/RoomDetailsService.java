package put.poznan.AcoPlaceBackend.service;

import org.springframework.stereotype.Service;
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
        return roomDetailsRepository.getById(id);
    }
}
