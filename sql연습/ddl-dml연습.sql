drop table member;
create table member(
	no int not null auto_increment,
    email varchar(100) not null,
    password varchar(64) not null,
    name varchar(100) not null,
    department varchar(100),
	primary key(no)
);

desc member;

alter table member add column juminbunho char(13) not null after email;

alter table member drop juminbunho;

alter table member change column department  dept varchar(200) not null;

alter table member add self_intro text;

alter table member drop juminbunho;

-- insert
insert into member values(null,'kickscar@gmail.com',password('1234'),'안대혁','개발팀',null);
select  * from member;

insert into member(no,email,name,dept,password)
values(null,'kickscar2@gmail.com','안대혁','개발팀',password('1234'));
select  * from member;

-- update
update member set email='kicksca3@gmail.com',password=password('5678') where no=2;

-- delete
delete from member where no=2;

-- transaction
-- 1 : 자동 커밋
-- 0 : 커밋을 해줘야 반영 됨
select @@autocommit;
set autocommit=0;

insert into member(no,email,name,dept,password)
values(null,'kickscar5@gmail.com','안대혁5','개발팀5',password('1234'));

commit;






