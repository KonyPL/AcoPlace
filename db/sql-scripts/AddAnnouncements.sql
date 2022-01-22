--Announcment table
insert into announcement(id, available_from, city, country, currency, district, house_number, living_space, postal_code, price, property_type, publication_date, state, street, text, title, year_built, web_user_id, active, reported, edited) values(100,'2021-11-15','Poznan','Polska','PLN','Gorna Wilda','1/3a',15,'61-784',1000,'POKOJ','2021-11-18','Wielkopolskie','Pamiatkowa','Zapraszam do odwiedzenia','Apartament przestronny', 2002,100, true, false, false);
insert into announcement(id, available_from, city, country, currency, district, house_number, living_space, postal_code, price, property_type, publication_date, state, street, text, title, year_built, web_user_id, active, reported, edited) values(101,'2022-06-15','Poznan','Polska','PLN','Dolna Wilda','6/24',18,'61-781',800,'POKOJ','2021-11-18','Wielkopolskie','Wielka','Warto wynajac','Rezydencja w centrum miasta', 2002,101, false, false, false);
insert into announcement(id, available_from, city, country, currency, district, house_number, living_space, postal_code, price, property_type, publication_date, state, street, text, title, year_built, web_user_id, active, reported, edited) values(102,'2022-01-01','Poznan','Polska','PLN','Rataje','12/31',13,'61-787',600,'POKOJ','2021-11-18','Wielkopolskie','Dluga','Duzo ciekawych miejsc w okolicy','Lokum w dobrej lokalizacji', 2002,102, true), false, false;
insert into announcement(id, available_from, city, country, currency, district, house_number, living_space, postal_code, price, property_type, publication_date, state, street, text, title, year_built, web_user_id, active, reported, edited) values(103,'2021-10-30','Warszawa','Polska','EUR','Praga','31/86',18,'41-783',1500,'MIESZKANIE','2021-10-25','Czechy','Ksiecia Jozefa','Wlasny kat w dobrej cenie','Pokoj dostepny od zaraz', 1999,103, true, false, false);
insert into announcement(id, available_from, city, country, currency, district, house_number, living_space, postal_code, price, property_type, publication_date, state, street, text, title, year_built, web_user_id, active, reported, edited) values(104,'2022-01-25','Paryz','Francja','EUR','Pola Elizejskie','12/113',1300,'08782',222,'DOM','2021-11-18','Francja','Ludwika XV','Mieszkanie na ktore Cie stac','Mieszkanie na wynajem', 2005,104, true, false, false);
insert into announcement(id, available_from, city, country, currency, district, house_number, living_space, postal_code, price, property_type, publication_date, state, street, text, title, year_built, web_user_id, active, reported, edited) values(105,'2022-02-01','Wroclaw','Polska','DOL','Stare Miasto','6/53',43,'21-002',1110,'POKOJ','2021-10-25','Dolnoslaskie','Krotka','Idealne dla kazdego','Pokoj dla studenta', 1999,100, true, false, false);
insert into announcement(id, available_from, city, country, currency, district, house_number, living_space, postal_code, price, property_type, publication_date, state, street, text, title, year_built, web_user_id, active, reported, edited) values(106,'2001-02-09','Gdansk','Polska','YEN','Oliwa','77',70,'61-782',890,'MIESZKANIE','2021-11-18','Pomorskie','Bajkowa','Malownicze parki obok domu','Dom w pieknej okolicy', 2002,101, false, false, false);
insert into announcement(id, available_from, city, country, currency, district, house_number, living_space, postal_code, price, property_type, publication_date, state, street, text, title, year_built, web_user_id, active, reported, edited) values(107,'2021-12-12','Bytom','Polska','PLN','Centrum','212/23',82,'61-443',300,'POKOJ','2021-11-18','Slaskie','Poznanska','Spodoba sie studentom','Lokum zadbane', 2005,102, true, false, false);
insert into announcement(id, available_from, city, country, currency, district, house_number, living_space, postal_code, price, property_type, publication_date, state, street, text, title, year_built, web_user_id, active, reported, edited) values(108,'2022-01-05','Berlin','Niemcy','CHF','Centrum','31',33,'61-762',2000,'POKOJ','2021-11-18','Niemcy','Ukryta','Dobre miejsce dla par','Apartament', 1999,103, true, false, false);
insert into announcement(id, available_from, city, country, currency, district, house_number, living_space, postal_code, price, property_type, publication_date, state, street, text, title, year_built, web_user_id, active, reported, edited) values(109,'2021-12-05','Praga','Czechy','KOR','Nowe Miasto','6a/3',53,'61783',1500,'POKOJ','2022-01-01','Czechy','Fioletowa','Wszedzie dobrze, ale w domu najlepiej','Pokoj do wynajecia', 2002,104, true, false, false);
insert into announcement(id, available_from, city, country, currency, district, house_number, living_space, postal_code, price, property_type, publication_date, state, street, text, title, year_built, web_user_id, active, reported, edited) values(110,'2021-03-10','Pniewy','Polska','PLN','Peryferia','8/32a',10,'62-228',3700,'MIESZKANIE','2021-11-18','Wielkopolskie','Mieszkalna','Mila i cicha okolica','Mieszkanie w bloku', 2002,104, true, false, false);
insert into announcement(id, available_from, city, country, currency, district, house_number, living_space, postal_code, price, property_type, publication_date, state, street, text, title, year_built, web_user_id, active, reported, edited) values(111,'2021-07-12','Torun','Polska','PLN','Stare Miasto','1d/2',33,'71-728',800,'DOM','2022-01-01','Kujawsko-Pomorskie','Karmelowa','Polecam i pozdrawiam','Szeregowiec', 2005,104, true, false, false);
insert into announcement(id, available_from, city, country, currency, district, house_number, living_space, postal_code, price, property_type, publication_date, state, street, text, title, year_built, web_user_id, active, reported, edited) values(112,'2021-01-01','Bruksela','Belgia','EUR','Centrum','9',111,'22078',2500,'MIESZKANIE','2020-02-01','Belgia','Szewska','Swietna opcja dla rodziny','Blizniak', 2012,101, true, false, false);

