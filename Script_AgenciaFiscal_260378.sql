CREATE DATABASE AgenciaFiscal_260378;
USE AgenciaFiscal_260378;

CREATE TABLE Personas(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    apellidoPaterno VARCHAR(100) NOT NULL,
    apellidoMaterno VARCHAR(100) NOT NULL,
	telefono VARCHAR(24) UNIQUE NOT NULL,
	fechaNacimiento DATE NOT NULL,
    rfc VARCHAR(13) NOT NULL
);

CREATE TABLE Tramites(
	id INT PRIMARY KEY AUTO_INCREMENT,
    fecha DATE NOT NULL,
    costo DECIMAL NOT NULL,
    idPersona INT NOT NULL,
    FOREIGN KEY(idPersona) REFERENCES Personas(id)
);

CREATE TABLE Licencias(
	id INT PRIMARY KEY,
    numero VARCHAR(10) UNIQUE NOT NULL,
    fechaVigencia DATE NOT NULL,
    FOREIGN KEY(id) REFERENCES Tramites(id)
);

CREATE TABLE Vehiculos(
	id INT PRIMARY KEY AUTO_INCREMENT,
	numSerie VARCHAR(50) UNIQUE NOT NULL,
    marca VARCHAR(50) NOT NULL,	
    linea VARCHAR(50) NOT NULL,
    color VARCHAR(20) NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    tipo ENUM("Automovil") NOT NULL,
    idPersona INT NOT NULL,
    FOREIGN KEY(idPersona) REFERENCES Personas(id)
);

CREATE TABLE Placas(
	id INT PRIMARY KEY,
    numero VARCHAR(7) UNIQUE NOT NULL,
    estado ENUM("Activas", "No activas") NOT NULL,
	fechaRecepcion DATE,
    idVehiculo INT NOT NULL,
    FOREIGN KEY(id) REFERENCES Tramites(id),
    FOREIGN KEY(idVehiculo) REFERENCES Vehiculos(id)
);

/**
	Funciones
**/
-- Función para generar un código "XXX-000" como número de las Placas nuevas.
DELIMITER $$
CREATE FUNCTION generar_numero_placa()
RETURNS VARCHAR(7)
DETERMINISTIC
BEGIN
    DECLARE letras CHAR(3);
    DECLARE numeros CHAR(3);

    SET letras = CONCAT(
        CHAR(FLOOR(65 + RAND() * 26)),
        CHAR(FLOOR(65 + RAND() * 26)),
        CHAR(FLOOR(65 + RAND() * 26))
    );

    SET numeros = LPAD(FLOOR(RAND() * 1000), 3, '0');

    RETURN CONCAT(letras, '-', numeros);
END $$
DELIMITER ;

-- Función para generar número de Licencia.
DELIMITER $$
CREATE FUNCTION generar_numero_licencia()
RETURNS VARCHAR(7)
DETERMINISTIC
BEGIN
    DECLARE letras CHAR(3);
    DECLARE numeros CHAR(4);

    SET letras = CONCAT(
        CHAR(FLOOR(65 + RAND() * 26)),
        CHAR(FLOOR(65 + RAND() * 26)),
        CHAR(FLOOR(65 + RAND() * 26))
    );

    SET numeros = LPAD(FLOOR(RAND() * 1000), 4, '0');

    RETURN CONCAT(letras, numeros);
END $$
DELIMITER ;

/**
	Procedimientos almacenados
**/
-- Procedimiento para Insertar un Nuevo Vehiculo junto con sus Placas.
DELIMITER $$
CREATE PROCEDURE insertar_vehiculo_con_placas(
	IN p_numSerie VARCHAR(50),
    IN p_marca VARCHAR(50),
    IN p_linea VARCHAR(50),
    IN p_color VARCHAR(50),
    IN p_modelo VARCHAR(50),
    IN p_tipo ENUM("Automovil"),
    IN p_idPersona INT
)
BEGIN
    DECLARE v_idVehiculo INT;
	DECLARE EXIT HANDLER FOR SQLEXCEPTION
	BEGIN
		ROLLBACK;
    END;

	START TRANSACTION;

	INSERT Vehiculos(numSerie, marca, linea, color, modelo, tipo, idPersona)
    VALUES(p_numSerie, p_marca, p_linea, p_color, p_modelo, p_tipo, p_idPersona);
    
    SET v_idVehiculo = LAST_INSERT_ID();
    
    INSERT Tramites(fecha, costo, idPersona)
    VALUES(NOW(), 1500, p_idPersona);
    
    INSERT Placas(id, numero, estado, idVehiculo)
    VALUES(LAST_INSERT_ID(), generar_numero_placa(), "Activas", v_idVehiculo);
    
    SELECT numero
    FROM Placas
    WHERE id = LAST_INSERT_ID();
    
    COMMIT;
END $$
DELIMITER ;

-- Procedimiento para asignar Nuevas Placas a un Vehiculo Usado.
DELIMITER $$
CREATE PROCEDURE insertar_placas_a_vehiculo_viejo(
	IN p_idVehiculo INT,
    IN p_idPersona INT
)
BEGIN
	DECLARE EXIT HANDLER FOR SQLEXCEPTION
	BEGIN
		ROLLBACK;
    END;

	START TRANSACTION;

	UPDATE Placas
    SET estado = "No activas"
    WHERE estado = "Activas" 
    AND idVehiculo = p_idVehiculo;
    
    INSERT Tramites(fecha, costo, idPersona)
    VALUES(NOW(), 1000, p_idPersona);
    
    INSERT Placas(id, numero, estado, idVehiculo)
    VALUES(LAST_INSERT_ID(), generar_numero_placa(), "Activas", p_idVehiculo);
    
    SELECT numero
    FROM Placas
    WHERE id = LAST_INSERT_ID();
    
    COMMIT;
