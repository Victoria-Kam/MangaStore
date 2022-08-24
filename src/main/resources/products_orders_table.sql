create table products_orders(
                                id integer primary key,
                                iditem integer,
                                idorder integer
)

--Обновлени таблицы products_orders, добавление вторичного ключа idorder для связи с таблицей orders
alter table products_orders add constraint idorder foreign key (idorder) references orders (idorder)

--Обновлени таблицы products_orders, добавление вторичного ключа idcustomer для связи с таблицей item
alter table products_orders add constraint iditem foreign key (idorder) references item (iditem)
