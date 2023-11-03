import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static int n;
    public static String[] str1;

    public static void numsScan() {
        Scanner scanner = new Scanner(System.in);
        n = Integer.parseInt(scanner.nextLine());
        String str2;
        str2 = scanner.nextLine();
        str1 = str2.split(" ");
        scanner.close();
    }

    public static void checkClean(int n, String[] str1) {
        if (str1.length < 1 || str1.length > 100000) {
            System.out.println("N's length is worng");
            return;
        }
        int result = -1;

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();
        Stack<Integer> stack4 = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (stack1.empty() || stack1.peek() < Integer.parseInt(str1[i])) {
                stack1.push(Integer.parseInt(str1[i]));
            } else if (stack2.empty() || stack2.peek() < Integer.parseInt(str1[i])) {
                stack2.push(Integer.parseInt(str1[i]));
            } else if (stack3.empty() || stack3.peek() < Integer.parseInt(str1[i])) {
                stack3.push(Integer.parseInt(str1[i]));
            } else if (stack4.empty() || stack4.peek() < Integer.parseInt(str1[i])) {
                stack4.push(Integer.parseInt(str1[i]));
            } else {
                result = 0;
            }
        }

        if (result == 0) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }

    }

    public static void main(String[] args) {
        numsScan();
        checkClean(n, str1);
    }
}