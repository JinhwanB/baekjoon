package platinum5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

// 가장 긴 증가하는 부분 수열 5
public class N14003 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n;
    static int[] a, lis, dp;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine()); // 수열의 크기
        a = new int[n];
        dp = new int[n];
        lis = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        lis[0] = -1_000_000_001;
        int len = 0, idx = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] > lis[len]) {
                dp[i] = ++len;
                lis[len] = a[i];
                continue;
            }

            idx = binarySearch(len, a[i]);
            lis[idx] = a[i];
            dp[i] = idx;
        }

        bw.write(len + "\n");

        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            if (dp[i] == len) {
                stack.push(a[i]);
                len--;
            }
        }

        while (!stack.isEmpty()) {
            bw.write(stack.pop() + " ");
        }

        bw.flush();
        bw.close();
    }

    private static int binarySearch(int right, int key) {
        int left = 0;

        while (left < right) {
            int mid = (left + right) / 2;

            if (lis[mid] < key) {
                left = mid + 1;
                continue;
            }

            right = mid;
        }

        return right;
    }
}
