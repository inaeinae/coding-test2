package inaeinae.studycodingtest.PGS;

import java.util.*;

/**
 * [PGS] 이중우선순위큐 / lv3
 * (2023.05.19) https://school.programmers.co.kr/learn/courses/30/lessons/42628
 */
public class PGS_42628 {
    public int[] solution(String[] operations) {
        int[] answer = {0,0};
        ArrayList<Integer> queue = new ArrayList<Integer>();

        for(String sOp : operations) {
            //값 추가
            if(sOp.contains("I")) {
                int iVal = Integer.parseInt(sOp.replace("I","").trim());
                queue.add(iVal);
            }

            //값 삭제
            if(sOp.contains("D")) {
                if(queue.isEmpty()) continue;

                int iFlag = Integer.parseInt(sOp.replace("D", "").trim());
                int iDelVal = (iFlag == 1) ? Collections.max(queue) : Collections.min(queue);
                int iDelValIdx = queue.indexOf(iDelVal);

                queue.remove(iDelValIdx);
            }
        }

        if(!queue.isEmpty()) {
            answer[0] = Collections.max(queue);
            answer[1] = Collections.min(queue);
        }

        return answer;
    }
}
