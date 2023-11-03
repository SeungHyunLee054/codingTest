import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static int N;
    public static int K;

    public static void scan() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        if (1 > K || N < K || N > 5000) {
            return;
        }
    }

    public static void josephusProblem(int N, int K) {
        Queue queue = new LinkedList();
        ArrayList result = new ArrayList<>();

        IntStream.range(1, N + 1).forEach(x -> queue.add(x));

        int cnt = 0;

        while (!queue.isEmpty()) {
            int data = (int) queue.remove();
            cnt += 1;
            if (cnt % K == 0) {
                result.add(data);
            } else {
                queue.add(data);
            }
        }

        System.out.println(result.toString().replace("[", "<").replace("]", ">"));
    }

    public static void main(String[] args) {
        scan();
        josephusProblem(N, K);
    }
}