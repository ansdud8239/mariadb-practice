-- select 기본!

select * from departments;
select dept_no,dept_name  from departments order by dept_no;

/** 프로젝션 (projection) **/
-- 예제 1 : employees 테이블에서 직원의 이름,  성별, 입사일을 출력
SELECT first_name, gender, hire_date FROM employees;

/** as(alias, 생략가능) **/
-- 예제 : employees 테이블에서 직원의 이름,  성별, 입사일을 출력
SELECT first_name AS '이름', gender AS '성별', hire_date AS '입사일' FROM employees;

SELECT concat(first_name ,' ', last_name) AS '이름', gender AS '성별', hire_date AS '입사일' FROM employees;

/** distinct **/
-- 예제 1:  titles 테이블에서 모든 직급의 이름 출력
select title from titles;
-- 예제 2: titles 테이블에서 직급은 어떤 것들이 있는지 직급이름을 한 번씩만 출력
select distinct (title) from titles;

/** where절 **/
-- 예제 1: 비교 연산자 :  employees 테이블에서 1991년 이전에 입사한 직원의 이름, 성별, 입사일을 출력
select first_name,gender,hire_date from employees where hire_date < '1991-01-01' order by hire_date desc;

-- 예제 2: 논리 연산자 employees 테이블에서 1989년 이전에 입사한 여직원의 이름,입사일을 출력
select first_name,gender,hire_date from employees where hire_date < '1989-01-01' and gender='f' order by hire_date desc;

-- 예제 3: in 연산자 : dept_emp 테이블에서 부서 번호가 d005나 d009에 속한 사원의 사번, 부서번호 출력
select emp_no,dept_no from dept_emp where dept_no = 'd005' or dept_no = 'doo9';
select emp_no,dept_no from dept_emp where dept_no in('d005','doo9');

-- 예제 4 : Like 검색 :  employees 테이블에서 1989년에 입사한 직원의 이름, 입사일을 출력  
select first_name,hire_date from employees where '1989-01-01' <= hire_date <= '1989-12-31';
select first_name,hire_date from employees where hire_date between '1989-01-01' and '1989-12-31';
select first_name,hire_date from employees where hire_date like '1989%';

/** order by **/
-- 예제 1 : employees 테이블에서 직원의 전체이름,  성별, 입사일을  입사일 순으로 출력
select concat(first_name,' ',last_name) as '전체 이름' ,gender as '성별',hire_date as '입사일' from employees order by hire_date asc;

-- 예제 2 : salaries 테이블에서 2001년 월급을 가장 높은순으로 사번, 월급순으로 출력
select emp_no,salary from salaries where from_date like '2001%' or  to_date like '2001%' order by salary desc;

-- 예제 3 :  남자 직원의 이름,성별 입사일을 입사일순(선임순)으로 출력
select first_name as '이름',gender as '성별',hire_date as '입사일' from employees where gender='m' order by 입사일;

-- 에제 4 : 직원들의 사번 월급을 사번(asc) , 월급은 (desc) 
select emp_no,salary ,from_date,to_date from salaries order by emp_no asc,salary desc; 





