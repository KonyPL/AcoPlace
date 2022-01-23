package put.poznan.AcoPlaceBackend.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import put.poznan.AcoPlaceBackend.criteria.AnnouncementSearchCriteria;
import put.poznan.AcoPlaceBackend.dto.AnnouncementDto;
import put.poznan.AcoPlaceBackend.exception.ResourceNotFoundException;

import put.poznan.AcoPlaceBackend.model.*;
import put.poznan.AcoPlaceBackend.repository.*;

import put.poznan.AcoPlaceBackend.model.Announcement;
import put.poznan.AcoPlaceBackend.model.WebUser;
import put.poznan.AcoPlaceBackend.repository.AnnouncementDetailsRepository;
import put.poznan.AcoPlaceBackend.repository.AnnouncementRepository;
import put.poznan.AcoPlaceBackend.repository.FavouriteRepository;
import put.poznan.AcoPlaceBackend.repository.UserRepository;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@AllArgsConstructor
@Service
public class AnnouncementService {

    private final AnnouncementRepository announcementRepository;
    private final AnnouncementDetailsRepository announcementDetailsRepository;
    private final UserRepository userRepository;
private final FavouriteRepository favouriteRepository;
    private final HouseDetailsRepository houseDetailsRepository;
    private final FlatDetailsRepository flatDetailsRepository;
    private final RoomDetailsRepository roomDetailsRepository;


 


    public Announcement getAnnouncementById(Integer id) {
        // return advertisementRepository.getById(id);
        return announcementRepository.findAnnouncementById(id).orElseThrow(() -> new ResourceNotFoundException("Advertisement with id:" + id + " not found in database"));
    }

    public List<AnnouncementDto> searchAnnouncements(AnnouncementSearchCriteria searchCriteria) {
        return announcementRepository.findAnnouncements(searchCriteria);
    }

    public List<Announcement> getAll() {
        return announcementRepository.findAll();
    }

    public Announcement saveAnnouncement(Announcement announcement) {
        return announcementRepository.save(announcement);
    }

    public List<Announcement> getActiveForCurrentUser() {
        String username= SecurityContextHolder.getContext().getAuthentication().getName();
        WebUser webUser = userRepository.findByUserName(username).orElseThrow(() -> new ResourceNotFoundException("user with name="+username+"nor found"));
       return announcementRepository.getActiveForUser(webUser.getId());

       // return announcementRepository.getActiveForUser();
    }

    public List<Announcement> getInactiveForCurrentUser() {
        String username= SecurityContextHolder.getContext().getAuthentication().getName();
        WebUser webUser = userRepository.findByUserName(username).orElseThrow(() -> new ResourceNotFoundException("user with name="+username+"nor found"));
        return announcementRepository.getInactiveForUser(webUser.getId());
    }


