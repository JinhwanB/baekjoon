package silver1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class N1931 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        List<Time> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list.add(new Time(s, e));
        }

        Collections.sort(list);

        int count = 0; // 총 회의 갯수
        int end = 0; // 현재 회의 끝나는 시간
        // 현재 회의가 끝나는 시간이 다음 회의 시작 시간보다 작거나 같을때 갱신
        for (Time time : list) {
            if(end <= time.start){
                end = time.end;
                count++;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }

    // 최대의 회의 시간을 가지려면 종료 시간을 기준으로 오름차순으로 정렬을 해준다.
    static class Time implements Comparable<Time> {
        private int start;
        private int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time o) {
            if (this.end != o.end) {
                return this.end - o.end;
            } else { // 종료 시간이 같을 때 시작시간을 기준으로 오름차순
                return this.start - o.start;
            }
        }
    }
}
