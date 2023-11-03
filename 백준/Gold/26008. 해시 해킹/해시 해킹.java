import java.util.Scanner;

public class Main {
    public static int N;
    public static int M;
    public static int A;

    public static void Scan() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        A = sc.nextInt();
        if (N < 1 || M < 1 || A < 1 || N > 5000000 || M > 5000000 || A > 5000000) {
            return;
        }
    }

    public static void HashHacking(int N, int M, int A) {
       long answer = 1L;
        for (int i = 0; i < N - 1; i++) {
            answer = (answer * M) % 1000000007;
        }
        System.out.println(answer);
    }


    public static void main(String[] args) {
        Scan();
        HashHacking(N, M, A);
    }
}