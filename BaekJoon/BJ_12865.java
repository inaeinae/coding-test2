package inaeinae.studycodingtest.BaekJoon;

import java.io.*;
import java.util.*;

/**
 * [BJ] 평범한 배낭 / gold lv5
 * (2026.02.02) https://www.acmicpc.net/problem/12865
 */
public class BJ_12865 {
    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        int maxWeight = Integer.parseInt(st.nextToken());
        int[][] objects = new int[count][2];
        int[][] dp = new int[count][maxWeight+1];

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            objects[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())}; // 무게, 가치
        }

        for (int w = objects[0][0]; w <= maxWeight; w++) {
            dp[0][w] = objects[0][1];
        }

        for (int i = 1; i < count; i++) {
            int nowWeight = objects[i][0];
            int nowValue = objects[i][1];
            for (int w = 0; w <= maxWeight; w++) {
                if (w < nowWeight) {
                    dp[i][w] = dp[i-1][w];
                    continue;
                }
                dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-nowWeight] + nowValue);
            }
        }

        System.out.println(dp[count-1][maxWeight]);
    }
}