END $$
DELIMITER ;

-- Procedimiento para obtener los datos de las primeras
-- personas registradas.
DELIMITER $$
CREATE PROCEDURE consultar_personas(
)
BEGIN
	SELECT PE.id, PE.nombre, PE.apellidoPaterno, PE.apellidoMaterno, PE.telefono, PE.fechaNacimiento, PE.rfc
    FROM Personas AS PE
    INNER JOIN Tramites AS TR ON TR.idPersona = PE.id
    INNER JOIN Licencias AS LI ON LI.id = TR.id
    WHERE LI.fechaVigencia > NOW()
    LIMIT 5;
END $$
DELIMITER ;

-- Procedimiento para obtener los datos de la Persona segun su
-- RFC.
DELIMITER $$
CREATE PROCEDURE consultar_persona_por_rfc_y_telefono(
	IN p_rfc VARCHAR(13),
    IN p_telefono VARCHAR(24)
)
BEGIN
	SELECT PE.id, PE.nombre, PE.apellidoPaterno, PE.apellidoMaterno, PE.telefono, PE.fechaNacimiento, PE.rfc
    FROM Personas AS PE
    INNER JOIN Tramites AS TR ON TR.idPersona = PE.id
    INNER JOIN Licencias AS LI ON LI.id = TR.id
    WHERE LI.fechaVigencia > NOW()
    AND (PE.rfc = "" OR PE.rfc LIKE LOWER(CONCAT(p_rfc, '%')))
    AND (PE.telefono = "" OR PE.telefono LIKE LOWER(CONCAT(p_telefono, '%')))
    LIMIT 5;
END $$
DELIMITER ;

-- Procedimiento para buscar los datos de un Vehiculo según
-- su número de Placas.
DELIMITER $$
CREATE PROCEDURE consultar_vehiculo_por_idPersona_y_numPlaca(
	IN p_idPersona INT,
    IN p_numPlaca VARCHAR(7)
)
BEGIN
	SELECT VE.id, PL.numero, VE.numSerie, VE.marca, VE.linea, VE.color, VE.modelo, VE.tipo
    FROM Vehiculos AS VE
    INNER JOIN Placas AS PL ON PL.idVehiculo = VE.id
    WHERE VE.idPersona = p_idPersona
    AND PL.estado = "Activas"
    AND (PL.numero = "" OR PL.numero LIKE LOWER(CONCAT(p_numPlaca, '%')))
    LIMIT 5;
END $$
DELIMITER ;

-- Procedimiento para consultar el historial de Placas por Vehiculo.
DELIMITER $$
CREATE PROCEDURE consultar_placas_por_idVehiculo_y_fechaTramite(
	IN p_idVehiculo INT,
    IN p_fechaTramite DATE
)
BEGIN
	SELECT PL.numero, PL.estado, TR.fecha, TR.costo, PL.fechaRecepcion
    FROM Placas AS PL
    INNER JOIN Tramites AS TR ON TR.id = PL.id
    WHERE PL.idVehiculo = p_idVehiculo
    AND (p_fechaTramite IS NULL OR TR.fecha = p_fechaTramite)
    LIMIT 5;
END $$
DELIMITER ;

-- Procedimiento para insertar Persona con Lisencia.
DELIMITER $$
CREATE PROCEDURE insertar_persona_y_lisencia(
	IN p_nombre VARCHAR(100),
    IN p_apellidoPaterno VARCHAR(100),
    IN p_apellidoMaterno VARCHAR(100),
    IN p_telefono VARCHAR(24),
    IN p_fechaNacimiento DATE,
    IN p_rfc VARCHAR(13),
    IN p_añosVigencia INT
)
BEGIN
	DECLARE v_idPersona INT;
    DECLARE v_costo DECIMAL;
    
	DECLARE EXIT HANDLER FOR SQLEXCEPTION
	BEGIN
		ROLLBACK;
    END;
    
    START TRANSACTION;
    
    INSERT Personas(nombre, apellidoPaterno, apellidoMaterno, telefono, fechaNacimiento, rfc)
    VALUES(p_nombre, p_apellidoPaterno, p_apellidoMaterno, p_telefono, p_fechaNacimiento, p_rfc);
    
    SET v_idPersona = LAST_INSERT_ID();
    
    IF p_añosVigencia = 1 THEN
		SET v_costo = 500;
	ELSEIF p_añosVigencia = 2 THEN
		SET v_costo = 900;
	ELSEIF p_añosVigencia >= 3 THEN
		SET v_costo = 1200;
    END IF;
    
    INSERT Tramites(fecha, costo, idPersona)
    VALUES(NOW(), v_costo, v_idPersona);
    
    INSERT Licencias(id, numero, fechaVigencia)
    VALUES(LAST_INSERT_ID(), generar_numero_licencia(), DATE_ADD(NOW(), INTERVAL p_añosVigencia YEAR));
    
    COMMIT;
END $$
DELIMITER ;

CALL insertar_persona_y_lisencia('Daniel', 'Buelna', 'Andujo', '6441613191', '2025-05-30', 'CANB08654', 3);
CALL insertar_vehiculo_con_placas("2", "Toyota", "3", "Negro", "2", "Automovil", 1);
CALL insertar_placas_a_vehiculo_viejo(1, 1);
CALL consultar_personas();
CALL consultar_persona_por_rfc_y_telefono("C", "");
CALL consultar_vehiculo_por_idPersona_y_numPlaca(1, "");
CALL consultar_placas_por_idVehiculo_y_fechaTramite(1, null);

SELECT * FROM Personas;
SELECT * FROM Vehiculos;
SELECT * FROM Tramites;
SELECT * FROM Licencias;
SELECT * FROM Placas;