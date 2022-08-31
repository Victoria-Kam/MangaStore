create table customer
(
    idcustomer  integer not null
        primary key,
    firstname   varchar(50),
    lastname    varchar(50),
    email       varchar(50),
    pass        varchar(16),
    phone       varchar(9),
    city        varchar(20),
    adress      varchar(50),
    housenumber integer,
    apartment   integer
);