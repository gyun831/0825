--*******************************
--2017.08.02
--[1]MAJOR_TAB
--[2]SUBJECT_TAB
--[3]MEMBER_TAB
--[4]PROF_TAB
--[5]STUDENT_TAB
--[6]GRADE_TAB
--[7]BOARD_TAB
--*******************************
DROP SEQUENCE STU_N;
CREATE SEQUENCE seq
START WITH 2000
INCREMENT BY 1
NOCACHE
NOCYCLE;

--*****************************
--[1]MAJOR_TAB
--2017.08.02
--MAJOR_ID,TITLE
--*******************************
--DDL
select * from MAJOR;
alter table major add subj_id varchar2(10);
CREATE TABLE Major(
	major_id varchar2(10),
	title varchar2(10),
	PRIMARY KEY(major_id)
);
--DML
INSERT INTO Major(major_id,title)
VALUES('','');

--*****************************
--[2]SUBJECT_TAB
--2017.08.02
--subj_id,title,major_id
--*******************************
--DDL
CREATE TABLE Subject(
	subj_id varchar2(10),
	title varchar2(10),
	major_id varchar2(10),
	PRIMARY KEY(subj_id),
	FOREIGN KEY(major_id) REFERENCES Major(major_id)
	ON DELETE CASCADE
);
--DML
INSERT INTO Subject(subj_id,title,major_id)
VALUES('','','');

--*****************************
--[3]MEMBER_TAB
--2017.08.02
--회원관리 테이블
--member_id,name,password,ssn,regdate,phone,email,major_id,profile
--*******************************
--DDL
select * from MEMBER;
CREATE TABLE Member(
	member_id VARCHAR2(10),
	name VARCHAR2(20),
	password VARCHAR2(10),
	ssn VARCHAR2(15),
	regdate DATE,
	major_id VARCHAR2(10),
	phone VARCHAR2(20),
	email VARCHAR2(20),
	profile VARCHAR2(20),
	PRIMARY KEY(member_id),
	FOREIGN KEY(marjor_id) REFERENCES Major(major_id)
	ON DELETE CASCADE
);

ALTER TABLE member add email varchar2(20);
ALTER TABLE member add phone varchar2(20);
ALTER TABLE member add profile varchar2(20);
ALTER TABLE Member ADD CONSTRAINT member_fk_major FOREIGN KEY (major_id) REFERENCES Major(major_id);

DROP TABLE member;

--DML
INSERT INTO Member(member_id,name,password,ssn,regdate,phone,email,major_id,profile)
values('mankiew','맨큐','1','701201-1234567',SYSDATE,'010-1234-5678','mankiew@test.com','economics','mankiew.jpg');

SELECT * FROM MEMBER;

SELECT count(*) AS COUNT FROM member;


UPDATE MEMBER 
SET ssn='910101-2222222' 
WHERE id='love'

DELETE FROM MEMBER WHERE member_id='';
--*****************************
--[4]PROF TABLE
--2017.08.02
--MEMBER_ID,SALARY
--*******************************
--DDL
CREATE TABLE Prof(
	member_id varchar2(10),
	salary varchar2(10),
	primary key(member_id),
	FOREIGN KEY(member_id) REFERENCES Member(member_id) ON DELETE CASCADE
);
--DML
INSERT INTO PROF(MEMBER_ID,SALARY)
VALUES('','');


--*****************************
--[5]STUDENT_TAB
--2017.08.02
--MEMBER_ID,STU_NO
--*******************************
--DDL
CREATE TABLE Student(
	member_id varchar2(10),
	stu_no varchar2(8),
	primary key(member_id),
	FOREIGN KEY(member_id) REFERENCES Member(member_id) ON DELETE CASCADE
);
DROP TABLE Student;
--DML
INSERT INTO STUDENT(MEMBER_ID,STU_NO)
VALUES('kim','20137008');

--*********************************************
--[6]GRADE_TAB
--2017.08.02
--grade_seq,member_id,subj_id,score,exam_date
--*********************************************
--DDL
CREATE TABLE Grade(
	grade_seq NUMBER,
	score varchar2(3),
	exam_date varchar2(12),
	subj_id varchar2(10),
	member_id varchar2(10),
	PRIMARY KEY(grade_seq),
	FOREIGN KEY(member_id) REFERENCES Member(member_id) ON DELETE CASCADE,
	FOREIGN KEY(subj_id) REFERENCES Subject(subj_id) ON DELETE CASCADE
);
ALTER TABLE Grade
RENAME COLUMN id TO member_id;
DROP TABLE Grade;

--DML
SELECT * FROM GRADE;
INSERT INTO Grade(grade_seq,member_id,subj_id,score,exam_date)
VALUES(seq.nextval,'hong','java','90','2017-03');

--member_id 를 입력하면 평균점수를 반환하는 sql
select avg(score)
from (select distinct
m.member_id id,m.name name,mj.title major,
g.score score,sj.title subject,g.exam_date
from member m, student s,grade g,subject sj,major mj
where m.member_id = s.member_id and m.member_id = g.member_id and sj.major_id = mj.major_id and sj.subj_id = g.subj_id)t
where t.id='hong';

--*****************************
--BOARD TABLE
--2017.08.02
--ARTICLE_SEQ,ID,TITLE,CONTENT,HITCOUNT,REGDATE
--*******************************
--DDL
CREATE TABLE Board(
	article_seq NUMBER,
	id VARCHAR2(10),
	title VARCHAR2(20),
	content VARCHAR2(100),
	hitcount NUMBER,
	regdate DATE,
	PRIMARY KEY(article_seq),
	FOREIGN KEY(id) REFERENCES Member(id)
		ON DELETE CASCADE
);
--DML
INSERT INTO BOARD(ARTICLE_SEQ,ID,TITLE,CONTENT,HITCOUNT,REGDATE)
VALUES(SEQ.nextval,'hong','안녕하세요','어떤 생각이나 일 따위의 내용을 글자로 나타낸 것',0,SYSDATE);
