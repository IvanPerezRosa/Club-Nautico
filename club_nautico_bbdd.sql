DROP DATABASE IF EXISTS club_nautico_bbdd;
CREATE DATABASE club_nautico_bbdd;
USE club_nautico_bbdd;

-- Crear la tabla socio
CREATE TABLE socio (
    id_socio INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    dni VARCHAR(20) NOT NULL UNIQUE,
    id_barco INT, 
    FOREIGN KEY (id_barco) REFERENCES barco(id) ON DELETE SET NULL
);

-- Crear la tabla barco
CREATE TABLE barco (
    id_barco INT AUTO_INCREMENT PRIMARY KEY,
    numero_matricula VARCHAR(20) NOT NULL UNIQUE,
    nombre VARCHAR(50) NOT NULL,
    numero_amarre INT NOT NULL,
    cuota_amarre DECIMAL(10, 2) NOT NULL
);

-- Crear la tabla salida
CREATE TABLE salida (
    id_salida INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE NOT NULL,
    hora TIME NOT NULL,
    destino VARCHAR(100) NOT NULL,
	id_barco INT,
    id_patron INT,
    FOREIGN KEY (id_barco) REFERENCES barco(id) ON DELETE SET NULL,
    FOREIGN KEY (id_patron) REFERENCES patron(id_patron) ON DELETE SET NULL
);

-- Crear la tabla patron
CREATE TABLE patron (
    id_patron INT AUTO_INCREMENT PRIMARY KEY,
    id_socio INT,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    FOREIGN KEY (id_socio) REFERENCES socio(id) ON DELETE SET NULL
);
