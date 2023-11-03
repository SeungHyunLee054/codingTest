import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static int N;
    public static ArrayList<Integer>[] list;
    public static boolean[] isVisit;
    public static int[] parent;

    public static void scan() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        if (N < 2 || N > 100000) {
            return;
        }

        list = new ArrayList[N + 1];
        parent = new int[N + 1];
        isVisit = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[a].add(b);
            list[b].add(a);
        }

        dfs(1);

        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }

    public static void dfs(int n) {
        if (isVisit[n]) {
            return;
        }
        isVisit[n] = true;
        for (int item : list[n]) {
            if (!isVisit[item]) {
                parent[item] = n;
                dfs(item);
            }
        }
    }

    public static void main(String[] args) {
        scan();
    }
}