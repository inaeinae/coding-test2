package inaeinae.studycodingtest.BaekJoon;

import java.io.*;
import java.util.*;

/**
 * [BJ] 빗물 / gold lv5
 * (2026.01.26) https://www.acmicpc.net/problem/14719
 */
public class BJ_14719 {
    private int H, W, count = 0;
    private int[][] blocks;
    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        blocks = new int[H][W];

        st = new StringTokenizer(br.readLine());
        for (int w = 0; w < W; w++) {
            int blockCount = Integer.parseInt(st.nextToken());
            for (int h = H-1; h >= H-blockCount; h--) {
                blocks[h][w] = 1;
            }
        }

        for (int h = 0; h < H; h++) {
            counting(h);
        }
        System.out.println(count);
    }

    private void counting(int h) {
        int start = -1;
        for (int w = 0; w < W; w++) {
            if (blocks[h][w] == 1) {
                if (start != -1) {
                    count += w - start - 1;
                }
                start = w;
            }
        }
    }
}
