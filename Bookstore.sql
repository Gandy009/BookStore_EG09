/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.1.62-community : Database - bookstore_1022
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bookstore_1022` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bookstore_1022`;

/*Table structure for table `bs_book` */

DROP TABLE IF EXISTS `bs_book`;

CREATE TABLE `bs_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(120) DEFAULT NULL,
  `author` varchar(120) DEFAULT NULL,
  `price` double(11,2) DEFAULT NULL,
  `sales` int(11) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `img_path` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

/*Data for the table `bs_book` */

insert  into `bs_book`(`id`,`title`,`author`,`price`,`sales`,`stock`,`img_path`) values (15,'三国演义','老罗',20.00,110,90,'/static/img/default.jpg'),(17,'解忧杂货店','东野圭吾',27.20,250,100,'/static/img/default.jpg'),(18,'边城','沈从文',23.00,250,100,'/static/img/default.jpg'),(19,'中国哲学史','冯友兰',44.50,200,150,'/static/img/default.jpg'),(20,'忽然七日',' 劳伦',19.33,100,100,'/static/img/default.jpg'),(21,'苏东坡传','林语堂',19.30,100,100,'/static/img/default.jpg'),(22,'百年孤独','马尔克斯',29.50,100,100,'/static/img/default.jpg'),(23,'扶桑','严歌苓',19.80,100,100,'/static/img/default.jpg'),(24,'教父','马里奥·普佐',29.00,100,100,'/static/img/default.jpg'),(25,'给孩子的诗','北岛',22.20,100,100,'/static/img/default.jpg'),(26,'为奴十二年','所罗门',16.50,100,100,'/static/img/default.jpg'),(27,'平凡的世界','路遥',55.00,100,100,'/static/img/default.jpg'),(28,'悟空传','今何在',14.00,100,100,'/static/img/default.jpg'),(29,'硬派健身','斌卡',31.20,100,100,'/static/img/default.jpg'),(30,'从晚清到民国','唐德刚',39.90,100,100,'/static/img/default.jpg'),(31,'三体','刘慈欣',56.50,100,100,'/static/img/default.jpg'),(32,'看见','柴静',19.50,100,100,'/static/img/default.jpg'),(33,'活着','余华',11.00,100,100,'/static/img/default.jpg'),(34,'小王子','安托万',19.20,100,100,'/static/img/default.jpg'),(35,'我们仨','杨绛',11.30,100,100,'/static/img/default.jpg'),(36,'生命不息,折腾不止','罗永浩',25.20,100,100,'/static/img/default.jpg'),(37,'皮囊','蔡崇达',23.90,100,100,'/static/img/default.jpg'),(38,'恰到好处的幸福','毕淑敏',16.40,100,100,'/static/img/default.jpg'),(39,'艾伦·图灵传','安德鲁',47.20,100,100,'/static/img/default.jpg'),(40,'大数据预测','埃里克',37.20,100,100,'/static/img/default.jpg'),(41,'人月神话','布鲁克斯',55.90,101,99,'/static/img/default.jpg'),(42,'C语言入门经典','霍尔顿',45.00,101,99,'/static/img/default.jpg'),(43,'数学之美','吴军',29.90,100,100,'/static/img/default.jpg'),(44,'Java编程思想','埃史尔',70.50,100,100,'/static/img/default.jpg'),(45,'设计模式之禅','秦小波',20.20,100,100,'/static/img/default.jpg'),(46,'图解机器学习','杉山将',33.80,100,100,'/static/img/default.jpg'),(47,'明朝的那些事1','不知道',16.90,1234,12345,'/static/img/default.jpg');

/*Table structure for table `bs_order` */

DROP TABLE IF EXISTS `bs_order`;

CREATE TABLE `bs_order` (
  `id` varchar(100) NOT NULL,
  `order_time` datetime DEFAULT NULL,
  `total_count` int(11) DEFAULT NULL,
  `total_amount` double(11,2) DEFAULT NULL,
  `state` int(2) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `bs_order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `bs_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `bs_order` */

insert  into `bs_order`(`id`,`order_time`,`total_count`,`total_amount`,`state`,`user_id`) values ('14512997203884','2015-12-28 18:48:40',2,20.00,1,4),('14513134632312','2015-12-28 22:37:43',4,114.70,0,2),('14513143263562','2015-12-28 22:52:06',3,94.70,0,2),('14513923267642','2015-12-29 20:32:06',4,151.10,0,2),('14513933239932','2015-12-29 20:48:43',6,163.20,0,2),('14513940784652','2015-12-29 21:01:18',3,81.60,0,2),('14513989702292','2015-12-29 22:22:50',7,170.50,0,2),('14513992503862','2015-12-29 22:27:30',5,136.00,0,2),('14513994030192','2015-12-29 22:30:03',3,81.60,0,2),('14513995994762','2015-12-29 22:33:19',10,272.00,0,2),('14513997311452','2015-12-29 22:35:31',10,272.00,0,2),('14517445250752','2016-01-02 22:22:05',17,526.50,0,2),('14518094475592','2016-01-03 16:24:07',50,1360.00,0,2),('14518100885892','2016-01-03 16:34:48',50,1150.00,0,2);

/*Table structure for table `bs_order_item` */

DROP TABLE IF EXISTS `bs_order_item`;

CREATE TABLE `bs_order_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `COUNT` int(11) DEFAULT NULL,
  `amount` double(11,2) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `author` varchar(100) DEFAULT NULL,
  `price` double(11,2) DEFAULT NULL,
  `img_path` varchar(200) DEFAULT NULL,
  `order_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  CONSTRAINT `bs_order_item_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `bs_order` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

