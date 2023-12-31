CREATE TABLE users (
  id int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
  address varchar(255) NOT NULL,
  email_address varchar(100) NOT NULL,
  "password" varchar(255) NOT NULL,
  CONSTRAINT users_pkey PRIMARY KEY (id)
);

CREATE TABLE "order" (
  id int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY, 
  order_time timestamp NULL,
  destination_address varchar(255) NULL,
  user_id int8 NOT NULL,
  completed boolean,
  CONSTRAINT order_pkey PRIMARY KEY (id),
  CONSTRAINT user_id_constraint FOREIGN KEY (user_id) REFERENCES users(id)
);

create table merchant (
	id int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY, 
	merchant_name varchar(255) NOT NULL,
	merchant_location varchar(255) NOT NULL,
	open boolean,
	 CONSTRAINT merchant_pkey PRIMARY KEY (id)
);

CREATE TABLE product (
  id int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY, 
  product_name varchar(255) NOT NULL,
  price int8 NOT NULL,
  merchant_id int8 NOT NULL,
  CONSTRAINT product_pkey PRIMARY KEY (id),
  CONSTRAINT merchant_id_constraint FOREIGN KEY (merchant_id) REFERENCES merchant(id)
);

CREATE TABLE orderdetail (
  id int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY, 
  order_id int8 NOT NULL,
  product_id int8 NOT NULL,
  quantity int8 NOT NULL,
  total_price int8 NOT NULL,
  CONSTRAINT orderdetail_pkey PRIMARY KEY (id),
  CONSTRAINT order_id_constraint FOREIGN KEY (order_id) REFERENCES "order"(id),
  CONSTRAINT product_id_constraint FOREIGN KEY (product_id) REFERENCES product(id)
);
