package gold3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

// 별자리 만들기
public class N4386 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine()); // 별의 개수
        Star[] stars = new Star[n];
        List<Matrix> list = new ArrayList<>();
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            stars[i] = new Star(x, y);
        }

        br.close();

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                list.add(new Matrix(i, j, getDist(stars[i], stars[j])));
            }
        }

        list.sort(Comparator.comparingDouble(x -> x.c));

        double answer = 0.0;

        for (Matrix matrix : list) {
            if(find(matrix.x) == find(matrix.y)){
                continue;
            }

            union(matrix.x, matrix.y);
            answer += matrix.c;
        }

        bw.write(String.format("%.2f", answer));
        bw.flush();
        bw.close();
    }

    // 각 별의 거리 구하기
    private static double getDist(Star s1, Star s2) {
        return Math.sqrt(Math.pow(Math.abs(s2.x - s1.x), 2) + Math.pow(Math.abs(s2.y - s1.y), 2));
    }

    private static int find(int x){
        if(parent[x] == x){
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    private static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a != b){
            if(a < b){
                parent[b] = a;

                return;
            }

            parent[a] = b;
        }
    }

    private static class Star {

        double x, y;

        public Star(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class Matrix {

        int x, y;
        double c;

        public Matrix(int x, int y, double c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }
}
