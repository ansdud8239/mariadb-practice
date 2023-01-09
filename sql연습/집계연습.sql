/** 1. 집계쿼리 : select 절에 통계 함수(avg,max,min,count,sum,stddev,varance,...)alter **/
select avg(salary), sum(salary) from salaries;

/** 2. select절에 통계함수가 있는 경우, 어떤 컬럼도 select절에 올 수 없다. **/
-- emp_no는 아무 의미가 없다.
select emp_no, avg(salary) from salaries;

/** 3. query 순서 **/
-- 1) from : 접근 테이블 확인
-- 2) where : 조건에 맞는 row를 선택(임시 테이블)
-- 3) 집계(결과 테이블) 
-- 4) projection 
-- 예제 : 사번이 10060인 사원이 받은 평균 월급은?
select avg(salary) from salaries where emp_no=10060;

/** 4. group by에 참여하고 있는 컬럼은 projection이 가능하다: seelct절에 올 수 있다. **/
-- 예제 : 사원 별 평균 월급은?
select emp_no, avg(salary) from salaries group by emp_no;

/** 5. having **/
-- 집계 결과(결과 테이블)에서 row를 선택해야 하는 경우 
-- 이미 where절은 실행이 되었기 때문에 having절에서 조건을 주어야 한다.
-- 예제 : 평균 월급이 60,000 달러 이상인 사원의 사번과 평균 월급을 출력
-- having 컬럼 이름(함수가 아님)
select emp_no, avg(salary) from salaries group by emp_no having avg(salary) > 60000;

/** 6. order by **/
-- order by는 항상 맨 마지막 출력전에 한다
select emp_no, avg(salary) from salaries group by emp_no having avg(salary) > 60000 order by avg(salary);

-- 주의)
-- 예) 사번이 10060인 사원의 사번, 급여 평균, 급여 총 합을 출력하세요
-- 집계함수를 사용할 경우 group by 절로 그룹을 묶고 where절이 아닌 having절을 사용할것
select emp_no,avg(salary),sum(salary) from salaries group by emp_no having emp_no='10060';










