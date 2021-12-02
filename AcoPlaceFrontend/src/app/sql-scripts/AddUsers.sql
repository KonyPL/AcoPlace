--user table
insert into web_user(id,email,password,verified) values(100,'piotr1@wp.pl','1234','true');
insert into web_user(id,email,password,verified) values(101,'mirek@wp.pl','4321','false'); --false 
insert into web_user(id,email,password,verified) values(102,'jurek@wp.pl','1221','true');
insert into web_user(id,email,password,verified) values(103,'wiesiek@wp.pl','5555','true');
insert into web_user(id,email,password,verified) values(104,'zbyszek@wp.pl','7890','true');

--user details
insert into user_details(user_id, first_name, last_name, phone_number, country_code, about) values (100, "Piotr", "Piotrowy", 123123123, 44, "Jestem Piotrek");
insert into user_details(user_id, first_name, last_name, phone_number, country_code, about) values (101, "Mirek", "Mirkowy", 44556655, 1, "Jestem Mirek");
insert into user_details(user_id, first_name, last_name, phone_number, country_code, about) values (102, "Jurek", "Jurkowy", 66776677, 222, "Jestem Jurek");
insert into user_details(user_id, first_name, last_name, phone_number, country_code, about) values (103, "Wiesiek", "Wieskowy", 88998899, 31, "Jestem Wiesiek");
insert into user_details(user_id, first_name, last_name, phone_number, country_code, about) values (104, "Zbyszek", "Zbyszkowy", 09090909, 44, "Jestem Zbyszek");

--user preferences
insert into user_preferences(user_id, pets, ) values(); -- to be done