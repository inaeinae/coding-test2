package inaeinae.studycodingtest.BaekJoon;

import java.util.*;

/**
 * [BJ] N과 M (2) / silver lv3
 * (2026.01.07) https://www.acmicpc.net/problem/15650
 */
public class BJ_15650 {
    int N, M;
    private int[] numbers;
    public void solution() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        numbers = new int[M];
        tracking(0, 1);
    }

    private void tracking(int index, int start) {
        if (index == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(numbers[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= N; i++) {
            numbers[index] = i;
            tracking(index+1, i+1);
        }
    }
}
