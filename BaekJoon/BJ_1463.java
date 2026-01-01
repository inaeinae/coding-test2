package inaeinae.studycodingtest.BaekJoon;

import java.util.*;

/**
 * [BJ] 1로 만들기 / silver lv3
 * (2026.01.02) https://www.acmicpc.net/problem/1463
 */
public class BJ_1463 {
    public void solution() {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] calculateCounts = new int[number+1];

        calculateCounts[1] = 0;
        for (int i = 2; i < calculateCounts.length; i++) {
            calculateCounts[i] = calculateCounts[i-1] + 1;
            if (i % 3 == 0) calculateCounts[i] = Math.min(calculateCounts[i], calculateCounts[i/3] + 1);
            if (i % 2 == 0) calculateCounts[i] = Math.min(calculateCounts[i], calculateCounts[i/2] + 1);
        }

        System.out.println(calculateCounts[calculateCounts.length-1]);
    }
}
