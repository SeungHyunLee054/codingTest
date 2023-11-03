import java.util.Scanner;

public class Main {
    public static int N;
    public static int[] arr;

    static void Scan() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        if (N > 1000000 || N < 1) {
            return;
        }

        arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=scanner.nextInt();
        }
    }

    static void CheckMaxMin(int N, int[] arr) {
        int minVal = arr[0];
        int maxVal = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= maxVal) {
                maxVal = arr[i];
            }

            if (arr[i] <= minVal) {
                minVal = arr[i];
            }
        }

        System.out.println(minVal + " " + maxVal);
    }


    public static void main(String[] args) {
        Scan();
        CheckMaxMin(N, arr);
    }
}