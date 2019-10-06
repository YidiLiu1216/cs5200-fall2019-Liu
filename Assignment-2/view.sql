DROP VIEW IF EXISTS `website_role_and_priviledges`;
DROP VIEW IF EXISTS `page_role_and_priviledges`;
DROP VIEW IF EXISTS `developer_roles_and_privileges`;
DROP VIEW IF EXISTS `developer_info`;
DROP VIEW IF EXISTS `web_info`;

CREATE VIEW `website_role_and_priviledges` AS
SELECT wp.developer,w.id,w.name as website_name,w.visits,w.updated,wr.role,wp.priviledge
FROM(website_role wr JOIN website_priviledge wp ON wp.website_role=wr.id) JOIN website w
WHERE w.id=wp.website;

CREATE VIEW `page_role_and_priviledges` AS
SELECT pp.developer,p.id,p.website,p.title as page_title,p.updated,p.views as page_views,pr.role,pp.priviledge
FROM(page_role pr JOIN page_priviledge pp ON pp.page_role=pr.id) JOIN page p
WHERE p.id=pp.page;

CREATE VIEW `developer_info` AS
SELECT d.id,p.firstname,p.lastname,p.username,p.email
FROM (developer d JOIN person p ON p.id=d.id)
WHERE p.id=d.id;

CREATE VIEW `web_info` AS
SELECT w.developer as developer_id,w.id as website_id, w.website_name,w.updated as web_updated,w.visits as web_visits,w.role as web_role,w.priviledge as web_priviledge,
p.id as page_id,p.page_title,p.updated as page_updated,p.page_views,p.role as page_role,p.priviledge as page_priviledge 
FROM website_role_and_priviledges as w JOIN page_role_and_priviledges as p
WHERE w.id=p.website AND w.developer=p.developer;

CREATE VIEW `developer_roles_and_privileges` AS
SELECT i.firstname,i.lastname,i.username,i.email,w.*
FROM web_info as w JOIN developer_info as i
WHERE i.id=w.developer_id
ORDER BY developer_id;


