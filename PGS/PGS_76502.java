package inaeinae.studycodingtest.PGS;

import java.util.*;

/**
 * [PGS] 괄호 회전하기 / lv2
 * (2024.03.24) https://school.programmers.co.kr/learn/courses/30/lessons/76502
 */
public class PGS_76502 {
    ArrayList<String> starter = new ArrayList<>(Arrays.asList("(", "{", "["));

    public int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            // 문자열 회전
            s = s.substring(1) + s.substring(0, 1);
            // 괄호 짝 찾기
            if (!checkParentheses(s)) continue;
            answer++;
        }

        return answer;
    }

    public boolean checkParentheses(String s) {
        ArrayList<String> allParentheses = new ArrayList<>(Arrays.asList(s.split("")));
        ArrayList<String> startParentheses = new ArrayList<>();

        for (String parenthesis : allParentheses) {
            String findStarter = "";

            if (starter.indexOf(parenthesis) > -1) {
                startParentheses.add(parenthesis);
                continue;
            }

            switch (parenthesis) {
                case ")": findStarter = "("; break;
                case "}": findStarter = "{"; break;
                case "]": findStarter = "["; break;
            }

            if (startParentheses.size() == 0 || !(findStarter.equals(startParentheses.get(startParentheses.size()-1)))) {
                return false;
            }

            startParentheses.remove(startParentheses.size()-1);
        }

        return (startParentheses.size() == 0) ? true : false;
    }
}
