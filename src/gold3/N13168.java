package gold3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// 내일로 여행
public class N13168 {

    static final int INF = 987654321;

    static BufferedReader br;
    static BufferedWriter bw;
    static int n, r, m, k;
    static int[][] dist;
    static int[][] distBuy;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 도시의 수
        r = Integer.parseInt(st.nextToken()); // 1인당 내일로 가격
        dist = new int[n + 1][n + 1];
        distBuy = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    continue;
                }

                dist[i][j] = INF;
                distBuy[i][j] = INF;
            }
        }

        int node = 1;
        HashMap<String, Integer> city = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            String cityName = st.nextToken();
            int existNode = city.getOrDefault(cityName, 0);
            if (existNode == 0) {
                city.put(cityName, node++);
            }
        }

        m = Integer.parseInt(br.readLine()); // 여행할 도시의 수
        int start = 0;
        List<Integer> travel = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            String cityName = st.nextToken();
            travel.add(city.get(cityName));

            if (i == 0) {
                start = travel.get(0);
            }
        }

        Map<String, Integer> trans = new HashMap<>();
        trans.put("Mugunghwa", 0);
        trans.put("ITX-Saemaeul", 0);
        trans.put("ITX-Cheongchun", 0);
        trans.put("S-Train", 1);
        trans.put("V-Train", 1);
        trans.put("Subway", 2);
        trans.put("Bus", 2);
        trans.put("KTX", 2);
        trans.put("Taxi", 2);
        trans.put("Airplane", 2);
        k = Integer.parseInt(br.readLine()); // 교통수단의 수
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int transInt = trans.get(st.nextToken());
            int s = city.get(st.nextToken());
            int e = city.get(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            dist[s][e] = Math.min(dist[s][e], cost * 2);
            dist[e][s] = dist[s][e];

            distBuy[s][e] = Math.min(distBuy[s][e], transInt * cost);
            distBuy[e][s] = distBuy[s][e];
        }
        br.close();

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                if (i == k) {
                    continue;
                }

                for (int j = i + 1; j <= n; j++) {

                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    dist[j][i] = dist[i][j];
                    distBuy[i][j] = Math.min(distBuy[i][j], distBuy[i][k] + distBuy[k][j]);
                    distBuy[j][i] = distBuy[i][j];
                }
            }
        }

        int cur = start;
        int res = 0;
        int resBuy = 0;
        for (int i = 1; i < travel.size() - 1; i++) {
            int next = travel.get(i);

            res += dist[cur][next];
            resBuy += distBuy[cur][next];
        }

        if (resBuy + r * 2 < res) {
            bw.write("Yes");
            bw.flush();
            bw.close();

            return;
        }

        bw.write("No");
        bw.flush();
        bw.close();
    }
}
