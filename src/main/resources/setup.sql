drop table users;
CREATE TABLE users
(id INTEGER NOT NULL,
name TEXT,
password TEXT NOT NULL,
role TEXT,
division_id INTEGER
);
INSERT INTO users (id, name, password, role, division_id) VALUES (1, 'user1', '$2a$08$xITTCrREA200KCYTQUHxNeg.rKbJBnaoKuy.eKSgsNiBMsWpjJYf2', 'ROLE_USER', 1);
INSERT INTO users (id, name, password, role, division_id) VALUES (2, 'user2', '$2a$08$TepBrGhgBa5IAw2f7Azf5e4Gp1CfPOJm92acE7JZLBaFAxfroNefS', 'ROLE_USER', 1);
INSERT INTO users (id, name, password, role, division_id) VALUES (3, 'user3', '$2a$08$dxbG77RWJBJoQ7TGGBiKXewqmBSWdnOBF3t.QE6ig57H797IIDnUW', 'ROLE_USER', 2);
INSERT INTO users (id, name, password, role, division_id) VALUES (4, 'admin1', '$2a$08$xITTCrREA200KCYTQUHxNeg.rKbJBnaoKuy.eKSgsNiBMsWpjJYf2', 'ROLE_ADMIN', 1);
INSERT INTO users (id, name, password, role, division_id) VALUES (5, 'admin2', '$2a$08$TepBrGhgBa5IAw2f7Azf5e4Gp1CfPOJm92acE7JZLBaFAxfroNefS', 'ROLE_ADMIN', 2);


drop table attendances;
CREATE TABLE attendances
(id INTEGER NOT NULL,
begin_time TIME,
end_time TIME,
    primary key(id));

