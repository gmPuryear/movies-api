# # 1. go get the json file from glitch
# # 2. copypasta into a new json file under /resources
#
# # --> You may need to establish a connection to your localhost db here
#
# 3. create the movies_db
CREATE DATABASE IF NOT EXISTS movies_db;
#
# # 4. use the movies_db
USE movies_db;
#
#
# # 5. drop the table(s) to which no other tables are dependent (none at first)
DROP TABLE IF EXISTS movies;
DROP TABLE IF EXISTS directors;


#
# # 6. map the json movie properties to movies table columns
# # --> start with just a movies table with all the columns found in the movie json properties
#
CREATE TABLE IF NOT EXISTS directors
(
    id   INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(120)
);

CREATE TABLE IF NOT EXISTS movies
(
    id          INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title       VARCHAR(120),
    rating      CHAR(1),
    year        CHAR(4),
    poster      TEXT,
    plot        TEXT,
    director_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (director_id) REFERENCES directors (id)
);
#
#
# 6a. Run the script to make sure it works
DESCRIBE movies;
DESCRIBE directors;

# 7. refactor to extract the directors to a new table with just an id and name
# --> change the movies table to reference the directors table via Foreign Key
# --> now that movies is dependent on directors, you need to move directors above movies in the script

# 8. Go add DROP IF EXIST statements for movies and directors

# 9. RUN IT!

CREATE TABLE IF NOT EXISTS genres
(
    id   INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)
);

DESCRIBE genres;

create table if not exists movie_genre
(
    movie_id int unsigned not null,
    genre_id int unsigned not null,
    foreign key (movie_id) references movies (id),
    foreign key (genre_id) references genres (id)
);

describe movie_genre;

create table if not exists actors
(
    id   int unsigned not null auto_increment primary key,
    actor varchar(255)
);

describe actors;

create table if not exists movie_actor
(
    movie_id int unsigned not null,
    actor_id int unsigned not null,
    foreign key (movie_id) references movies (id),
    foreign key (actor_id) references actors (id)
);

describe movie_actor;

# ----- Adding genres to genres  Table -----
INSERT INTO genres (name)
VALUES ('action'),
       ('drama'),
       ('fantasy'),
       ('history'),
       ('horror'),
       ('romance'),
       ('sci-fi'),
       ('war'),
       ('comedy');

# ----- Adding Directors to directors Table -----
INSERT INTO directors (name)
VALUES ('roger christian'),
       ('quentin tarantino'),
       ('guy ritchie'),
       ('lexi alexander');

# ----- Adding Actors to actors Table -----
INSERT INTO actors(name)
VALUES ('Elijah Wood'),
       ('Charlie Hunnam'),
       ('Claire Forlani'),
       ('John Travolta'),
       ('Uma Thurman'),
       ('Samuel L. Jackson'),
       ('Jason Statham'),
       ('Brad Pitt'),
       ('Stephen Graham'),
       ('Forest Whitaker'),
       ('Barry Pepper');


# ----- Adding Movies to movies Table -----
Insert Into movies (title, rating, year, director_id, plot)
VALUES ('pulp fiction', 5, '1994', 8,'The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.'),
       ('snatch', 5, '2000', 9,'Unscrupulous boxing promoters, violent bookmakers, a Russian gangster, incompetent amateur robbers and supposedly Jewish jewelers fight to track down a priceless stolen diamond.'),
       ('green street hooligans', 5, '2005', 10,'A wrongfully expelled Harvard undergrad moves to London, where he is introduced to the violent underworld of football hooliganism.'),
       ('battlefield earth', '1', '2000', 7,'It''s the year 3000 A.D., and the Earth is lost to the alien race of Psychlos. Humanity is enslaved by these gold-thirsty tyrants, who are unaware that their ''man-animals'' are about to ignite the rebellion of a lifetime.')

# ----- Matching movie ids with their genres -----
INSERT INTO movie_genre (movie_id, genre_id)
VALUES (2, 1),
       (2, 2),
       (3, 1),
       (3, 5),
       (4, 1),
       (4, 3),
       (5, 1);

# ----- Matching movie ids with their actors -----
INSERT INTO movie_actor (movie_id, actor_id)
VALUES (2, 5),
       (2, 6),
       (2, 4),
       (5, 4),
       (3, 7),
       (3, 8),
       (3, 9),
       (4, 1),
       (4, 2),
       (4, 3),
       (5, 10),
       (5, 11);


