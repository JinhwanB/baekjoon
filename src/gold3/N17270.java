package gold3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 연예인은 힘들어
public class N17270 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int v, m;
    static int[][] dist;

    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken()); // 약속 장소 후보의 수
        m = Integer.parseInt(st.nextToken()); // 약속 장소를 연결하는 총 길의 수
        dist = new int[v + 1][v + 1];

        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                if (i == j) {
                    dist[i][j] = 0;

                    continue;
                }

                dist[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            dist[a][b] = Math.min(dist[a][b], c);
            dist[b][a] = Math.min(dist[b][a], c);
        }

        st = new StringTokenizer(br.readLine());
        int jh = Integer.parseInt(st.nextToken()); // 지헌이의 위치
        int sh = Integer.parseInt(st.nextToken()); // 성하의 위치
        br.close();

        for (int k = 1; k <= v; k++) {
            for (int i = 1; i <= v; i++) {
                for (int j = 1; j <= v; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        List<Integer> ansList = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= v; i++) {
            if (i == jh || i == sh) {
                continue;
            }

            int jDis = dist[jh][i];
            int sDis = dist[sh][i];

            if (jDis + sDis <= min) {
                if (jDis + sDis == min) {
                    ansList.add(i);
                } else {
                    min = jDis + sDis;
                    ansList.clear();
                    ansList.add(i);
                }
            }
        }

        for (int i = ansList.size() - 1; i >= 0; i--) {
            int place = ansList.get(i);
            int jDis = dist[jh][place];
            int sDis = dist[sh][place];
            if (jDis > sDis) {
                ansList.remove(i);
            }
        }

        ansList.sort((a, b) -> {
            if (dist[a][jh] == dist[b][jh]) {
                return a - b;
            }

            return dist[a][jh] - dist[b][jh];
        });

        if (ansList.isEmpty()) {
            bw.write("-1");
            bw.flush();
            bw.close();
            return;
        }

        bw.write(ansList.get(0) + "");
        bw.flush();
        bw.close();
    }
}
