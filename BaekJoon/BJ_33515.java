package inaeinae.studycodingtest.BaekJoon;

import java.io.*;
import java.util.Arrays;

/**
 * [BJ] 노트북 세 대를 가지고 왔다 / bronze lv5
 * (2025.12.14) https://www.acmicpc.net/problem/33515
 */
public class BJ_33515 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] times = br.readLine().split(" ");

        bw.write(Integer.parseInt(times[0]) <= Integer.parseInt(times[1]) ? times[0] : times[1]);

        bw.flush();
        bw.close();
    }
}
