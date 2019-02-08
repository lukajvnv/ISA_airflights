insert into users (username, password, enabled,role, activation_id, first_name, last_name, email, city, phone_number) values ('pass1', '$2a$10$YH99cJ7MGjILsbSa3AW4JuHMh8vpFXdk4TpYqQsKn4O5VNnwK3Zty', 1, 'USER', '', 'Luka', 'Jovanovic1', 'lukajvnv@gmail.com', 'Novi Sad', 0644498628);
insert into users (username, password, enabled,role, activation_id, first_name, last_name, email, city, phone_number) values ('pass2', '$2a$10$KRtcMU6ypJ4zIHhKHkSzs.Zi.j7EpC5LAGH.h8iUXYK6pp0t1cq0C', 1, 'USER', '', 'Luka', 'Jovic2', 'lukajvnv@gmail.com', 'Novi Sad', 0644498628);
insert into users (username, password, enabled,role, activation_id, first_name, last_name, email, city, phone_number) values ('pass3', '$2a$10$49.z2JyU/z2Og0PsQt5l2uqN3Z9osIaJIP7cLjVmDvK8Dc/4NnjYe', 1, 'USER', '', 'Marko', 'Jovanovic3', 'lukajvnv@gmail.com', 'Novi Sad', 0644498628);
insert into users (username, password, enabled,role, activation_id, first_name, last_name, email, city, phone_number) values ('pass4', '$2a$10$Qmj2.H0pbha.QUOKQ.SlF.RlOuzo.MQ1DituuTalEfpN0uBr/1nsG', 1, 'USER', '', 'Nenad', 'Hajduk4', 'lukajvnv@gmail.com', 'Novi Sad', 0644498628);
insert into users (username, password, enabled,role, activation_id, first_name, last_name, email, city, phone_number) values ('pass5', '$2a$10$YY4V0oiJ/3oguveYgQi0Bu8AnKIZ6gJwUTI0/q/MCtb//XNwUemBC', 1, 'USER', '', 'Marko', 'Nikolic5', 'lukajvnv@gmail.com', 'Novi Sad', 0644498628);
insert into users (username, password, enabled,role, activation_id, first_name, last_name, email, city, phone_number) values ('pass6', '$2a$10$HJSR3D9o8JvuaRtCQRJt1.zYC1W6Vhdbls9XxP3ZJloJK2x9QUZr2', 1, 'USER', '', 'Damjan', 'Greda6', 'lukajvnv@gmail.com', 'Novi Sad', 0644498628);

insert into users (username, password, enabled,role, activation_id, first_name, last_name, email, city, phone_number) values ('airSerbia', '$2a$10$zpnSrY.yjTb2HnIazS3/q.pS46la3dkj/xZfLCm85W0/6sz7CwHuK', 1, 'ADMIN', '', 'Luka', 'Airline', 'lukajvnv@gmail.com', 'Novi Sad', 0644498628);


insert into airline (address, city, name, description, admin_id) values ('Autoput BG-ZG bb', 'Beograd, Srbija', 'Air Serbia', 'Srpska kompanija lider u jugoistocnoj Evropi po broju ostvarenih letova', 7);
insert into airline (address, city, name, description) values ('Marsala Tita 55', 'Podgorica, Crna Gora', 'Montenegro Airlines', 'Crnogorska medjunarodna avio kompanija');
insert into airline (address, city, name, description) values ('Singapure HV 88', 'Singapur', 'Singapure Airlines', 'U 2018. godini proglasena za najbolju avio kompaniju');
insert into airline (address, city, name, description) values ('Al Matar Street', 'Doha', 'Qatar Airways', 'Katarska avio kompanija');
insert into airline (address, city, name, description, admin_id) values ('Kaiser Fridrih 185', 'Berlin', 'Lufthansa', 'Nemacka kompanija koja posluje u svim krajevima sveta', 7);
insert into airline (address, city, name, description) values ('Cornice Road', 'Dubai', 'Emirates', 'Kompanija iz UAE koja je 2017 bila proglasena za najbolju svetsku kompaniju');
insert into airline (address, city, name, description) values ('Ataturk Blv 199/D', 'Ankara', 'Turkish Airlines', 'Jedna od najvecih avio kompanija nam dolazi iz Turske');
insert into airline (address, city, name, description) values ('Sheremetyeovo airport', 'Moskva, Rusija', 'Aeroflot', 'Ruska najznacajnija medjunarodna kompanija');
insert into airline (address, city, name, description) values ('Dublin airport', 'Dublin, Irska', 'Ryaniar', 'Najznacajnija irska low-cost kompanija');
insert into airline (address, city, name, description) values ('Basel airport', 'Basel, Svajcarska', 'easyJet', 'Najpoznatija svajcarska low-cost kompanija');



