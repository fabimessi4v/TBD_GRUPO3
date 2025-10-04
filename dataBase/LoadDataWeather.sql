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
(1, 1, 22.5, '2025-01-10 14:00:00'),
(1, 1, 24.1, '2025-02-10 14:00:00'),
(4, 1, 6.8, '2025-01-10 14:00:00'),
(4, 1, 5.2, '2025-02-10 14:00:00');

-- Dataset 2: CO₂ (ppm)
INSERT INTO Mediciones (IdPunto, IdDataset, Valor, FechaHora)
VALUES
(2, 2, 417.3, '2025-01-10 10:00:00'),
(2, 2, 419.5, '2025-02-10 10:00:00');

-- Dataset 3: Nivel del mar (metros)
INSERT INTO Mediciones (IdPunto, IdDataset, Valor, FechaHora)
VALUES
(3, 3, 0.12, '2025-01-15 09:00:00'),
(3, 3, 0.18, '2025-02-15 09:00:00');
	