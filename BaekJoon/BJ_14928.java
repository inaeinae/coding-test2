package inaeinae.studycodingtest.BaekJoon;

import java.io.*;

/**
 * [BJ] 큰 수 (BIG) / bronze lv5
 * (2025.12.11) https://www.acmicpc.net/problem/14928
 */
public class BJ_14928 {
    public void solution() throws IOException {
        // N % M == (N * 10 + digit) % M
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();

        int result = 0;
        for (char c : input.toCharArray()) {
            result = (result * 10 + (c - '0')) % 20000303;
        }
        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
    }
}
