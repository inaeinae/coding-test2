package inaeinae.studycodingtest.BaekJoon;

import java.io.*;

/**
 * [BJ] Piece of Cake! / bronze lv4
 * (2025.12.14) https://www.acmicpc.net/problem/17874
 */
public class BJ_17874 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int h = Integer.parseInt(input[1]);
        int v = Integer.parseInt(input[2]);

        int max = Integer.MIN_VALUE;
        max = Math.max(h * v * 4, h * (n-v) * 4);
        max = Math.max(max, (n-h) * v * 4);
        max = Math.max(max, (n-h) * (n-v) * 4);

        System.out.println(max);
    }
}
