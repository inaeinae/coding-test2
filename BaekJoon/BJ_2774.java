package inaeinae.studycodingtest.BaekJoon;

import java.io.*;
import java.util.*;

/**
 * [BJ] 아름다운 수 / lv2
 * (2025.12.14) https://www.acmicpc.net/problem/2774
 */
public class BJ_2774 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[] result = new int[count];

        for (int i = 0; i < count; i++) {
            Set<Character> number = new HashSet<>();
            for (char c : br.readLine().toCharArray()) {
                number.add(c);
            }
            result[i] = number.size();
        }

        for (int i = 0; i < count; i++) {
            System.out.println(result[i]);
        }
    }
}
