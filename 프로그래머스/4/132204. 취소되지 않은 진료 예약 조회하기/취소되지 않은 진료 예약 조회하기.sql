-- 코드를 입력하세요
SELECT a.APNT_NO, p.PT_NAME, a.PT_NO, a.MCDP_CD, d.DR_NAME, a.APNT_YMD
from APPOINTMENT a
join DOCTOR d
on a.MDDR_ID = d.DR_ID
join PATIENT p
on a.PT_NO = p.PT_NO
where a.APNT_YMD like '2022-04-13%' and a.APNT_CNCL_YMD is null and a.MCDP_CD = 'CS'
order by a.APNT_YMD
;