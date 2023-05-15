drop table popularidad if exists;
drop table producto if exists;
drop table categoria if exists;
drop sequence if exists hibernate_sequence;


create sequence hibernate_sequence start with 100 increment by 1;

CREATE TABLE categoria (
  id bigint AUTO_INCREMENT PRIMARY KEY,
  destacada boolean not null, 
  imagen varchar(512), 
  nombre VARCHAR(255)
);

CREATE TABLE producto (
  id bigint AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(255) NOT NULL,
  descripcion TEXT NOT NULL,
  precio float NOT NULL,
  stock INT NOT NULL,
  imagen BLOB,
  categoria_id INT NOT NULL
);

CREATE TABLE popularidad (
  id bigint AUTO_INCREMENT PRIMARY KEY,
  puntuacion integer not null, 
  producto_id bigint
);

alter table producto add constraint fk_producto_categoria foreign key (categoria_id) references categoria on update cascade on delete cascade;
alter table popularidad add constraint fk_puntuacion_producto foreign key (producto_id) references producto on update cascade on delete cascade;

