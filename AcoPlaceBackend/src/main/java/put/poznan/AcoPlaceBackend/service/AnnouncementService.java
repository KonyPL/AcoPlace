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
@Service
public class AnnouncementService {

    private final AnnouncementRepository announcementRepository;
    private final AnnouncementDetailsRepository announcementDetailsRepository;
    private final UserRepository userRepository;
    private final FavouriteRepository favouriteRepository;
    private final HouseDetailsRepository houseDetailsRepository;
    private final FlatDetailsRepository flatDetailsRepository;
    private final RoomDetailsRepository roomDetailsRepository;
    private final ImageStorageRepository imageStorageRepository;



    public Announcement getAnnouncementById(Integer id) {
        // return advertisementRepository.getById(id);
        return announcementRepository.findAnnouncementById(id).orElseThrow(() -> new ResourceNotFoundException("Advertisement with id:" + id + " not found in database"));
    }

    public List<AnnouncementDto> searchAnnouncements(AnnouncementSearchCriteria searchCriteria) {
        List<AnnouncementDto> announcementDtoList = announcementRepository.findAnnouncements(searchCriteria);
        for (AnnouncementDto announcement : announcementDtoList){
            List<String> images = imageStorageRepository.findAllByAnnouncementId(announcement.getId());
            announcement.setImages(images);
        }
        return announcementDtoList;
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
        announcement.setTitle(announcementCreateDto.getTitle());
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
        announcement.setEditedByUser(false); // nie jest edytowane przez usera
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
        announcementDetailsRepository.save(announcementDetails);

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

    public AnnouncementCreateDto getAnnouncementDtoById(Integer id) {
        Announcement announcement = announcementRepository.findAnnouncementById(id).orElseThrow(()-> new ResourceNotFoundException("Announcement with"+id+"not found"));
        AnnouncementDetails announcementDetails = announcementDetailsRepository.findAnnouncementDetailsByAnnouncementId(id);
        //zmapowac annoucnementdetails i announcement na annoucnemtCreateDto

        AnnouncementCreateDto announcementCreateDto = new AnnouncementCreateDto();
        announcementCreateDto.setId(announcement.getId());
        announcementCreateDto.setCountry(announcement.getCountry());
        announcementCreateDto.setCity(announcement.getCity());
        announcementCreateDto.setPostalCode(announcement.getPostalCode());
        announcementCreateDto.setDistrict(announcement.getDistrict());
        announcementCreateDto.setState(announcement.getState());
        announcementCreateDto.setStreet(announcement.getStreet());
        announcementCreateDto.setHouseNumber(announcement.getHouseNumber());
        announcementCreateDto.setTitle(announcement.getTitle());
        announcementCreateDto.setText(announcement.getText());
        announcementCreateDto.setPropertyType(announcement.getPropertyType());
        announcementCreateDto.setPrice(announcement.getPrice());
        announcementCreateDto.setCurrency(announcement.getCurrency());
        announcementCreateDto.setLivingSpace(announcement.getLivingSpace());
        announcementCreateDto.setYearBuilt(announcement.getYearBuilt());
        //TYCH ADMINOWSKICH CHYBA NIE BEDZIEMY POTRZEBOWAC TAK MYSLE, bo w sumie tego uzytkownik nie moze edytowac


                //announcment details
        //TODO caly czas blad leci na bath
        announcementCreateDto.setBath(announcementDetails.isBath());
        announcementCreateDto.setShower(announcementDetails.isShower());
        announcementCreateDto.setMicrowave(announcementDetails.isMicrowave());
        announcementCreateDto.setOven(announcementDetails.isOven());
        announcementCreateDto.setPetsAllowed(announcementDetails.isPetsAllowed());
        announcementCreateDto.setElevator(announcementDetails.isElevator());
        announcementCreateDto.setNearPark(announcementDetails.isNearPark());
        announcementCreateDto.setFenced(announcementDetails.isFenced());
        announcementCreateDto.setNearTram(announcementDetails.isNearTram());
        announcementCreateDto.setNearBus(announcementDetails.isNearBus());
        announcementCreateDto.setWifi(announcementDetails.isWifi());
        announcementCreateDto.setEthernetOutlets(announcementDetails.isEthernetOutlets());
        announcementCreateDto.setInternetSpeed(announcementDetails.getInternetSpeed());
        announcementCreateDto.setInternet(announcementDetails.isInternet());
        announcementCreateDto.setTv(announcementDetails.isTv());
        announcementCreateDto.setDishwasher(announcementDetails.isDishwasher());
        announcementCreateDto.setClothesDryer(announcementDetails.isClothesDryer());
        announcementCreateDto.setNearShoppingMall(announcementDetails.isNearShoppingMall());
        announcementCreateDto.setNearSupermarket(announcementDetails.isNearSupermarket());
        announcementCreateDto.setNearFoodMarket(announcementDetails.isNearFoodMarket());

        if(announcement.getPropertyType()=="ROOM"){
            RoomDetails roomDetails  = roomDetailsRepository.findByAnnouncementId(id);
            announcementCreateDto.setFloor(roomDetails.getFloor());
            announcementCreateDto.setBedsInRoom(roomDetails.getBedsInRoom());
            announcementCreateDto.setNumberOfFlatmates(roomDetails.getNumberOfFlatmates());
            announcementCreateDto.setBathrooms(roomDetails.getBathrooms());
        }
        if(announcement.getPropertyType()=="HOUSE"){
            HouseDetails houseDetails = houseDetailsRepository.findByAnnouncementId(id);
            announcementCreateDto.setFloors(houseDetails.getFloors());
            announcementCreateDto.setBasement(houseDetails.getBasement());
            announcementCreateDto.setBedrooms(houseDetails.getBedrooms());
            announcementCreateDto.setBathrooms(houseDetails.getBathrooms());
            announcementCreateDto.setLotSize(houseDetails.getLotSize());
            announcementCreateDto.setParking(houseDetails.getParking());
            announcementCreateDto.setBalcony(houseDetails.getBalcony());
        }
        if(announcement.getPropertyType()=="FLAT"){
            FlatDetails flatDetails = flatDetailsRepository.findByAnnouncementId(id);
            announcementCreateDto.setBasement(flatDetails.getBasement());
            announcementCreateDto.setFloor(flatDetails.getFloor());
            announcementCreateDto.setBedrooms(flatDetails.getBedrooms());
            announcementCreateDto.setBathrooms(flatDetails.getBathrooms());
            announcementCreateDto.setFlatParking(flatDetails.getFlatParking());
            announcementCreateDto.setBalcony(flatDetails.getBalcony());
        }

        return announcementCreateDto;

    }

    public Announcement updateAnnouncementByDto(AnnouncementCreateDto announcementCreateDto) {
        Announcement announcement = announcementRepository.findAnnouncementById(announcementCreateDto.getId()).orElseThrow(() -> new ResourceNotFoundException("announcmenet with"+announcementCreateDto.getId()+"not fount"));
        AnnouncementDetails announcementDetails = announcementDetailsRepository.findAnnouncementDetailsByAnnouncementId(announcementCreateDto.getId());
        announcement.setTitle(announcementCreateDto.getTitle());
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

        announcement.setActive(false);// po edycji ogloszenia jest nieaktywne
        announcement.setEditedByUser(true);
        //TODO EDITED BY USER USTAWIC

        announcementRepository.save(announcement);

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
        announcementDetailsRepository.save(announcementDetails);

        if(announcement.getPropertyType().equalsIgnoreCase("HOUSE")){
            HouseDetails houseDetails = houseDetailsRepository.findByAnnouncementId(announcementCreateDto.getId());
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
            RoomDetails roomDetails = roomDetailsRepository.findByAnnouncementId(announcementCreateDto.getId());
            roomDetails.setFloor(announcementCreateDto.getFloor());
            roomDetails.setBedsInRoom(announcementCreateDto.getBedsInRoom());
            roomDetails.setNumberOfFlatmates(announcementCreateDto.getNumberOfFlatmates());
            roomDetails.setBathrooms(announcementCreateDto.getBathrooms());
            roomDetails.setAnnouncement(announcement);
            //save
            roomDetailsRepository.save(roomDetails);
        }

        if(announcement.getPropertyType().equalsIgnoreCase("FLAT")){
            FlatDetails flatDetails = flatDetailsRepository.findByAnnouncementId(announcementCreateDto.getId());
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

       return  announcement;

    }

    public List<Announcement> getActiveForUserByAnnouncementId(Integer id) {
        Announcement announcement = announcementRepository.findAnnouncementById(id).orElseThrow(() -> new ResourceNotFoundException("announcement not found"));
        return announcementRepository.getActiveForUser(announcement.getWebUser().getId());
    }
}
