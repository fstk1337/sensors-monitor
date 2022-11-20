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

INSERT INTO locations(id, location_name)
VALUES (1, 'Room1'),
       (2, 'Room2'),
       (3, 'Room3'),
       (4, 'Room4'),
       (5, 'Room5'),
       (6, 'Room6'),
       (7, 'Room7');

INSERT INTO models(id, model_name, type, min_value, max_value)
VALUES (1, 'PC33-56', 'pressure', 0, 16),
       (2, 'EH-567', 'voltage', 0, 15),
       (3, 'TER-21', 'temperature', -70, 50),
       (4, 'H94', 'humidity', 0, 100),
       (5, 'GSD-33', 'voltage', 0, 120),
       (6, 'BJK-5', 'pressure', 0, 20),
       (7, 'EDD-211', 'temperature', -40, 40),
       (8, 'ASS-4', 'humidity', 0, 100),
       (9, 'FEE-7', 'voltage', 0, 240),
       (10, 'BOR-53', 'temperature', -50, 50),
       (11, 'WER-1', 'humidity', 0, 100),
       (12, 'QUU-77', 'pressure', 0, 10);

INSERT INTO sensors(id, sensor_name, model_id, location_id) VALUES
(1, 'Sensor 1',
    (SELECT id FROM models WHERE model_name = 'PC33-56'),
    (SELECT id FROM locations WHERE location_name = 'Room1')
),
(2, 'Sensor 2',
    (SELECT id FROM models WHERE model_name = 'EH-567'),
    (SELECT id FROM locations WHERE location_name = 'Room1')
),
(3, 'Sensor 3',
    (SELECT id FROM models WHERE model_name = 'TER-21'),
    (SELECT id FROM locations WHERE location_name = 'Room2')
),
(4, 'Sensor 4',
    (SELECT id FROM models WHERE model_name = 'H94'),
    (SELECT id FROM locations WHERE location_name = 'Room3')
),
(5, 'Sensor 5',
    (SELECT id FROM models WHERE model_name = 'GSD-33'),
    (SELECT id FROM locations WHERE location_name = 'Room4')
),
(6, 'Sensor 6',
    (SELECT id FROM models WHERE model_name = 'BJK-5'),
    (SELECT id FROM locations WHERE location_name = 'Room6')
),
(7, 'Sensor 7',
    (SELECT id FROM models WHERE model_name = 'EDD-211'),
    (SELECT id FROM locations WHERE location_name = 'Room5')
),
(8, 'Sensor 8',
    (SELECT id FROM models WHERE model_name = 'ASS-4'),
    (SELECT id FROM locations WHERE location_name = 'Room3')
),
(9, 'Sensor 9',
    (SELECT id FROM models WHERE model_name = 'FEE-7'),
    (SELECT id FROM locations WHERE location_name = 'Room7')
),
(10, 'Sensor 10',
    (SELECT id FROM models WHERE model_name = 'BOR-53'),
    (SELECT id FROM locations WHERE location_name = 'Room2')
),
(11, 'Sensor 11',
    (SELECT id FROM models WHERE model_name = 'WER-1'),
    (SELECT id FROM locations WHERE location_name = 'Room4')
),
(12, 'Sensor 12',
    (SELECT id FROM models WHERE model_name = 'QUU-77'),
    (SELECT id FROM locations WHERE location_name = 'Room5')
);