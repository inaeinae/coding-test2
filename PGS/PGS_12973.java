package inaeinae.studycodingtest.PGS;

/**
 * [PGS] 짝지어 제거하기 / lv2
 * (2023.05.18) https://school.programmers.co.kr/learn/courses/30/lessons/12973
 */
public class PGS_12973 {
    public int solution(String s) {
        while(true) {
            String repStr = s.replaceFirst("(\\w)\\1", "");

            if(s.equals(repStr)) return 0;
            if(repStr.length() == 0) return 1;

            s = repStr;
        }
    }
}
