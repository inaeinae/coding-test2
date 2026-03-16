package inaeinae.studycodingtest.BaekJoon;

import java.io.*;
import java.util.*;

/**
 * [BJ] 사이클 게임 / gold lv4
 * (2026.03.16) https://www.acmicpc.net/problem/20040
 */
public class BJ_20040 {
    private int[] parent;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int pointCount = Integer.parseInt(st.nextToken());
        int roundCount = Integer.parseInt(st.nextToken());
        int answer = -1;

        parent = new int[pointCount];
        for (int i = 0; i < pointCount; i++) {
            parent[i] = i;
        }

        for (int round = 1; round <= roundCount; round++) {
            st = new StringTokenizer(br.readLine());
            int rootA = find(Integer.parseInt(st.nextToken()));
            int rootB = find(Integer.parseInt(st.nextToken()));
            if (rootA == rootB) {
                answer = round;
                break;
            }
            union(rootA, rootB);
        }

        System.out.println(answer > -1 ? answer : 0);
    }

    private int find(int node) {
        while (parent[node] != node) {
            node = parent[node];
        }
        return node;
    }

    private void union(int rootA, int rootB) {
        parent[rootB] = rootA;
    }
}
