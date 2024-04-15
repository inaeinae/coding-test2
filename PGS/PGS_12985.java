package inaeinae.studycodingtest.PGS;

/**
 * [PGS] 예상 대진표 / lv2
 * (2023.05.14) https://school.programmers.co.kr/learn/courses/30/lessons/12985
 */
public class PGS_12985 {
    public int solution(int n, int a, int b) {
        int answer = 0;

        while(true) {
            answer++;
            int min = a < b ? a : b;
            int max = a < b ? b : a;
            if(min + 1 == max && min % 2 > 0) break;

            if(a % 2 > 0) a++;
            if(b % 2 > 0) b++;

            a = a / 2;
            b = b / 2;
        }

        return answer;
    }
}
