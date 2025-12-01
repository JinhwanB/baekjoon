package gold1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 냅색문제
public class N1450 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n, c, res;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 물건의 수
        c = Integer.parseInt(st.nextToken()); // 가방에 넣을 수 있는 최대 무게
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        dfs(0, n / 2 - 1, 0, left);
        dfs(n / 2, n - 1, 0, right);

        Collections.sort(left);
        Collections.sort(right);

        res = 0;
        int e = right.size() - 1;
        for (Integer num : left) {
            while (e >= 0 && num + right.get(e) > c) {
                e--;
            }

            res += e + 1;
        }

        bw.write(res + "");
        bw.flush();
        bw.close();
    }

    private static void dfs(int s, int e, int sum, List<Integer> list) {
        if (sum > c) {
            return;
        }

        if (s > e) {
            list.add(sum);
            return;
        }

        dfs(s + 1, e, sum, list);
        dfs(s + 1, e, sum + arr[s], list);
    }
}
