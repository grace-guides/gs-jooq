CREATE TABLE IF NOT EXISTS POSTS(
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `title` VARCHAR(60) NOT NULL,
    `content` TEXT NOT NULL
);

INSERT INTO POSTS(title, content) VALUES ('Grace 2022.2.6 released', 'Grace 2022.2.6 released in 2024.6.20');
INSERT INTO POSTS(title, content) VALUES ('Grace 2023.0.0 released', 'Grace 2023.0.0 released in 2024.8.21');
INSERT INTO POSTS(title, content) VALUES ('Grace 2024.0.0 released', 'Grace 2024.0.0 released in 2026.4.1');
INSERT INTO POSTS(title, content) VALUES ('Grace 2024.2.0 released', 'Grace 2024.2.0 released in 2026.11.8');
INSERT INTO POSTS(title, content) VALUES ('Grace 2025.0.0', 'Grace 2025.0.0 is comming');
