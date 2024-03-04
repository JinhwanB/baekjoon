package bronze3;

import java.io.*;
import java.util.StringTokenizer;

public class N10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int min = 0;
        int max = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            if(i == 0){ // 맨 처음 수는 아직 비교 대상이 없기에 최소 및 최댓값 모두 해당한다.
                min = num;
                max = num;
                continue;
            }

            // 다음 수부터 최솟값보다 작은 경우 최솟값으로, 최댓값보다 큰 경우 최댓값으로 변경한다.
            if(num < min){
                min = num;
            }else if(num > max){
                max = num;
            }
        }

        bw.write(min + " " + max);
        bw.flush();
        bw.close();
        br.close();
    }
}
