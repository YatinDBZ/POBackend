create table Order_Details (
foreign key (order_id) references Order(order_id),
foreign key (prod_id) references Product_Details(prod_id),
status varchar(20),
order_date date,
quantity int
);

