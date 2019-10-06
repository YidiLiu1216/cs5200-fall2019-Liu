#1.
DROP procedure IF EXISTS `d1`;
DELIMITER $$
CREATE PROCEDURE `d1` ()
begin
   declare ad int;
   set ad=0;
   DELETE FROM address WHERE address.person=(select person.id from person where person.username='alice') and address.primary=1;
   select address.id into ad from address where address.person=(select person.id from person where person.username='alice') limit 1;
   update address
   set address.primary = 1
   where address.id=ad;
 
end$$
DELIMITER ;
call d1();


#2.
 DELETE from widget where widget.page=(SELECT page.id FROM page WHERE page.title='Contact') order by widget.order desc limit 1;

#3.
DROP procedure IF EXISTS `d3`;
DELIMITER $$
CREATE PROCEDURE `d3` ()
begin
   declare pid int;
   SELECT page.id into pid FROM page WHERE page.website=(select w.id from website as w where w.name='Wikipedia')order by page.updated desc limit 1;
   delete from page_role where page_role.page = pid;
   delete from widget where widget.page=pid;
   DELETE from page where page.id=pid;
end$$
DELIMITER ;
call d3();

#4.
DROP procedure IF EXISTS `d4`;
DELIMITER $$
CREATE PROCEDURE `d4` ()
begin
   declare wid int;
   declare identify int;
   declare i int;
   declare pid int;
   set i=0;
   
   SELECT count(page.id) into identify
   FROM (SELECT website.id FROM website Where website.name='CNET')as w, page
   WHERE page.website=w.id; 
   
  while i<identify do
  
  SELECT p.id into pid
  FROM (SELECT website.id FROM website Where website.name='CNET')as w, page as p
  WHERE p.website=w.id limit 1;
  delete from page_role where page_role.page = pid;
  delete from widget where widget.page=pid;
  DELETE from page where page.id=pid;
     
  set i=i+1;
  end while;
   
  SELECT website.id into wid FROM website Where website.name='CNET';
  delete from website_role where website_role.website = wid;
  delete from website where website.id=wid;
end$$
DELIMITER ;
call d4();
