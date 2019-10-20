DROP procedure IF EXISTS `getUnansweredQuestions`;
DELIMITER $$
CREATE PROCEDURE `getUnansweredQuestions`()
begin
  select q.id,q.text,q.module,max(q.ans_number) as ans_number
  from(select question.text,question.id,question.module,count(answer.id) as ans_number,sum(correct_answer)as cor_number from question left join answer on question.id=answer.question group by question.id)as q
  where q.cor_number=0 
  group by module;
  
end$$

DELIMITER ;
call getUnansweredQuestions();

DROP procedure IF EXISTS `endorsedUsersForWeek`;
DELIMITER $$
CREATE PROCEDURE `endorsedUsersForWeek` (IN start DATE, IN end DATE)
BEGIN
  select p.id as user,p.firstname as firstname,p.ans_number from
  (select count(cor_ans.aid) as ans_number,user.* from user join (
  select answer.id as aid, question.id as qid,answer.posted_by from question left join answer on question.id = answer.question where question.posted_on between start and end and correct_answer=1)as cor_ans on user.id=cor_ans.posted_by order by ans_number limit 5)as p
   order by p.firstname;
END$$
DELIMITER ;