---Announcment_detail table
insert into announcement_details(announcement_id, id, bath, shower, microwave, oven, pets_allowed, elevator, near_park, fenced, near_tram, near_bus, wifi, ethernet_outlets, internet, internet_speed, tv, dishwasher, clothes_dryer, near_shopping_mall, near_bakery, near_food_market, near_supermarket) values (100, 100, true, true, true, true, false, false, false, true, true, false, true, false, true, 50, false, true, true, false, true, false, true);
insert into announcement_details(announcement_id, id, bath, shower, microwave, oven, pets_allowed, elevator, near_park, fenced, near_tram, near_bus, wifi, ethernet_outlets, internet, internet_speed, tv, dishwasher, clothes_dryer, near_shopping_mall, near_bakery, near_food_market, near_supermarket) values (101, 101, true, true, true, true, true, true, true, true, true, true, true, true, true, 999, true, true, true, true, true, true, true);
insert into announcement_details(announcement_id, id, bath, shower, microwave, oven, pets_allowed, elevator, near_park, fenced, near_tram, near_bus, wifi, ethernet_outlets, internet, internet_speed, tv, dishwasher, clothes_dryer, near_shopping_mall, near_bakery, near_food_market, near_supermarket) values (102, 102, false, false, false, false, false, false, false, false, false, false, false, false, false, 0, false, false, false, false, false, false, false);
insert into announcement_details(announcement_id, id, bath, shower, microwave, oven, pets_allowed, elevator, near_park, fenced, near_tram, near_bus, wifi, ethernet_outlets, internet, internet_speed, tv, dishwasher, clothes_dryer, near_shopping_mall, near_bakery, near_food_market, near_supermarket) values (103, 103, true, false, true, true, false, false, false, false, true, false, true, false, true, 3, false, true, false, true, true, false, true);
insert into announcement_details(announcement_id, id, bath, shower, microwave, oven, pets_allowed, elevator, near_park, fenced, near_tram, near_bus, wifi, ethernet_outlets, internet, internet_speed, tv, dishwasher, clothes_dryer, near_shopping_mall, near_bakery, near_food_market, near_supermarket) values (104, 104, false, true, true, true, false, false, true, true, true, false, true, false, true, 555, false, true, true, false, true, false, true);
insert into announcement_details(announcement_id, id, bath, shower, microwave, oven, pets_allowed, elevator, near_park, fenced, near_tram, near_bus, wifi, ethernet_outlets, internet, internet_speed, tv, dishwasher, clothes_dryer, near_shopping_mall, near_bakery, near_food_market, near_supermarket) values (105, 105, false, true, true, true, true, false, false, true, true, true, true, false, true, 20, false, true, true, false, true, false, true);
insert into announcement_details(announcement_id, id, bath, shower, microwave, oven, pets_allowed, elevator, near_park, fenced, near_tram, near_bus, wifi, ethernet_outlets, internet, internet_speed, tv, dishwasher, clothes_dryer, near_shopping_mall, near_bakery, near_food_market, near_supermarket) values (106, 106, true, true, true, true, false, false, false, true, true, false, true, false, true, 40, false, true, true, false, false, false, true);
insert into announcement_details(announcement_id, id, bath, shower, microwave, oven, pets_allowed, elevator, near_park, fenced, near_tram, near_bus, wifi, ethernet_outlets, internet, internet_speed, tv, dishwasher, clothes_dryer, near_shopping_mall, near_bakery, near_food_market, near_supermarket) values (107, 107, true, true, true, true, false, false, false, true, true, false, true, false, true, 200, false, false, true, false, true, false, false);
insert into announcement_details(announcement_id, id, bath, shower, microwave, oven, pets_allowed, elevator, near_park, fenced, near_tram, near_bus, wifi, ethernet_outlets, internet, internet_speed, tv, dishwasher, clothes_dryer, near_shopping_mall, near_bakery, near_food_market, near_supermarket) values (108, 108, false, true, false, true, false, false, false, true, false, false, true, false, true, 50, false, true, true, true, true, false, true);
insert into announcement_details(announcement_id, id, bath, shower, microwave, oven, pets_allowed, elevator, near_park, fenced, near_tram, near_bus, wifi, ethernet_outlets, internet, internet_speed, tv, dishwasher, clothes_dryer, near_shopping_mall, near_bakery, near_food_market, near_supermarket) values (109, 109, true, true, true, true, false, false, false, true, true, false, true, false, true, 0, false, true, true, false, true, false, true);
insert into announcement_details(announcement_id, id, bath, shower, microwave, oven, pets_allowed, elevator, near_park, fenced, near_tram, near_bus, wifi, ethernet_outlets, internet, internet_speed, tv, dishwasher, clothes_dryer, near_shopping_mall, near_bakery, near_food_market, near_supermarket) values (110, 110, true, true, true, true, false, false, false, true, true, true, true, false, false, 150, false, true, true, false, true, false, true);
insert into announcement_details(announcement_id, id, bath, shower, microwave, oven, pets_allowed, elevator, near_park, fenced, near_tram, near_bus, wifi, ethernet_outlets, internet, internet_speed, tv, dishwasher, clothes_dryer, near_shopping_mall, near_bakery, near_food_market, near_supermarket) values (111, 111, true, false, true, true, true, false, true, true, true, false, true, false, true, 50, false, true, true, false, true, false, false);
insert into announcement_details(announcement_id, id, bath, shower, microwave, oven, pets_allowed, elevator, near_park, fenced, near_tram, near_bus, wifi, ethernet_outlets, internet, internet_speed, tv, dishwasher, clothes_dryer, near_shopping_mall, near_bakery, near_food_market, near_supermarket) values (112, 112, false, false, true, true, true, false, true, true, true, false, false, false, true, 555, false, true, true, false, true, false, false);


