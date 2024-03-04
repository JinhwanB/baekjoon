package silver1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class N2002 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>(); // 들어간 순서 map에 저장
        for(int i = 0; i < N; i++){
            map.put(br.readLine(), i);
        }

        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            String s = br.readLine();
            arr[i] = map.get(s); // 나온 차량의 순서대로 원래 들어왔을 때의 순서를 배열에 저장
        }

        int count = 0;

        for(int i = 0; i < N; i++){
            for(int j = i + 1; j < N; j++){
                if(arr[i] > arr[j]){ // arr[i]가 더 큰 경우, 즉 원래 뒷 순서에 들어왔지만 앞순서에 있는 경우
                    count++;
                    break;
                }
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }
}