INSERT INTO attendances (id, user_id, work_place_id, rest_status, working_status, date, begin_time, end_time, rest_start_time, rest_end_time) VALUES (1, 1, 0, 1, 0, '2022-11-11','10:00', '16:00','12:00', '12:45');
INSERT INTO attendances (id, user_id, work_place_id, rest_status, working_status, date, begin_time, end_time, rest_start_time, rest_end_time) VALUES (2, 1, 1, 1, 0, '2022-11-12','10:30', '17:00', '12:00', '12:30');
INSERT INTO attendances (id, user_id, work_place_id, rest_status, working_status, date, begin_time, end_time, rest_start_time, rest_end_time) VALUES (3, 1, 1, 1, 0, '2022-11-13','10:00', '16:00', '12:00', '12:45');
INSERT INTO attendances (id, user_id, work_place_id, rest_status, working_status, date, begin_time, end_time, rest_start_time, rest_end_time) VALUES (4, 1, 0, 1, 0, '2022-11-14','10:30', '17:00', '12:00', '12:30');
INSERT INTO attendances (id, user_id, work_place_id, rest_status, working_status, date, begin_time, end_time, rest_start_time, rest_end_time) VALUES (5, 1, 1, 1, 0, '2022-11-15','11:00', '18:00', '12:00', '12:45');
INSERT INTO attendances (id, user_id, work_place_id, rest_status, working_status, date, begin_time, end_time, rest_start_time, rest_end_time) VALUES (6, 2, 1, 1, 0, '2022-11-11','10:00', '16:00', '12:00', '12:30');
INSERT INTO attendances (id, user_id, work_place_id, rest_status, working_status, date, begin_time, end_time, rest_start_time, rest_end_time) VALUES (7, 2, 1, 1, 0, '2022-11-12','10:30', '17:00', '12:00', '12:45');
INSERT INTO attendances (id, user_id, work_place_id, rest_status, working_status, date, begin_time, end_time, rest_start_time, rest_end_time) VALUES (8, 2, 1, 1, 0, '2022-11-13','10:00', '16:00', '12:00', '12:30');
INSERT INTO attendances (id, user_id, work_place_id, rest_status, working_status, date, begin_time, end_time, rest_start_time, rest_end_time) VALUES (9, 2, 0, 1, 0, '2022-11-14','10:30', '17:00', '12:00', '12:45');
INSERT INTO attendances (id, user_id, work_place_id, rest_status, working_status, date, begin_time, end_time, rest_start_time, rest_end_time) VALUES (10, 2, 1, 1, 0, '2022-11-15','11:00', '18:00', '12:00', '12:30');
INSERT INTO attendances (id, user_id, work_place_id, rest_status, working_status, date, begin_time, end_time, rest_start_time, rest_end_time) VALUES (11, 3, 0, 1, 0, '2022-11-11','10:00', '16:00', '12:00', '12:45');
INSERT INTO attendances (id, user_id, work_place_id, rest_status, working_status, date, begin_time, end_time, rest_start_time, rest_end_time) VALUES (12, 3, 1, 1, 0, '2022-11-12','10:30', '17:00', '12:00', '12:30');
INSERT INTO attendances (id, user_id, work_place_id, rest_status, working_status, date, begin_time, end_time, rest_start_time, rest_end_time) VALUES (13, 3, 0, 1, 0, '2022-11-13','10:00', '16:00', '12:00', '12:45');
INSERT INTO attendances (id, user_id, work_place_id, rest_status, working_status, date, begin_time, end_time, rest_start_time, rest_end_time) VALUES (14, 3, 0, 1, 0, '2022-11-14','10:30', '17:00', '12:00', '12:30');
INSERT INTO attendances (id, user_id, work_place_id, rest_status, working_status, date, begin_time, end_time, rest_start_time, rest_end_time) VALUES (15, 3, 1, 1, 0, '2022-11-15','11:00', '18:00', '12:00', '12:45');
INSERT INTO attendances (id, user_id, work_place_id, rest_status, working_status, date, begin_time, end_time, rest_start_time, rest_end_time) VALUES (16, 4, 1, 1, 0, '2022-11-11','10:00', '16:00', '12:00', '12:30');
INSERT INTO attendances (id, user_id, work_place_id, rest_status, working_status, date, begin_time, end_time, rest_start_time, rest_end_time) VALUES (17, 4, 1, 1, 0, '2022-11-12','10:30', '17:00', '12:00', '12:45');
INSERT INTO attendances (id, user_id, work_place_id, rest_status, working_status, date, begin_time, end_time, rest_start_time, rest_end_time) VALUES (18, 4, 1, 1, 0, '2022-11-13','10:00', '16:00', '12:00', '12:30');
INSERT INTO attendances (id, user_id, work_place_id, rest_status, working_status, date, begin_time, end_time, rest_start_time, rest_end_time) VALUES (19, 4, 0, 1, 0, '2022-11-14','10:30', '17:00', '12:00', '12:45');
INSERT INTO attendances (id, user_id, work_place_id, rest_status, working_status, date, begin_time, end_time, rest_start_time, rest_end_time) VALUES (20, 4, 0, 1, 0, '2022-11-15','11:00', '18:00', '12:00', '12:30');
INSERT INTO attendances (id, user_id, work_place_id, rest_status, working_status, date, begin_time, end_time, rest_start_time, rest_end_time) VALUES (21, 5, 1, 1, 0, '2022-11-11','10:00', '16:00', '12:00', '12:45');
INSERT INTO attendances (id, user_id, work_place_id, rest_status, working_status, date, begin_time, end_time, rest_start_time, rest_end_time) VALUES (22, 5, 1, 1, 0, '2022-11-12','10:30', '17:00', '12:00', '12:30');
INSERT INTO attendances (id, user_id, work_place_id, rest_status, working_status, date, begin_time, end_time, rest_start_time, rest_end_time) VALUES (23, 5, 1, 1, 0, '2022-11-13','10:00', '16:00', '12:00', '12:45');
INSERT INTO attendances (id, user_id, work_place_id, rest_status, working_status, date, begin_time, end_time, rest_start_time, rest_end_time) VALUES (24, 5, 0, 1, 0, '2022-11-14','10:30', '17:00', '12:00', '12:30');
INSERT INTO attendances (id, user_id, work_place_id, rest_status, working_status, date, begin_time, end_time, rest_start_time, rest_end_time) VALUES (25, 5, 1, 1, 0, '2022-11-15','11:00', '18:00', '12:00', '12:45');


drop table divisions;
CREATE TABLE divisions
(id INTEGER NOT NULL,
name TEXT,
primary key(id));

INSERT INTO divisions (id, name) VALUES (1, '営業部');
INSERT INTO divisions (id, name) VALUES (2, '経理部');
INSERT INTO divisions (id, name) VALUES (3, '人事部');

drop table contact_addresses;
CREATE TABLE contact_addresses
(
id INTEGER NOT NULL,
user_id INTEGER NOT NULL,
phone CHARACTER(11),
email TEXT,
primary key(id));

INSERT INTO contact_addresses (id, user_id, phone, email) VALUES (1, 2, '09000000', 'spacer2@gmail.com');
INSERT INTO contact_addresses (id, user_id, phone, email) VALUES (2, 1, '09087654321', 'spaceofstar2@gmail.com');
INSERT INTO contact_addresses (id, user_id, phone, email) VALUES (3, 4, '0593876553', 'spac1eofstar2@gmail.com');
INSERT INTO contact_addresses (id, user_id, phone, email) VALUES (4, 3, '87654321', 'spaceofstar2@gmail.com');
INSERT INTO contact_addresses (id, user_id, phone, email) VALUES (5, 5, '0593876553', 'spaceofstar2@gmail.com');
