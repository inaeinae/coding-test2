package inaeinae.studycodingtest.PGS;

import java.util.*;

/**
 * [PGS] 구명보트 / lv2
 * (2024.05.19) https://school.programmers.co.kr/learn/courses/30/lessons/42885
 */
public class PGS_42885 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int minIndex = 0;
        int maxIndex = people.length - 1;

        Arrays.sort(people);

        while (maxIndex >= minIndex){
            answer++;
            if (minIndex == maxIndex) break;

            int maxWeight = people[maxIndex];
            int minWeight = people[minIndex];

            if ((maxWeight + minWeight) <= limit) {
                minIndex++;
            }
            maxIndex--;
        }

        return answer;
    }
}
