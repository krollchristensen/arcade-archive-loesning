DROP TABLE IF EXISTS arcade_games;

CREATE TABLE arcade_games (
                              id INT AUTO_INCREMENT PRIMARY KEY,
                              title VARCHAR(100) NOT NULL,
                              release_year INT NOT NULL,
                              genre VARCHAR(50) NOT NULL,
                              manufacturer VARCHAR(100) NOT NULL,
                              players INT NOT NULL,
                              active BOOLEAN NOT NULL,
                              image_name VARCHAR(255) NOT NULL
);