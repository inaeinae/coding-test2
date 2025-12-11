package inaeinae.studycodingtest.BaekJoon;

import java.util.*;
import java.io.*;

/**
 * [BJ] 삼각형 / lv5
 * (2025.12.12) https://www.acmicpc.net/problem/29751
 */
public class BJ_29751 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] triangle = br.readLine().split(" ");
        float width = Float.parseFloat(triangle[0]);
        float height = Float.parseFloat(triangle[1]);
        float result = (width * height) / 2;

        bw.write(String.format("%.1f", result));

        bw.flush();
        bw.close();
    }
}
