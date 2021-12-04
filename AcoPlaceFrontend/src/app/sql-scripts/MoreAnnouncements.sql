--all need fixes to be used

--flat details
insert into flat_details(announcement_id, id, floor, bedrooms, bathrooms, basement, flat_parking, balcony) values (104, 2, 1, 2, 1, 3);
insert into flat_details(announcement_id, id, floor, bedrooms, bathrooms, basement, flat_parking, balcony) values (105, 55, 2, 2, 2, 3);
insert into flat_details(announcement_id, id, floor, bedrooms, bathrooms, basement, flat_parking, balcony) values (106, 111, 3, 2, 2, 3);
insert into flat_details(announcement_id, id, floor, bedrooms, bathrooms, basement, flat_parking, balcony) values (107, 0, 5, 2, 3, 3);
insert into flat_details(announcement_id, id, floor, bedrooms, bathrooms, basement, flat_parking, balcony) values (108, 66, 1, 2, 2, 3);
insert into flat_details(announcement_id, id, floor, bedrooms, bathrooms, basement, flat_parking, balcony) values (109, 3, 6, 1, 1, 3);
insert into flat_details(announcement_id, id, floor, bedrooms, bathrooms, basement, flat_parking, balcony) values (110, 0, 21, 6, 2, 3);
insert into flat_details(announcement_id, id, floor, bedrooms, bathrooms, basement, flat_parking, balcony) values (111, 1, 1, 7, 0, 3); 

---room details
insert into room_details(announcement_id, id, floor, beds_in_room, number_of_flatmates, bathrooms) values (100, 0, 0, 0, 0);
insert into room_details(announcement_id, id, floor, beds_in_room, number_of_flatmates, bathrooms) values (101, 2, 3, 1, 0);
insert into room_details(announcement_id, id, floor, beds_in_room, number_of_flatmates, bathrooms) values (102, 1, 1, 1, 1);
insert into room_details(announcement_id, id, floor, beds_in_room, number_of_flatmates, bathrooms) values (103, 1, 6, 3, 2);
---
insert into room_details(announcement_id, id, floor, beds_in_room, number_of_flatmates, bathrooms) values (109, 8, 1, 3, 2);
insert into room_details(announcement_id, id, floor, beds_in_room, number_of_flatmates, bathrooms) values (110, 11, 2, 0, 2);
insert into room_details(announcement_id, id, floor, beds_in_room, number_of_flatmates, bathrooms) values (111, 22, 2, 0, 0);

--house details
insert into house_details(announcement_id, id, floors, basement, bedrooms, bathrooms, lot_size, parking, balcony) values (100, 0, false, 0, 0, 0, false, 0);
insert into house_details(announcement_id, id, floors, basement, bedrooms, bathrooms, lot_size, parking, balcony) values (101, 1, true, 1, 1, 1, true, 1);
insert into house_details(announcement_id, id, floors, basement, bedrooms, bathrooms, lot_size, parking, balcony) values (102, 2, true, 2, 2, 2, false, 2);
insert into house_details(announcement_id, id, floors, basement, bedrooms, bathrooms, lot_size, parking, balcony) values (103, 4, false, 2, 5, 5, false, 0);
insert into house_details(announcement_id, id, floors, basement, bedrooms, bathrooms, lot_size, parking, balcony) values (104, 5, false, 5, 7, 1, true, 2);
insert into house_details(announcement_id, id, floors, basement, bedrooms, bathrooms, lot_size, parking, balcony) values (105, 1, false, 6, 9, 4, false, 1);
insert into house_details(announcement_id, id, floors, basement, bedrooms, bathrooms, lot_size, parking, balcony) values (106, 2, false, 3, 3, 1, true, 5);
insert into house_details(announcement_id, id, floors, basement, bedrooms, bathrooms, lot_size, parking, balcony) values (107, 3, false, 8, 2, 2, false, 4);
insert into house_details(announcement_id, id, floors, basement, bedrooms, bathrooms, lot_size, parking, balcony) values (108, 2, false, 2, 6, 5, false, 3);
