package gold4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

// 가장 긴 증가하는 부분 수열 4
public class N14002 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n;
    static int[] a, dp;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine()); // 수열의 크기
        a = new int[n + 1]; // 수열
        dp = new int[n + 1];
        int result = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    result = Math.max(result, dp[i]);
                }
            }
        }
        br.close();

        bw.write(result + "\n");

        int k = result;
        Stack<Integer> stack = new Stack<>();
        for (int i = n; i >= 1; i--) {
            if (k == dp[i]) {
                stack.push(a[i]);
                k--;
            }
        }

        while (!stack.isEmpty()) {
            bw.write(stack.pop() + " ");
        }

        bw.flush();
        bw.close();
    }
}
