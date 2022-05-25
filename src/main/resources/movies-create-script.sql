# # 1. go get the json file from glitch
# # 2. copypasta into a new json file under /resources
#
# # --> You may need to establish a connection to your localhost db here
#
DROP DATABASE IF EXISTS movies_db;
# 3. create the movies_db
CREATE DATABASE movies_db;
# # 4. use the movies_db
USE movies_db;
#
#
# # 5. drop the table(s) to which no other tables are dependent (none at first)
DROP TABLE IF EXISTS movies, movie_actor, movie_genre;


#
# # 6. map the json movie properties to movies table columns
# # --> start with just a movies table with all the columns found in the movie json properties
#
CREATE TABLE IF NOT EXISTS directors
(
    id INT NOT NULL,
    director varchar(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS movies
(
    id       INT          NOT NULL,
    title    varchar(255) NOT NULL,
    actors   varchar(255),
    rating   INT,
    year     INT          NOT NULL,
    genre    varchar(255),
    plot     varchar(255),
    poster   varchar(255),
    director varchar(255)
)
#
#
# 6a. Run the script to make sure it works


# 7. refactor to extract the directors to a new table with just an id and name
# --> change the movies table to reference the directors table via Foreign Key
# --> now that movies is dependent on directors, you need to move directors above movies in the script

# 8. Go add DROP IF EXIST statements for movies and directors

# 9. RUN IT!


# ----- Adding genres to genres  Table -----

# ----- Adding Directors to directors Table -----


# ----- Adding Actors to actors Table -----



# ----- Adding Movies to movies Table -----


# ----- Matching movie ids with their genres -----


# ----- Matching movie ids with their actors -----







