USE restaurant_db;

INSERT INTO users (username, password, email, first_name, last_name, phone) values("fer", "pass", "fernando@codeup.com", "Fernando", "Mendoza", "2101234567");
INSERT INTO users (username, password, email, first_name, last_name, phone) values("luis", "pass", "luis@codeup.com", "Luis", "Montealegre", "2101234568");
INSERT INTO users (username, password, email, first_name, last_name, phone) values("zach", "pass", "zach@codeup.com", "Zach", "Gulde", "2101234569");

INSERT INTO reservations (num_people, date, time, user_id) VALUES (2, curdate(), curtime(), 1);
INSERT INTO reservations (num_people, date, time, user_id) VALUES (4, adddate(curdate(), 5), curtime(), 2);
INSERT INTO reservations (num_people, date, time, user_id) VALUES (3, adddate(current_date(), 10), curtime(), 3);
INSERT INTO reservations (num_people, date, time, user_id) VALUES (8, adddate(current_date(), 10), curtime(), 1);