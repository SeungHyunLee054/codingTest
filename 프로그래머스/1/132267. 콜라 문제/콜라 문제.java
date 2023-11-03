class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
    
        int Fbottle = b;

        if(b >= 1 && a > b && n >=a && n <= 1000000){
            while(n >= a){
                n = (n - a + Fbottle);
                Fbottle = b; 
                answer += Fbottle;
            }
        }
        else{
            return 0;
        }
        return answer;
    }
}