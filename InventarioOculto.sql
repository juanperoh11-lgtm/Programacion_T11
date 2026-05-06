CREATE DATABASE IF NOT EXISTS tienda


USE tienda;

DROP TABLE IF EXISTS productos;

CREATE TABLE productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    stock INT NOT NULL
);

INSERT INTO productos (nombre, precio, stock) VALUES
('Ratón Inalámbrico', 15.50, 20),
('Teclado Mecánico', 49.99, 8),
('Monitor 24 pulgadas', 129.90, 5),
('Cable USB-C', 7.99, 0),
('Auriculares Bluetooth', 35.00, 12);