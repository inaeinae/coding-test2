package inaeinae.studycodingtest.PGS;

import java.util.*;

/**
 * [PGS] 최솟값 만들기 / lv2
 * (2024.03.24) https://school.programmers.co.kr/learn/courses/30/lessons/12941
 */
public class PGS_12941 {
    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[B.length - 1- i];
        }

        return answer;
    }
}
