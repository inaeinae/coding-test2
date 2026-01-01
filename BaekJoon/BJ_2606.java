package inaeinae.studycodingtest.BaekJoon;

import java.io.*;
import java.util.*;

/**
 * [BJ] 바이러스 / silver lv3
 * (2026.01.02) https://www.acmicpc.net/problem/2606
 */
public class BJ_2606 {
    private ArrayList<Integer>[] connectMap;
    private boolean[] visited;
    private final int VIRUS_TARGET_NUMBER = 1;
    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computerCount = Integer.parseInt(br.readLine());
        int connectCount = Integer.parseInt(br.readLine());

        connectMap = new ArrayList[computerCount+1];
        visited = new boolean[computerCount+1];

        for (int i = 0; i < computerCount+1; i++) {
            connectMap[i] = new ArrayList<>();
        }

        for (int i = 0; i < connectCount; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            connectMap[a].add(b);
            connectMap[b].add(a);
        }

        System.out.println(virus());
    }

    private int virus() {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[VIRUS_TARGET_NUMBER] = true;
        queue.add(VIRUS_TARGET_NUMBER);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i : connectMap[now]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                    answer++;
                }
            }
        }

        return answer;
    }
}
