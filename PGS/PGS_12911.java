package inaeinae.studycodingtest.PGS;

/**
 * [PGS] 다음 큰 숫자 / lv2
 * (2023.06.14) https://school.programmers.co.kr/learn/courses/30/lessons/12911
 */
public class PGS_12911 {
    public int solution(int n) {
        int answer = n+1;
        long numCnt = getBinaryCnt(n);

        while(true) {
            if(getBinaryCnt(answer) == numCnt) break;
            answer++;
        }

        return answer;
    }

    private int getBinaryCnt(int num) {
        String binaryStr = Integer.toString(num, 2);
        return binaryStr.length() - binaryStr.replace("1", "").length();
        	/*return Arrays.stream(binaryStr.split(""))
			        	.filter(e -> e.equals("1"))
			        	.count();*/
    }
}