/*Data for the table `bs_order_item` */

insert  into `bs_order_item`(`id`,`COUNT`,`amount`,`title`,`author`,`price`,`img_path`,`order_id`) values (2,2,10.00,'三国演义','老罗',5.00,'hello','14512997203884'),(3,1,20.00,'三国演义','老罗',20.00,'/static/img/default.jpg','14513134632312'),(4,1,27.20,'解忧杂货店','东野圭吾',27.20,'/static/img/default.jpg','14513134632312'),(5,1,23.00,'边城','沈从文',23.00,'/static/img/default.jpg','14513134632312'),(6,1,44.50,'中国哲学史','冯友兰',44.50,'/static/img/default.jpg','14513134632312'),(7,1,27.20,'解忧杂货店','东野圭吾',27.20,'/static/img/default.jpg','14513143263562'),(8,1,23.00,'边城','沈从文',23.00,'/static/img/default.jpg','14513143263562'),(9,1,44.50,'中国哲学史','冯友兰',44.50,'/static/img/default.jpg','14513143263562'),(10,1,27.20,'解忧杂货店','东野圭吾',27.20,'/static/img/default.jpg','14513923267642'),(11,1,23.00,'边城','沈从文',23.00,'/static/img/default.jpg','14513923267642'),(12,1,45.00,'C语言入门经典','霍尔顿',45.00,'/static/img/default.jpg','14513923267642'),(13,1,55.90,'人月神话','布鲁克斯',55.90,'/static/img/default.jpg','14513923267642'),(14,6,163.20,'解忧杂货店','东野圭吾',27.20,'/static/img/default.jpg','14513933239932'),(15,3,81.60,'解忧杂货店','东野圭吾',27.20,'/static/img/default.jpg','14513940784652'),(16,2,46.00,'边城','沈从文',23.00,'/static/img/default.jpg','14513989702292'),(17,1,44.50,'中国哲学史','冯友兰',44.50,'/static/img/default.jpg','14513989702292'),(18,4,80.00,'三国演义','老罗',20.00,'/static/img/default.jpg','14513989702292'),(19,5,136.00,'解忧杂货店','东野圭吾',27.20,'/static/img/default.jpg','14513992503862'),(20,3,81.60,'解忧杂货店','东野圭吾',27.20,'/static/img/default.jpg','14513994030192'),(21,10,272.00,'解忧杂货店','东野圭吾',27.20,'/static/img/default.jpg','14513995994762'),(22,10,272.00,'解忧杂货店','东野圭吾',27.20,'/static/img/default.jpg','14513997311452'),(23,5,100.00,'三国演义','老罗',20.00,'/static/img/default.jpg','14517445250752'),(24,5,115.00,'边城','沈从文',23.00,'/static/img/default.jpg','14517445250752'),(25,7,311.50,'中国哲学史','冯友兰',44.50,'/static/img/default.jpg','14517445250752'),(26,50,1360.00,'解忧杂货店','东野圭吾',27.20,'/static/img/default.jpg','14518094475592'),(27,50,1150.00,'边城','沈从文',23.00,'/static/img/default.jpg','14518100885892');

/*Table structure for table `bs_user` */

DROP TABLE IF EXISTS `bs_user`;

CREATE TABLE `bs_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(120) NOT NULL,
  `password` varchar(120) DEFAULT NULL,
  `email` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `bs_user` */

insert  into `bs_user`(`id`,`username`,`password`,`email`) values (2,'admin','123123','ad@ad.com'),(3,'sunyongdi','123123','ab@bn.com'),(4,'sunwukong','123456','abv@nn.com'),(7,'hehuixin','920322','ab@nc.com');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
