-- HR_EMPLOYEES 사번, 성명, 부서 ID, 직책, 이메일, 전화번호, 입사일, 연봉
-- HR_GRADE 사번, 연도, 반기, 평가 점수
SELECT G.SCORE, G.EMP_NO, E.EMP_NAME, E.POSITION, E.EMAIL
FROM (SELECT EMP_NO, SUM(SCORE) AS SCORE
FROM HR_GRADE
GROUP BY EMP_NO) AS G
INNER JOIN HR_EMPLOYEES E ON G.EMP_NO = E.EMP_NO
ORDER BY G.SCORE DESC
LIMIT 1;