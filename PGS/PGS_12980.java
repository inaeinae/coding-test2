package inaeinae.studycodingtest.PGS;

/**
 * [PGS] 점프와 순간이동 / lv2
 * (2023.05.14) https://school.programmers.co.kr/learn/courses/30/lessons/12980
 */
public class PGS_12980 {
    public int solution(int n) {
        int ans = 0;

        while(n > 0) {
            if(n % 2 > 0) ans += (n % 2);
            n = n / 2;
        }

        return ans;
    }
}
