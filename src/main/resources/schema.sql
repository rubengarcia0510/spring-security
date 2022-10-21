CREATE TABLE customers(
    customer_id bigint auto_increment primary key,
    name varchar(64) not null,
    contact_name varchar(128) not null,
    email varchar(128) not null,
    phone varchar(24) not null
);

CREATE TABLE orders(
    order_id bigint auto_increment primary key,
    customer_id bigint not null,
    order_info varchar (2048) not null,
    foreign key (customer_id) references customers(customer_id)
);

CREATE TABLE users(
	username VARCHAR(50) not null primary key,
	password VARCHAR(500) not null,
	enabled BOOLEAN not null
);

CREATE TABLE authorities(
	username VARCHAR(50) not null,
	authority VARCHAR(50) not null,
	constraint fk_authorities_users foreign key (username) references users(username)
);

CREATE UNIQUE INDEX ix_authorities_users on authorities (username,authority);

