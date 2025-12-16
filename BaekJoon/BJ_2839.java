package inaeinae.studycodingtest.BaekJoon;

import java.io.*;

/**
 * [BJ] 설탕 배달 / silver lv4
 * (2025.12.16) https://www.acmicpc.net/problem/2839
 */
public class BJ_2839 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalAmount = Integer.parseInt(br.readLine());
        int result = 0;

        while (totalAmount > 0) {
            if (totalAmount < 3) {
                result = -1;
                break;
            }
            if (totalAmount % 5 == 0) {
                result += totalAmount / 5;
                break;
            }

            totalAmount -= 3;
            result++;
        }

        System.out.println(result);
    }
}
