USE restaurant_db;

INSERT INTO users (username, password, email, firstName, lastName, phone) values('fer', '$2a$12$y1PuMP6jM189HfGcMgvPPeykOzJnPMtuhYphFx3oWB.KgCzNo47Su', 'fernando@codeup.com', 'Fernando', 'Mendoza', '2101234567');
INSERT INTO users (username, password, email, firstName, lastName, phone) values('luis', '$2a$12$y1PuMP6jM189HfGcMgvPPeykOzJnPMtuhYphFx3oWB.KgCzNo47Su', 'luis@codeup.com', 'Luis', 'Montealegre', '2101234568');
INSERT INTO users (username, password, email, firstName, lastName, phone) values('zach', '$2a$12$y1PuMP6jM189HfGcMgvPPeykOzJnPMtuhYphFx3oWB.KgCzNo47Su', 'zach@codeup.com', 'Zach', 'Gulde', '2101234569');

INSERT INTO reservations (num_people, date, time, user_id) VALUES (2, curdate(), curtime(), 1);
INSERT INTO reservations (num_people, date, time, user_id) VALUES (4, adddate(curdate(), 5), curtime(), 2);
INSERT INTO reservations (num_people, date, time, user_id) VALUES (3, adddate(current_date(), 10), curtime(), 3);
INSERT INTO reservations (num_people, date, time, user_id) VALUES (8, adddate(current_date(), 10), curtime(), 1);

INSERT INTO items (name, price, url, description) VALUES ('Pozole', 8, 'pozole.jpg', 'Pozole which means "hominy", is a traditional soup or stew from Mexico');
INSERT INTO items (name, price, url, description) VALUES ('Pastor tacos', 6, 'pastor.jpg', 'A dish developed in Central Mexico that is based on shawarma spit-grilled meat brought by mainly Christian Lebanese immigrants to Mexico');
INSERT INTO items (name, price, url, description) VALUES ('Enchiladas', 10, 'michoacanas.jpg', 'A corn tortilla rolled around a filling and covered with a chili pepper sauce. Enchiladas can be filled with a variety of ingredients, including various meats, cheese, beans, potatoes, vegetables or combinations.');
INSERT INTO items (name, price, url, description) VALUES ('Sopa Azteca', 7, 'sopa.jpg', 'A traditional Mexican soup made of fried corn tortilla pieces, submerged into a broth of tomato, garlic, onion, and chile de árbol and epazote');