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

INSERT INTO models(id, model_name, type, min_value, max_value)
VALUES (nextval('model_id_sequence'), 'PC33-56', 'Pressure', 0, 16),
       (nextval('model_id_sequence'), 'EH-567', 'Voltage', 0, 15),
       (nextval('model_id_sequence'), 'TER-21', 'Temperature', -70, 50),
       (nextval('model_id_sequence'), 'H94', 'Humidity', 0, 100),
       (nextval('model_id_sequence'), 'GSD-33', 'Voltage', 0, 120),
       (nextval('model_id_sequence'), 'BJK-5', 'Pressure', 0, 20),
       (nextval('model_id_sequence'), 'EDD-211', 'Temperature', -40, 40),
       (nextval('model_id_sequence'), 'ASS-4', 'Humidity', 0, 100),
       (nextval('model_id_sequence'), 'FEE-7', 'Voltage', 0, 240),
       (nextval('model_id_sequence'), 'BOR-53', 'Temperature', -50, 50),
       (nextval('model_id_sequence'), 'WER-1', 'Humidity', 0, 100),
       (nextval('model_id_sequence'), 'QUU-77', 'Pressure', 0, 10);

INSERT INTO sensors(id, sensor_name, model_id, location, description) VALUES
(
    nextval('sensor_id_sequence'),
    'Sensor 1',
    (SELECT id FROM models WHERE model_name = 'PC33-56'),
    'Room1',
    ''
),
(
    nextval('sensor_id_sequence'),
    'Sensor 2',
    (SELECT id FROM models WHERE model_name = 'EH-567'),
    'Room1',
    ''
),
(
    nextval('sensor_id_sequence'),
    'Sensor 3',
    (SELECT id FROM models WHERE model_name = 'TER-21'),
    'Room2',
    ''
),
(
    nextval('sensor_id_sequence'),
    'Sensor 4',
    (SELECT id FROM models WHERE model_name = 'H94'),
    'Room3',
    ''
),
(
    nextval('sensor_id_sequence'),
    'Sensor 5',
    (SELECT id FROM models WHERE model_name = 'GSD-33'),
    'Room4',
    ''
),
(
    nextval('sensor_id_sequence'),
    'Sensor 6',
    (SELECT id FROM models WHERE model_name = 'BJK-5'),
    'Room6',
    ''
),
(
    nextval('sensor_id_sequence'),
    'Sensor 7',
    (SELECT id FROM models WHERE model_name = 'EDD-211'),
    'Room5',
    ''
),
(
    nextval('sensor_id_sequence'),
    'Sensor 8',
    (SELECT id FROM models WHERE model_name = 'ASS-4'),
    'Room3',
    ''
),
(
    nextval('sensor_id_sequence'),
    'Sensor 9',
    (SELECT id FROM models WHERE model_name = 'FEE-7'),
    'Room7',
    ''
),
(
    nextval('sensor_id_sequence'),
    'Sensor 10',
    (SELECT id FROM models WHERE model_name = 'BOR-53'),
    'Room2',
    ''
),
(
    nextval('sensor_id_sequence'),
    'Sensor 11',
    (SELECT id FROM models WHERE model_name = 'WER-1'),
    'Room4',
    ''
),
(
    nextval('sensor_id_sequence'),
    'Sensor 12',
    (SELECT id FROM models WHERE model_name = 'QUU-77'),
    'Room5',
    ''
);