-- 코드를 입력하세요
SELECT u.USER_ID, u.NICKNAME, concat(u.CITY, ' ', u.STREET_ADDRESS1, ' ', u.STREET_ADDRESS2) as '전체주소'
, concat(substr(u.TLNO, 1, 3), '-', substr(u.TLNO, 4, 4), '-', substr(u.TLNO, 8, 4)) as 전화번호
from USED_GOODS_USER u
join USED_GOODS_BOARD b
on u.USER_ID = b.WRITER_ID
group by u.USER_ID
having count(b.STATUS = 'DONE') >= 3
order by u.USER_ID desc
;