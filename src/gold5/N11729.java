package gold5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N11729 {

    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        br.close();

        int count = (int) (Math.pow(2, n) - 1);
        bw.write(count + "\n");

        hanoi(n, 1, 2, 3);

        bw.flush();
        bw.close();
    }

    private static void hanoi(int n, int start, int mid, int end) throws IOException {
        if (n == 1) {
            bw.write(start + " " + end + "\n");
            return;
        }

        hanoi(n - 1, start, end, mid);

        bw.write(start + " " + end + "\n");

        hanoi(n - 1, mid, start, end);
    }

}
