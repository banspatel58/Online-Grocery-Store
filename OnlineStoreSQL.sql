
CREATE DATABASE onlinestore;

USE onlinestore;

CREATE TABLE Customer (
Customer_ID INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
FirstName VARCHAR(30) NOT NULL,
LastName VARCHAR(30) NOT NULL,
UserName VARCHAR(50) NOT NULL,
Password VARCHAR(50) NOT NULL
);

SHOW TABLES;

SELECT * FROM Customer;

INSERT INTO Customer VALUES (1,"sam","reddy","sreddy","sr1234");
INSERT INTO Customer VALUES (2,"Katie","McBell","Katiebell","Katie1234");
INSERT INTO Customer VALUES (3,"Natasha","Paul","Natspaul","Nats0000");

CREATE TABLE Admin (
Admin_ID INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
FirstName VARCHAR(30) NOT NULL,
LastName VARCHAR(30) NOT NULL,
UserName VARCHAR(50) NOT NULL,
Password VARCHAR(50) NOT NULL
);

INSERT INTO Admin VALUES (1,"John","Roberts","jroberts","jr1234");
INSERT INTO Admin VALUES (2,"Cidra","James","cijames","cijames1234");
INSERT INTO Admin VALUES (3,"Samantha","Rivera","samriv","sam@247");
INSERT INTO Admin VALUES (4,"Aatushi","Patel","aatushi","patel@24");
 
CREATE TABLE Item (
Item_ID int(6) PRIMARY KEY,
Type VARCHAR(50) NOT NULL,
Description VARCHAR(500) NOT NULL,
Price int,
Quantity int,
Unit VARCHAR(50) NOT NULL);

INSERT INTO Item VALUES (1,"Fruits","Red Apple",2.99,3, "lb");
INSERT INTO Item VALUES (2,"Fruits","Green Apple",4.99,3, "lb");
INSERT INTO Item VALUES (3,"Fruits","Banana",0.79,1, "lb");
INSERT INTO Item VALUES (4,"Dairy","Milk",1.79,1, "gallon");
INSERT INTO Item VALUES (5,"Bakery","White Bread",1.79,1, "unit");

CREATE TABLE Cart (
    Cart_ID int NOT NULL AUTO_INCREMENT,
    Item_ID int,
	Customer_ID int,
    Quantity int,
    PRIMARY KEY (Cart_ID)
);
export CLASSPATH=.:/home/$USER/MYSQL/mysql-connector-java-5.1.46.jar

#DROP DATABASE onlinestore;

#SHOW databases;

