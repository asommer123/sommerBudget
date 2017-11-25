-- MySQL dump 10.13  Distrib 5.7.19, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: sommerBudget
-- ------------------------------------------------------
-- Server version	5.7.19-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


--
-- Drop all tables first
--

DROP TABLE IF EXISTS `transaction`;
DROP TABLE IF EXISTS `budgetedSubCategory`;
DROP TABLE IF EXISTS `subCategory`;
DROP TABLE IF EXISTS `category`;
DROP TABLE IF EXISTS `income`;
DROP TABLE IF EXISTS `budgetMonth`;
DROP TABLE IF EXISTS `user_role`;
DROP TABLE IF EXISTS `users`;


--
-- Re-create tables and insert rows
--


--
-- Table structure for table `users`
--


/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (  `account_id` int(11) NOT NULL AUTO_INCREMENT,  `user_name` varchar(15) NOT NULL,  `user_pass` varchar(15) NOT NULL,  `first_name` varchar(25) DEFAULT NULL,  `last_name` varchar(30) DEFAULT NULL,  `email_address` varchar(60) DEFAULT NULL,  PRIMARY KEY (`account_id`)) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
CREATE UNIQUE INDEX users_user_name_uindex ON users (user_name);

create table user_role (  user_role_id    int(11) NOT NULL auto_increment,  user_name       varchar(15) NOT NULL,  role_name       varchar(15) NOT NULL,  PRIMARY KEY (user_role_id),  FOREIGN KEY fk_users(user_name)  REFERENCES users(user_name)    ON DELETE CASCADE    ON UPDATE CASCADE);



--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'testAccount','1234','Test','Account','asommer@madisoncollege.edu'),(2,'secondAccount','1234','My','Name','test@test.com'),(3,'myTest','1234','First','Last','email@email.edu');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;


--
-- Dumping data for table `user_role`
--
LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,'secondAccount','testers'),(2,'testAccount','admins'),(3,'testAccount','testers');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;




--
-- Table structure for table `budgetMonth`
--


/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `budgetMonth` (  `budget_month_id` int(11) NOT NULL AUTO_INCREMENT,  `budget_date` date NOT NULL,  `account_id` int(11) NOT NULL,  PRIMARY KEY (`budget_month_id`),  KEY `fk_users` (`account_id`),  CONSTRAINT `budgetMonth_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `users` (`account_id`) ON DELETE CASCADE ON UPDATE CASCADE) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `budgetMonth`
--

LOCK TABLES `budgetMonth` WRITE;
/*!40000 ALTER TABLE `budgetMonth` DISABLE KEYS */;
INSERT INTO `budgetMonth` VALUES (1,'2017-09-01',1),(2,'2017-10-01',1);
/*!40000 ALTER TABLE `budgetMonth` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `income`
--


/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `income` (  `income_id` int(11) NOT NULL AUTO_INCREMENT,  `pay_date` date DEFAULT NULL,  `pay_amount` decimal(7,2) NOT NULL,  `budget_month_id` int(11) NOT NULL,  PRIMARY KEY (`income_id`),  KEY `fk_budgetMonth` (`budget_month_id`),  CONSTRAINT `income_ibfk_1` FOREIGN KEY (`budget_month_id`) REFERENCES `budgetMonth` (`budget_month_id`) ON DELETE CASCADE ON UPDATE CASCADE) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `income`
--

LOCK TABLES `income` WRITE;
/*!40000 ALTER TABLE `income` DISABLE KEYS */;
INSERT INTO `income` VALUES (1,'2017-08-30',1000.00,1),(2,'2017-09-13',1527.88,1),(3,'2017-09-27',1267.22,2),(4,'2017-10-12',1003.53,2),(5,'2017-10-01',450.00,2);
/*!40000 ALTER TABLE `income` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--


/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (  `category_id` int(11) NOT NULL AUTO_INCREMENT,  `category_name` varchar(60) NOT NULL,  `default_fl` tinyint(1) DEFAULT NULL,  `account_id` int(11) NOT NULL,  PRIMARY KEY (`category_id`),  KEY `fk_account` (`account_id`),  CONSTRAINT `category_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `users` (`account_id`) ON DELETE CASCADE ON UPDATE CASCADE) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Housing',NULL,1),(2,'Utilities',NULL,1),(3,'Food',NULL,1);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;



