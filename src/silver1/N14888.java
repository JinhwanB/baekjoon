package silver1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N14888 {

    static BufferedWriter bw;
    static int[] arr;
    static int[] math;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        math = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num == 0) {
                math[i] = -1;
                continue;
            }

            math[i] = num;
        }
        br.close();

        findNum(1, arr[0]);

        bw.write(max + "\n" + min);
        bw.flush();
        bw.close();
    }

    private static void findNum(int idx, int num) {
        if (idx >= arr.length) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for (int i = 0; i < math.length; i++) {
            if (math[i] == -1) {
                continue;
            }

            int result;
            if (math[i] != 0) {
                if (i == 0) {
                    result = num + arr[idx];
                    math[i]--;
                    findNum(idx + 1, result);
                    math[i]++;
                    continue;
                }

                if (i == 1) {
                    result = num - arr[idx];
                    math[i]--;
                    findNum(idx + 1, result);
                    math[i]++;
                    continue;
                }

                if (i == 2) {
                    result = num * arr[idx];
                    math[i]--;
                    findNum(idx + 1, result);
                    math[i]++;
                    continue;
                }

                result = num / arr[idx];
                math[i]--;
                findNum(idx + 1, result);
                math[i]++;
            }
        }
    }

}
