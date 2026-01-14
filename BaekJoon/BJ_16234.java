package inaeinae.studycodingtest.BaekJoon;

import java.io.*;
import java.util.*;

/**
 * [BJ] 인구 이동 / gold lv4
 * (2026.01.14) https://www.acmicpc.net/problem/16234
 */
public class BJ_16234 {
    private int N, L, R;
    private int[][] A;
    private boolean[][] visited;
    private final int[] dx = {1, 0, -1, 0};
    private final int[] dy = {0, 1, 0, -1};
    public void solution() throws IOException{
        int movingDayCount = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        A = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            boolean moved = false;
            visited = new boolean[N][N];

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (!visited[r][c]) {
                        ArrayList<int[]> groupList = new ArrayList<>();
                        grouping(r, c, groupList);

                        if (groupList.size() <= 1) continue;
                        moving(groupList);
                        moved = true;
                    }
                }
            }

            if (!moved) break;
            movingDayCount++;
        }

        System.out.println(movingDayCount);
    }

    private void grouping(int r, int c, ArrayList<int[]> groupList) {
        groupList.add(new int[]{r, c});
        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nextR = r + dx[i];
            int nextC = c + dy[i];
            if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= N) continue;

            if (!visited[nextR][nextC] && (L <= Math.abs(A[r][c] - A[nextR][nextC]) && Math.abs(A[r][c] - A[nextR][nextC]) <= R)) {
                grouping(nextR, nextC, groupList);
            }
        }
    }

    private void moving(ArrayList<int[]> groupList) {
        int sum = 0;
        for (int[] arr : groupList) {
            sum += A[arr[0]][arr[1]];
        }

        int averagePerson = Math.floorDiv(sum, groupList.size());
        for (int[] arr : groupList) {
            A[arr[0]][arr[1]] = averagePerson;
        }
    }
}
