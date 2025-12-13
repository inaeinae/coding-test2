package inaeinae.studycodingtest.BaekJoon;

import java.util.*;
import java.io.*;

/**
 * [BJ] 정보섬의 대중교통 / lv5
 * (2025.12.12) https://www.acmicpc.net/problem/28113
 */
public class BJ_28113 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] times = br.readLine().split(" ");
        int bus = Integer.parseInt(times[1]);
        int subway = Integer.parseInt(times[2]);

        bw.write(bus < subway ? "Bus" : bus > subway ? "Subway" : "Anything");

        bw.flush();
        bw.close();
    }
}
