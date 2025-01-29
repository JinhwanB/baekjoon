package bronze3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N9063 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int maxY = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minX = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            maxY = Math.max(maxY, y);
            minY = Math.min(minY, y);
            maxX = Math.max(maxX, x);
            minX = Math.min(minX, x);
        }
        br.close();

        int squareY = maxY - minY < 0 ? (maxY - minY) * -1 : (maxY - minY);
        int squareX = maxX - minX < 0 ? (maxX - minX) * -1 : (maxX - minX);
        int result = squareY * squareX;

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

}
