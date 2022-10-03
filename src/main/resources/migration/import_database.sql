create schema taller;
create table taller.articulo
(
    id          INTEGER     not null,
    nombre      varchar(50) null,
    codigo      INTEGER     null,
    precio      FLOAT       null,
    descripcion VARCHAR(50) null
);

