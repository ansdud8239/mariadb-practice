-- 서브쿼리(SUBQUERY) SQL 문제입니다.

-- 문제1.
-- 현재 평균 급여보다 많은 월급을 받는 직원은 몇 명이나 있습니까?
select avg(salary) from salaries where to_date='9999-01-01';
select count(*) from salaries 
where salary > (select avg(salary) from salaries where to_date='9999-01-01') and to_date='9999-01-01' order by salary;

-- 문제2. 
-- 현재, 각 부서별로 최고의 급여를 받는 사원의 사번, 이름, 급여를 조회하세요. 
-- 단 조회결과는 급여의 내림차순으로 정렬되어 나타나야 합니다. 

-- 부서별 최고 급여를 받는 사원의 dept_no,salary,emp_no
select b.dept_no,max(a.salary),b.emp_no from salaries a
join dept_emp b on a.emp_no = b.emp_no 
where a.to_date='9999-01-01' and b.to_date='9999-01-01' 
group by b.dept_no;

-- sol)
select a.emp_no,a.first_name,b.max_salary from employees a 
join (select b.dept_no,max(a.salary) 'max_salary',b.emp_no from salaries a
		join dept_emp b on a.emp_no = b.emp_no 
		where a.to_date='9999-01-01' and b.to_date='9999-01-01' 
		group by b.dept_no) b on a.emp_no = b.emp_no
order by b.max_salary desc;

-- 문제3.
-- 현재, 자신의 부서 평균 급여보다 급여(salary)가 많은 사원의 사번, 이름과 급여를 조회하세요 
select b.dept_no,avg(a.salary) from salaries a 
join dept_emp b on a.emp_no = b.emp_no 
where a.to_date='9999-01-01' and b.to_date='9999-01-01'
group by b.dept_no;

select a.emp_no,a.first_name,b.salary from employees a
join salaries b on a.emp_no = b.emp_no
join dept_emp c on b.emp_no = c.emp_no
join (select b.dept_no,avg(a.salary) 'avg_salary' from salaries a 
	join dept_emp b on a.emp_no = b.emp_no 
	where a.to_date='9999-01-01' and b.to_date='9999-01-01'
	group by b.dept_no) d on d.dept_no = c.dept_no
where b.to_date='9999-01-01' and c.to_date='9999-01-01'
and d.avg_salary < b.salary;

-- 문제4.
-- 현재, 사원들의 사번, 이름, 매니저 이름, 부서 이름으로 출력해 보세요.
-- 자신의 dept_no와 dept_manager의 dept_no가 같으면 dept_manager의 emp_no가 자신의 매니저 임. 
-- 매니저 이름을 구하려면 employees에서 dept_manager의 emp_no로 조회
-- 현재 메니저
select * from dept_manager where to_date='9999-01-01';
-- 현재 매니저 이름
select a.first_name, a.emp_no, b.dept_no from employees a 
join (select * from dept_manager where to_date='9999-01-01') b on a.emp_no=b.emp_no;

-- sol)
select a.emp_no,a.first_name,d.manager_name,c.dept_name from employees a
join dept_emp b on a.emp_no = b.emp_no
join departments c on b.dept_no = c.dept_no
join (select a.first_name 'manager_name', a.emp_no, b.dept_no from employees a 
		join (select * from dept_manager where to_date='9999-01-01') b on a.emp_no=b.emp_no) d on b.dept_no=d.dept_no
where b.to_date='9999-01-01';

-- 문제5.
-- 현재, 평균급여가 가장 높은 부서의 사원들의 사번, 이름, 직책, 급여를 조회하고 급여 순으로 출력하세요.
-- 부서별 가장 높은 평균 급여가
select max(a.avg_salary) from (select avg(salary) 'avg_salary',b.dept_no from salaries a 
							join dept_emp b on a.emp_no = b.emp_no 
							where a.to_date='9999-01-01' and b.to_date='9999-01-01'
							group by b.dept_no) a;
 
 -- 평균 급여가 가장 높은 부서의 dept_no와 급여                           
