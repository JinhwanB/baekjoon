package silver1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N14889 {

    static BufferedWriter bw;
    static int n;
    static int teamNum;
    static int[][] s;
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        teamNum = n / 2;
        s = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= n; j++) {
                int num = Integer.parseInt(st.nextToken());

                s[i][j] = num;
            }
        }
        br.close();

        makeTeam(0, 1);

        bw.write(result + "");
        bw.flush();
        bw.close();
    }

    private static void makeTeam(int cnt, int idx) throws IOException {
        if (cnt == teamNum) {
            score();
            return;
        }

        for (int i = idx; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                makeTeam(cnt + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    private static void score() throws IOException {
        int startTeamScore = 0;
        int linkTeamScore = 0;

        for (int i = 1; i <= n - 1; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (visited[i] && visited[j]) {
                    startTeamScore += s[i][j];
                    startTeamScore += s[j][i];
                    continue;
                }

                if (!visited[i] && !visited[j]) {
                    linkTeamScore += s[i][j];
                    linkTeamScore += s[j][i];
                }
            }
        }

        int diff = Math.abs(startTeamScore - linkTeamScore);

        if (diff == 0) {
            bw.write(0 + "");
            bw.flush();
            bw.close();
            System.exit(0);
        }

        result = Math.min(result, diff);
    }

}
