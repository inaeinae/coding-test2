package inaeinae.studycodingtest.BaekJoon;

import java.io.*;
import java.util.*;

/**
 * [BJ] 알고리즘 수업 - 깊이 우선 탐색 1 / silver lv2
 * (2026.01.13) https://www.acmicpc.net/problem/24479
 */
public class BJ_24479 {
    private int N, M, order = 1;
    private ArrayList<Integer>[] map;
    private int[] visited;
    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        map = new ArrayList[N+1];
        visited = new int[N+1];

        for (int i = 1; i <= N; i++) {
            map[i] = new ArrayList<>();
            visited[i] = 0;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            map[start].add(end);
            map[end].add(start);
        }

        dfs(R);

        for (int i = 1; i <= N; i++) {
            System.out.println(visited[i]);
        }
    }

    private void dfs(int spot) {
        visited[spot] = order;
        order++;

        map[spot].sort((o1,o2) -> {return o1!=o2 ? o1-o2 : o1-o2;});

        for (int i = 0; i < map[spot].size(); i++) {
            int linkedSpot = map[spot].get(i);
            if (visited[linkedSpot] == 0) {
                dfs(linkedSpot);
            }
        }
    }
}
