desc user;

insert into user values('null','조문영','010-0000-0000','test@naver.com',sha2('1234',256));

Select * from user;
select * from category;

Select * from book;
select a.no,a.name,b.name,a.price from book a join category b on a.category_no=b.no;
desc cart;
-- insert into book values('null',(select name from book where no=1),(select price from book where no=1),?,?)

select b.name '책 이름',a.count '갯수',b.price '가격',(a.count*b.price) '총 가격'  from cart a join book b on a.book_no = b.no;
select a.no ,b.name '책 이름',a.count '갯수',b.price '가격' from cart a join book b on a.book_no = b.no;
select * from orders;
select * from book_has_orders;
select * from book;