-- 버전 검색
select version();

-- 테이블을 명시하지 않아도 될때 form dual
-- 대소문자 구분 안함
select version(),current_date,now() from dual;

-- 덧셈도 가능(사칙연산)
select 1+2+3+4 from dual;
select sin(pi()/4); 

-- table 생성
create table pet(
	name varchar(100),
	owner varchar(20),
	species varchar(20),
	gender char(1),
	birth date,
	death date
);

-- schema 확인
desc pet;

-- table 삭제
drop table pet;
show tables;

-- insert : DML(C)
-- 한글 입력 안됨
insert into pet values('메리','조문영','dog','f','2020-12-25',null);

select * from pet;