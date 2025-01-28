package bronze3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class N3009 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<Integer> xSet = new HashSet<>();
        Set<Integer> ySet = new HashSet<>();

        int xNum = 0;
        int yNum = 0;
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (!xSet.add(x)) {
                xNum = x;
            }

            if (!ySet.add(y)) {
                yNum = y;
            }
        }
        br.close();

        for (int i : xSet) {
            if (i != xNum) {
                bw.write(i + " ");
            }
        }

        for (int i : ySet) {
            if (i != yNum) {
                bw.write(String.valueOf(i));
            }
        }

        bw.flush();
        bw.close();
    }

}
