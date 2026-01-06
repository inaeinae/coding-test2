package inaeinae.studycodingtest.BaekJoon;

import java.util.*;

/**
 * [BJ] 계단 오르기 / silver lv3
 * (2026.01.06) https://www.acmicpc.net/problem/2579
 */
public class BJ_2579 {
    public void solution() {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] stairs = new int[count];

        for (int i = 0; i < count; i++) {
            stairs[i] = scanner.nextInt();
        }

        if (count == 1) {
            System.out.println(stairs[0]);
            return;
        }
        if (count == 2) {
            System.out.println(stairs[0] + stairs[1]);
            return;
        }

        int[] score = new int[count];
        score[0] = stairs[0];
        score[1] = stairs[1] + stairs[0];
        score[2] = Math.max(stairs[2] + stairs[0], stairs[2] + stairs[1]);

        for (int i = 3; i < count; i++) {
            score[i] = Math.max(stairs[i] + score[i-2], stairs[i] + stairs[i-1] + score[i-3]);
        }

        System.out.println(score[count-1]);
    }
}
