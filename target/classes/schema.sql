CREATE DATABASE IF NOT EXISTS tourism_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE tourism_db;
CREATE TABLE IF NOT EXISTS tourists (
 tourist_id BIGINT PRIMARY KEY AUTO_INCREMENT,
 first_name VARCHAR(100) NOT NULL,
 last_name VARCHAR(100) NOT NULL,
 email VARCHAR(254) NOT NULL UNIQUE,
 phone VARCHAR(30), country VARCHAR(100), visit_date DATE,
 created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
INSERT IGNORE INTO tourists(first_name,last_name,email,phone,country,visit_date) VALUES
('Asha','Rao','asha.example@example.com','+91-9000000001','India','2026-12-01'),
('Ravi','Kumar','ravi.example@example.com','+91-9000000002','India','2026-12-05');