insert into destination (code, airport, description, name) values ('BEG', 'Aerodrom Nikola Tesla', 'Prestonica Srbije', 'Beograd');
insert into destination (code, airport, description, name) values ('ZAG', 'Aerodrom Dr Franjo Tudjman', 'Prestonica Hrvatske', 'Zagreb');
insert into destination (code, airport, description, name) values ('IST', 'Aerodrom Kemal Ataturk', 'Grad sa bogatom istorijom. Prestonica nekoliko carstava. Biser Bosfora', 'Istanbul');
insert into destination (code, airport, description, name) values ('IST', 'Aerodrom Sabiha Gokcen', 'Grad sa bogatom istorijom. Prestonica nekoliko carstava. Biser Bosfora', 'Istanbul');
insert into destination (code, airport, description, name) values ('LON', 'Aerodrom Hitrou', 'Jedna od najvecih i istorijski najznacajnijih svetskih metropola', 'London');
insert into destination (code, airport, description, name) values ('LON', 'Aerodrom Gatwick', 'Jedna od najvecih i istorijski najznacajnijih svetskih metropola', 'London');
insert into destination (code, airport, description, name) values ('FRA', 'Aerodrom Frankfurt', 'Zivopisno mesto u centralnoj Nemackoj, ekonomski najrazvijenijoj oblasti u Nemackoj', 'Frankfurt na Majni');
insert into destination (code, airport, description, name) values ('LAX', 'Aerodrom Bel Air', 'Centar zabave i najbogatiji grad na zapadnoj obali SAD', 'Los Angeles');
insert into destination (code, airport, description, name) values ('MIA', 'Aerodrom Miami', 'Najveci grad u najtoplijoj drzavi SAD, Florida', 'Miami');
insert into destination (code, airport, description, name) values ('NYC', 'Aerodrom JFK', 'Grad koji nikad ne spava', 'New York');
insert into destination (code, airport, description, name) values ('BEI', 'Aerodrom Beijing PEK', 'Prestonica najbrze ekonomski rastuce drzave, Kine', 'Peking');
insert into destination (code, airport, description, name) values ('TOK', 'Aerodrom Haneda', 'Glavni grad zemlje izlazeceg Sunca', 'Tokio');
insert into destination (code, airport, description, name) values ('MOW', 'Aerodrom Sheremetyeovo', 'Prestonica ocaravajuce Rusije', 'Moskva');
insert into destination (code, airport, description, name) values ('SHA', 'Aerodrom Pudong', 'Velicanstveni grad na jugoistoku Kine. Ekonomski centar Kine', 'Sangaj');
insert into destination (code, airport, description, name) values ('BER', 'Aerodrom Brandenburg', 'Posetite velicanstveni Berlin u Nemackoj', 'Berlin');

insert into flight_destinations (airline_id, destination_id) values (1, 1);
insert into flight_destinations (airline_id, destination_id) values (1, 2);
insert into flight_destinations (airline_id, destination_id) values (1, 8);
insert into flight_destinations (airline_id, destination_id) values (1, 3);
insert into flight_destinations (airline_id, destination_id) values (3, 5);
insert into flight_destinations (airline_id, destination_id) values (3, 8);
insert into flight_destinations (airline_id, destination_id) values (5, 1);
insert into flight_destinations (airline_id, destination_id) values (5, 3);
insert into flight_destinations (airline_id, destination_id) values (5, 5);
insert into flight_destinations (airline_id, destination_id) values (5, 8);

insert into pricelist (economy, business, first) values (500.30, 600, 800);
insert into pricelist (economy, business, first) values (300, 400, 900);
insert into pricelist (economy, business, first) values (600, 700, 800);
insert into pricelist (economy, business, first) values (800, 900, 1000);


