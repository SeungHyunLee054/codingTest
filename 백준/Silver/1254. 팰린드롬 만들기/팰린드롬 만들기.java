import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static String S;

    public static void scan() {
        Scanner sc = new Scanner(System.in);
        S = sc.nextLine();
        if (S.length() > 50 || S.length() <= 0) {
            return;
        }
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) < 'a' || S.charAt(i) > 'z') {
                return;
            }
        }
        
        int result = S.length();
        for (int i = 0; i < S.length(); i++) {
            if (palindrome(S.substring(i))) {
                break;
            }
            result++;
        }
        System.out.println(result);
    }

    public static Boolean palindrome(String S) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            stack.push(String.valueOf(S.charAt(i)));
        }
        Queue<String> queue = new LinkedList<>(stack);

        while (!stack.isEmpty()) {
            if (!queue.poll().equals(stack.pop())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        scan();
        palindrome(S);
    }
}
