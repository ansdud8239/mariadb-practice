-- 문자열 함수

/* upper */
select upper('busan'),upper('Busan'),upper('BusaN') from dual;
select upper(first_name) from employees;

/* lower */
select lower('busan'),lower('Busan'),lower('BusaN') from dual;
select lower(first_name) from employees;

/* substring */
-- (문자열,index,length)
select substring('Hello World',3,2) from dual;

-- 예제 : employees 테이블에서 1989년에 입사한 직원의 이름, 입사일을 출력  
select first_name,hire_date from employees where substring(hire_date,1,4) = '1989';

/* lpad, rpad*/
-- (문자열,length,채울 문자열)
-- lpad : 채울 문자열을 왼쪽부터 채운다 / rpad : 채울 문자열을 오른쪽부터 채운다
select lpad('1234',10,'-'),rpad('1234',10,'-') from dual;

-- 직원들의 월급을 오른쪽 정렬(빈공간 *)
select lpad(salary,10,'*') from salaries;

/* trim,ltrim,rtrim */
select concat('---',ltrim('     hello     '),'---'),concat('---',rtrim('     hello     '),'---'),concat('---',trim(both 'x' from 'xxxhelloxxx'),'---') from dual;

/* length */
select length('Hello World') from dual;






 