insert into flight (airplane, departure_date, departure_time, arrival_date, arrival_time, duration, number_of_seats, economy_free, business_free, first_free, airline_id, departure_dest, arrival_dest, pricelist_id, add_service, distance, luggage) values 
('Boing 44', '2019-03-06', '14:30:00', '2019-03-07', '02:30:00', 16.50, 20, 20, 0, 0, 5, 8, 1, 2, 'Novine, posluzenje...', 10300, 15);
insert into flight (airplane, departure_date, departure_time, arrival_date, arrival_time, duration, number_of_seats, economy_free, business_free, first_free, airline_id, departure_dest, arrival_dest, pricelist_id, add_service, distance, luggage) values 
('Boing 757', '2019-03-01', '03:30:00', '2019-03-01', '17:30:00', 10.50, 20, 20, 0, 0, 4, 5, 8, 2, 'Novine, posluzenje...', 2000, 15);
insert into flight (airplane, departure_date, departure_time, arrival_date, arrival_time, duration, number_of_seats, economy_free, business_free, first_free, airline_id, departure_dest, arrival_dest, pricelist_id, add_service, distance, luggage) values 
('Atr 757', '2019-03-01', '04:30:00', '2019-03-01', '19:30:00', 10.50, 20, 20, 0, 0, 4, 5, 8, 1, 'Novine, posluzenje...', 2000, 15);
insert into flight (airplane, departure_date, departure_time, arrival_date, arrival_time, duration, number_of_seats, economy_free, business_free, first_free,  airline_id, departure_dest, arrival_dest, pricelist_id, add_service, distance, luggage) values 
('Airbus 757', '2019-03-01', '10:30:00', '2019-03-02', '02:30:00', 20.50, 20, 20, 0, 0, 4, 7, 8, 1, 'Novine, posluzenje...', 3000, 15);
insert into flight (airplane, departure_date, departure_time, arrival_date, arrival_time, duration, number_of_seats, economy_free, business_free, first_free,  airline_id, departure_dest, arrival_dest, pricelist_id, add_service, distance, luggage) values 
('Boing 222', '2019-03-01', '06:45:00', '2019-03-01', '18:30:00', 10.50, 20, 20, 0, 0, 4, 6, 8, 2, 'Novine, posluzenje...', 3600, 15);
insert into flight (airplane, departure_date, departure_time, arrival_date, arrival_time, duration, number_of_seats, economy_free, business_free, first_free,  airline_id, departure_dest, arrival_dest, pricelist_id, add_service, distance, luggage) values 
('Ceasna 44', '2019-02-28', '08:30:00', '2019-02-28', '21:30:00', 16.50, 18, 16, 1, 1, 1, 1, 8, 1, 'Novine, posluzenje...', 10300, 15);
insert into flight (airplane, departure_date, departure_time, arrival_date, arrival_time, duration, number_of_seats, economy_free, business_free, first_free,  airline_id, departure_dest, arrival_dest, pricelist_id, add_service, distance, luggage) values 
('Falcon 44', '2019-02-28', '09:30:00', '2019-02-28', '22:30:00', 15.50, 18, 16, 2, 0, 5, 1, 8, 1, 'Novine, posluzenje...', 10300, 15);
insert into flight (airplane, departure_date, departure_time, arrival_date, arrival_time, duration, number_of_seats, economy_free, business_free, first_free,  airline_id, departure_dest, arrival_dest, pricelist_id, add_service, distance, luggage) values 
('Falcon 44', '2019-03-06', '06:30:00', '2019-03-06', '18:30:00', 14.50, 11, 11, 0, 0, 5, 8, 1, 1, 'Novine, posluzenje...', 10300, 15);
insert into flight (airplane, departure_date, departure_time, arrival_date, arrival_time, duration, number_of_seats, economy_free, business_free, first_free,  airline_id, departure_dest, arrival_dest, pricelist_id, add_service, distance, luggage) values 
('Falcon 44', '2019-03-06', '07:30:00', '2019-03-06', '22:30:00', 16.50, 18, 16, 1, 1, 1, 8, 1, 3, 'Novine, posluzenje...', 10300, 15);


insert into flight_stops (flight_id, stop_id) values (1, 7);
insert into flight_stops (flight_id, stop_id) values (1, 9);
insert into flight_stops (flight_id, stop_id) values (2, 7);

