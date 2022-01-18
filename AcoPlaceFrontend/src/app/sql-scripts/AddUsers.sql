--user table
insert into web_user(id, user_name, email, password, active, roles) values(100,'piotr1','piotr1@wp.pl','1234','true','USER');
insert into web_user(id, user_name, email, password, active, roles) values(101,'admin1','piotradmin1@wp.pl','1234','true','USER,ADMIN');
insert into web_user(id, user_name, email, password, active, roles) values(102,'user1','user@onet.pl','1234','true','USER');
insert into web_user(id, user_name, email, password, active, roles) values(103,'onlyadmin','onlyadmin@gmail.pl','1234','true','ADMIN');
insert into web_user(id, user_name, email, password, active, roles) values(104,'marcin1','marcin1@o2.pl','1234','true','USER,ADMIN');

--user details
insert into user_details(id, web_user_id, first_name, last_name, phone_number, country_code, about) values (100, 100, 'Piotr', 'Piotrowy', 123123123, 44, 'Jestem Piotrek');
insert into user_details(id, web_user_id, first_name, last_name, phone_number, country_code, about) values (101, 101, 'Mirek', 'Mirkowy', 44556655, 1, 'Jestem Mirek');
insert into user_details(id, web_user_id, first_name, last_name, phone_number, country_code, about) values (102, 102, 'Jurek', 'Jurkowy', 66776677, 222, 'Jestem Jurek');
insert into user_details(id, web_user_id, first_name, last_name, phone_number, country_code, about) values (103, 103, 'Wiesiek', 'Wieskowy', 88998899, 31, 'Jestem Wiesiek');
insert into user_details(id, web_user_id, first_name, last_name, phone_number, country_code, about) values (104, 104, 'Zbyszek', 'Zbyszkowy', 09090909, 44, 'Jestem Zbyszek');

--user preferences
insert into user_preferences(id, web_user_id, cooking_together, getting_up_in_the_morning, going_to_bed_late, parties, pets, quiet_roommates) values(100, 100, 'lubi razem gotowac', 'wstaje wczesnie', 'wczesnie kladzie sie spac', 'lubi imprezy', 'lubi zwierzeta', 'lubi glosnych lokatorow');
insert into user_preferences(id, web_user_id, cooking_together, getting_up_in_the_morning, going_to_bed_late, parties, pets, quiet_roommates) values(101, 101, 'nie lubi razem gotowac', 'wstaje pozno', 'pozno kladzie sie spac', 'lubi imprezy', 'nie lubi zwierzet', 'lubi cichych lokatorow');
insert into user_preferences(id, web_user_id, cooking_together, getting_up_in_the_morning, going_to_bed_late, parties, pets, quiet_roommates) values(102, 102, 'lubi razem gotowac', 'wstaje pozno', 'wczesnie kladzie sie spac', 'lubi imprezy', 'nie lubi zwierzet', 'lubi glosnych lokatorow');
insert into user_preferences(id, web_user_id, cooking_together, getting_up_in_the_morning, going_to_bed_late, parties, pets, quiet_roommates) values(103, 103, 'nie lubi razem gotowac', 'wstaje wczesnie', 'pozno kladzie sie spac', 'nie lubi imprez', 'lubi zwierzeta', 'lubi cichych lokatorow');
insert into user_preferences(id, web_user_id, cooking_together, getting_up_in_the_morning, going_to_bed_late, parties, pets, quiet_roommates) values(104, 104, 'lubi razem gotowac', 'wstaje pozno', 'wczesnie kladzie sie spac', 'nie lubi imprez', 'lubi zwierzeta', 'lubi cichych lokatorow');
