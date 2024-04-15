package inaeinae.studycodingtest.PGS;

/**
 * [PGS] 최고의 집합 / lv3
 * (2024.03.26) https://school.programmers.co.kr/learn/courses/30/lessons/12938
 */
public class PGS_12938 {
    public int[] solution(int n, int s) {
        int[] group = new int[n];
        if (n > s) return new int[]{-1};

        for (int i = n; i > 0; i--) {
            int num = s / i;
            group[n - i] = num;
            s = s - num;
        }

        return group;
    }
}
