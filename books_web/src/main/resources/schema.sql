DROP TABLE IF EXISTS AUTHORS;
CREATE TABLE AUTHORS(
    ID SERIAL PRIMARY KEY,
    NAME VARCHAR(255)
);

DROP TABLE IF EXISTS GENRES;
CREATE TABLE GENRES(
     ID SERIAL PRIMARY KEY,
     NAME VARCHAR(255)
);

DROP TABLE IF EXISTS BOOKS;
CREATE TABLE BOOKS(
   ID SERIAL PRIMARY KEY,
   AUTHOR_ID INT REFERENCES AUTHORS(ID),
   GENRE_ID INT REFERENCES GENRES,
   NAME VARCHAR(255)
);

DROP TABLE IF EXISTS COMMENTS;
CREATE TABLE COMMENTS
(
    ID      SERIAL PRIMARY KEY,
    BOOK_ID INT REFERENCES BOOKS (ID),
    TEXT    VARCHAR(255)
);

DROP TABLE IF EXISTS USER;
CREATE TABLE USER(
    ID SERIAL PRIMARY KEY,
    USERNAME VARCHAR(50),
    PASSWORD VARCHAR(50)
);

