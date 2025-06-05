package gold4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N11054 {

//    수열 S가 어떤 수 Sk를 기준으로 S1 < S2 < ... Sk-1 < Sk > Sk+1 > ... SN-1 > SN을 만족한다면, 그 수열을 바이토닉 수열이라고 한다.
//    예를 들어, {10, 20, 30, 25, 20}과 {10, 20, 30, 40}, {50, 40, 25, 10} 은 바이토닉 수열이지만, {1, 2, 3, 2, 1, 2, 3, 2, 1}과 {10, 20, 30, 40, 20, 30} 은 바이토닉 수열이 아니다.
//    수열 A가 주어졌을 때, 그 수열의 부분 수열 중 바이토닉 수열이면서 가장 긴 수열의 길이를 구하는 프로그램을 작성하시오.

    static BufferedWriter bw;
    static int[] arr;
    static int[] lDp;
    static int[] rDp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        lDp = new int[n];
        rDp = new int[n];
        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            lDp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && lDp[i] < lDp[j] + 1) {
                    lDp[i] = lDp[j] + 1;
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            rDp[i] = 1;

            for (int j = n - 1; j > i; j--) {
                if (arr[j] < arr[i] && rDp[i] < rDp[j] + 1) {
                    rDp[i] = rDp[j] + 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int val = lDp[i] + rDp[i] - 1;
            max = Math.max(max, val);
        }

        bw.write(max + "");
        bw.flush();
        bw.close();
    }

}
