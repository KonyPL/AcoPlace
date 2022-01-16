--Announcment table
insert into announcement(id, available_from, city, country, currency, district, house_number, living_space, postal_code, price, property_type, publication_date, state, street, text, title, year_built, web_user_id) values(100,'2021-11-15','poznan','polska','PLN','wilda','12/3',10,'61-78',999,'POKOJ','2021-11-18','wlkp','gorna wilda','mega domol','super pokoj dla studenta', 2002,100);
insert into announcement(id, available_from, city, country, currency, district, house_number, living_space, postal_code, price, property_type, publication_date, state, street, text, title, year_built, web_user_id) values(101,'2021-11-15','poznan','polska','PLN','wilda','12/3',10,'61-78',999,'POKOJ','2021-11-18','wlkp','gorna wilda','chata jak ta lala','super pokoj dla studenta wersja 2', 2002,101);
insert into announcement(id, available_from, city, country, currency, district, house_number, living_space, postal_code, price, property_type, publication_date, state, street, text, title, year_built, web_user_id) values(102,'2021-11-15','poznan','polska','PLN','wilda','12/3',10,'61-78',999,'POKOJ','2021-11-18','wlkp','gorna wilda','dom jak slon','super pokoj dla studenta wersja 3', 2002,102);
insert into announcement(id, available_from, city, country, currency, district, house_number, living_space, postal_code, price, property_type, publication_date, state, street, text, title, year_built, web_user_id) values(103,'2021-11-15','warszawa','polska','EUR','lazarz','12',10,'61-783',111,'MIESZKANIE','2021-10-25','malopl','dolna wilda','ciasny ale wlasny','super pokoj dla studenta wersja 3', 1999,103);
insert into announcement(id, available_from, city, country, currency, district, house_number, living_space, postal_code, price, property_type, publication_date, state, street, text, title, year_built, web_user_id) values(104,'1999-01-01','paryz','francja','CHF','gorczyn','12/113',13,'61-782',222,'DOM','2021-11-18','wlkp','gorna wilda','gigagiga chata','super pokoj dla nikogo', 2005,104);
insert into announcement(id, available_from, city, country, currency, district, house_number, living_space, postal_code, price, property_type, publication_date, state, street, text, title, year_built, web_user_id) values(105,'2000-12-31','wroclaw','polska','DOL','wilda','122/3',13,'61-783',111,'POKOJ','2021-10-25','wlkp','dolna wilda','super to jest  domek','pokoj dla studenta', 1999,100);
insert into announcement(id, available_from, city, country, currency, district, house_number, living_space, postal_code, price, property_type, publication_date, state, street, text, title, year_built, web_user_id) values(106,'2001-02-28','gdansk','polska','YEN','wilda','112/13',10,'61-782',222,'MIESZKANIE','2021-11-18','wlkp','gorna wilda','giga chata','super', 2002,101);
insert into announcement(id, available_from, city, country, currency, district, house_number, living_space, postal_code, price, property_type, publication_date, state, street, text, title, year_built, web_user_id) values(107,'2020-05-12','czechowice','polska','FNT','lazarz','212/23',22,'61-783',1212,'POKOJ','2021-11-18','malopl','dolna wilda','chata chada','super pokoj', 2005,102);
insert into announcement(id, available_from, city, country, currency, district, house_number, living_space, postal_code, price, property_type, publication_date, state, street, text, title, year_built, web_user_id) values(108,'2021-10-25','berlin','niemcy','FRN','wilda','133',33,'61-782',1212,'POKOJ','2021-11-18','zachpom','gorna wilda','domek romek','super pokoj', 1999,103);
insert into announcement(id, available_from, city, country, currency, district, house_number, living_space, postal_code, price, property_type, publication_date, state, street, text, title, year_built, web_user_id) values(109,'2021-12-05','nowe miasto','czechy','JPG','gorczyn','112a/3',33,'61783',1212,'POKOJ','1999-01-01','wlkp','gorczyn','w domu najlepiej','czadowy pokoj dla nas', 2002,104);
insert into announcement(id, available_from, city, country, currency, district, house_number, living_space, postal_code, price, property_type, publication_date, state, street, text, title, year_built, web_user_id) values(110,'2021-03-10','gdansk','polska','OMG','wilda','12/3a',10,'61228',222,'MIESZKANIE','2021-11-18','malopl','gorna wilda','tu tez milo jest','super wersja 3', 2002,104);
insert into announcement(id, available_from, city, country, currency, district, house_number, living_space, postal_code, price, property_type, publication_date, state, street, text, title, year_built, web_user_id) values(111,'2021-07-12','lodz','czechy','ABC','rataje','122a/3',33,'6178',444,'DOM','1999-01-01','zachpom','gorczyn','super domor','wersja 3', 2005,104);
insert into announcement(id, available_from, city, country, currency, district, house_number, living_space, postal_code, price, property_type, publication_date, state, street, text, title, year_built, web_user_id) values(112,'2021-01-01','krakow','belgia','MHM','florencja','132',11,'61078',224,'MIESZKANIE','1999-02-01','malo','stare','super domor dla mnie i ciebie','wersja 1231233', 2012,101);

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