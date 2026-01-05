package inaeinae.studycodingtest.BaekJoon;

import java.util.*;
import java.io.*;

/**
 * [BJ] RGB거리 / silver lv1
 * (2026.01.06) https://www.acmicpc.net/problem/1149
 */
public class BJ_1149 {
    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int houseCount = Integer.parseInt(st.nextToken());
        int[][] colorCharge = new int[houseCount][3];
        int[][] bills = new int[houseCount][3];

        for (int i = 0; i < houseCount; i++) {
            st = new StringTokenizer(br.readLine());
            colorCharge[i][0] = Integer.parseInt(st.nextToken());
            colorCharge[i][1] = Integer.parseInt(st.nextToken());
            colorCharge[i][2] = Integer.parseInt(st.nextToken());
        }

        bills[0] = colorCharge[0];
        for (int i = 1; i < colorCharge.length; i++) {
            for (int j = 0; j < 3; j++) {
                bills[i][j] = colorCharge[i][j] + Math.min(bills[i-1][(j+1)%3], bills[i-1][(j+2)%3]);
            }
        }

        int min = bills[bills.length-1][0];
        min = Math.min(min, bills[bills.length-1][1]);
        min = Math.min(min, bills[bills.length-1][2]);
        System.out.println(min);
    }
}
