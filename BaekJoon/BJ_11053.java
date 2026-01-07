package inaeinae.studycodingtest.BaekJoon;

import java.util.*;

/**
 * [BJ] 가장 긴 증가하는 부분 수열 / silver lv2
 * (2026.01.08) https://www.acmicpc.net/problem/11053
 */
public class BJ_11053 {
    public void solution() {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] numbers = new int[count];
        int[] lengths = new int[count];

        for (int i = 0; i < count; i++) {
            numbers[i] = scanner.nextInt();
        }

        lengths[0] = 1;
        for (int i = 1; i < count; i++) {
            lengths[i] = 1;
            for (int j = i-1; j >= 0; j--) {
                if (numbers[i] > numbers[j] && lengths[i] <= lengths[j]+1) {
                    lengths[i] = lengths[j] + 1;
                }
            }
        }

        Arrays.sort(lengths);
        System.out.println(lengths[count-1]);
    }
}
