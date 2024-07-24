create database shop ;
use shop;

create table users (
    id int PRIMARY KEY auto_increment,
    full_name varchar(100) Default '',
    phone_number varchar(100) Default Null,
    address varchar(100) Default '',
    password varchar(100) NOT NULL,
    created_at datetime,
    updated_at datetime,
    is_active tinyint default 1,
    date_of_birth DATE,
    google_account_id INT DEFAULT 0,
    facebook_account_id INT DEFAULT 0
)

ALTER TABLE users ADD COLUMN role_id INT,

CREATE TABLE roles (
    id INT PRIMARY KEY auto_increment,
    name VARCHAR(20) NOT NULL
)

ALTER TABLE users ADD FOREIGN KEY (role_id) REFERENCES roles (id)

create table tokens (
    id int PRIMARY KEY AUTO_INCREMENT,
    token VARCHAR(200) UNIQUE NOT NULL,
    token_type VARCHAR(50) NOT NULL,
    expỉation_data DATETIME,
    revoked TINYINT(1) NOT NULL,
    expried TINYINT(1) NOT NULL,
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES users (id)
)

create table social_accounts (
    id INT PRIMARY KEY AUTO_INCREMENT,
    provider VARCHAR(20) NOT NULL COMMENT 'Tên nhà social network provider'
    provider_id VARCHAR(50) NOT NULL
    email VARCHAR(50) NOT NULL COMMENT 'Email address'
    name VARCHAR(50) NOT NULL COMMENT 'TÊN NGƯỜI DÙNG'
    user_id int,
    FOREIGN KEY (user_id) REFERENCES users(id)
)

create TABLE categories (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(200) NOT NULL DEFAULT "" COMMENT "TÊN DANH MỤC SẢN PHẨM"
)

create TABLE products (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(200) NOT NULL DEFAULT "" COMMENT "TÊN SẢN PHẨM",
    description LONGTEXT DEFAULT "" COMMENT "MÔ TẢ SẢN PHẨM",
    price FLOAT NOT NULL CHECK(price >= 0),
    thumbnail VARCHAR(300) DEFAULT "", 
    created_at DATETIME,
    updated_at DATETIME,
    category_id INT,
    FOREIGN KEY (category_id) REFERENCES categories (id)
)

CREATE TABLE orders (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id int,
    FOREIGN KEY (user_id) REFERENCES users (id),
    fullname VARCHAR(255),
    email VARCHAR(255),
    phone_number VARCHAR(255) NOT NULL,
    note VARCHAR(100) DEFAULT "",
    oder_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(20),
    total_money FLOAT CHECK(total_money >= 0)
)

ALTER TABLE orders ADD COLUMN `shipping_method` VARCHAR(100);
ALTER TABLE orders ADD COLUMN `shipping_address` VARCHAR(100);
ALTER TABLE orders ADD COLUMN `shipping_date` DATE;
ALTER TABLE orders ADD COLUMN `tracking_number` VARCHAR(100);
ALTER TABLE orders ADD COLUMN `payment_method` VARCHAR(100);
ALTER TABLE orders ADD COLUMN active TINYINT(1);
ALTER TABLE orders MODIFY COLUMN status ENUM ('PENDING', 'PROCESSING', 'SHIPPED', 'DELIVERY', 'CANCELLED') CONTENT ; 

CREATE TABLE order_details(
    id INT PRIMARY KEY AUTO_INCREMENT,
    order_id INT,
    FOREIGN KEY (order_id) REFERENCES orders (id),
    product_id INT,
    FOREIGN KEY (product_id) REFERENCES products(id),
    price FLOAT CHECK(price >= 0),
    number_of_products INT CHECK(number_of_products > 0),
    total_money FLOAT CHECK(total_money >= 0),
    color VARCHAR(20) DEFAULT '',
)
