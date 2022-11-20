INSERT INTO roles(id, role_name)
VALUES (1, 'Administrator'),
       (2, 'Viewer');

INSERT INTO users(id, username, password, role_id)
VALUES
(1, 'admin', '3094042D4F193AE1B73F33E504BBCE2018E75993131F9C94FF3BCD29F3183F74',
    (SELECT id FROM roles WHERE role_name = 'Administrator')
),
(2, 'user', '081805BDA105816CE893EB730A7ED3030FC3DA71D7263B6BACF4205B46F4F66F',
    (SELECT id FROM roles WHERE role_name = 'Viewer')
);

-- INSERT INTO sensors(id, name, model, type, min_value, max_value, unit, location)
-- VALUES (1, 'Sensor 1', 'PC33-56', 'pressure', 0, 16, 'bar', 'room1'),
--        (2, 'Sensor 2', 'EH-567', 'voltage', 0, 15, 'volt', 'room1'),
--        (3, 'Sensor 3', 'TER-21', 'temperature', -70, 50, 'celsius', 'room2'),
--        (4, 'Sensor 4', 'H94', 'humidity', 0, 100, 'percent', 'room3'),
--        (5, 'Sensor 5', 'GSD-33', 'voltage', 0, 120, 'volt', 'room4'),
--        (6, 'Sensor 6', 'BJK-5', 'pressure', 0, 20, 'bar', 'room6'),
--        (7, 'Sensor 7', 'EDD-211', 'temperature', -40, 40, 'celsius', 'room5'),
--        (8, 'Sensor 8', 'ASS-4', 'humidity', 0, 100, 'percent', 'room3'),
--        (9, 'Sensor 9', 'FEE-7', 'voltage', 0, 240, 'volt', 'room7'),
--        (10, 'Sensor 10', 'BOR-53', 'temperature', -50, 50, 'celsius', 'room2'),
--        (11, 'Sensor 11', 'WER-1', 'humidity', 0, 100, 'percent', 'room4'),
--        (12, 'Sensor 12', 'QUU-77', 'pressure', 0, 10, 'bar', 'room5');