select b.dept_no from salaries a 
join dept_emp b on a.emp_no = b.emp_no 
where a.to_date='9999-01-01' and b.to_date='9999-01-01'
group by b.dept_no
having avg(salary) = (select max(a.avg_salary) from (select avg(salary) 'avg_salary',b.dept_no from salaries a 
							join dept_emp b on a.emp_no = b.emp_no 
							where a.to_date='9999-01-01' and b.to_date='9999-01-01'
							group by b.dept_no) a);

-- 사원들의 사번, 이름, 직책, 급여를 조회하고 급여 순으로 출력하
select a.emp_no,a.first_name,b.title,c.salary from employees a
join titles b on a.emp_no = b.emp_no
join salaries c on b.emp_no = c.emp_no
join dept_emp d on c.emp_no = d.emp_no
where b.to_date='9999-01-01' and c.to_date='9999-01-01'
and d.dept_no = (select b.dept_no from salaries a 
				join dept_emp b on a.emp_no = b.emp_no 
				where a.to_date='9999-01-01' and b.to_date='9999-01-01'
				group by b.dept_no
				having avg(salary) = (select max(a.avg_salary) from (select avg(salary) 'avg_salary',b.dept_no from salaries a 
											join dept_emp b on a.emp_no = b.emp_no 
											where a.to_date='9999-01-01' and b.to_date='9999-01-01'
											group by b.dept_no) a))
order by c.salary desc;

-- 문제6.
-- 평균 급여가 가장 높은 부서는? 
-- 부서별 평균 급여
select c.dept_name,avg(a.salary) from salaries a 
join dept_emp b on a.emp_no=b.emp_no
join departments c on b.dept_no = c.dept_no
group by b.dept_no;
 
-- sol)
select c.dept_name,avg(a.salary) 'avg_salary' from salaries a 
join dept_emp b on a.emp_no=b.emp_no
join departments c on b.dept_no = c.dept_no
group by b.dept_no
having avg_salary = (select max(a.avg_salary ) from 
						(select c.dept_name,avg(a.salary) 'avg_salary' from salaries a 
						join dept_emp b on a.emp_no=b.emp_no
						join departments c on b.dept_no = c.dept_no
						group by b.dept_no) a);

-- 문제7.
-- 평균 급여가 가장 높은 직책?
-- 직책 별 평균 급여
select  b.title,avg(a.salary) 'avg_salary' from salaries a 
join titles b on a.emp_no=b.emp_no 
group by b.title;

select  b.title,avg(a.salary) 'avg_salary' from salaries a 
join titles b on a.emp_no=b.emp_no 
group by b.title
having avg_salary = (select max(a.avg_salary) from 
						(select b.title,avg(a.salary) 'avg_salary' from salaries a 
						join titles b on a.emp_no=b.emp_no 
						group by b.title) a);

-- 문제8.
-- 현재 자신의 매니저보다 높은 급여를 받고 있는 직원은?
-- 부서이름, 사원이름, 급여, 매니저 이름, 메니저 급여 순으로 출력합니다.
-- 매니저 이름, 매니저 급여
select a.dept_no,a.emp_no,b.salary,c.first_name from dept_manager a
join salaries b on a.emp_no = b.emp_no
join employees c on a.emp_no = c.emp_no
where a.to_date='9999-01-01' and b.to_date='9999-01-01';

select a.first_name,c.dept_name,d.salary,e.first_name,e.salary from employees a
join dept_emp b on a.emp_no = b.emp_no
join departments c on b.dept_no = c.dept_no
join salaries d on a.emp_no = d.emp_no
join (select a.dept_no,a.emp_no,b.salary,c.first_name from dept_manager a
	join salaries b on a.emp_no = b.emp_no
    join employees c on a.emp_no = c.emp_no
	where a.to_date='9999-01-01' and b.to_date='9999-01-01') e on b.dept_no = e.dept_no
where b.to_date = '9999-01-01' and d.to_date='9999-01-01'
and d.salary > e.salary;

