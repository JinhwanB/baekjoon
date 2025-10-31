package silver2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N2805 {

    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 나무의 수
        int k = Integer.parseInt(st.nextToken()); // 가져가려는 나무 길이
        int[] trees = new int[n];

        int min = 0;
        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, trees[i]);
        }
        br.close();

        while (min < max) {
            int mid = (min + max) / 2;

            long len = 0;
            for (int tree : trees) {
                if (tree > mid) {
                    len += tree - mid;
                }
            }

            if (len >= k) {
                min = mid + 1;
                continue;
            }

            max = mid;
        }

        bw.write(min - 1 + "");
        bw.flush();
        bw.close();
    }
}
