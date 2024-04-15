package inaeinae.studycodingtest.PGS;

import java.util.regex.*;

/**
 * [PGS] JadenCase 문자열 만들기 / lv2
 * (2024.04.10) https://school.programmers.co.kr/learn/courses/30/lessons/12951
 */
public class PGS_12951 {
    public String solution(String s) {
        s = s.toLowerCase();
        Pattern pattern = Pattern.compile("^[a-z]|\\b[a-z]");
        Matcher matcher = pattern.matcher(s);

        while(matcher.find()){
            s = s.substring(0, matcher.start()) + matcher.group().toUpperCase() + s.substring(matcher.end());
        }

        return s;
    }
}
