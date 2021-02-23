create database products;
use  products;

create table product(
	product_id int auto_increment primary key,
	product_name varchar(20) ,
	product_image LONGBLOB  ,
	color varchar(20),
	price int	
);
create table category(
	category_id int auto_increment primary key,
	category_type varchar(20) ,
	cat_product_id int,
	constraint fk_catprod_id foreign key (cat_product_id) references product(product_id)	
);