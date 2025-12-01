package gold3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 소수의 연속합
public class N1644 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n;
    static boolean[] isPrime;
    static List<Integer> sosuList;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        br.close();

        makePrime();

        int s = 0;
        int e = 0;
        int sum = 0;
        int cnt = 0;

        while (s <= e && e < sosuList.size()) {
            if (sum < n) {
                sum += sosuList.get(e++);
                continue;
            }

            if (sum == n) {
                cnt++;
            }

            sum -= sosuList.get(s++);
        }

        bw.write(cnt + "");
        bw.flush();
        bw.close();
    }

    private static void makePrime() {
        isPrime = new boolean[n + 1];
        sosuList = new ArrayList<>();
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (isPrime[i]) {
                sosuList.add(i);
            }
        }

        sosuList.add(0);
    }
}
