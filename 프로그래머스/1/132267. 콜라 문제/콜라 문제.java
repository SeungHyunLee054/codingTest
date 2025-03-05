class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
    
        int fBottle = b;

        if(b >= 1 && a > b && n >=a && n <= 1000000){
            while(n >= a){
                n = (n - a + fBottle);
                fBottle = b; 
                answer += fBottle;
            }
        }
        else{
            return 0;
        }
        return answer;
    }
}