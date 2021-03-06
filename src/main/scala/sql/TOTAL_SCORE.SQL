SELECT t.HACKER_ID,
       t.NAME,
       SUM(MAX_SCORE) AS TOTAL_SCORE
FROM
(SELECT MAX(S.SCORE) AS MAX_SCORE,
        H.HACKER_ID as HACKER_ID ,
        H.NAME as name
 FROM (HACKERS H INNER JOIN SUBMISSIONS S ON H.HACKER_ID = S.HACKER_ID)
 GROUP BY H.HACKER_ID,H.NAME, s.challenge_id ) as t

GROUP BY t.HACKER_ID,t.NAME
HAVING TOTAL_SCORE > 0
ORDER BY TOTAL_SCORE DESC, t.HACKER_ID ASC