package inaeinae.studycodingtest.BaekJoon;

import java.io.*;
import java.util.*;

/**
 * [BJ] 유기농 배추 / silver lv2
 * (2026.01.06) https://www.acmicpc.net/problem/1012
 */
public class BJ_1012 {
    private int[][] testMap;
    private boolean visited[][];
    private int groupCount = 0;
    private int M;
    private int N;
    private final int[] dx = {-1, 1, 0, 0};
    private final int[] dy = {0, 0, -1, 1};
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            M  = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            visited = new boolean[M][N];
            testMap = new int[M][N];

            for (int z = 0; z < K; z++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                testMap[x][y] = 1;
            }

            for (int x = 0; x < M; x++) {
                for (int y = 0; y < N; y++) {
                    if (testMap[x][y] == 1 && !visited[x][y]) {
                        grouping(x,y);
                        groupCount++;
                    }
                }
            }

            System.out.println(groupCount);
            groupCount = 0;
        }
    }

    private void grouping(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) {
                continue;
            }

            if (testMap[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                grouping(nextX, nextY);
            }
        }
    }
}
