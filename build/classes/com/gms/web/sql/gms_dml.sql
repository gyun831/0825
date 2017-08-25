--*****************************
--BOARD TABLE
--2017.08.02
--ARTICLE_SEQ,ID,TITLE,CONTENT,HITCOUNT,REGDATE
--*******************************

SELECT * from board;












INSERT INTO STUDENT(MEMBER_ID,STU_NO)
VALUES('kim','20137008');








--*****************************
--조인
--*******************************
select *
from member m ,board b
where m.id=b.id;
order by b.article_seq desc;


select *
from member m, board b, grade g
where m.id=b.id and m.id=g.id;


select name,ssn 
from member m, BOARD b
where m.id=b.id and rownum <= 2





