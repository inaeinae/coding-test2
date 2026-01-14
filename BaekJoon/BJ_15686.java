package inaeinae.studycodingtest.BaekJoon;

import java.io.*;
import java.util.*;

/**
 * [BJ] 치킨 배달 / gold lv5
 * (2026.01.15) https://www.acmicpc.net/problem/15686
 */
public class BJ_15686 {
    private int N, M, answer = Integer.MAX_VALUE;
    private ArrayList<int[]> houses;
    private ArrayList<int[]> chickenStores;

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        houses = new ArrayList<>();
        chickenStores = new ArrayList<>();

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < N; c++) {
                int parseInput = Integer.parseInt(st.nextToken());
                if (parseInput == 1) {
                    houses.add(new int[]{r,c});
                } else if (parseInput == 2) {
                    chickenStores.add(new int[]{r,c});
                }
            }
        }

        int[] combo = new int[M];
        tracking(0, 0, combo);

        System.out.println(answer);
    }

    private void tracking(int index, int start, int[] combo) {
        if (index == M) {
            distanceCalculate(combo);
            return;
        }

        for (int i = start; i < chickenStores.size(); i++) {
            combo[index] = i;
            tracking(index+1, i+1, combo);
        }
    }

    private void distanceCalculate(int[] combo) {
        int cityChickenDistance = 0;

        for (int[] house : houses) {
            int min = Integer.MAX_VALUE;

            for (int chickenIndex : combo) {
                int[] chickenStore = chickenStores.get(chickenIndex);
                min = Math.min(min, Math.abs(house[0] - chickenStore[0]) + Math.abs(house[1] - chickenStore[1]));
            }

            cityChickenDistance += min;
        }

        answer = Math.min(answer, cityChickenDistance);
    }
}
