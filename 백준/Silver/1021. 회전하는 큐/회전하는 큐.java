import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static int N;
    public static int M;
    public static int[] arr;

    public static void Scan() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        if (N > 50 || N <= 0) {
            System.out.println("N의 값을 잘못 입력하였습니다.");
            return;
        }
        M = scanner.nextInt();
        if (M > N || M < 1) {
            System.out.println("M의 값을 잘못 입력하였습니다.");
            return;
        }
        arr = new int[M];

        IntStream.range(0, M).forEach(i -> arr[i] = scanner.nextInt());
        scanner.close();
    }

    public static void TurningQueue(int N, int M, int[] arr) {
        LinkedList<Integer> queue = new LinkedList();

        IntStream.range(1, N + 1).forEach(x -> queue.add(x));
        int result = 0;
        int count2 = 0;
        int count3 = 0;

        for (int i = 0; i < M; i++) {
            int idx = queue.indexOf(arr[i]);
            int halfIdx = 0;

            if (queue.size() % 2 == 0) {
                halfIdx = queue.size() / 2 - 1;
            } else {
                halfIdx = queue.size() / 2;
            }

            if (idx > halfIdx) {
                for (int j = 0; j < queue.size() - idx; j++) {
                    int data = queue.pollLast();
                    queue.addFirst(data);
                    count3++;
                }
            } else {
                for (int j = 0; j < idx; j++) {
                    int data = queue.pollFirst();
                    queue.addLast(data);
                    count2++;
                }
            }
            queue.pollFirst();
        }

        result = count2 + count3;
        System.out.println(result);
    }

    public static void main(String[] args) {

        Scan();
        TurningQueue(N, M, arr);
    }
}