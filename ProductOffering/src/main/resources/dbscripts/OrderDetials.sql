create table Order_Details (
order_id int,
prod_id int,
quantity int,
foreign key (order_id) references Order(order_id),
foreign key (prod_id) references Product_Details(prod_id)
);




