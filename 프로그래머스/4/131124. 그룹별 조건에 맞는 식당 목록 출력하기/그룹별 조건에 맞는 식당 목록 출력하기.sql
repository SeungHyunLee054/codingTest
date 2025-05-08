-- 코드를 입력하세요
SELECT m.MEMBER_NAME, r.REVIEW_TEXT, date_format(r.REVIEW_DATE, '%Y-%m-%d') as REVIEW_DATE
from MEMBER_PROFILE m
join REST_REVIEW r on m.MEMBER_ID = r.MEMBER_ID
where m.MEMBER_NAME = (select MEMBER_NAME
                        from MEMBER_PROFILE m
                        join REST_REVIEW r on m.MEMBER_ID = r.MEMBER_ID 
                        group by MEMBER_NAME
                        order by count(r.REVIEW_ID) desc
                        limit 1)
order by REVIEW_DATE, r.REVIEW_TEXT
;