package inaeinae.studycodingtest.BaekJoon;

import java.io.*;
import java.util.*;

/**
 * [BJ] 연구소 / gold lv4
 * (2026.03.17) https://www.acmicpc.net/problem/14502
 */
public class BJ_14502 {
    private int N, M;
    private int[][] laboratory;
    private ArrayList<int[]> virus;
    private final int[] DR = {-1, 1, 0, 0};
    private final int[] DC = {0, 0, -1, 1};
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        laboratory = new int[N][M];
        virus = new ArrayList<>();
        ArrayList<int[]> space = new ArrayList<>();
        int infectionCount = Integer.MAX_VALUE;

        for (int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < M; col++) {
                int num = Integer.parseInt(st.nextToken());
                laboratory[row][col] = num;
                if (num == 0) space.add(new int[]{row,col});
                if (num == 2) virus.add(new int[]{row,col});
            }
        }

        for (int a = 0; a < space.size(); a++) {
            int[] spotA = space.get(a);
            int[] spotB;
            int[] spotC;
            for (int b = a+1; b < space.size(); b++) {
                spotB = space.get(b);
                for (int c = b+1; c < space.size(); c++) {
                    spotC = space.get(c);
                    buildWalls(spotA, spotB, spotC);
                    infectionCount = Math.min(infectionCount, infecting());
                    removeWalls(spotA, spotB, spotC);
                }
            }
        }

        System.out.println((space.size()-3)-infectionCount);
    }

    private void buildWalls(int[]... spots) {
        for (int[] spot : spots) laboratory[spot[0]][spot[1]] = 1;
    }

    private void removeWalls(int[]... spots) {
        for (int[] spot : spots) laboratory[spot[0]][spot[1]] = 0;
    }

    private int infecting() {
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new ArrayDeque<>();
        int infectionCount = 0;

        for (int[] v : virus) {
            queue.add(v);
            visited[v[0]][v[1]] = true;
        }

        while (!queue.isEmpty()) {
            int[] spot = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextR = spot[0] + DR[i], nextC = spot[1] + DC[i];
                if (nextR >= N || nextC >= M || nextR < 0 || nextC < 0 || laboratory[nextR][nextC] != 0 || visited[nextR][nextC]) continue;
                visited[nextR][nextC] = true;
                queue.add(new int[]{nextR,nextC});
                infectionCount++;
            }
        }

        return infectionCount;
    }
}