class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int time = 0;
        int hp = health;
        int cnt = 0;
        for (int[] attack : attacks) {
            cnt = attack[0] - time - 1;
            time = attack[0];
            if (hp < health) {
                hp += cnt * bandage[1];
                if (cnt >= bandage[0]) {
                    hp += (cnt / bandage[0]) * bandage[2];
                }
            }

            if (hp > health) {
                hp = health;
            }
            hp -= attack[1];

            if (hp <= 0) {
                return -1;
            }
        }

        return hp;
    }
}