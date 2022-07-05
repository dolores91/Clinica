
--create table IF NOT EXISTS domicilios(id int auto_increment primary key,calle varchar(255),numero varchar (255),localidad varchar (255),provincia varchar (255));
--create table IF NOT EXISTS pacientes(id int auto_increment primary key,nombre varchar(255),apellido varchar (255),dni varchar (255),fecha_ingreso TIMESTAMP WITHOUT TIME ZONE,domicilio_id int);
--create table IF NOT EXISTS odontologos(id int auto_increment primary key,nombre varchar(255),apellido varchar (255),matricula varchar(255));
--create table IF NOT EXISTS turnos(id int auto_increment primary key, paciente int, odontologo int, fecha DATE);

-- Pueden agregar acá sentencias Insert para precargar datos.
-- INSERT INTO domicilios(calle, numero, localidad, provincia) VALUES('Calle Falsa', 123, 'Springfield', 'Provincia Test1');
-- INSERT INTO pacientes(nombre, apellido, dni , fecha_ingreso, domicilio_id) VALUES('Nombre1', 'Apellido1', '11222333', '2022-05-31 00:00:01', 1);
--INSERT INTO pacientes(nombre, apellido, dni , fecha_ingreso, domicilio_id) VALUES('Nombre1', 'Apellido1', '11222334', '2022-05-31 00:00:01', 1);
--INSERT INTO odontologos(nombre, apellido, matricula) VALUES('Nombre', 'Apellido',"1");
--INSERT INTO odontologos (nombre, apellido, matricula) VALUES ('nombreTest', 'apellidoTest', 12343);
