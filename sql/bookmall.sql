-- user
select * from user;

-- cart
select * from cart;

-- book
select * from book;

-- orders
select * from orders;

-- order_book
select * from order_book;
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

-- auto 
SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = 'orders' AND table_schema = 'bookmall';

