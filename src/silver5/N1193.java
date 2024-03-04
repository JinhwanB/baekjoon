package silver5;

import java.io.*;

public class N1193 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(br.readLine());

        int a = 1; // 분자
        int b = 1; // 분모
        int value = 2; // 분모와 분자의 합
        int count = 0; // X번째 분수를 찾는 과정
        boolean flag = false; // 분모가 클때 false, 분자가 클 때 true

        while (true) {
            int result = a + b;
            if(result == value) {
                count++; //
                if(count == X) break;

                if(a == 1 && b == 1) {
                    b += 1;
                    continue;
                }

                if(flag && a > 1) {
                    a -= 1;
                    b += 1;
                }else if(!flag && b > 1){
                    a += 1;
                    b -= 1;
                }else{
                    value++;
                    flag = Math.max(a, b) != b;
                    if(flag) a += 1;
                    else b += 1;
                }
            }else {
                value++;
                flag = Math.max(a, b) != b;
            }
        }
        bw.write(a + "/" + b);

        bw.flush();
        bw.close();
        br.close();
    }
}
