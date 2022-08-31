create table item
(
    iditem            integer not null
        primary key,
    title             varchar(50),
    publisher         varchar(50),
    yearofpublication integer,
    pages             integer,
    description       varchar(150),
    price             numeric,
    image             varchar(255),
    instock           integer
);