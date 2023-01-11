-- subquery

-- 1) select 절,insert values(...) 절

-- 2) from 절
select a.n,a.r from (select now() as n,sysdate() as s,3+1 as r from dual) a;

-- 3) where(having)절
-- 예제 : 현재, Fai Bale이 근무하는 부서에서 근무하는 다른 직원의 사번,이름을 출력하세요
select b.dept_no from employees a 
join dept_emp b on a.emp_no = b.emp_no 
where b.to_date='9999-01-01' and concat(a.first_name,' ',a.last_name) = 'Fai Bale';
-- 'd004'
select a.emp_no,a.first_name from employees a 
join dept_emp b on a.emp_no = b.emp_no 
where b.to_date='9999-01-01' and b.dept_no = 'd004';

select a.emp_no,a.first_name from employees a 
join dept_emp b on a.emp_no = b.emp_no 
where b.to_date='9999-01-01' and b.dept_no = ( 
 select b.dept_no from employees a 
 join dept_emp b on a.emp_no = b.emp_no 
 where b.to_date='9999-01-01' and concat(a.first_name,' ',a.last_name) = 'Fai Bale'
 );
 
-- 3-1) 단일행 연산자 : =,>,<,>=,<=,<>,!=
-- 실습문제 1 :
-- 현재, 전체 사원의 평균 연봉보다 적은 급여를 받는 사원의 이름과 급여를 출력하세요
select a.first_name,b.salary from employees a 
join salaries b on a.emp_no = b.emp_no 
where b.to_date='9999-01-01' and b.salary < (select avg(salary) from salaries where to_date='9999-01-01') 
order by salary desc;
  
-- 실습문제 2 :
-- 현재, 가장 적은 평균 급여의 직책과 그 평균 급여를 출력

-- 직책별 평균급여 리스트
select b.title, avg(a.salary) as 'avg_salary' from salaries a 
join titles b on a.emp_no = b.emp_no 
where a.to_date='9999-01-01' and b.to_date='9999-01-01' 
group by b.title 
order by avg_salary;

-- 가장 적은 평균 급여  
select min(s.avg_salary) as avg_salary from 
(select b.title, avg(a.salary) as 'avg_salary' from salaries a 
join titles b on a.emp_no = b.emp_no 
where a.to_date='9999-01-01' and b.to_date='9999-01-01' 
group by b.title) s;
 
 -- sol1
select b.title, avg(a.salary) as 'avg_salary' from salaries a 
join titles b on a.emp_no = b.emp_no 
where a.to_date='9999-01-01' and b.to_date='9999-01-01' 
group by b.title 
having avg_salary = (select min(s.avg_salary) as avg_salary from 
						(select b.title, avg(a.salary) as 'avg_salary' from salaries a 
						join titles b on a.emp_no = b.emp_no 
						where a.to_date='9999-01-01' and b.to_date='9999-01-01' 
						group by b.title) s);
 
-- sol2
select b.title, avg(a.salary) as 'avg_salary' from salaries a 
join titles b on a.emp_no = b.emp_no 
where a.to_date='9999-01-01' and b.to_date='9999-01-01' 
group by b.title 
order by avg_salary 
limit 1;

-- 3-2) 복수행 연산자 : in, not in,any비교 연산자, all 비교 연산자
-- any 사용법
-- 1. =any : in
-- 2. >any, >=any: 최소값
-- 3. <any, ,<=any: 최대값
-- 4. <>any,!=any:not in

-- all 사용법
-- 1. =all:(x)
-- 2. >all,>=all : 최대값
-- 3. <all,<=all : 최소값
-- 4. <>all,!=all : 

-- 실습문제 3: 
-- 현재 급여가 5000 이상인 직원의 이름과 급여를 출력하세요
-- 둘리 6000
-- 또치 8000

-- sol1) join
select a.first_name,b.salary from employees a , salaries b 
where a.emp_no = b.emp_no and b.to_date='9999-01-01' and b.salary > 5000 
order by b.salary asc;

-- sol2) subquery
select emp_no, salary from salaries where to_date = '9999-01-01' and salary > 50000;

-- sol3)
select a.first_name,b.salary from employees a 
join salaries b on a.emp_no = b.emp_no 
where b.to_date='9999-01-01' and (a.emp_no,b.salary) in
					(select emp_no, salary from salaries where to_date = '9999-01-01' and salary > 50000)
order by b.salary asc;
 
-- 실습문제 4 : 현재, 각 부서별 최고 급여를 받고 있는 직원의 이름과 월급을 출력하세요

-- 부서별 최고 급여 리스트
select dept_no,max(salary) 'max_salary' from salaries a 
join dept_emp b on a.emp_no = b.emp_no 
where a.to_date='9999-01-01' and b.to_date='9999-01-01'
group by dept_no;

-- sol1 ) where 절 
select b.dept_no,a.first_name,c.salary from employees a 
join dept_emp b on a.emp_no = b.emp_no
join salaries c on b.emp_no = c.emp_no
where b.to_date = '9999-01-01'
and (b.dept_no,c.salary) in (select dept_no,max(salary) 'max_salary' from salaries a 
							join dept_emp b on a.emp_no = b.emp_no 
							where a.to_date='9999-01-01' and b.to_date='9999-01-01'
							group by dept_no)
order by dept_no;

-- join 절
select b.dept_no,a.first_name,c.salary from employees a 
join dept_emp b on a.emp_no = b.emp_no
join salaries c on b.emp_no = c.emp_no
join (select dept_no,max(salary) 'max_salary' from salaries a 
	join dept_emp b on a.emp_no = b.emp_no 
	where a.to_date='9999-01-01' and b.to_date='9999-01-01'
	group by dept_no) d on b.dept_no = d.dept_no
where b.to_date = '9999-01-01' and c.salary = d.max_salary
order by dept_no;
 
 
 