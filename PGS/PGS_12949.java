package inaeinae.studycodingtest.PGS;

/**
 * [PGS] 행렬의 곱셈 / lv2
 * (2024.04.02) https://school.programmers.co.kr/learn/courses/30/lessons/12949
 */
public class PGS_12949 {
    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                int multi = 0;

                for (int a = 0; a < arr2.length; a++) {
                    multi += arr1[i][a] * arr2[a][j];
                }

                answer[i][j] = multi;
            }
        }

        return answer;
    }
}
