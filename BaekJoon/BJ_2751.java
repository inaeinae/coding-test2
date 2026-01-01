package inaeinae.studycodingtest.BaekJoon;

import java.io.*;
import java.util.*;

/**
 * [BJ] 수 정렬하기 2 / silver lv5
 * (2026.01.02) https://www.acmicpc.net/problem/2751
 */
public class BJ_2751 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        Integer[] numbers = new Integer[count];

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);
        for (int num : numbers) {
            bw.write(String.valueOf(num));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
