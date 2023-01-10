-- Inner join

-- 예제 1 : 현재, 근무하고 있는 직원의 이름과 직책을 모두 출력하세요
select a.first_name,b.title from employees a , titles b 
where a.emp_no=b.emp_no  -- join 조건(n-1)
and b.to_date='9999-01-01';  -- row선택 조건
select * from employees a join titles b on a.emp_no=b.emp_no where b.to_date='9999-01-01';

-- 예제 2 : 현재, 근무하고 있는 직원의 이름과 직책을 출력하되 여성 엔지니어(Engineer)만 출력하세요
select a.first_name, a.gender, b.title from employees a , titles b where a.emp_no=b.emp_no and a.gender = 'f' and b.to_date='9999-01-01' and b.title='Engineer'; 
select a.first_name, a.gender, b.title from employees a join titles b on a.emp_no=b.emp_no where a.gender = 'f' and b.to_date='9999-01-01' and b.title='Engineer'; 

-- ANSI/ISO SQL1999 JOIN 표준 문법

-- 1) Natural Join
-- 조인 대상이 되는 두 테이블에 이름이 같은 공통 컬럼이 있으면 조인 조건을 
-- 명시하지 않고 암묵적으로 조인이 된다. 
select a.first_name,b.title from employees a natural join titles b where b.to_date='9999-01-01';

-- 2) join ~ using
-- 공통인 컬럼이 여러개 있는경우 원하는 컬럼으로 join 할때 using(컬럼명) 으로 표시
select count(*) from salaries a join titles b using(emp_no) where a.to_date = '9999-01-01' and b.to_date='9999-01-01';

-- 3) join ~ on *** 
select a.first_name,b.title from employees a join titles b on a.emp_no=b.emp_no where b.to_date='9999-01-01';
-- 예제 : 현재,직책별 평균 연봉을 큰 순서대로 출력하세요
select b.title,avg(a.salary) avg_salary from salaries a join titles b on a.emp_no = b.emp_no where a.to_date='9999-01-01' and b.to_date = '9999-01-01' group by title order by avg_salary desc;

-- 실습 문제 1 : 현재, 직원별 근무 부서를 사번,직원 이름, 부서명으로 출력하세요.
-- 부서 departments
select b.emp_no, c.first_name, a.dept_name from departments a 
join dept_emp b on a. dept_no = b.dept_no 
join employees c on b.emp_no = c.emp_no 
where b.to_date='9999-01-01' 
group by b.emp_no;

-- 실습 문제 2 : 현재, 지급되고 있는 급여를 출력하세요
-- 사번, 이름, 급여 순으로 출력
select a.emp_no,a.first_name,b.salary from employees a 
join salaries b on a.emp_no=b.emp_no 
where b.to_date='9999-01-01';

-- 실습 문제 3 : 현재, 직책별 평균 연봉,직원 수를 구하되 직책별 직원수가 100명 이상인 직책만 출력하세요
-- 직책, 평균연봉, 직원 수 순으로 출력
-- 직책 : titles
-- 연봉 : salaries
select b.title,avg(a.salary),count(*) count from salaries a 
join titles b on a.emp_no = b.emp_no 
where a.to_date='9999-01-01' and b.to_date='9999-01-01' 
group by b.title
having count>=100;

-- 실습 문제 4 : 현재, 부서별로 직책이 Engineer인 직원들에 대해서만 평균 급여를 구하세요.
-- 부서이름, 평균급여 순으로 출력 
-- 부서 departments
-- 급여 : salaries
-- 직책 : titles
select a.dept_name,avg(d.salary) avg_salary from departments a 
join dept_emp b on a.dept_no = b.dept_no
join titles c on b.emp_no = c.emp_no 
join salaries d on c.emp_no = d.emp_no 
where b.to_date='9999-01-01' and c.to_date='9999-01-01' and d.to_date='9999-01-01' and c.title='Engineer' 
group by a.dept_name;





