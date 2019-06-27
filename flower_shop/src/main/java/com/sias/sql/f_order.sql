create table f_order(
id varchar(40) primary key,
orderNo varchar(100),
total double,
createDate date,
addressId varchar(40),
userId varchar(40)
);