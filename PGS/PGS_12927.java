package inaeinae.studycodingtest.PGS;

import java.util.*;

/**
 * [PGS] 야근 지수 / lv3
 * (2024.03.25) https://school.programmers.co.kr/learn/courses/30/lessons/12927
 */
public class PGS_12927 {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int work : works) queue.add(work);

        while (n > 0) {
            int max = queue.poll();
            if (max == 0) break;
            queue.add(max - 1);
            n--;
        }

        for (int work : queue) answer += Math.pow(work, 2);
        return answer;
    }
}
