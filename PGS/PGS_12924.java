package inaeinae.studycodingtest.PGS;

/**
 * [PGS] 숫자의 표현 / lv2
 * (2023.06.12) https://school.programmers.co.kr/learn/courses/30/lessons/12924
 */
public class PGS_12924 {
    public int solution(int n) {
        int answer = 1;

        for(int j = 1; j <= n/2; j++) {
            int sum = 0;

            for(int i = j; (sum+i) <= n; i++) { sum += i; }
            if(sum == n) { answer++; }
        }

        return answer;
    }
}
