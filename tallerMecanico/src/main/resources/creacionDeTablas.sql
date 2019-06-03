

/*
Configuraciones de formato de fecha
ALTER SESSION SET NLS_DATE_FORMAT='DD/MM/YYYY';

Configuración de la Zona horario de la base de datos;
SET GLOBAL time_zone = '-3:00';


*/
/*USUARIO ADMINISTRADOR*/
INSERT INTO `usuario` (`id_usuario`, `nombre`, `apellidos`, `email`, `password`, `permisos`) VALUES (NULL, 'usuario', 'usuario', 'usuario@hotmail.com', '$2a$10$rG9EutsdZa4EGjVhmsUdruiq8x4u9GTEeuBBEs9mHFrSwz3NvvQfm', 'U');


CREATE TABLE IF NOT EXISTS USUARIO (
	id_usuario INT(4) AUTO_INCREMENT,
	nombre VARCHAR(255) ,
	apellidos VARCHAR(255) , 
	email	VARCHAR(255) ,
	password VARCHAR(255),
	permisos VARCHAR(1),
	CONSTRAINT PK_USUARIO PRIMARY KEY (id_usuario)
);

CREATE TABLE IF NOT EXISTS COCHE (
	id_coche INT AUTO_INCREMENT,
	matricula VARCHAR(10),
	marca	VARCHAR(255),
	modelo	VARCHAR(255),
	CONSTRAINT PK_COCHE PRIMARY KEY (ID_COCHE)
);

CREATE TABLE IF NOT EXISTS FACTURA (
	id_factura INT AUTO_INCREMENT, 
	id_usuario INT,
	id_coche INT, 
	fecha DATE ,
	Descripcion VARCHAR(500), 
	importe	FLOAT(7,2),
	pagada	VARCHAR(2),
	CONSTRAINT PK_FACTURA PRIMARY KEY(id_factura),
	CONSTRAINT FK_USUARIO_FACTURA FOREIGN KEY(id_usuario) REFERENCES USUARIO(id_usuario),
	CONSTRAINT FK_COCHE_FACTURA FOREIGN KEY(id_coche) REFERENCES COCHE(id_coche)
);