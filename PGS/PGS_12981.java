package inaeinae.studycodingtest.PGS;

import java.util.*;

/**
 * [PGS] 영어 끝말잇기 / lv2
 * (2023.05.30) https://school.programmers.co.kr/learn/courses/30/lessons/12981
 */
public class PGS_12981 {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        ArrayList<String> chkArr = new ArrayList<String>();
        chkArr.add(words[0]);

        for(int i = 1; i < words.length; i++) {
            String word = words[i];
            String before = words[i-1];

            if(chkArr.contains(word) || before.charAt(before.length()-1) != word.charAt(0)) {
                int num = (i+1) % n;
                int count = ((i+1) / n) + 1;

                if(num == 0) {
                    num = n;
                    count--;
                }

                answer[0] = num;
                answer[1] = count;
                break;
            }

            chkArr.add(word);
        }

        return answer;
    }
}
