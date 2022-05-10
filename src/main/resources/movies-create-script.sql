# 1. go get the json file from glitch
# 2. copypasta into a new json file under /resources

# --> You may need to establish a connection to your localhost db here

# 3. create the movies_db
CREATE DATABASE IF NOT EXISTS movies_db;

# 4. use the movies_db
USE movies_db;


# 5. drop the table(s) to which no other tables are dependent (none at first)
DROP TABLE IF EXISTS movie_genre;
DROP TABLE IF EXISTS movies_actor;
DROP TABLE IF EXISTS actors;
DROP TABLE IF EXISTS genres;
DROP TABLE IF EXISTS movies;
DROP TABLE IF EXISTS directors;

# 6. map the json movie properties to movies table columns
# --> start with just a movies table with all the columns found in the movie json properties

CREATE TABLE IF NOT EXISTS directors
(
    id   INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(120),
    PRIMARY KEY (id)

);

CREATE TABLE IF NOT EXISTS movies
(
    id          INT UNSIGNED NOT NULL AUTO_INCREMENT,
    title       VARCHAR(120) NOT NULL,
    year        CHAR(4)      NOT NULL,
    plot        TEXT,
    poster      TEXT,
    rating      CHAR(1),
    director    VARCHAR(120),
    director_id INT UNSIGNED NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (director_id) REFERENCES directors (id)
);


# 6a. Run the script to make sure it works

# DESCRIBE movies;


# 7 ADD A TABLE FOR GENRE AND CREATE A JOIN TABLE BETWEEN MOVIES AND GENRE

CREATE TABLE IF NOT EXISTS genres
(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(32),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS movie_genre(
                                          movie_id INT UNSIGNED NOT NULL,
                                          genre_id INT UNSIGNED NOT NULL,
                                          FOREIGN KEY (movie_id) REFERENCES movies (id),
                                          FOREIGN KEY (genre_id) REFERENCES genres (id)
);

CREATE TABLE IF NOT EXISTS actors(
                                     id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                                     name VARCHAR(255),
                                     PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS movies_actor(
                                           movie_id INT UNSIGNED NOT NULL,
                                           actor_id INT UNSIGNED NOT NULL,
                                           FOREIGN KEY (movie_id) REFERENCES movies(id),
                                           FOREIGN KEY (actor_id) REFERENCES actors(id)
);