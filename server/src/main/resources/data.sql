INSERT INTO roles(id, role_name)
VALUES (100, 'Administrator'),
       (101, 'Viewer');

INSERT INTO users(id, username, password, role_id, active)
VALUES (100, 'admin', '$2y$10$P8kJ9NPMffFUqiQnhICPfeRwdqOOga2CvSAivnhUhLTshhmXjxjBW', 100, TRUE),
       (101, 'user', '$2y$10$/2.IdCxRrdKmjrMkq..TreB0R/aJKL.8zifT6aD0WuUsaDSDgkX7S', 101, TRUE);

INSERT INTO sensor_types(id, name, unit)
VALUES (200, 'Pressure', 'bar'),
       (201, 'Voltage', 'voltage'),
       (202, 'Temperature', '°C'),
       (203, 'Humidity', '%');

INSERT INTO sensors(id, name, model, sensor_type_id, min_value, max_value, location, description)
VALUES (nextval('sensor_id_sequence'), 'Sensor 1', 'PC33-56', 200, 0, 16, 'Room1', 'This one is very sensitive. Treat with patience.'),
       (nextval('sensor_id_sequence'), 'Sensor 2', 'EH-567', 201, 0, 15, 'Room1', 'Be careful! Do not put into extremely high voltage.'),
       (nextval('sensor_id_sequence'), 'Sensor 3', 'TER-21', 202, -70, 50, 'Room2', 'The most useful one. Huge power.'),
       (nextval('sensor_id_sequence'), 'Sensor 4', 'H94', 203, 0, 100, 'Room3', 'Simple and exact. Make it fast.'),
       (nextval('sensor_id_sequence'), 'Sensor 5', 'GSD-33', 201, 0, 120, 'Room4', 'The old one. Just for fun.'),
       (nextval('sensor_id_sequence'), 'Sensor 6', 'BJK-5', 200, 0, 20, 'Room6', 'Mobile and lightweight. Useful for tests.'),
       (nextval('sensor_id_sequence'), 'Sensor 7', 'EDD-211', 202, -40, 40, 'Room5', 'Slightly complex sensor. Acts a bit unpredictable.'),
       (nextval('sensor_id_sequence'), 'Sensor 8', 'ASS-4', 203, 0, 100, 'Room3', 'The most secure and safe. Very slow.'),
       (nextval('sensor_id_sequence'), 'Sensor 9', 'FEE-7', 201, 0, 240, 'Room7', 'Looks optimized. Intermediate cost/efficiency ratio.'),
       (nextval('sensor_id_sequence'), 'Sensor 10', 'BOR-53', 202, -50, 50, 'Room2', 'The latest version. Not yet tested.'),
       (nextval('sensor_id_sequence'), 'Sensor 11', 'WER-1', 203, 0, 100, 'Room4', 'For personal use only. Big errors at industrial level.'),
       (nextval('sensor_id_sequence'), 'Sensor 12', 'QUU-77', 200, 0, 10, 'Room5', 'Extra small sized. Useful for nanotechnology sphere.');