package bronze3;

import java.io.*;

public class N5613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int result = Integer.parseInt(br.readLine()); // 처음은 무조건 수이다.
        String next = br.readLine();
        while(!next.equals("=")){
            if(next.equals("+")){
                result += Integer.parseInt(br.readLine());
            }else if(next.equals("-")){
                result -= Integer.parseInt(br.readLine());
            }else if(next.equals("*")){
                result *= Integer.parseInt(br.readLine());
            }else{
                result /= Integer.parseInt(br.readLine());
            }
            next = br.readLine();
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
