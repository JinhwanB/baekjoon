package gold3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

// 최소비용 구하기 2
public class N11779 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n, m;
    static List<List<int[]>> bus;
    static int[] dist, route;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine()); // 도시의 개수
        m = Integer.parseInt(br.readLine()); // 버스의 개수
        bus = new ArrayList<>();
        dist = new int[n + 1];
        route = new int[n + 1];
        visited = new boolean[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i <= n; i++) {
            bus.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            bus.get(a).add(new int[]{b, c});
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken()); // 출발점
        int e = Integer.parseInt(st.nextToken()); // 도착점
        br.close();

        solve(s);

        bw.write(dist[e] + "\n");

        Stack<Integer> stack = new Stack<>();
        stack.push(e);
        int num = e;

        while (num != s) {
            int prev = route[num];
            stack.push(prev);
            num = prev;
        }

        bw.write(stack.size() + "\n");

        while (!stack.isEmpty()) {
            bw.write(stack.pop() + " ");
        }

        bw.flush();
        bw.close();
    }

    private static void solve(int s) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.add(new int[]{s, 0});
        dist[s] = 0;
        route[s] = 0;

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int now = poll[0];

            if (visited[now]) {
                continue;
            }

            visited[now] = true;

            for (int[] road : bus.get(now)) {
                int next = road[0];
                int nextCost = road[1];

                if (dist[next] > dist[now] + nextCost) {
                    dist[next] = dist[now] + nextCost;
                    pq.offer(new int[]{next, dist[next]});
                    route[next] = now;
                }
            }
        }
    }
}