--insert into authority (id, name) values (1, 'USER');
--
--insert into user_authority(user_id, authority_id) values (1, 1);
--insert into user_authority(user_id, authority_id) values (2, 1);
--insert into user_authority(user_id, authority_id) values (3, 1);
--insert into user_authority(user_id, authority_id) values (4, 1);
--insert into user_authority(user_id, authority_id) values (5, 1);
--insert into user_authority(user_id, authority_id) values (6, 1);

insert into seat (discount_ticket, reserved, seat_number, flight_id) values (0, 1, 5, 8);
insert into seat (discount_ticket, reserved, seat_number, flight_id) values (0, 0, 1, 8);
insert into seat (discount_ticket, reserved, seat_number, flight_id) values (0, 0, 4, 8);
insert into seat (discount_ticket, reserved, seat_number, flight_id) values (0, 0, 3, 8);
insert into seat (discount_ticket, reserved, seat_number, flight_id) values (0, 1, 2, 8);
insert into seat (discount_ticket, reserved, seat_number, flight_id) values (0, 1, 6, 8);
insert into seat (discount_ticket, reserved, seat_number, flight_id) values (0, 1, 7, 8);
insert into seat (discount_ticket, reserved, seat_number, flight_id) values (0, 0, 8, 8);
insert into seat (discount_ticket, reserved, seat_number, flight_id) values (0, 0, 9, 8);
insert into seat (discount_ticket, reserved, seat_number, flight_id) values (0, 0, 10, 8);
insert into seat (discount_ticket, reserved, seat_number, flight_id) values (0, 1, 11, 8);
insert into seat (discount_ticket, reserved, seat_number, flight_id) values (0, 0, 12, 8);
insert into seat (discount_ticket, reserved, seat_number, flight_id) values (0, 0, 13, 8);
insert into seat (discount_ticket, reserved, seat_number, flight_id) values (0, 1, 14, 8);
insert into seat (discount_ticket, reserved, seat_number, flight_id) values (0, 0, 15, 8);
insert into seat (discount_ticket, reserved, seat_number, flight_id) values (0, 0, 16, 8);
insert into seat (discount_ticket, reserved, seat_number, flight_id) values (0, 1, 17, 8);


insert into friendship (inviter_id, accepter_id, established) values (4, 5, 0);
insert into friendship (inviter_id, accepter_id, established) values (1, 4, 1);
insert into friendship (inviter_id, accepter_id, established) values (1, 5, 1);
insert into friendship (inviter_id, accepter_id, established) values (1, 6, 1);
insert into friendship (inviter_id, accepter_id, established) values (1, 2, 0);
insert into friendship (inviter_id, accepter_id, established) values (3, 2, 1);
insert into friendship (inviter_id, accepter_id, established) values (4, 1, 1);
insert into friendship (inviter_id, accepter_id, established) values (5, 1, 1);
insert into friendship (inviter_id, accepter_id, established) values (6, 1, 1);
insert into friendship (inviter_id, accepter_id, established) values (2, 3, 1);

insert into ticket (flight_id, seat_id, class, status, base_price, discount, selling_price, marked_flight, selling_date) values (8, 1, 0, 1, 500.3, 0, 500.3, 0, '2019-02-06');
insert into ticket (flight_id, seat_id, class, status, base_price, discount, selling_price, marked_flight, selling_date) values (8, 5, 0, 2, 600.3, 0, 500.3, 0, '2019-02-06');
insert into ticket (flight_id, seat_id, class, status, base_price, discount, selling_price, marked_flight, selling_date) values (8, 6, 0, 2, 500.3, 0, 500.3, 0, '2019-02-09');
insert into ticket (flight_id, seat_id, class, status, base_price, discount, selling_price, marked_flight, selling_date) values (8, 7, 0, 1, 800.3, 10, 720.3, 0, '2019-02-04');
insert into ticket (flight_id, seat_id, class, status, base_price, discount, selling_price, marked_flight, airline_id) values (8, 11, 0, 2, 800.3, 10, 720.3, 0, 5);
insert into ticket (flight_id, seat_id, class, status, base_price, discount, selling_price, marked_flight, airline_id) values (8, 14, 0, 2, 600.3, 10, 540.3, 0, 5);
insert into ticket (flight_id, seat_id, class, status, base_price, discount, selling_price, marked_flight, airline_id) values (8, 17, 0, 2, 700.3, 15, 675.3, 0, 5);

