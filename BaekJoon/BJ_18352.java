package inaeinae.studycodingtest.BaekJoon;

import java.util.*;

/**
 * [BJ] 특정 거리의 도시 찾기 / silver lv2
 * (2025.12.18) https://www.acmicpc.net/problem/18352
 */
public class BJ_18352 {
    private int cityCount, roadCount, distance, startCity;
    private ArrayList<Integer> answer;
    private ArrayList<Integer>[] map;
    private int[] visited;
    public void solution() {
        Scanner scanner = new Scanner(System.in);

        cityCount = scanner.nextInt();
        roadCount = scanner.nextInt();
        distance = scanner.nextInt();
        startCity = scanner.nextInt();

        answer = new ArrayList<>();
        map = new ArrayList[cityCount+1];
        visited = new int[cityCount+1];

        for (int i = 1; i < map.length; i++) {
            map[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < roadCount; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();

            map[start].add(end);
        }

        for (int i = 1; i < visited.length; i++) {
            visited[i] = -1;
        }

        findCity();

        if (answer.size() == 0) {
            System.out.println(-1);
            return;
        }

        Collections.sort(answer);
        for (int i : answer) {
            System.out.println(i);
        }
    }

    private void findCity() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startCity);
        visited[startCity] = 0;

        while (!queue.isEmpty()) {
            int nowLoc = queue.poll();

            for (int i : map[nowLoc]) {
                if (visited[i] == -1) {
                    visited[i] = visited[nowLoc]+1;
                    if (visited[i] == distance) {
                        answer.add(i);
                    }
                    queue.offer(i);
                }
            }
        }
    }
}
