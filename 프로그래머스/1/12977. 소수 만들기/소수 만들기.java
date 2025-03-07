class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    boolean flg = false;
                    int temp = nums[i] + nums[j] + nums[k];
                    for (int l = 2; l <= Math.sqrt(temp); l++) {
                        if (temp % l == 0) {
                            flg = true;
                            break;
                        }
                    }
                    if (!flg) {
                        answer++;
                    }
                }
            }
        }

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println(answer);

        return answer;
    }
}