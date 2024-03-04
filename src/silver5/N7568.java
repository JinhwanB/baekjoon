package silver5;

import java.io.*;
import java.util.StringTokenizer;

public class N7568 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];
        for(int i = 0; i < arr.length; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < arr.length; i++){
            int rank = 1;

            for(int j = 0; j < arr.length; j++){
                if(i == j) continue;

                if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) rank++; // i번째보다 더 덩치가 큰 사람이 있을 시 rank++
            }
            bw.write(rank + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
