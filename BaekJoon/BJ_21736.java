package inaeinae.studycodingtest.BaekJoon;

import java.io.*;
import java.util.*;

/**
 * [BJ] 헌내기는 친구가 필요해 / silver lv2
 * (2026.01.13) https://www.acmicpc.net/problem/21736
 */
public class BJ_21736 {
    private int N, M, count = 0;
    private char[][] map;
    private boolean[][] visited;
    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, 1, 0, -1};
    private final char START_SIGN = 'I';
    private final char WALL_SIGN = 'X';
    private final char PERSON_SIGN = 'P';
    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int startX = 0, startY = 0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = input[j];
                if (input[j] == START_SIGN) {
                    startX = i;
                    startY = j;
                }
            }
        }

        dfs(startX, startY);

        System.out.println(count > 0 ? count : "TT");
    }

    private void dfs(int x, int y) {
        visited[x][y] = true;
        if (map[x][y] == PERSON_SIGN) {
            count++;
        }

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;

            if (map[nextX][nextY] != WALL_SIGN && !visited[nextX][nextY]) {
                dfs(nextX, nextY);
            }
        }
    }
}