--
-- Table structure for table `subCategory`
--


/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subCategory` (  `subCategory_id` int(11) NOT NULL AUTO_INCREMENT,  `subCategory_name` varchar(60) NOT NULL,  `default_fl` tinyint(1) DEFAULT NULL,  `day_of_month_due` int(2) DEFAULT NULL,  `category_id` int(11) NOT NULL,  PRIMARY KEY (`subCategory_id`),  KEY `fk_category` (`category_id`),  CONSTRAINT `subCategory_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`) ON DELETE CASCADE ON UPDATE CASCADE) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subCategory`
--

LOCK TABLES `subCategory` WRITE;
/*!40000 ALTER TABLE `subCategory` DISABLE KEYS */;
INSERT INTO `subCategory` VALUES (1,'Mortgage',NULL,1,1),(2,'Electricity',NULL,8,2),(3,'Water',NULL,25,2),(4,'Phone',NULL,5,2),(5,'Internet',NULL,15,2),(6,'Groceries',NULL,NULL,3),(7,'Restaurants',NULL,NULL,3);
/*!40000 ALTER TABLE `subCategory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `budgetedSubCategory`
--


/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `budgetedSubCategory` (  `budgeted_id` int(11) NOT NULL AUTO_INCREMENT,  `budgeted_amount` decimal(7,2) DEFAULT NULL,  `due_date` date DEFAULT NULL,  `envelope_amount` decimal(7,2) DEFAULT NULL,  `note` text,  `subCategory_id` int(11) NOT NULL,  `budget_month_id` int(11) NOT NULL,  PRIMARY KEY (`budgeted_id`),  KEY `fk_subCategory` (`subCategory_id`),  KEY `fk_budetMonth` (`budget_month_id`),  CONSTRAINT `budgetedSubCategory_ibfk_1` FOREIGN KEY (`subCategory_id`) REFERENCES `subCategory` (`subCategory_id`),  CONSTRAINT `budgetedSubCategory_ibfk_2` FOREIGN KEY (`budget_month_id`) REFERENCES `budgetMonth` (`budget_month_id`) ON DELETE CASCADE ON UPDATE CASCADE) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `budgetedSubCategory`
--

LOCK TABLES `budgetedSubCategory` WRITE;
/*!40000 ALTER TABLE `budgetedSubCategory` DISABLE KEYS */;
INSERT INTO `budgetedSubCategory` VALUES (1,650.00,'2017-10-01',NULL,'test note here',1,1),(2,60.00,'2017-09-08',NULL,NULL,2,1),(3,30.00,'2017-09-25',NULL,NULL,3,1),(4,80.00,'2017-09-05',NULL,NULL,4,1),(5,45.00,'2017-09-15',NULL,NULL,5,1),(6,253.94,NULL,225.00,'Keeping some in bank just in case need something and don\'t have the food envelope.',6,1),(7,40.00,NULL,40.00,NULL,7,1);
/*!40000 ALTER TABLE `budgetedSubCategory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--


/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaction` (  `transaction_id` int(11) NOT NULL AUTO_INCREMENT,  `transaction_amount` decimal(7,2) DEFAULT NULL,  `transaction_date` date DEFAULT NULL,  `note` text,  `budgeted_id` int(11) NOT NULL,  PRIMARY KEY (`transaction_id`),  KEY `fk_budgetedSubCategory` (`budgeted_id`),  CONSTRAINT `transaction_ibfk_1` FOREIGN KEY (`budgeted_id`) REFERENCES `budgetedSubCategory` (`budgeted_id`) ON DELETE CASCADE ON UPDATE CASCADE) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` VALUES (1,225.00,'2017-09-01','Taking money out of bank and into envelope',6),(2,40.00,'2017-09-01',NULL,7),(3,64.26,'2017-09-08',NULL,2),(4,78.98,'2017-09-05',NULL,4);
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-09-25 23:19:01
