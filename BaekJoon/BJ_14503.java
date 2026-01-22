package inaeinae.studycodingtest.BaekJoon;


import java.io.*;
import java.util.*;

/**
 * [BJ] 로봇 청소기 / gold lv5
 * (2026.01.22) https://www.acmicpc.net/problem/14503
 */
public class BJ_14503 {
    private int N, M, answer = 0;
    private int[][] map;
    private final int[] dr = {-1, 0, 1, 0};
    private final int[] dc = {0, 1, 0, -1};
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int robotR = Integer.parseInt(st.nextToken());
        int robotC = Integer.parseInt(st.nextToken());
        int robotDirection = Integer.parseInt(st.nextToken()); // 0:북쪽, 1:동쪽, 2:남쪽, 3:서쪽

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken()); // 0:청소되지 않은 빈칸, 1:벽
            }
        }

        cleaning(robotR, robotC, robotDirection);
        System.out.println(answer);
    }

    private void cleaning(int r, int c, int direction) {
        if (map[r][c] == 0) {
            map[r][c] = 2;
            answer++;
        }

        for (int i = 0; i < 4; i++) {
            direction = (direction + 3) % 4; // 반시계 회전
            int nextR = r + dr[direction];
            int nextC = c + dc[direction];

            if (map[nextR][nextC] == 0) {
                cleaning(nextR, nextC, direction);
                return;
            }
        }

        int backR = r + dr[(direction + 2) % 4];
        int backC = c + dc[(direction + 2) % 4];
        if (map[backR][backC] != 1) {
            cleaning(backR, backC, direction);
        }
    }
}
