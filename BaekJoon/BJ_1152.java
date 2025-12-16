package inaeinae.studycodingtest.BaekJoon;

import java.io.*;

/**
 * [BJ] 단어의 개수 / bronze lv2
 * (2025.12.16) https://www.acmicpc.net/problem/1152
 */
public class BJ_1152 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().trim();
        System.out.println(input.isEmpty() ? 0 : input.split(" ").length);
    }
}
