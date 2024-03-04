package silver3;

import java.io.*;
import java.util.Arrays;

public class N2108 {

    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        double sum = 0; // 반올림을 위해 double로 선언

        arr = new int[N];
        for(int i = 0; i < N; i++){
            int value = Integer.parseInt(br.readLine());
            arr[i] = value;

            sum += value; // 입력 값 저장하면서 값들의 합을 같이 저장한다
        }
        Arrays.sort(arr); // 배열을 값이 작은 순서대로 정렬

        bw.write(Math.round(sum / N) + "\n"); // 첫 째자리에서 반올림
        bw.write(arr[(N - 1) / 2] + "\n"); // 중앙값
        bw.write(findModeValue() + "\n"); // 최빈값
        bw.write(arr[N-1] - arr[0] + "\n"); // 최대값 - 최소값

        bw.flush();
        bw.close();
        br.close();
    }

    private static int findModeValue() {

        if(arr.length == 1) return arr[0]; // 입력값이 하나밖에 없을 시 최빈값은 원래 값 하나이다
        else{
            /**
             * count = 입력 받은 값의 중복 갯수
             * max = 최대 중복 갯수
             * mode = 최빈값
             * flag = 최빈값이 여러개일 시 2번째로 작은 값 확인용
             */
            int count = 1; int max = 0; int mode = 0;
            boolean flag = false;

            for(int i = 0; i < arr.length - 1; i++){
                if(arr[i] == arr[i + 1]) count++;
                else count = 1;

                // 위에서 배열을 정렬해줬기 때문에 순서대로 순환하면 최빈값도 작은 값 순으로 얻을 수 있다.
                if(max < count){ // 최빈값이 여러개일 때 첫번째로 작은 값이 저장됨
                    max = count;
                    mode = arr[i];
                    flag = true;
                }else if(max == count && flag){ // 최빈값이 여러개일 때 두번쨰로 작은 값이 저장됨
                    mode = arr[i];
                    flag = false;
                }
            }

            return mode;
        }
    }
}
