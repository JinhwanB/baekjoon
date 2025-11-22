package gold1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 최종 순위
public class N3665 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int[] indegree;
    static boolean[][] checked;
    static int n;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine()); // 테스트케이스 수

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine()); // 팀 수
            indegree = new int[n + 1];
            checked = new boolean[n + 1][n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                indegree[num] = j;

                for (int k = 1; k <= n; k++) {
                    if (k != num && !checked[k][num]) {
                        checked[num][k] = true;
                    }
                }
            }

            int m = Integer.parseInt(br.readLine()); // 상대적인 등수가 바뀐 쌍의 수

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                swap(a, b);
            }

            String result = topologicalSort();
            bw.write(result + "\n");
        }
        br.close();

        bw.flush();
        bw.close();
    }

    private static String topologicalSort() {
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        for (int i = 1; i <= n; i++) {
            if (q.isEmpty()) {
                return "IMPOSSIBLE";
            }

            if (q.size() > 1) {
                return "?";
            }

            int cur = q.poll();
            sb.append(cur).append(" ");

            for (int j = 1; j <= n; j++) {
                if (checked[cur][j]) {
                    checked[cur][j] = false;

                    if (--indegree[j] == 0) {
                        q.offer(j);
                    }
                }
            }
        }

        return sb.toString();
    }

    private static void swap(int a, int b) {
        if (!checked[a][b]) {
            checked[a][b] = true;
            checked[b][a] = false;
            indegree[a]--;
            indegree[b]++;
        } else {
            checked[a][b] = false;
            checked[b][a] = true;
            indegree[a]++;
            indegree[b]--;
        }
    }
}
