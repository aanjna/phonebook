# phonebook
A simple phone book application with CRUD operations. you can enter in first name, last name, and phone number. You should then be able to perform 4 basic operations: create new entries in your database, read the entries, update entries by editing any of the properties, and delete the entries

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

collections
GET :- 
'curl --location 'localhost:8080/api/v1/phone-book''

POST :- 'curl --location 'localhost:8080/api/v1/phone-book' \
--header 'Content-Type: application/json' \
--data '{
"firstName": "Praveen",
"lastName": "Patel",
"phoneNumber": "9660294530"
}'''

PUT :- 
'curl --location --request PUT 'localhost:8080/api/v1/phone-book/2' \
--header 'Content-Type: application/json' \
--data '{
"firstName": "Rohit",
"lastName": "Sharma",
"phoneNumber": "9669294590"
}''