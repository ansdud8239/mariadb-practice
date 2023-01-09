-- 날짜 함수

/* curdate(), current_date */
select curdate(),current_date from dual;

/* curtime(), current_time */
select curtime(),current_time from dual;

/* now() vs sysdate() */
select now(),sysdate() from dual;
-- now : 쿼리가 시작할때
-- sysdate() : 함수가 시작할때
select now(),sleep(2),now() from dual;
select now(),sleep(2),sysdate() from dual;

/* date_format */
select date_format(now(),'%Y년 %m월 %d일 %h시 %i분 %s초') from dual;
select date_format(now(),'%d %b \'%y') from dual;

/* peroid_diff */
-- 포맷팅 : YYMM,YYYYMM
-- 개월수를 구할 수 있음
-- 예) 근무개월
select first_name, hire_date ,period_diff(date_format(curdate(),'%y%m'),date_format(hire_date,'%y%m')) as month from employees order by month desc;

/* date_add(=adddate), date_sub(=subdate) */
-- 날짜를 date 타입인 컬럼이나 값에 type(year,.month,day)의 표현식으로 더하거나 뺄 수 있다.
-- (기준이 되는 날짜,interval +숫자 +할 년or월or일)
-- 예) 각 사원들의 근속 년 수가 5년이 되는 날에 휴가를 보내준다면 각 사원의 5년 근속 휴가날짜는?
select first_name,hire_date,date_add(hire_date,interval 5 year) from employees;

/* cast */
select '12345' + 10 ,cast('12345' as int)+10 from dual;
select date_format(cast('2023-01-09' as date),'%Y년 %m월 %d일') from dual;
select cast(cast(1-2 as unsigned) as signed) from dual;
select cast(cast(1-2 as unsigned) as int) from dual;
select cast(cast(1-2 as unsigned) as integer) from dual;

/* type */
-- 문자 : varchar,char,text,CLOB(Character Large OBject)
-- 정수 : medium int,int(signed,integer),unsigned, bit int
-- 실수 : float,double 
-- 시간 : date, datetime
-- LOB : CLOB, BLOB(Binary Large OBject)

