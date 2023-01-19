-- user
select * from user;
select no from user where name=?
-- category
select * from category;
-- cart
select * from cart;

-- book
select * from book;

-- orders
select * from orders;
select order_no,name,price,receive from orders where user_no=1;

-- order_book
select * from order_book;
select b.no,b.name,a.count,c.name from order_book a 
join book b on a.book_no=b.no
join orders c on c.no=a.orders_no;

select count(*) from cart where user_no=1;
-- 회원의 cart를 구매했을 경우
insert into order_book values(
(select book_no from cart where user_no=1),
(select last_insert_id() as orders),
(select count from cart where user_no=1 )
);
select book_no from cart where user_no=1;
select last_insert_id() as orders;

-- 회원의 cart 에서 책 가격 구하기
select count*price from cart a join book b on a.book_no=b.no where user_no=1;

-- auto 조회
SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = 'orders' AND table_schema = 'bookmall';

-- auto increment 초기화
ALTER TABLE orders AUTO_INCREMENT =1; 

select concat((date_format(now(),'%Y%m%d')),'-',lpad(1,8,0)) from dual;
