USE restaurant_db;

INSERT INTO users (username, password, email, firstName, lastName, phone) values('fer', '$2a$12$y1PuMP6jM189HfGcMgvPPeykOzJnPMtuhYphFx3oWB.KgCzNo47Su', 'fernando@codeup.com', 'Fernando', 'Mendoza', '2101234567');
INSERT INTO users (username, password, email, firstName, lastName, phone) values('luis', '$2a$12$y1PuMP6jM189HfGcMgvPPeykOzJnPMtuhYphFx3oWB.KgCzNo47Su', 'luis@codeup.com', 'Luis', 'Montealegre', '2101234568');
INSERT INTO users (username, password, email, firstName, lastName, phone) values('zach', '$2a$12$y1PuMP6jM189HfGcMgvPPeykOzJnPMtuhYphFx3oWB.KgCzNo47Su', 'zach@codeup.com', 'Zach', 'Gulde', '2101234569');

INSERT INTO reservations (num_people, date, time, user_id) VALUES (2, curdate(), curtime(), 1);
INSERT INTO reservations (num_people, date, time, user_id) VALUES (4, adddate(curdate(), 5), curtime(), 2);
INSERT INTO reservations (num_people, date, time, user_id) VALUES (3, adddate(current_date(), 10), curtime(), 3);
INSERT INTO reservations (num_people, date, time, user_id) VALUES (8, adddate(current_date(), 10), curtime(), 1);

INSERT INTO items (name, price, url) VALUES ('Pozole', 7.99, 'pozole.jpg');
INSERT INTO items (name, price, url) VALUES ('Pastor tacos', 5.99, 'pastor.jpg');
INSERT INTO items (name, price, url) VALUES ('Enchiladas', 9.99, 'michoacanas.jpg');
INSERT INTO items (name, price, url) VALUES ('Sopa Azteca', 6.99, 'sopa.jpg');