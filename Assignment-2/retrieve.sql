SET SQL_SAFE_UPDATES = 0;
#retrive developers a
SELECT developer.id,person.firstname,person.lastname
FROM developer,person
Where developer.id=person.id;

#retrive developers b
SELECT developer.id,person.firstname,person.lastname
FROM developer,person
Where developer.id=person.id AND developer.id='34';

#retrive developers c
SELECT d.id,person.firstname,person.lastname
FROM (SELECT wr.developer as id,wr.role
FROM website_role as wr,website as w
WHERE w.id=wr.website AND w.name = 'Twitter' )as d JOIN person
WHERE d.role!='owner' AND d.id= person.id;

#retrive developers d
SELECT ex.developer_id,person.firstname,person.lastname
FROM(
SELECT pr.developer as developer_id,pr.role
FROM page_role as pr,page as p
WHERE p.id=pr.page AND p.views<300000) as ex,person
WHERE ex.role='reviewer' AND ex.developer_id=person.id;
#retrive developers e

SELECT ex.id, person.firstname,person.lastname
FROM(
SELECT pp.developer as id
FROM page_priviledge as pp, (SELECT page.id FROM page WHERE page.title='HOME')as p
WHERE pp.priviledge='create' AND pp.page=p.id) as ex,person
WHERE ex.id=person.id;

#retrive websites a
SELECT website.name
FROM website
ORDER BY visits
LIMIT 1;

#retrive websites b
SELECT website.name
FROM website
WHERE website.id=678;

#retrive websites c
SELECT website.name
FROM website,(
SELECT page.website
FROM page,(
SELECT pr.page
FROM (SELECT p.id FROM person as p WHERE p.username='bob')as a, page_role as pr,widget as wg,(SELECT widget.page FROM widget WHERE widget.dtype='youtube')as b
WHERE pr.developer = a.id AND pr.role='reviewer'AND pr.page=b.page GROUP BY page)as ans
WHERE page.id=ans.page) as ans1
WHERE website.id=ans1.website;

#retrive websites d
SELECT website.name FROM(
SELECT wr.website
FROM(SELECT person.id FROM person WHERE person.username='alice')as p,website_role as wr
WHERE wr.developer=p.id AND wr.role='owner')as wr,website
WHERE website.id=wr.website;

#retrive websites e
SELECT website.name FROM(
SELECT wr.website
FROM(SELECT person.id FROM person WHERE person.username='charlie')as p,website_role as wr
WHERE wr.developer=p.id AND wr.role='admin')as wr,website
WHERE website.id=wr.website and website.visits>=6000000;

#retrive pages a
SELECT page.title
FROM page
ORDER BY views DESC 
LIMIT 1;

#retrive pages b
SELECT page.title
FROM page
WHERE page.id=234;

#retrive pages c
SELECT page.title FROM(
SELECT pr.page
FROM(SELECT person.id FROM person WHERE person.username='alice')as p,page_role as pr
WHERE pr.developer=p.id AND pr.role='editor')as pr,page
WHERE page.id=pr.page;

#retrive pages d
SELECT SUM(page.views) as total_views
FROM (SELECT website.id FROM website Where website.name='CNET')as w, page
WHERE page.website=w.id;

#retrive pages e
SELECT AVG(page.views) as avg_views
FROM (SELECT website.id FROM website Where website.name='Wikipedia')as w, page
WHERE page.website=w.id;

#retrive widgets a
SELECT widget.id, widget.name
FROM widget,(
SELECT page.id 
FROM (SELECT website.id FROM website WHERE website.name='CNET')as w,page 
WHERE page.title='Home' AND page.website=w.id) as p
WHERE widget.page=p.id;

#retrive widgets b
SELECT widget.id, widget.name
FROM widget,(
SELECT page.id 
FROM (SELECT website.id FROM website WHERE website.name='CNN')as w,page 
WHERE page.website=w.id) as p
WHERE widget.page=p.id AND widget.dtype='youtube';

#retrive widgets c
SELECT widget.id, widget.name
FROM widget,(
SELECT page.id FROM(
SELECT pr.page
FROM(SELECT person.id FROM person WHERE person.username='alice')as p,page_role as pr
WHERE pr.developer=p.id AND pr.role='reviewer')as pr,page
WHERE page.id=pr.page) as p
WHERE widget.page=p.id AND widget.dtype='image';

#retrive widgets d
SELECT COUNT(widget.id) as widget_in_wiki
FROM widget,(
SELECT page.id 
FROM (SELECT website.id FROM website WHERE website.name='Wikipedia')as w,page 
WHERE page.website=w.id) as p
WHERE widget.page=p.id;

#5 a
SELECT website.name
FROM(
SELECT wp.website
FROM (SELECT person.id FROM person WHERE person.username='bob')as p,website_priviledge as wp
WHERE wp.developer=p.id AND wp.priviledge='delete') as wp, website
WHERE website.id=wp.website;

#5 b
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

END$$
DELIMITER ;

call u2();






