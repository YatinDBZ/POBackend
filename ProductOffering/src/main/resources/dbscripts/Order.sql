create table Order (
order_id int not null primary key,
foreign key (user_id) references User_Detils(id) 
);