insert into reservation (passport_num , ticket_id, user_id) values ('452876896', 1, 1);
insert into reservation (passport_num , ticket_id, user_id) values ('452876896', 2, 1);
insert into reservation (passport_num , ticket_id, user_id) values ('369743355', 3, 2);
insert into reservation (passport_num , ticket_id, user_id) values ('452876896', 4, 1);

insert into airline_rating (user_id, airline_id, rating) values (1, 5, 2);
insert into airline_rating (user_id, airline_id, rating) values (2, 5, 5);
insert into airline_rating (user_id, airline_id, rating) values (3, 5, 4);
insert into airline_rating (user_id, airline_id, rating) values (4, 4, 2);
insert into airline_rating (user_id, airline_id, rating) values (5, 5, 3);

insert into flight_rating (user_id, flight_id, rating) values (1, 8, 2);
insert into flight_rating (user_id, flight_id, rating) values (2, 8, 3);
insert into flight_rating (user_id, flight_id, rating) values (3, 8, 4);
insert into flight_rating (user_id, flight_id, rating) values (4, 8, 4);
insert into flight_rating (user_id, flight_id, rating) values (1, 7, 2);
insert into flight_rating (user_id, flight_id, rating) values (5, 8, 5);

------------
insert into car_reservation (car_reservation_id, car_id, dropof_date, pickup_date, username) values (1, 1, '2019-02-10','2019-02-09', 'pass1');
insert into car_reservation (car_reservation_id, car_id, dropof_date, pickup_date, username) values (2, 2, '2019-02-17','2019-02-15', 'pass1');

insert into rentacar (rentacar_name, rentacar_adress, rentacar_description) values ('Nevian Rent a Car','Banjsak 14, Beograd','NEVIAN rent a car Beograd je kompanija iz Beograda, osnovana 2017. godine. Cilj nam je da vrhunskom uslugom i povoljnim cenama zadovoljimo potrebe naših korisnika.');
insert into rentacar (rentacar_name, rentacar_adress, rentacar_description) values ('AAA 1 Rent','Zorza Klemansoa 19, Beograd','Bez opisa');
insert into rentacar (rentacar_name, rentacar_adress, rentacar_description) values ('Abakus Rent Rent a Car','Vidovdanska 11, Beograd','Najpovoljniji Rentacar u Beogradu i na Aerodromu Nikola Tesla.Besplatna dostava u Beogradu i odlicni uslovi iznajmljivanja vozila.');
insert into rentacar (rentacar_name, rentacar_adress, rentacar_description) values ('Dollar Rent-a-Car UAE','Arenco Building, Zabeel Road, Dubai','Dollar rentacar ima filijale na preko 640 svetskih lokacija u 53 zemlje, sa preko 200 hiljada vozila');
insert into rentacar (rentacar_name, rentacar_adress, rentacar_description) values ('Hertz Rentacar','Berlin-Charlottenburg, Kaiserdamm 25a, Berlin','Jedna od vodecih rentacar kompanija u Berlinu');
insert into rentacar (rentacar_name, rentacar_adress, rentacar_description) values ('Avis Rent A Car','Komsomolskaya Square 3, Moskva','Najpopularnija rentacar kompanija u moskvi');

insert into renta_branch (branch_name, branch_location, rentacar_rentacar_id) values ('Nevian', 'Beograd aerodrom', 1);
insert into renta_branch (branch_name, branch_location, rentacar_rentacar_id) values ('Nevian', 'Beograd centar', 1);
insert into renta_branch (branch_name, branch_location, rentacar_rentacar_id) values ('AAA 1', 'Novi Beograd', 2);
insert into renta_branch (branch_name, branch_location, rentacar_rentacar_id) values ('Dollar', 'ABU DHABI AIRPORT TERMINAL 3', 3);
insert into renta_branch (branch_name, branch_location, rentacar_rentacar_id) values ('Dollar', 'CROWNE PLAZA - YAS ISLAND', 3);
insert into renta_branch (branch_name, branch_location, rentacar_rentacar_id) values ('Dollar', 'DOLLAR HEAD OFFICE MUSSAFAH, ABU DHABI', 3);
insert into renta_branch (branch_name, branch_location, rentacar_rentacar_id) values ('Hertz', 'Berlin', 4);
insert into renta_branch (branch_name, branch_location, rentacar_rentacar_id) values ('Hertz', 'Basel', 4);
insert into renta_branch (branch_name, branch_location, rentacar_rentacar_id) values ('Hertz', 'Dublin', 4);
insert into renta_branch (branch_name, branch_location, rentacar_rentacar_id) values ('AVIS', 'Los Andjeles', 5);
insert into renta_branch (branch_name, branch_location, rentacar_rentacar_id) values ('AVIS', 'London', 5);
insert into renta_branch (branch_name, branch_location, rentacar_rentacar_id) values ('AVIS', 'Frankfurt', 5);

