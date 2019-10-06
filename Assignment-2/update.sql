SET SQL_SAFE_UPDATES = 0;
#1.
UPDATE phone 
SET phone = '333-444-5555' 
WHERE person=(SELECT person.id FROM person WHERE person.username='charlie') AND phone.primary=1;

#2.
DROP procedure IF EXISTS `u2`;
DELIMITER $$
CREATE PROCEDURE `u2` ()
BEGIN
declare r varchar(45);
declare i varchar(45);
SELECT w.name INTO r From (
SELECT widget.name,widget.order
FROM(SELECT widget.page,widget.order FROM widget WHERE widget.name='head345')as w,widget
WHERE widget.page=w.page)as w 
WHERE w.order=3;

SELECT widget.order INTO i FROM widget WHERE widget.name='head345';

IF r !='' then
   Update widget
   SET widget.order=i
   WHERE widget.name=r;
   
   Update widget
   SET widget.order='3'
   WHERE widget.name='head345';
else
   Update widget
   SET widget.order='3'
   WHERE widget.name='head345';
END IF;

END$$;
DELIMITER ;

call u2();

#3
DROP procedure IF EXISTS `u3`;
DELIMITER $$
CREATE PROCEDURE `u3` ()
begin
  declare identify int;
  declare i int;
  declare a int;
  declare mid int;
  declare pt varchar(45);
  set i=0;
  
  SELECT count(page.id) into identify
  FROM (SELECT website.id FROM website Where website.name='CNET')as w, page
  WHERE page.website=w.id; 
  
  while i<identify do
  set a=i+1;
  
  SELECT p.id into mid
  FROM (SELECT website.id FROM website Where website.name='CNET')as w, page as p
  WHERE p.website=w.id limit i,a;
  
  SELECT p.title into pt
  FROM (SELECT website.id FROM website Where website.name='CNET')as w, page as p
  WHERE p.website=w.id limit i,a;
  
  update page
  set title=concat('CNET-',pt)
  WHERE page.id=mid;
     
  set i=i+1;
  end while;

end$$
DELIMITER ;
call u3();

#4
DROP procedure IF EXISTS `u4`;
DELIMITER $$
CREATE PROCEDURE `u4` ()
begin
  declare crole varchar(45);
  declare brole varchar(45);
  declare pid int;
  declare cid int;
  declare bid int;
  declare identify int;
  
  SELECT page.id into pid
  FROM (SELECT website.id FROM website Where website.name='CNET')as w, page
  WHERE page.website=w.id and page.title='Home'; 
  
  SELECT person.id into cid FROM person WHERE person.username='charlie';
  SELECT person.id into bid FROM person WHERE person.username='bob';
  
  select pr.role into crole from page_role as pr where pr.page=pid and pr.developer=cid;
  select pr.role into brole from page_role as pr where pr.page=pid and pr.developer=bid;
  
  update page_role
  set page_role.role=brole
  WHERE page_role.developer=cid and page_role.page=pid;
  
  update page_role
  set page_role.role=crole
  WHERE page_role.developer=bid and page_role.page=pid;
     
 
end$$
DELIMITER ;
call u4();


