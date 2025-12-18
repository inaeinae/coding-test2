package inaeinae.studycodingtest.BaekJoon;

import java.io.*;
import java.util.*;

/**
 * [BJ] 효율적인 해킹 / silver 1
 * (2025.12.18) https://www.acmicpc.net/problem/1325
 */
public class BJ_1325 {
    private int computerCount, trustCount;
    private ArrayList<Integer>[] trustMap;
    private int[] hacked;
    private boolean[] visited;
    private int maxHackCount = 0;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        computerCount = Integer.parseInt(st.nextToken());
        trustCount = Integer.parseInt(st.nextToken());
        trustMap = new ArrayList[computerCount+1];
        hacked = new int[computerCount+1];

        for (int i = 1; i < trustMap.length; i++) {
            trustMap[i] = new ArrayList<>();
        }
        for (int i = 0; i < trustCount; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            trustMap[start].add(end);
        }

        for (int i = 1; i < trustMap.length; i++) {
            visited = new boolean[computerCount+1];
            hacking(i);
        }

        for (int i = 1; i < hacked.length; i++) {
            if (hacked[i] == maxHackCount) {
                System.out.print(i + " ");
            }
        }
    }

    private void hacking(int computerNumber) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(computerNumber);
        visited[computerNumber] = true;

        while(!queue.isEmpty()) {
            int nowLoc = queue.poll();

            for (int i : trustMap[nowLoc]) {
                if (visited[i] == false) {
                    visited[i] = true;
                    hacked[i]++;
                    queue.offer(i);

                    if (maxHackCount < hacked[i]) {
                        maxHackCount = hacked[i];
                    }
                }
            }
        }
    }
}
