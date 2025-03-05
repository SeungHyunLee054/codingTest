class Solution {
    public String solution(int a, int b) {
        String[] dayOfTheWeek = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int[] monthDays = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int days = 0;
        for (int i = 0; i < a; i++) {
            days += monthDays[i];
        }
        days += b + 4;

        return dayOfTheWeek[days % 7];
    }
}