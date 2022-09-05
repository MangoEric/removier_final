drop table notice;

--테이블 생성
create table notice (
	notice_pk int primary key, --공지사항 PK 
	notice_title varchar2(50) not null, --공지사항 제목
	notice_content varchar2(200) not null,--공지사항 내용
	notice_date date not null--공지사항 등록일
); 


--시퀀스
create sequence notice_seq nocache; 

drop sequence notice_seq;

select * from notice where upper(notice_title) like upper(?);

commit

select * from notice order by notice_pk desc


--인서트
select * from notice

--이벤트공지
insert into notice (notice_pk, notice_title, notice_content, notice_date) 
values (notice_seq.nextval, 
'[9월 리뷰 이벤트]',
'9월 한 달 동안 최다 리뷰를 작성한 회원 중' ||CHR(10)||CHR(10)||
'     추첨을 통해 영화 시사회 초대권을 드립니다!',sysdate);

--점검 공지
insert into notice (notice_pk, notice_title, notice_content, notice_date) 
values (notice_seq.nextval, 
'[시스템 점검 안내]',
'- 작업 일시 : 9월 30일(금) 01:00 ~ 05:00' ||CHR(10)||CHR(10)|| 
'       시스템 점검으로 일시 중단 될 수 있으니 양해 부탁 드립니다.',sysdate);



--테스트
insert into notice (notice_pk, notice_title, notice_content, notice_date) 
values (3, '등록테스트', '내용 등록 테스트입니다.', sysdate);

SELECT notice_seq.CURRVAL FROM DUAL;

SELECT notice_seq.NEXTVAL FROM DUAL; 

insert into notice (notice_pk, notice_title, notice_content, notice_date) 
values (notice_seq.nextval, '등록테스트4', '4내용 등록 테스트입니다.', sysdate);

ALTER SEQUENCE notice_seq INCREMENT BY 1;

update notice 
set notice_content = '수정22 테스트입니다.' 
where notice_pk = 2


select * from customer


