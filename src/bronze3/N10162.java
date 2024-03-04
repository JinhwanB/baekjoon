package bronze3;

import java.util.Scanner;

public class N10162 {

    static int T, A, B, C;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        solve();

        if(A != 0 || B != 0 || C != 0){ // A, B, C 중 하나라도 0이 아닐 때
            System.out.print(A + " " + B + " " + C);
        }else{ // 모두 0일 때
            System.out.println(-1);
        }
    }

    private static void solve() {
        while(T > 0){
            A = T / 300;
            if(A > 0) T %= 300;

            B = T / 60;
            if(B > 0) T %= 60;

            C = T / 10;
            if(C > 0) T %= 10;

            if(0 < T && T < 10){
                // T가 0과 10 사이의 수라면 A, B, C 버튼 모두 누를 수 없으므로 -1을 출력해야함
                A = 0; B = 0; C = 0; // -1이 출력되는 조건을 맞춰줌
                break;
            }
        }
    }
}
