package inaeinae.studycodingtest.BaekJoon;

import java.util.*;

/**
 * [BJ] N과 M (1) / silver lv3
 * (2026.01.07) https://www.acmicpc.net/problem/15649
 */
public class BJ_15649 {
    private int N, M;
    private int[] numbers;
    private boolean[] visited;
    public void solution() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        visited = new boolean[N];
        numbers = new int[M];
        tracking(0);
    }

    private void tracking(int index) {
        if (index == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(numbers[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                numbers[index] = i+1;
                tracking(index+1);
                visited[i] = false;
            }
        }
    }
}
