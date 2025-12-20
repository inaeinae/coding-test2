package inaeinae.studycodingtest.BaekJoon;

import java.io.*;
import java.util.*;

/**
 * [BJ] 이분 그래프 / gold 4
 * (2025.12.18) https://www.acmicpc.net/problem/1707
 */
public class BJ_1707 {
    private ArrayList<Integer>[] graphs;
    private boolean[] visited;
    private int[] group;
    private boolean isBipartite;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            graphs = new ArrayList[V+1];
            visited = new boolean[V+1];
            group = new int[V+1];
            isBipartite = true;

            for (int j = 1; j <= V; j++) {
                graphs[j] = new ArrayList<>();
            }

            for (int k = 0; k < E; k++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graphs[u].add(v);
                graphs[v].add(u);
            }

            for (int z = 1; z < graphs.length; z++) {
                if (!isBipartite) break;
                checkGraph(z);
            }

            System.out.println(isBipartite ? "YES" : "NO");
        }

    }

    private void checkGraph(int index) {
        visited[index] = true;

        for (int i : graphs[index]) {
            if (!visited[i]) {
                group[i] = (group[index] + 1) % 2;
                checkGraph(i);
            } else if (group[i] == group[index]) {
                isBipartite = false;
            }
        }
    }

}
