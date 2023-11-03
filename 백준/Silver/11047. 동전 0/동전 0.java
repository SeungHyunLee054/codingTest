import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void scan() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] coins = new int[N];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        calCoins(K, coins);
    }

    public static void calCoins(int K, int[] coins) {
        int cnt = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            if (coins[i] > K) {
                continue;
            }
            cnt += K / coins[i];
            K %= coins[i];
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) throws IOException {
        scan();
    }
}
