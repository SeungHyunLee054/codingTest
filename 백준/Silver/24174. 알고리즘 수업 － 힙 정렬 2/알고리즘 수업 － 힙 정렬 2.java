import java.util.Scanner;

public class Main {
    public static int N;
    public static int K;
    public static int[] A;
    public static int cnt = 0;
    public static boolean flag = false;

    public static void scan() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        if (N < 5 || N > 500000) {
            return;
        }
        K = sc.nextInt();
        sc.nextLine();
        if (K < 1 || K > (int) Math.pow(10, 8)) {
            return;
        }
        A = new int[N + 1];
        A[0] = 0;
        for (int i = 1; i <= N; i++) {
            A[i] = sc.nextInt();
            if (A[i] < 1 || A[i] > (int) Math.pow(10, 9)) {
                return;
            }
        }
    }

    public static void heapSort(int[] A, int N) {
        buildMinHeap(A, N);
        for (int i = N; i >= 2; i--) {
            swap(A, 1, i);
            heapify(A, 1, i - 1);
        }

    }

    public static void buildMinHeap(int[] A, int N) {
        for (int i = N / 2; i >= 1; i--) {
            heapify(A, i, N);
        }
    }

    public static void heapify(int[] A, int K, int N) {
        int left = 2 * K;
        int right = 2 * K + 1;
        int smaller = 0;
        if (right <= N) {
            smaller = A[left] < A[right] ? left : right;
        } else if (left <= N) {
            smaller = left;
        } else {
            return;
        }

        if (A[smaller] < A[K]) {
            swap(A, K, smaller);
            heapify(A, smaller, N);
        }
    }

    public static void swap(int[] A, int a, int b) {
        cnt++;
        int c = A[a];
        A[a] = A[b];
        A[b] = c;
        if (cnt == K) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < A.length; i++) {
                sb.append(A[i]);
                sb.append(" ");
            }
            System.out.println(sb.toString());
            flag = true;
        }
    }

    public static void main(String[] args) {
        scan();
        heapSort(A, N);
        if (!flag) {
            System.out.println(-1);
        }
    }
}