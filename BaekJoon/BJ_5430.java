package inaeinae.studycodingtest.BaekJoon;

import java.io.*;
import java.util.*;

/**
 * [BJ] AC / gold lv5
 * (2026.02.04) https://www.acmicpc.net/problem/5430
 */
public class BJ_5430 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCount; i++) {
            char[] functions = br.readLine().toCharArray();
            br.readLine();
            String input = br.readLine().replaceAll("[\\[\\]]","");

            Deque<Integer> deque = new ArrayDeque<>();
            if (!input.isEmpty()) {
                for (String s : input.split(",")) {
                    deque.add(Integer.parseInt(s));
                }
            }

            boolean isReversed = false;
            boolean isError = false;
            for (char func : functions) {
                if (func == 'R') {
                    isReversed = !isReversed;
                } else {
                    if (deque.size() < 1) {
                        isError = true;
                        break;
                    }
                    if (isReversed) {
                        deque.removeLast();
                    } else {
                        deque.removeFirst();
                    }
                }
            }

            if (isError) {
                System.out.println("error");
                continue;
            }
            StringBuilder sb = new StringBuilder("[");
            while(!deque.isEmpty()) {
                sb.append(isReversed ? deque.removeLast() : deque.removeFirst());
                if (!deque.isEmpty()) sb.append(",");
            }
            sb.append("]");
            System.out.println(sb);
        }
    }
}
