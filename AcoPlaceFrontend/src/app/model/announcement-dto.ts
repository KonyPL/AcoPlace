export class AnnouncementCreateDto {
    id: number;
    country: string;
    city: string;
    postalCode: string;
    district: string;
    state: string;
    street: string;
    houseNumber: string;
    title: string;
    text: string;
    propertyType: string;
    price: number;
    currency: string;
    livingSpace: number;
    yearBuilt: number;
    availableFrom: Date;
    publicationDate: Date;
    webUser: number;
    reported: boolean;
    reason: string; 
    description: string;
    admin: string;
    reportedTime: string;
    edited: boolean;
    active: boolean; 
    //WEB USR ID
    webUserId: number; 
    //annoucnement detail info
    bath: boolean; 
    shower: boolean; 
    microwave: boolean; 
    oven: boolean; 
    petsAllowed: boolean; 
    elevator: boolean; 
    nearPark: boolean; 
    fenced: boolean; 
    nearTram: boolean; 
    nearBus: boolean;
    wifi: boolean; 
    ethernetOutlets: boolean; 
    internet: boolean;
    internetSpeed: number;
    tv: boolean; 
    dishwasher: boolean;
    clothesDryer: boolean;
    nearShoppingMall: boolean;
    nearBakery: boolean;
    nearFoodMarket: boolean;
    nearSupermarket: boolean; 
    //flat details
    floor: number;
    bedrooms: number; 
    bathrooms: number; 
    flatParking: boolean; 
    balcony: number;
    //house details
    floors: number;
    basement: boolean;
  //  bedrooms: number; 
    //bathrooms: number; 
    lotSize: number;
    parking: boolean; 
    //balcony: number;

    //ROOM DETAILS
    //floor: number;
  bedsInRoom: number;
  numberOfFlatmates: number;
  //bathrooms: number;
}

