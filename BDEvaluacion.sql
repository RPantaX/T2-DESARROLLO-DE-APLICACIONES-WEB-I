DROP DATABASE BDEvaluacion;
CREATE DATABASE BDEvaluacion;
USE BDEvaluacion;

CREATE TABLE usuario (
	idusuario INT auto_increment NOT NULL,
	nomusuario varchar(100) NULL,
	email varchar(200) NULL,
	password varchar(300) NULL,
	nombres varchar(100) NULL,
	apellidos varchar(100) NULL,
	activo BOOL NULL,
	CONSTRAINT users_pk PRIMARY KEY (idusuario)
);

CREATE TABLE rol (
	idrol INT auto_increment NOT NULL,
	nomrol varchar(300) NULL,
	CONSTRAINT roles_pk PRIMARY KEY (idrol)
);

CREATE TABLE usuario_rol (
	idusuario INT NOT NULL,
	idrol INT NOT NULL,
	CONSTRAINT user_role_pk PRIMARY KEY (idusuario, idrol),
	CONSTRAINT user_role_FK FOREIGN KEY (idusuario) REFERENCES BDEvaluacion.usuario(idusuario),
	CONSTRAINT user_role_FK_1 FOREIGN KEY (idrol) REFERENCES BDEvaluacion.rol(idrol)
);

CREATE TABLE Medico
(
 IdMedico 		INT NOT NULL AUTO_INCREMENT,
 NomMedico		VARCHAR(50) NOT NULL,
 ApeMedico 		VARCHAR(50) NOT NULL,
 FechNacMedico	DATE NOT NULL,
 PRIMARY KEY (IdMedico)
);

CREATE TABLE Especialidad
(
 IdEspecialidad 		INT NOT NULL AUTO_INCREMENT,
 Titulo 			VARCHAR(250) NOT NULL,
 Funcion 			VARCHAR(250) NOT NULL,
 FechGraduacion	DATE NOT NULL,
 IdMedico 			INT NOT NULL,
 PRIMARY KEY (IdEspecialidad),
 FOREIGN KEY (IdMedico) REFERENCES Medico(IdMedico)
 );
 
 Insert Into Rol
 Values (null, 'USER');
 
 SELECT * FROM USUARIO;