package inaeinae.studycodingtest.PGS;

/**
 * [PGS] 카펫 / lv2
 * (2023.06.02) https://school.programmers.co.kr/learn/courses/30/lessons/42842
 */
public class PGS_42842 {
    public int[] solution(int brown, int yellow) {
        int[] answer = {0,0};

        for(int yellowRow = 1; yellowRow <= yellow; yellowRow++) {
            int top = yellowRow + 2;
            int side = yellow / yellowRow;

            if((top*2) + (side*2) == brown && top >= side+2) {
                return new int[] {top, side + 2};
            }
        }

        return answer;
    }
}