    public Announcement createAnnouncementByDto(AnnouncementCreateDto announcementCreateDto){
        System.out.println(announcementCreateDto.toString());
        // announcementService.saveAnnouncement(announcement);
        //TODO MAPPER PROSTY i tak pewnie nie zdazymy
        //TODO v1 w odpowiedniej kolejosci dac add details i flat details+++
        Announcement announcement = new Announcement();
        announcement.setCountry(announcementCreateDto.getCountry());
        announcement.setCity(announcementCreateDto.getCity());
        announcement.setPostalCode(announcementCreateDto.getPostalCode());
        announcement.setDistrict(announcementCreateDto.getDistrict());
        announcement.setState(announcementCreateDto.getState());
        announcement.setStreet(announcementCreateDto.getStreet());
        announcement.setHouseNumber(announcementCreateDto.getHouseNumber());
        announcement.setText(announcementCreateDto.getText());
        announcement.setPropertyType(announcementCreateDto.getPropertyType());
        announcement.setPrice(announcementCreateDto.getPrice());
        announcement.setCurrency(announcementCreateDto.getCurrency());
        announcement.setLivingSpace(announcementCreateDto.getLivingSpace());
        announcement.setYearBuilt(announcementCreateDto.getYearBuilt());
        announcement.setAvailableFrom(announcementCreateDto.getAvailableFrom());
        announcement.setPublicationDate((new Date(System.currentTimeMillis()))); //TU BYĆ MOŻE BĘDZIE POTRZEBNY ZMIAANA FORMATU DATY

        // publication date ustawiana automatycznie
        //ADMIN things automatically
        announcement.setReported(false);
        // reason, description i admin oraz reported time nie ustawiamy bo bedzie null
        announcement.setEdited(false);
        announcement.setActive(false);
        //TODO tutaj zrobic rzeczy zwiazane z flaga editedByUser
        //USTAWIANIE USERA Z SECURITY CONTEX HOLDERA
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        announcement.setWebUser(userRepository.findByUserName(username)
                .orElseThrow(()-> new ResourceNotFoundException("WebUser with name="+username+" not found.")));

        //saving add
        announcementRepository.save(announcement);

        AnnouncementDetails announcementDetails = new AnnouncementDetails();
        announcementDetails.setBath(announcementCreateDto.isBath());
        announcementDetails.setShower(announcementCreateDto.isShower());
        announcementDetails.setMicrowave(announcementCreateDto.isMicrowave());
        announcementDetails.setOven(announcementCreateDto.isOven());
        announcementDetails.setPetsAllowed(announcementCreateDto.isPetsAllowed());
        announcementDetails.setElevator(announcementCreateDto.isElevator());
        announcementDetails.setNearPark(announcementCreateDto.isNearPark());
        announcementDetails.setFenced(announcementCreateDto.isFenced());
        announcementDetails.setNearTram(announcementCreateDto.isNearTram());
        announcementDetails.setNearBus(announcementCreateDto.isNearBus());
        announcementDetails.setWifi(announcementCreateDto.isWifi());
        announcementDetails.setEthernetOutlets(announcementCreateDto.isEthernetOutlets());
        announcementDetails.setInternetSpeed(announcementCreateDto.getInternetSpeed());
        announcementDetails.setInternet(announcementCreateDto.isInternet());
        announcementDetails.setTv(announcementCreateDto.isTv());
        announcementDetails.setDishwasher(announcementCreateDto.isDishwasher());
        announcementDetails.setClothesDryer(announcementCreateDto.isClothesDryer());
        announcementDetails.setNearShoppingMall(announcementCreateDto.isNearShoppingMall());
        announcementDetails.setNearBakery(announcementDetails.isNearBakery());
        announcementDetails.setNearFoodMarket(announcementDetails.isNearSupermarket());
        announcementDetails.setNearSupermarket(announcementDetails.isNearSupermarket());
        announcementDetails.setAnnouncement(announcement);

        if(announcement.getPropertyType().equalsIgnoreCase("HOUSE")){
            HouseDetails houseDetails = new HouseDetails();
            houseDetails.setFloors(announcementCreateDto.getFloors());
            houseDetails.setBasement(announcementCreateDto.getBasement());
            houseDetails.setBedrooms(announcementCreateDto.getBedrooms());
            houseDetails.setBathrooms(announcementCreateDto.getBathrooms());
            houseDetails.setLotSize(announcementCreateDto.getLotSize());
            houseDetails.setParking(announcementCreateDto.getParking());
            houseDetails.setBalcony(announcementCreateDto.getBalcony());
            houseDetails.setAnnouncement(announcement);
            //save
            houseDetailsRepository.save(houseDetails);
        }

        if(announcement.getPropertyType().equalsIgnoreCase("ROOM")){
            RoomDetails roomDetails = new RoomDetails();
            roomDetails.setFloor(announcementCreateDto.getFloor());
            roomDetails.setBedsInRoom(announcementCreateDto.getBedsInRoom());
            roomDetails.setNumberOfFlatmates(announcementCreateDto.getNumberOfFlatmates());
            roomDetails.setBathrooms(announcementCreateDto.getBathrooms());
            roomDetails.setAnnouncement(announcement);
            //save
            roomDetailsRepository.save(roomDetails);
        }

        if(announcement.getPropertyType().equalsIgnoreCase("FLAT")){
            FlatDetails flatDetails = new FlatDetails();
            flatDetails.setBasement(announcementCreateDto.getBasement());
            flatDetails.setFloor(announcementCreateDto.getFloor());
            flatDetails.setBedrooms(announcementCreateDto.getBedrooms());
            flatDetails.setBathrooms(announcementCreateDto.getBathrooms());
            flatDetails.setFlatParking(announcementCreateDto.getFlatParking());
            flatDetails.setBalcony(announcementCreateDto.getBalcony());
            flatDetails.setAnnouncement(announcement);
            //save
            flatDetailsRepository.save(flatDetails);
        }

        return announcement;}
      
    public List<Announcement> getFavouriteForCurrentUser() {
        String username= SecurityContextHolder.getContext().getAuthentication().getName();
        WebUser webUser = userRepository.findByUserName(username).orElseThrow(() -> new ResourceNotFoundException("user with name="+username+"nor found"));
        List<Integer> favouriteIdList = favouriteRepository.getAllAnnouncementIdForCurrentUser(webUser.getId());
        List<Announcement> announcementList = new ArrayList<>();
        for (int id: favouriteIdList) {
            announcementList.add( announcementRepository.findAnnouncementById(id).orElseThrow(()-> new ResourceNotFoundException("Announcement with id="+id+"not found")));
        }
        return announcementList;
        //@Query(value="SELECT announcement_details.announcement_id FROM announcement_details WHERE shower=?1  AND oven=?2",nativeQuery = true)

    }
}
