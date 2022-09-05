CREATE TABLE removier_USER (
	id NUMBER(3) PRIMARY KEY,
	name varchar2(20) NOT NULL,
	login_id varchar2(100) NOT NULL,
	password varchar2(1000) NOT NULL,
	ROLE number(1) NOT NULL,
	phone varchar2(100) NOT NULL,
	favourite_genre varchar2(100),
	favourite_actor varchar2(100)
);

CREATE SEQUENCE USER_ID_SEQ
increment BY 1
START WITH 1
MINVALUE 1
MAXVALUE 1000
nocycle
nocache;


SELECT * FROM removier_user;

INSERT INTO removier_user VALUES (user_id_seq.nextval,
													  '김영철',
													  'test',
													  '1234',
													  1,
													  '010-9316-1455',
													  '공포',
													  '최동우');

INSERT INTO removier_user VALUES (user_id_seq.nextval,
													  '성준혁',
													  'test1',
													  '1234',
													  1,
													  '010-3349-4187',
													  '멜로',
													  '최동우');

CREATE TABLE movie (
	id number(3) PRIMARY KEY,
	title varchar2(100) NOT NULL,
	genre varchar2(20) NOT NULL,
	plot varchar2(1000) NOT NULL,
	release_date date NOT NULL,
	director varchar2(20) NOT NULL
);



CREATE SEQUENCE MOVIE_ID_SEQ
increment BY 1
START WITH 1
MINVALUE 1
MAXVALUE 1000
nocycle
nocache;

DROP SEQUENCE MOVIE_ID_SEQ

DELETE FROM movie;

INSERT INTO movie VALUES (movie_id_seq.nextval,
										  '괴물',
										  '공포',
										  '무서워',
										  '20220904',
										  '노영록'
);



SELECT * FROM movie;



CREATE TABLE review (
	id number(3) PRIMARY KEY,
	review_stars NUMBER (1) NOT NULL,
	review_content varchar2(1000),
	user_id number(3) REFERENCES removier_user(id),
	user_login_id varchar2(100),
	movie_id number(3) REFERENCES movie(id)
);

DROP TABLE review;
DROP SEQUENCE review_id_seq;

SELECT * FROM review;

CREATE SEQUENCE review_id_seq
increment BY 1
START WITH 1
MINVALUE 1
MAXVALUE 1000
nocycle
nocache;

COMMIT;


select * from review where user_id = 1;






