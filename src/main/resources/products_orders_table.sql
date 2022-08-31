create table products_orders
(
    id         integer not null,
    iditem     integer  constraint iditem  references item,
    amount     numeric,
    idcustomer integer not null  constraint idcustomer  references customer,
    cheque     integer
);