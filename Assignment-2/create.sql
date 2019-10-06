CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `user_agreement` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `user_person_generalization` FOREIGN KEY (`id`) REFERENCES `person` (`id`)
); 
CREATE TABLE `developer` (
  `id` int(11) NOT NULL,
  `developer_key` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `developer_person_generalization` FOREIGN KEY (`id`) REFERENCES `person` (`id`)
); 
CREATE TABLE `website` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `created` date DEFAULT NULL,
  `updated` date DEFAULT NULL,
  `visits` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
); 
CREATE TABLE `page` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `created` date DEFAULT NULL,
  `updated` date DEFAULT NULL,
  `views` int(11) DEFAULT NULL,
  `website` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `website_idx` (`website`),
  CONSTRAINT `website` FOREIGN KEY (`website`) REFERENCES `website` (`id`)
); 
CREATE TABLE `widget` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `width` int(11) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  `cssClass` varchar(45) DEFAULT NULL,
  `cssStyle` varchar(45) DEFAULT NULL,
  `text` varchar(45) DEFAULT NULL,
  `order` varchar(45) DEFAULT NULL,
  `dtype` varchar(45) DEFAULT NULL,
  `page` int(11) DEFAULT NULL,
  `url` varchar(45) DEFAULT NULL,
  `shareble` tinyint(4) DEFAULT NULL,
  `expandable` tinyint(4) DEFAULT NULL,
  `src` varchar(45) DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  `html` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `page_idx` (`page`),
  CONSTRAINT `page` FOREIGN KEY (`page`) REFERENCES `page` (`id`)
); 
CREATE TABLE `role` (
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`role`)
); 
CREATE TABLE `priviledge` (
  `priviledge` varchar(45) NOT NULL,
  PRIMARY KEY (`priviledge`)
);
CREATE TABLE `page_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(45) DEFAULT NULL,
  `developer` int(11) DEFAULT NULL,
  `page` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `page_role_role_idx` (`role`),
  KEY `page_role_developer_idx` (`developer`),
  KEY `page_role_page_idx` (`page`),
  CONSTRAINT `page_role_developer` FOREIGN KEY (`developer`) REFERENCES `developer` (`id`),
  CONSTRAINT `page_role_page` FOREIGN KEY (`page`) REFERENCES `page` (`id`),
  CONSTRAINT `page_role_role` FOREIGN KEY (`role`) REFERENCES `role` (`role`)
); 
CREATE TABLE `page_priviledge` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `priviledge` varchar(45) DEFAULT NULL,
  `developer` int(11) DEFAULT NULL,
  `page` int(11) DEFAULT NULL,
  `page_role` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `page_priviledge_priviledge_idx` (`priviledge`),
  KEY `page_priviledge_page_idx` (`page`),
  KEY `page_priviledge_developer_idx` (`developer`),
  KEY `page_pribiledge_page_role_idx` (`page_role`),
  CONSTRAINT `page_pribiledge_page_role` FOREIGN KEY (`page_role`) REFERENCES `page_role` (`id`),
  CONSTRAINT `page_priviledge_developer` FOREIGN KEY (`developer`) REFERENCES `developer` (`id`),
  CONSTRAINT `page_priviledge_page` FOREIGN KEY (`page`) REFERENCES `page` (`id`),
  CONSTRAINT `page_priviledge_priviledge` FOREIGN KEY (`priviledge`) REFERENCES `priviledge` (`priviledge`)
); 
CREATE TABLE `website_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(45) DEFAULT NULL,
  `website` int(11) DEFAULT NULL,
  `developer` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `role_idx` (`role`),
  KEY `developer_idx` (`developer`),
  KEY `role_website_idx` (`website`),
  CONSTRAINT `role_developer` FOREIGN KEY (`developer`) REFERENCES `developer` (`id`),
  CONSTRAINT `role_website` FOREIGN KEY (`website`) REFERENCES `website` (`id`),
  CONSTRAINT `webiste_role` FOREIGN KEY (`role`) REFERENCES `role` (`role`)
);
CREATE TABLE `website_priviledge` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `priviledge` varchar(45) DEFAULT NULL,
  `developer` int(11) DEFAULT NULL,
  `website` int(11) DEFAULT NULL,
  `website_role` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `website_priviledge_priviledge_idx` (`priviledge`),
  KEY `website_priviledge_developer_idx` (`developer`),
  KEY `website_priviledge_website_idx` (`website`),
  KEY `website_pribiledge_website_role_idx` (`website_role`),
  CONSTRAINT `website_pribiledge_website_role` FOREIGN KEY (`website_role`) REFERENCES `website_role` (`id`),
  CONSTRAINT `website_priviledge_developer` FOREIGN KEY (`developer`) REFERENCES `developer` (`id`),
  CONSTRAINT `website_priviledge_priviledge` FOREIGN KEY (`priviledge`) REFERENCES `priviledge` (`priviledge`),
  CONSTRAINT `website_priviledge_website` FOREIGN KEY (`website`) REFERENCES `website` (`id`)
);
CREATE TABLE `phone` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(45) DEFAULT NULL,
  `primary` tinyint(4) DEFAULT NULL,
  `person` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `phone_person` (`person`),
  CONSTRAINT `phone_person` FOREIGN KEY (`person`) REFERENCES `person` (`id`)
) ;
CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `person` int(11) DEFAULT NULL,
  `street1` varchar(45) DEFAULT NULL,
  `street2` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `zip` varchar(45) DEFAULT NULL,
  `primary` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `address_person_idx` (`person`),
  CONSTRAINT `address_person` FOREIGN KEY (`person`) REFERENCES `person` (`id`)
) ;