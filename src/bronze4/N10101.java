package bronze4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N10101 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[3];
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            int n = Integer.parseInt(br.readLine());
            arr[i] = n;
            sum += n;
        }
        br.close();

        // 세 각의 크기가 모두 60이면, Equilateral
        // 세 각의 합이 180이고, 두 각이 같은 경우에는 Isosceles
        // 세 각의 합이 180이고, 같은 각이 없는 경우에는 Scalene
        // 세 각의 합이 180이 아닌 경우에는 Error
        if (arr[0] == 60 && arr[1] == 60 && arr[2] == 60) {
            bw.write("Equilateral");
        } else {
            if (sum == 180) {
                if (arr[0] == arr[1] || arr[0] == arr[2] || arr[1] == arr[2]) {
                    bw.write("Isosceles");
                } else {
                    bw.write("Scalene");
                }
            } else {
                bw.write("Error");
            }
        }

        bw.flush();
        bw.close();
    }

}
