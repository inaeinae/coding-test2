package inaeinae.studycodingtest.BaekJoon;

import java.io.*;
import java.util.*;

/**
 * [BJ] 좌표 정렬하기 / silver lv5
 * (2026.01.04) https://www.acmicpc.net/problem/11650
 */
public class BJ_11650 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        int[][] map = new int[count][2];

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            map[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        Arrays.sort(map, (o1, o2) -> {
            return o1[0]!=o2[0] ? o1[0]-o2[0] : o1[1]-o2[1];
        });

        for (int i = 0; i < count; i++) {
            System.out.println(String.format("%d %d", map[i][0], map[i][1]));
        }
    }
}
