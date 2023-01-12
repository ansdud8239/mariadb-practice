desc emaillist;

insert into emaillist value(null,'둘','리','dooly@gmail.com');

select no,first_name, list_name,email from emaillist order by no desc;

delete from emaillist where email='dooly@gmail.com';