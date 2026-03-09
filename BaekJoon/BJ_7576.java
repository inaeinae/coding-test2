package inaeinae.studycodingtest.BaekJoon;

import java.io.*;
import java.util.*;

/**
 * [BJ] 토마토 / gold lv5
 * (2026.03.09) https://www.acmicpc.net/problem/7576
 */
public class BJ_7576 {
    private int M, N;
    private int[][] box;
    private final int[] DR = {-1, 1, 0, 0};
    private final int[] DC = {0, 0, -1, 1};
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<int[]> ripes = new LinkedList<>();
        int unripeCount = 0;
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N][M];

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                int input = Integer.parseInt(st.nextToken());
                if (input == 1) ripes.add(new int[]{0,n,m});
                if (input == 0) unripeCount++;
                box[n][m] = input;
            }
        }

        System.out.println(growing(ripes, unripeCount));
    }

    private int growing(Queue<int[]> ripes, int unripeCount) {
        if (unripeCount == 0) return 0;
        int dayCount = ripes.isEmpty() ? -1 : 0;

        while (!ripes.isEmpty()) {
            int[] ripePoint = ripes.poll();

            for (int x = 0; x < 4; x++) {
                int n = ripePoint[1] + DR[x];
                int m = ripePoint[2] + DC[x];

                if (n >= N || m >= M || n < 0 || m < 0 || box[n][m] != 0) continue;
                ripes.add(new int[]{ripePoint[0]+1,n,m});
                box[n][m] = 1;
                unripeCount--;
            }

            if (ripes.isEmpty()) {
                dayCount = unripeCount > 0 ? -1 : ripePoint[0];
            }
        }

        return dayCount;
    }
}
