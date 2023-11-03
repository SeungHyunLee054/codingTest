import java.util.Scanner;

public class Main {
    public static int N;
    public static int[] name;

    public static void scan() {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        name = new int[N];
        for (int i = 0; i < N; i++) {
            name[i] = Integer.parseInt(sc.nextLine());
        }
    }

    public static void intimacy(int N, int[] name) {
        int[] one = new int[20];
        long answer = 0L;

        for (int i = 0; i < N; i++) {
            int idx = 0;
            int tmp = 0;
            while (name[i] != 0) {
                tmp = name[i] % 2;
                name[i] = name[i] / 2;
                if (tmp == 1) {
                    one[idx]++;
                }
                idx++;
            }
        }

        for (int i = 0; i < 20; i++) {
            answer += (1L << i) * one[i] * (N - one[i]);
        }
        System.out.println(answer);
    }

    public static void main(String[] args) {
        scan();
        intimacy(N, name);
    }
}