--Flat_delails table
insert into flat_details(announcement_id, id, floor, bedrooms, bathrooms, basement, flat_parking, balcony) values (100, 100, 0, 1, 2, true, 1, 3);
insert into flat_details(announcement_id, id, floor, bedrooms, bathrooms, basement, flat_parking, balcony) values (101, 101, 3, 1, 2, false, 0, 3);
insert into flat_details(announcement_id, id, floor, bedrooms, bathrooms, basement, flat_parking, balcony) values (102, 102, 4, 3, 2, false, 1, 3);
insert into flat_details(announcement_id, id, floor, bedrooms, bathrooms, basement, flat_parking, balcony) values (103, 103, 1, 2, 2, false, 1, 3);
--room_details table
insert into room_details(announcement_id, id, floor, beds_in_room, number_of_flatmates, bathrooms) values (104, 104, 4, 7, 5, 3);
insert into room_details(announcement_id, id, floor, beds_in_room, number_of_flatmates, bathrooms) values (105, 105, 5, 5, 6, 1);
insert into room_details(announcement_id, id, floor, beds_in_room, number_of_flatmates, bathrooms) values (106, 106, 6, 11, 2, 5);
insert into room_details(announcement_id, id, floor, beds_in_room, number_of_flatmates, bathrooms) values (107, 107, 7, 1, 1, 6);
insert into room_details(announcement_id, id, floor, beds_in_room, number_of_flatmates, bathrooms) values (108, 108, 7, 3, 0, 1);
--house_details table
insert into house_details(announcement_id, id, floors, basement, bedrooms, bathrooms, lot_size, parking, balcony) values (109, 109, 11, false, 2, 1, 0, true, 2);
insert into house_details(announcement_id, id, floors, basement, bedrooms, bathrooms, lot_size, parking, balcony) values (110, 110, 2, true, 1, 4, 2, false, 1);
insert into house_details(announcement_id, id, floors, basement, bedrooms, bathrooms, lot_size, parking, balcony) values (111, 111, 6, false, 3, 1, 7, true, 2);
insert into house_details(announcement_id, id, floors, basement, bedrooms, bathrooms, lot_size, parking, balcony) values (112, 112, 1, true, 2, 3, 1, true, 6);
