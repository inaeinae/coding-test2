package inaeinae.studycodingtest.PGS;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * [PGS] 더 맵게 / lv3
 * (2024.05.17) https://school.programmers.co.kr/learn/courses/30/lessons/42626
 */
public class PGS_42626 {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> scovilleQueue = new PriorityQueue<>(Arrays.stream(scoville).boxed().collect(Collectors.toList()));

        while (scovilleQueue.peek() < K) {
            if (scovilleQueue.size() < 2) return -1;

            int firstFood = scovilleQueue.poll();
            int secondFood = scovilleQueue.poll();
            int mixFood = firstFood + (secondFood * 2);

            answer++;
            scovilleQueue.add(mixFood);
        }

        return answer;
    }
}
