CREATE TABLE IF NOT EXISTS POSTS(
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `title` VARCHAR(60) NOT NULL,
    `content` TEXT NOT NULL
);

INSERT INTO POSTS(title, content) VALUES ('Grace 2022.2.6 released', 'Grace 2022.2.6 released in 2022.6.20');
INSERT INTO POSTS(title, content) VALUES ('Grace 2023', 'Grace 2023 is comming');
