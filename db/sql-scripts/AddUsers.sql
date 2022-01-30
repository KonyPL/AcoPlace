--user table
insert into web_user(id,user_name,email,password) values(100,'piter','piotr1@wp.pl','1234');
insert into web_user(id,user_name,email,password) values(101,'mrEk',mirek@wp.pl','4321');
insert into web_user(id,user_name,email,password) values(102,'rekju','jurek@wp.pl','1221');
insert into web_user(id,user_name,email,password) values(103,'VIS','wiesiek@wp.pl','5555');
insert into web_user(id,user_name,email,password) values(104,'zibi','zbyszek@wp.pl','7890');

--user details
insert into user_details(id, web_user_id, first_name, last_name, phone_number, country_code, about) values (100, 100, 'Piotr', 'Nowak', 123123123, 44, 'Jestem Piotrek');
insert into user_details(id, web_user_id, first_name, last_name, phone_number, country_code, about) values (101, 101, 'Jacek', 'Kowalski', 44556655, 48, 'Jestem Jacek');
insert into user_details(id, web_user_id, first_name, last_name, phone_number, country_code, about) values (102, 102, 'Jerzy', 'Jackowski', 66776677, 222, 'Jestem Jurek');
insert into user_details(id, web_user_id, first_name, last_name, phone_number, country_code, about) values (103, 103, 'Jan', 'Piastowski', 88998899, 48, 'Jestem Janek');
insert into user_details(id, web_user_id, first_name, last_name, phone_number, country_code, about) values (104, 104, 'Zbigniew', 'Noga', 09090909, 44, 'Jestem Zbyszek');

--user preferences
insert into user_preferences(id, web_user_id, cooking_together, getting_up_in_the_morning, going_to_bed_late, parties, pets, quiet_roommates) values(100, 100, 'Lubi razem gotowac', 'Wstaje wczesnie', 'Wczesnie kladzie sie spac', 'Lubi imprezy', 'Lubi zwierzeta', 'Lubi glosnych lokatorow');
insert into user_preferences(id, web_user_id, cooking_together, getting_up_in_the_morning, going_to_bed_late, parties, pets, quiet_roommates) values(101, 101, 'Nie lubi razem gotowac', 'Wstaje pozno', 'Pozno kladzie sie spac', 'Lubi imprezy', 'Nie Lubi zwierzet', 'Lubi cichych lokatorow');
insert into user_preferences(id, web_user_id, cooking_together, getting_up_in_the_morning, going_to_bed_late, parties, pets, quiet_roommates) values(102, 102, 'Lubi razem gotowac', 'Wstaje pozno', 'Wczesnie kladzie sie spac', 'Lubi imprezy', 'Nie Lubi zwierzet', 'Lubi glosnych lokatorow');
insert into user_preferences(id, web_user_id, cooking_together, getting_up_in_the_morning, going_to_bed_late, parties, pets, quiet_roommates) values(103, 103, 'Nie lubi razem gotowac', 'Wstaje wczesnie', 'Pozno kladzie sie spac', 'Nie Lubi imprez', 'Lubi zwierzeta', 'Lubi cichych lokatorow');
insert into user_preferences(id, web_user_id, cooking_together, getting_up_in_the_morning, going_to_bed_late, parties, pets, quiet_roommates) values(104, 104, 'Lubi razem gotowac', 'Wstaje pozno', 'Wczesnie kladzie sie spac', 'Nie Lubi imprez', 'Lubi zwierzeta', 'Lubi cichych lokatorow');
