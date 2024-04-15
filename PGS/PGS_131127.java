package inaeinae.studycodingtest.PGS;

import java.util.*;

/**
 * [PGS] 할인행사 / lv2
 * (2024.03.24) https://school.programmers.co.kr/learn/courses/30/lessons/131127
 */
public class PGS_131127 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        // 원하는 품목, 개수 목록
        Map<String, Integer> wantList = new HashMap<String, Integer>();
        for (int i = 0; i < want.length; i++) {
            Map<String, Integer> wantMap = new HashMap<String, Integer>();
            wantList.put(want[i], number[i]);
        }

        for (int i = 0; i <= discount.length - 10; i++) {
            // 10일 동안의 할인품목 목록
            ArrayList<String> discountList = new ArrayList<String>(Arrays.asList(discount).subList(i, i + 10));
            if (!matchWantList(wantList, discountList)) continue;
            answer++;
        }

        return answer;
    }

    public boolean matchWantList(Map<String, Integer> wantList, ArrayList<String> discountList) {
        for (String key : wantList.keySet()) {
            int wantCount = wantList.get(key);
            if (wantCount > Collections.frequency(discountList, key)) return false;
        }

        return true;
    }
}
