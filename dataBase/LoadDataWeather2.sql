-- Poblamiento de tablas - Visualización Climática

-- 1 Usuarios
INSERT INTO Usuarios (Nombre, Email, ConHash, Rol)
VALUES
('Ana Torres', 'ana.torres@email.com', 'a1b2c3d4e5f6g7', 'admin'),
('Carlos Ruiz', 'carlos.ruiz@email.com', 'd7e8f9g0h1i2j3', 'usuario'),
('Lucía Pérez', 'lucia.perez@email.com', 'k4l5m6n7o8p9q0', 'usuario');

-- 2 Datasets
INSERT INTO Datasets (Nombre, Descripcion, Fuente)
VALUES
('Temperatura', 'Registros de temperatura promedio', 'NOAA'),
('CO2', 'Concentración de dióxido de carbono', 'NASA'),
('NivelMar', 'Variación del nivel del mar', 'ESA');

-- 3 PuntosMedicion
INSERT INTO PuntosMedicion (Nombre, Latitud, Longitud, TipoSensor, Activo)
VALUES
('Estación Santiago Centro', -33.4489, -70.6693, 'Termómetro', TRUE),
('Estación Valparaíso', -33.0472, -71.6127, 'Sensor CO2', TRUE),
('Estación Antofagasta', -23.6500, -70.4000, 'Mareógrafo', TRUE),
('Estación Punta Arenas', -53.1638, -70.9171, 'Termómetro', TRUE);

-- 4 Mediciones

-- Dataset 1: Temperatura (°C)
INSERT INTO Mediciones (IdPunto, IdDataset, Valor, FechaHora)
VALUES
(1, 1, 22.5, '03-01-2025 14:00:00'),
(1, 1, 23.1, '10-01-2025 14:00:00'),
(1, 1, 25.0, '17-01-2025 14:00:00'),
(1, 1, 21.8, '24-01-2025 14:00:00'),
(1, 1, 24.1, '10-02-2025 14:00:00'),
(4, 1, 6.8,  '03-01-2025 14:00:00'),
(4, 1, 7.2,  '10-01-2025 14:00:00'),
(4, 1, 5.9,  '17-01-2025 14:00:00'),
(4, 1, 5.4,  '24-01-2025 14:00:00'),
(4, 1, 5.2,  '10-02-2025 14:00:00'),
(1, 1, 26.3, '10-07-2025 14:00:00'),
(1, 1, 27.0, '24-07-2025 14:00:00'),
(4, 1, 7.6,  '10-07-2025 14:00:00'),
(4, 1, 8.0,  '24-07-2025 14:00:00');

-- Dataset 2: CO₂ (ppm)
INSERT INTO Mediciones (IdPunto, IdDataset, Valor, FechaHora)
VALUES
(2, 2, 417.3, '03-01-2025 10:00:00'),
(2, 2, 417.8, '10-01-2025 10:00:00'),
(2, 2, 418.4, '17-01-2025 10:00:00'),
(2, 2, 418.9, '24-01-2025 10:00:00'),
(2, 2, 419.5, '10-02-2025 10:00:00'),
(2, 2, 425.2, '10-07-2025 10:00:00'),
(2, 2, 426.0, '24-07-2025 10:00:00');


-- Dataset 3: Nivel del mar (metros)
INSERT INTO Mediciones (IdPunto, IdDataset, Valor, FechaHora)
VALUES
(3, 3, 0.10, '03-01-2025 09:00:00'),
(3, 3, 0.12, '10-01-2025 09:00:00'),
(3, 3, 0.14, '17-01-2025 09:00:00'),
(3, 3, 0.16, '24-01-2025 09:00:00'),
(3, 3, 0.18, '15-02-2025 09:00:00'),
(3, 3, 0.25, '10-07-2026 09:00:00'),
(3, 3, 0.27, '24-07-2026 09:00:00');	