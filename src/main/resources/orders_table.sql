create table orders(
                       idorder integer primary key,
                       idorderproduct integer,
                       idcustomer integer,
                       amount decimal
)

--Обновлени таблицы orders, добавление вторичного ключа idcustomer для связи с таблицей customer
alter table orders add constraint idorderproduct foreign key (idcustomer)