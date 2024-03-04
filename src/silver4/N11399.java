package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N11399 {

    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solve());

        br.close();
    }

    private static int solve() {
        int previousTime = 0; // 전 사람이 걸린 시간
        int result = 0; // 총 걸린 시간

        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++){
            previousTime += arr[i]; // 전 사람이 걸린 시간 + 현재 사람이 걸린 시간
            result += previousTime;
        }

        return result;
    }
}
