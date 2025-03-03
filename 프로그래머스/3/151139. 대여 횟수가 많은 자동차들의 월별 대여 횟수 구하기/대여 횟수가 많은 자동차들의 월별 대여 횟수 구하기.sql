SELECT MONTH(START_DATE) AS MONTH, CAR_ID, COUNT(*) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE CAR_ID IN 
(SELECT CAR_ID
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE DATE_FORMAT(START_DATE, '%Y-%m') >= '2022-08' AND DATE_FORMAT(START_DATE, '%Y-%m') <= '2022-10'
GROUP BY CAR_ID
HAVING COUNT(CAR_ID) >= 5
ORDER BY CAR_ID)
AND DATE_FORMAT(START_DATE, '%Y-%m') >= '2022-08' AND DATE_FORMAT(START_DATE, '%Y-%m') <= '2022-10'
GROUP BY MONTH, CAR_ID
HAVING COUNT(*) > 0
ORDER BY MONTH, CAR_ID DESC;