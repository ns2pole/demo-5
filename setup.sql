drop table users;
CREATE TABLE users
(id INTEGER NOT NULL,
user_name TEXT,
password TEXT NOT NULL,
auth TEXT,
division_id INTEGER
);
INSERT INTO users (id, user_name, password, auth, division_id) VALUES (1, 'user1', '$2a$08$xITTCrREA200KCYTQUHxNeg.rKbJBnaoKuy.eKSgsNiBMsWpjJYf2', 'ROLE_USER', 1);
INSERT INTO users (id, user_name, password, auth, division_id) VALUES (2, 'user2', '$2a$08$TepBrGhgBa5IAw2f7Azf5e4Gp1CfPOJm92acE7JZLBaFAxfroNefS', 'ROLE_USER', 1);
INSERT INTO users (id, user_name, password, auth, division_id) VALUES (3, 'user3', '$2a$08$dxbG77RWJBJoQ7TGGBiKXewqmBSWdnOBF3t.QE6ig57H797IIDnUW', 'ROLE_USER', 2);
INSERT INTO users (id, user_name, password, auth, division_id) VALUES (4, 'admin1', '$2a$08$xITTCrREA200KCYTQUHxNeg.rKbJBnaoKuy.eKSgsNiBMsWpjJYf2', 'ROLE_ADMIN', 1);
INSERT INTO users (id, user_name, password, auth, division_id) VALUES (5, 'admin2', '$2a$08$TepBrGhgBa5IAw2f7Azf5e4Gp1CfPOJm92acE7JZLBaFAxfroNefS', 'ROLE_ADMIN', 2);


drop table attendances;
CREATE TABLE attendances
(id INTEGER NOT NULL,
user_id INTEGER,
work_place_id INTEGER,
date DATE,
begin_time TIME,
end_time TIME, 
rest_start_time TIME,
rest_end_time TIME,

primary key(id));
INSERT INTO attendances (id, user_id, work_place_id, date, begin_time, end_time, rest_start_time, rest_end_time) VALUES (1, 1, 1, '2022-11-11','10:00', '16:00','12:00', '12:45');
INSERT INTO attendances (id, user_id, work_place_id, date, begin_time, end_time, rest_start_time, rest_end_time) VALUES (2, 1, 2, '2022-11-12','10:30', '17:00', '12:00', '12:30');
INSERT INTO attendances (id, user_id, work_place_id, date, begin_time, end_time, rest_start_time, rest_end_time) VALUES (3, 1, 1, '2022-11-13','10:00', '16:00', '12:00', '12:45');
INSERT INTO attendances (id, user_id, work_place_id, date, begin_time, end_time, rest_start_time, rest_end_time) VALUES (4, 1, 1, '2022-11-14','10:30', '17:00', '12:00', '12:30');
INSERT INTO attendances (id, user_id, work_place_id, date, begin_time, end_time, rest_start_time, rest_end_time) VALUES (5, 1, 2, '2022-11-15','11:00', '18:00', '12:00', '12:45');
INSERT INTO attendances (id, user_id, work_place_id, date, begin_time, end_time, rest_start_time, rest_end_time) VALUES (6, 2, 2, '2022-11-11','10:00', '16:00', '12:00', '12:30');
INSERT INTO attendances (id, user_id, work_place_id, date, begin_time, end_time, rest_start_time, rest_end_time) VALUES (7, 2, 2, '2022-11-12','10:30', '17:00', '12:00', '12:45');
INSERT INTO attendances (id, user_id, work_place_id, date, begin_time, end_time, rest_start_time, rest_end_time) VALUES (8, 2, 2, '2022-11-13','10:00', '16:00', '12:00', '12:30');
INSERT INTO attendances (id, user_id, work_place_id, date, begin_time, end_time, rest_start_time, rest_end_time) VALUES (9, 2, 1, '2022-11-14','10:30', '17:00', '12:00', '12:45');
INSERT INTO attendances (id, user_id, work_place_id, date, begin_time, end_time, rest_start_time, rest_end_time) VALUES (10, 2, 2, '2022-11-15','11:00', '18:00', '12:00', '12:30');
INSERT INTO attendances (id, user_id, work_place_id, date, begin_time, end_time, rest_start_time, rest_end_time) VALUES (11, 3, 1, '2022-11-11','10:00', '16:00', '12:00', '12:45');
INSERT INTO attendances (id, user_id, work_place_id, date, begin_time, end_time, rest_start_time, rest_end_time) VALUES (12, 3, 2, '2022-11-12','10:30', '17:00', '12:00', '12:30');
INSERT INTO attendances (id, user_id, work_place_id, date, begin_time, end_time, rest_start_time, rest_end_time) VALUES (13, 3, 1, '2022-11-13','10:00', '16:00', '12:00', '12:45');
INSERT INTO attendances (id, user_id, work_place_id, date, begin_time, end_time, rest_start_time, rest_end_time) VALUES (14, 3, 1, '2022-11-14','10:30', '17:00', '12:00', '12:30');
INSERT INTO attendances (id, user_id, work_place_id, date, begin_time, end_time, rest_start_time, rest_end_time) VALUES (15, 3, 2, '2022-11-15','11:00', '18:00', '12:00', '12:45');
INSERT INTO attendances (id, user_id, work_place_id, date, begin_time, end_time, rest_start_time, rest_end_time) VALUES (16, 4, 2, '2022-11-11','10:00', '16:00', '12:00', '12:30');
INSERT INTO attendances (id, user_id, work_place_id, date, begin_time, end_time, rest_start_time, rest_end_time) VALUES (17, 4, 2, '2022-11-12','10:30', '17:00', '12:00', '12:45');
INSERT INTO attendances (id, user_id, work_place_id, date, begin_time, end_time, rest_start_time, rest_end_time) VALUES (18, 4, 2, '2022-11-13','10:00', '16:00', '12:00', '12:30');
INSERT INTO attendances (id, user_id, work_place_id, date, begin_time, end_time, rest_start_time, rest_end_time) VALUES (19, 4, 1, '2022-11-14','10:30', '17:00', '12:00', '12:45');
INSERT INTO attendances (id, user_id, work_place_id, date, begin_time, end_time, rest_start_time, rest_end_time) VALUES (20, 4, 2, '2022-11-15','11:00', '18:00', '12:00', '12:30');
INSERT INTO attendances (id, user_id, work_place_id, date, begin_time, end_time, rest_start_time, rest_end_time) VALUES (21, 5, 2, '2022-11-11','10:00', '16:00', '12:00', '12:45');
INSERT INTO attendances (id, user_id, work_place_id, date, begin_time, end_time, rest_start_time, rest_end_time) VALUES (22, 5, 2, '2022-11-12','10:30', '17:00', '12:00', '12:30');
INSERT INTO attendances (id, user_id, work_place_id, date, begin_time, end_time, rest_start_time, rest_end_time) VALUES (23, 5, 2, '2022-11-13','10:00', '16:00', '12:00', '12:45');
INSERT INTO attendances (id, user_id, work_place_id, date, begin_time, end_time, rest_start_time, rest_end_time) VALUES (24, 5, 1, '2022-11-14','10:30', '17:00', '12:00', '12:30');
INSERT INTO attendances (id, user_id, work_place_id, date, begin_time, end_time, rest_start_time, rest_end_time) VALUES (25, 5, 2, '2022-11-15','11:00', '18:00', '12:00', '12:45');