insert into car (car_brand, car_model, car_name, car_year, number_of_seats, price, dropof_date, pickup_date, dropof_location, pickup_location, rentacar_rentacar_id, tip, version) values ('Mercedes','C180','Mercedes',2002,5,100.0, '2019-02-05', '2019-02-06','lok1','lok2', 1, 'Karavan', 1);
insert into car (car_brand, car_model, car_name, car_year, number_of_seats, price, dropof_date, pickup_date, dropof_location, pickup_location, rentacar_rentacar_id, tip, version) values ('Mercedes','W213','Mercedes',2017,5,220.0,'1111-11-11','1111-11-11','lok1','lok2', 2, 'Karavan', 1);
insert into car (car_brand, car_model, car_name, car_year, number_of_seats, price, dropof_date, pickup_date, dropof_location, pickup_location, rentacar_rentacar_id, tip, version) values ('BMW','Serije 3','BMW',2017,5,200.0,'1111-11-11','1111-11-11','lok1','lok2', 3, 'Kombi', 1);
insert into car (car_brand, car_model, car_name, car_year, number_of_seats, price, dropof_date, pickup_date, dropof_location, pickup_location, rentacar_rentacar_id, tip, version) values ('BMW','M140i','BMW',2015,5,190.0,'1111-11-11','1111-11-11','lok1','lok2', 1, 'Kombi', 1);
insert into car (car_brand, car_model, car_name, car_year, number_of_seats, price, dropof_date, pickup_date, dropof_location, pickup_location, rentacar_rentacar_id, tip, version) values ('AUDI','Q2','Mercedes',2012,5,120.0,'1111-11-11','1111-11-11','lok1','lok2', 2, 'Kombi', 1);
insert into car (car_brand, car_model, car_name, car_year, number_of_seats, price, dropof_date, pickup_date, dropof_location, pickup_location, rentacar_rentacar_id, tip, version) values ('AUDI','A6','Audi',2006,5,100.0,'1111-11-11','1111-11-11','lok1','lok2', 3, 'Karavan', 1);
insert into car (car_brand, car_model, car_name, car_year, number_of_seats, price, dropof_date, pickup_date, dropof_location, pickup_location, rentacar_rentacar_id, tip, version) values ('FIAT','500','Fica',2016,5,180.0,'1111-11-11','1111-11-11','lok1','lok2', 1, 'Karavan', 1);
insert into car (car_brand, car_model, car_name, car_year, number_of_seats, price, dropof_date, pickup_date, dropof_location, pickup_location, rentacar_rentacar_id, tip, version) values ('FIAT','Punto','Fiat',2005,4,80.0,'1111-11-11','1111-11-11','lok1','lok2',2, 'Kupe', 1);
insert into car (car_brand, car_model, car_name, car_year, number_of_seats, price, dropof_date, pickup_date, dropof_location, pickup_location, rentacar_rentacar_id, tip, version) values ('PEUGEOT','308','PEUGEOT',2007,5,110.0,'1111-11-11','1111-11-11','lok1','lok2', 3, 'Karavan', 1);
insert into car (car_brand, car_model, car_name, car_year, number_of_seats, price, dropof_date, pickup_date, dropof_location, pickup_location, rentacar_rentacar_id, tip, version) values ('PEUGEOT','307','PEUGEOT',2010,5,150.0,'1111-11-11','1111-11-11','lok1','lok2', 4, 'Kupe', 1);
insert into car (car_brand, car_model, car_name, car_year, number_of_seats, price, dropof_date, pickup_date, dropof_location, pickup_location, rentacar_rentacar_id, tip, version) values ('Zastava','55','Yugo',1985,4,20.0,'1111-11-11','1111-11-11','lok1','lok2', 4, 'Karavan', 1);
