package inaeinae.studycodingtest.BaekJoon;

import java.util.*;

/**
 * [BJ] 미로 탐색 / silver lv1
 * (2025.12.17) https://www.acmicpc.net/problem/2178
 */
public class BJ_2178 {
    static int startX = 0, startY = 0;
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}; // x 방향 상하좌우
    static int[] dy = {0, 0, -1, 1}; // y방향 상하좌우

    public void solution() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        map = new int[n][m];
        visited = new boolean[n][m];
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            String str = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        findRoute();

        System.out.println(map[n-1][m-1]);
    }

    static void findRoute() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX,startY});
        visited[startX][startY] = true; // 방문

        while(!queue.isEmpty()) {
            int[] nowLoc = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextLocX = nowLoc[0] + dx[i];
                int nextLocY = nowLoc[1] + dy[i];

                if (nextLocX < 0 || nextLocY < 0 || nextLocX >= n || nextLocY >= m) {
                    continue;
                }
                if (map[nextLocX][nextLocY] == 1 && !visited[nextLocX][nextLocY]) {
                    visited[nextLocX][nextLocY] = true;
                    map[nextLocX][nextLocY] = map[nowLoc[0]][nowLoc[1]] + 1;
                    queue.offer(new int[]{nextLocX, nextLocY});
                }
            }
        }
    }
}
