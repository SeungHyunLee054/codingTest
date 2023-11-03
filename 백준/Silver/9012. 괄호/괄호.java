import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static int T;
    public static String[] s;

    public static void scan() {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        sc.nextLine();
        s = new String[T];
        for (int i = 0; i < T; i++) {
            s[i] = sc.nextLine();
        }
    }

    public static void checkParenthesis(String[] s) {
        Stack stack = new Stack<>();
        boolean checkFlag = true;

        for (int i = 0; i < s.length; i++) {
            for (String s1 : s[i].split("")) {
                if (s1.equals("(")) {
                    stack.push("(");
                } else {
                    if (stack.isEmpty()) {
                        checkFlag = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }

            if (checkFlag && stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            stack.clear();
            checkFlag = true;
        }
    }

    public static void main(String[] args) {
        scan();
        checkParenthesis(s);
    }
}