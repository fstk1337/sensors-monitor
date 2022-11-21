INSERT INTO roles(id, role_name)
VALUES (nextval('role_id_sequence'), 'Administrator'),
       (nextval('role_id_sequence'), 'Viewer');

INSERT INTO users(id, username, password, role_id)
VALUES
(
    nextval('user_id_sequence'),
    'admin', '3094042D4F193AE1B73F33E504BBCE2018E75993131F9C94FF3BCD29F3183F74',
    (SELECT id FROM roles WHERE role_name = 'Administrator')
),
(
    nextval('user_id_sequence'),
    'user', '081805BDA105816CE893EB730A7ED3030FC3DA71D7263B6BACF4205B46F4F66F',
    (SELECT id FROM roles WHERE role_name = 'Viewer')
);

INSERT INTO locations(id, location_name)
VALUES (nextval('location_id_sequence'), 'Room1'),
       (nextval('location_id_sequence'), 'Room2'),
       (nextval('location_id_sequence'), 'Room3'),
       (nextval('location_id_sequence'), 'Room4'),
       (nextval('location_id_sequence'), 'Room5'),
       (nextval('location_id_sequence'), 'Room6'),
       (nextval('location_id_sequence'), 'Room7');

INSERT INTO models(id, model_name, type, min_value, max_value)
VALUES (nextval('model_id_sequence'), 'PC33-56', 'pressure', 0, 16),
       (nextval('model_id_sequence'), 'EH-567', 'voltage', 0, 15),
       (nextval('model_id_sequence'), 'TER-21', 'temperature', -70, 50),
       (nextval('model_id_sequence'), 'H94', 'humidity', 0, 100),
       (nextval('model_id_sequence'), 'GSD-33', 'voltage', 0, 120),
       (nextval('model_id_sequence'), 'BJK-5', 'pressure', 0, 20),
       (nextval('model_id_sequence'), 'EDD-211', 'temperature', -40, 40),
       (nextval('model_id_sequence'), 'ASS-4', 'humidity', 0, 100),
       (nextval('model_id_sequence'), 'FEE-7', 'voltage', 0, 240),
       (nextval('model_id_sequence'), 'BOR-53', 'temperature', -50, 50),
       (nextval('model_id_sequence'), 'WER-1', 'humidity', 0, 100),
       (nextval('model_id_sequence'), 'QUU-77', 'pressure', 0, 10);

INSERT INTO sensors(id, sensor_name, model_id, location_id) VALUES
(
    nextval('sensor_id_sequence'),
    'Sensor 1',
    (SELECT id FROM models WHERE model_name = 'PC33-56'),
    (SELECT id FROM locations WHERE location_name = 'Room1')
),
(
    nextval('sensor_id_sequence'),
    'Sensor 2',
    (SELECT id FROM models WHERE model_name = 'EH-567'),
    (SELECT id FROM locations WHERE location_name = 'Room1')
),
(
    nextval('sensor_id_sequence'),
    'Sensor 3',
    (SELECT id FROM models WHERE model_name = 'TER-21'),
    (SELECT id FROM locations WHERE location_name = 'Room2')
),
(
    nextval('sensor_id_sequence'),
    'Sensor 4',
    (SELECT id FROM models WHERE model_name = 'H94'),
    (SELECT id FROM locations WHERE location_name = 'Room3')
),
(
    nextval('sensor_id_sequence'),
    'Sensor 5',
    (SELECT id FROM models WHERE model_name = 'GSD-33'),
    (SELECT id FROM locations WHERE location_name = 'Room4')
),
(
    nextval('sensor_id_sequence'),
    'Sensor 6',
    (SELECT id FROM models WHERE model_name = 'BJK-5'),
    (SELECT id FROM locations WHERE location_name = 'Room6')
),
(
    nextval('sensor_id_sequence'),
    'Sensor 7',
    (SELECT id FROM models WHERE model_name = 'EDD-211'),
    (SELECT id FROM locations WHERE location_name = 'Room5')
),
(
    nextval('sensor_id_sequence'),
    'Sensor 8',
    (SELECT id FROM models WHERE model_name = 'ASS-4'),
    (SELECT id FROM locations WHERE location_name = 'Room3')
),
(
    nextval('sensor_id_sequence'),
    'Sensor 9',
    (SELECT id FROM models WHERE model_name = 'FEE-7'),
    (SELECT id FROM locations WHERE location_name = 'Room7')
),
(
    nextval('sensor_id_sequence'),
    'Sensor 10',
    (SELECT id FROM models WHERE model_name = 'BOR-53'),
    (SELECT id FROM locations WHERE location_name = 'Room2')
),
(
    nextval('sensor_id_sequence'),
    'Sensor 11',
    (SELECT id FROM models WHERE model_name = 'WER-1'),
    (SELECT id FROM locations WHERE location_name = 'Room4')
),
(
    nextval('sensor_id_sequence'),
    'Sensor 12',
    (SELECT id FROM models WHERE model_name = 'QUU-77'),
    (SELECT id FROM locations WHERE location_name = 'Room5')
);