package inaeinae.studycodingtest.BaekJoon;

import java.io.*;
import java.util.*;

/**
 * [BJ] 테트로미노 / gold lv4
 * (2026.03.12) https://www.acmicpc.net/problem/14500
 */
public class BJ_14500 {
    private int N, M, answer=0;
    private int[][] paper;
    private final int[] DR = {-1, 1, 0, 0};
    private final int[] DC = {0, 0, -1, 1};
    private final int[][][] T_SHAPES = {
            {{0,0},{0,1},{0,2},{1,1}},  // ㅜ
            {{0,1},{1,0},{1,1},{1,2}},  // ㅗ
            {{0,0},{1,0},{1,1},{2,0}},  // ㅓ
            {{0,1},{1,0},{1,1},{2,1}},  // ㅏ
    };
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        paper = new int[N][M];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                paper[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] visited = new boolean[N][M];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                visited[r][c] = true;
                searchDFS(r, c, 1, paper[r][c], visited);
                searchTShape(r, c);
                visited[r][c] = false;
            }
        }

        System.out.println(answer);
    }

    private void searchDFS(int r, int c, int depth, int sum, boolean[][] visited) {
        if (depth == 4) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextR = r + DR[i], nextC = c + DC[i];
            if (nextR >= N || nextC >= M || nextR < 0 || nextC < 0) continue;

            if (!visited[nextR][nextC]) {
                visited[nextR][nextC] = true;
                searchDFS(nextR, nextC, depth+1, sum+paper[nextR][nextC], visited);
                visited[nextR][nextC] = false;
            }
        }
    }

    private void searchTShape(int r, int c) {
        for (int[][] shape : T_SHAPES) {
            int sum = 0;
            boolean isValid = true;
            for (int[] d : shape) {
                int nextR = r + d[0], nextC = c + d[1];
                if (nextR >= N || nextC >= M || nextR < 0 || nextC < 0) { isValid = false; break; }
                sum += paper[nextR][nextC];
            }
            if (isValid) answer = Math.max(answer, sum);
        }
    }
}
