create table Order (
order_id int not null auto_increment,
user_id int,
status varchar(20),
order_date date,
primary key(order_id),
foreign key (user_id) references User_Details(id)
);
