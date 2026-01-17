CREATE TABLE products (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    descricao VARCHAR(255),
    price DECIMAL(10,2) NOT NULL,
    type VARCHAR(50)
);

CREATE TABLE orders (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    total_amount DECIMAL(10,2),
    order_date DATETIME NOT NULL
);

CREATE TABLE items (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    product_id BIGINT NOT NULL,
    order_id BIGINT NOT NULL,
    quantity INT NOT NULL,
    unit_price DECIMAL(10,2),

    CONSTRAINT fk_item_product
        FOREIGN KEY (product_id) REFERENCES products(id),

    CONSTRAINT fk_item_order
        FOREIGN KEY (order_id) REFERENCES orders(id)
);

