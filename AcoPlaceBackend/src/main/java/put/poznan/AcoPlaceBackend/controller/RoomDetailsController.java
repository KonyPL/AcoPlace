package put.poznan.AcoPlaceBackend.controller;


import org.springframework.web.bind.annotation.*;
import put.poznan.AcoPlaceBackend.model.RoomDetails;
import put.poznan.AcoPlaceBackend.service.RoomDetailsService;

import java.util.List;

@RestController
@CrossOrigin()
public class RoomDetailsController {
    private final RoomDetailsService roomDetailsService;

    public RoomDetailsController(RoomDetailsService roomDetailsService) {
        this.roomDetailsService = roomDetailsService;
    }

    @GetMapping("/roomDetailsAll")
    public List<RoomDetails> getAllRoomDetails(){
        return  roomDetailsService.getAllRoomDetails();
    }

    @GetMapping("/roomDetails/{id}")
    public RoomDetails getRoomDetailsById(long id){
        return roomDetailsService.getRoomDetailsById(id);
    }

    @PostMapping("/addRoomDetails")
    public RoomDetails createRoomDetails(@RequestBody RoomDetails roomDetails){
        return roomDetailsService.saveRoomDetails(roomDetails);
    }
}
