DROP TABLE customers IF EXISTS CASCADE;
CREATE TABLE IF NOT EXISTS customers (id bigserial PRIMARY KEY, name VARCHAR(100));
INSERT INTO customers (name) VALUES ('Alice'), ('Jill'), ('Mary');

DROP TABLE products If EXISTS CASCADE;
CREATE TABLE IF NOT EXISTS products (id bigserial PRIMARY KEY , title VARCHAR(100), cost integer);
INSERT INTO products (title, cost) VALUES ('Milk', 70), ('Bread', 40), ('Apples', 80);

DROP TABLE orders If EXISTS CASCADE;
CREATE TABLE IF NOT EXISTS orders (id bigserial PRIMARY KEY, customer_id bigint REFERENCES customers (id), product_id bigint REFERENCES products (id), product_cost integer REFERENCES products (cost));
INSERT INTO orders (customer_id, product_id, product_cost) VALUES (1, 1), (1, 2), (3, 1), (2, 2), (2, 3);



