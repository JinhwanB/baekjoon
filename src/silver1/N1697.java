package silver1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 숨바꼭질
public class N1697 {

    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 수빈이의 위치
        int k = Integer.parseInt(st.nextToken()); // 동생의 위치
        br.close();

        if (n == k) {
            bw.write(0 + "");
            bw.flush();
            bw.close();
            return;
        }

        int[] arr = new int[100001];
        boolean[] checked = new boolean[100001];
        checked[n] = true;

        Queue<Integer> q = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        q.offer(n);
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur - 1 >= 0 && !checked[cur - 1]) {
                q.offer(cur - 1);
                checked[cur - 1] = true;
                arr[cur - 1] = arr[cur] + 1;
                min = cur - 1 == k ? Math.min(min, arr[cur - 1]) : min;
            }

            if (cur + 1 < arr.length && !checked[cur + 1]) {
                q.offer(cur + 1);
                checked[cur + 1] = true;
                arr[cur + 1] = arr[cur] + 1;
                min = cur + 1 == k ? Math.min(min, arr[cur + 1]) : min;
            }

            if (cur * 2 < arr.length && !checked[cur * 2]) {
                q.offer(cur * 2);
                checked[cur * 2] = true;
                arr[cur * 2] = arr[cur] + 1;
                min = cur * 2 == k ? Math.min(min, arr[cur * 2]) : min;
            }
        }

        bw.write(min + "");
        bw.flush();
        bw.close();
    }
}
