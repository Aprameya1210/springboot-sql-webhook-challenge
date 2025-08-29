-- PostgreSQL solution
-- Problem: For each employee, count how many employees in the same department are younger (DOB later than theirs).
-- Output: EMP_ID, FIRST_NAME, LAST_NAME, DEPARTMENT_NAME, YOUNGER_EMPLOYEES_COUNT
-- Order: EMP_ID in descending order.

SELECT
  e.emp_id AS EMP_ID,
  e.first_name AS FIRST_NAME,
  e.last_name AS LAST_NAME,
  d.department_name AS DEPARTMENT_NAME,
  (
    SELECT COUNT(*)
    FROM employee e2
    WHERE e2.department = e.department
      AND e2.dob > e.dob
  ) AS YOUNGER_EMPLOYEES_COUNT
FROM employee e
JOIN department d
  ON d.department_id = e.department
ORDER BY e.emp_id DESC;