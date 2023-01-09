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
insert into pet values('메리','조문영','dog','f','2020-12-25',null);

-- select : DML(R)
select * from pet;

-- update : DML(U)
update pet set name='콩' where name='메리';
update pet set death = null where name != 'Bowser';

-- delete : DML(D)
delete from pet where name='콩';

-- load data
load data local infile '' into table pet;

-- 이름이 'Bowser'인
select name,species from pet where name='Bowser';

-- 1998년 이후 태어난
select name,species from pet where birth >= '1998-01-01';

-- 암컷 강아지
select name,species from pet where species = 'dog' and gender ='f';

-- 뱀 또는 새
select name,species from pet where species = 'snake' or species ='bird';

-- 정렬
-- asc : 오름차순(기본값) / desc : 내림차순
select name,birth from pet order by birth desc;

-- 죽은 애완동물
select name,birth,death from pet where death is not null;

-- 이름이 B로 시작하는 애완동물
select name from pet where name like 'B%';

-- 이름이 fi로 끝나는 애완동물
select name from pet where name like '%fy';

-- 이름이 w가 포함되어 있는 애완동물
select name from pet where name like '%w%';

-- 이름이 다섯글자인 애완동물 : _
select name from pet where name like '_____';

-- 이름이 b로 시작하는데 다섯글자인 애완동물 : _
select name from pet where name like 'b____';

-- 애완 동물 전체 수
-- select count(death) from pet; 
-- -> count 함수안에 컬럼을 명시할 경우 해당 컬림이 null이 아닌 갯수
select count(*) from pet;

















