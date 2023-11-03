import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main {
    public static int N;
    public static int[] nums;
    public static int v;

    public static void scan() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        v = Integer.parseInt(br.readLine());
    }

    public static void countNum(int N, int[] nums, int v) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for (int i = 0; i < N; i++) {
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }

        if (hm.containsKey(v)){
            System.out.println(hm.get(v));
        }else {
            System.out.println(0);
        }
    }

    public static void main(String[] args) throws IOException {
        scan();
        countNum(N,nums,v);
    }
}