# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* mvn clean install

Run main class MPokketApplication.java

* Data base queries;

* CREATE DATABASE mpokket;
* USE mpokket;
* DROP TABLE IF EXIST phonebook;

* CREATE TABLE phonebook(
  id  SERIAL NOT NULL,
  first_name           TEXT    NOT NULL,
  last_name            TEXT     NOT NULL,
  phone_number        CHAR(10),
  PRIMARY KEY (id)
  );


