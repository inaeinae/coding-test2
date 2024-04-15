package inaeinae.studycodingtest.PGS;

import java.util.*;

/**
 * [PGS] 의상 / lv2
 * (2024.04.10) https://school.programmers.co.kr/learn/courses/30/lessons/42578
 */
public class PGS_42578 {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> clothType = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            String key = clothes[i][1];
            clothType.put(key, clothType.getOrDefault(key, 0) + 1);
        }

        for (String type : clothType.keySet()) {
            answer *= (clothType.get(type) + 1);
        }

        return answer - 1;
    }
}
