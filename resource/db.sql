create table admininfo(
  admin_idn number(12) primary key,
  admin_name varchar2(100) not null,
  admin_id varchar2(50) not null,
  admin_pw varchar2(100) not null,
  role number(10) not null
);


insert into  admininfo values(1,'고종영','wow','1111',0);

select * from admininfo;

drop table admininfo;

commit;

drop table users;

//int id, String name, String logingId,
String password, int role, String phone, String favourite_genre, String favourite_actor

create table users(
  mem_idn number(12) primary key,
  mem_name varchar2(100) not null,
  mem_id varchar2(50) not null,
  mem_pw varchar2(100) not null,
  role number(10) not null,
  mem_contact varchar2(50) not null,
  mem_genre varchar2(100) not null,
  act_idn2 varchar2(100) not null
);

insert into users values(1,'나루토','naruto','1111',1,'010-1111-1111','액션','정우성');
insert into users values(2,'루피','ruffy','1111',1,'010-1511-3111','공포','이정재');
insert into users values(3,'쵸파','chopa','1111',1,'010-1411-1311','응가','김혜수');

select * from users;
commit;


drop table notice;
create table notice(
    notice_idn number(12) primary key,
    notice_title varchar2(500) not null,
    notice_content varchar2(2000) not null,
    notice_date date
);

insert into notice values(1, '<9월의 이벤트>','* 9월 한달동안 최다 리류작성자에게는 리무버가 영화 시사회권을 드립니다!
	* 9월 한달동안 10개 이상의 리뷰를 작성한 회원 중 추첨을 통해 영화 시사회원을 드립니다!',sysdate);
insert into notice values(2, '<공지사항>','* 8월 31일은 3AM ~ 10AM 까지 서버점검입니다.',sysdate);

commit;

update notice set notice_title ='와우', notice_content='예쓰' where notice_idn=0;

select * from notice;