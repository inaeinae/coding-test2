package inaeinae.studycodingtest.BaekJoon;

import java.io.*;

/**
 * [BJ] 와글와글 숭고한 / lv4
 * (2025.12.14) https://www.acmicpc.net/problem/17388
 */
public class BJ_17388 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int soongsil = Integer.parseInt(input[0]);
        int korea = Integer.parseInt(input[1]);
        int hanyang = Integer.parseInt(input[2]);

        if (soongsil + korea + hanyang >= 100) {
            System.out.println("OK");
            return;
        }

        if (soongsil < korea && soongsil < hanyang) {
            System.out.println("Soongsil");
        } else if (korea < hanyang) {
            System.out.println("Korea");
        } else {
            System.out.println("Hanyang");
        }
    }
}
