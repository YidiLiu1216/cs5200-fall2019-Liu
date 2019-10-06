DELIMITER $$
CREATE DEFINER=`flyingcat`@`%` TRIGGER `page_role_AFTER_INSERT` AFTER INSERT ON `page_role` FOR EACH ROW BEGIN
   DECLARE role_insert varchar(45) DEFAULT new.role;
   DECLARE developer_insert INT DEFAULT new.developer;
   DECLARE page_insert INT DEFAULT new.page;
   DECLARE id_insert INT DEFAULT new.id;
   INSERT INTO `page_priviledge` (`priviledge`,`developer`,`page`,`page_role`) VALUES ('read', developer_insert,page_insert,id_insert);
   IF role_insert!='reviewer' THEN
      INSERT INTO `page_priviledge` (`priviledge`,`developer`,`page`,`page_role`) VALUES ('update', developer_insert,page_insert,id_insert);
      IF role_insert!='editor' THEN
      INSERT INTO `page_priviledge` (`priviledge`,`developer`,`page`,`page_role`) VALUES ('create', developer_insert,page_insert,id_insert);
        IF role_insert!='writer' THEN
        INSERT INTO `page_priviledge` (`priviledge`,`developer`,`page`,`page_role`) VALUES ('delete', developer_insert,page_insert,id_insert);
        END IF;
      END IF;
   END IF;
END$$
DELIMITER ;
DELIMITER $$
CREATE DEFINER=`flyingcat`@`%` TRIGGER `page_role_BEFORE_DELETE` BEFORE DELETE ON `page_role` FOR EACH ROW BEGIN
    DECLARE id_delete INT DEFAULT old.id;
    DELETE FROM `page_priviledge` WHERE page_role=id_delete;
END$$
DELIMITER ;
DELIMITER $$
CREATE DEFINER=`flyingcat`@`%` TRIGGER `page_role_BEFORE_UPDATE` BEFORE UPDATE ON `page_role` FOR EACH ROW BEGIN
    DECLARE id_delete INT DEFAULT old.id;
    DELETE FROM `page_priviledge` WHERE page_role=id_delete;
END$$
DELIMITER ;
DELIMITER $$
CREATE DEFINER=`flyingcat`@`%` TRIGGER `page_role_AFTER_UPDATE` AFTER UPDATE ON `page_role` FOR EACH ROW BEGIN
   DECLARE role_insert varchar(45) DEFAULT new.role;
   DECLARE developer_insert INT DEFAULT new.developer;
   DECLARE page_insert INT DEFAULT new.page;
   DECLARE id_insert INT DEFAULT new.id;
   INSERT INTO `page_priviledge` (`priviledge`,`developer`,`page`,`page_role`) VALUES ('read', developer_insert,page_insert,id_insert);
   IF role_insert!='reviewer' THEN
      INSERT INTO `page_priviledge` (`priviledge`,`developer`,`page`,`page_role`) VALUES ('update', developer_insert,page_insert,id_insert);
      IF role_insert!='editor' THEN
      INSERT INTO `page_priviledge` (`priviledge`,`developer`,`page`,`page_role`) VALUES ('create', developer_insert,page_insert,id_insert);
        IF role_insert!='writer' THEN
        INSERT INTO `page_priviledge` (`priviledge`,`developer`,`page`,`page_role`) VALUES ('delete', developer_insert,page_insert,id_insert);
        END IF;
      END IF;
   END IF;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`flyingcat`@`%` TRIGGER `website_role_AFTER_INSERT` AFTER INSERT ON `website_role` FOR EACH ROW BEGIN
   DECLARE role_insert varchar(45) DEFAULT new.role;
   DECLARE developer_insert INT DEFAULT new.developer;
   DECLARE website_insert INT DEFAULT new.website;
   DECLARE id_insert INT DEFAULT new.id;
   INSERT INTO `website_priviledge` (`priviledge`,`developer`,`website`,`website_role`) VALUES ('read', developer_insert,website_insert,id_insert);
   IF role_insert!='reviewer' THEN
      INSERT INTO `website_priviledge` (`priviledge`,`developer`,`website`,`website_role`) VALUES ('update', developer_insert,website_insert,id_insert);
      IF role_insert!='editor' THEN
      INSERT INTO `website_priviledge` (`priviledge`,`developer`,`website`,`website_role`) VALUES ('create', developer_insert,website_insert,id_insert);
        IF role_insert!='writer' THEN
        INSERT INTO `website_priviledge` (`priviledge`,`developer`,`website`,`website_role`) VALUES ('delete', developer_insert,website_insert,id_insert);
        END IF;
      END IF;
   END IF;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`flyingcat`@`%` TRIGGER `website_role_BEFORE_DELETE` BEFORE DELETE ON `website_role` FOR EACH ROW BEGIN
   DECLARE id_delete INT DEFAULT old.id;
   DELETE FROM `website_priviledge` WHERE website_role=id_delete;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`flyingcat`@`%` TRIGGER `website_role_BEFORE_UPDATE` BEFORE UPDATE ON `website_role` FOR EACH ROW BEGIN
   DECLARE id_delete INT DEFAULT old.id;
   DELETE FROM `website_priviledge` WHERE website_role=id_delete;
END$$
DELIMITER ;
DELIMITER $$
CREATE DEFINER=`flyingcat`@`%` TRIGGER `website_role_AFTER_UPDATE` AFTER UPDATE ON `website_role` FOR EACH ROW BEGIN
   DECLARE role_insert varchar(45) DEFAULT new.role;
   DECLARE developer_insert INT DEFAULT new.developer;
   DECLARE website_insert INT DEFAULT new.website;
   DECLARE id_insert INT DEFAULT new.id;
   INSERT INTO `website_priviledge` (`priviledge`,`developer`,`website`,`website_role`) VALUES ('read', developer_insert,website_insert,id_insert);
   IF role_insert!='reviewer' THEN
      INSERT INTO `website_priviledge` (`priviledge`,`developer`,`website`,`website_role`) VALUES ('update', developer_insert,website_insert,id_insert);
      IF role_insert!='editor' THEN
      INSERT INTO `website_priviledge` (`priviledge`,`developer`,`website`,`website_role`) VALUES ('create', developer_insert,website_insert,id_insert);
        IF role_insert!='writer' THEN
        INSERT INTO `website_priviledge` (`priviledge`,`developer`,`website`,`website_role`) VALUES ('delete', developer_insert,website_insert,id_insert);
        END IF;
      END IF;
   END IF;
END$$
DELIMITER ;
