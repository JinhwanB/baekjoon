package gold5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 텔레포트 3
public class N12908 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int xs, ys, xe, ye;
    static Node[] node;
    static long[][] dist;

    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        node = new Node[8];
        dist = new long[8][8];

        xs = Integer.parseInt(st.nextToken());
        ys = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        xe = Integer.parseInt(st.nextToken());
        ye = Integer.parseInt(st.nextToken());

        node[0] = new Node(xs, ys);
        node[7] = new Node(xe, ye);

        for (long[] longs : dist) {
            Arrays.fill(longs, INF);
        }

        dist[0][7] = dist[7][0] = Math.abs(xs - xe) + Math.abs(ys - ye);

        for (int i = 1; i < 7; i += 2) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            node[i] = new Node(x1, y1);
            node[i + 1] = new Node(x2, y2);

            dist[i][i + 1] = dist[i + 1][i] = Math.min(Math.abs(node[i].x - node[i + 1].x) + Math.abs(node[i].y - node[i + 1].y), 10);
        }
        br.close();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                dist[i][j] = Math.min(dist[i][j], Math.abs(node[i].x - node[j].x) + Math.abs(node[i].y - node[j].y));
            }
        }

        for (int k = 0; k < 8; k++) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        bw.write(dist[0][7] + "");
        bw.flush();
        bw.close();
    }

    public static class Node {

        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
