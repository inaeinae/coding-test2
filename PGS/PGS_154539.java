package inaeinae.studycodingtest.PGS;

import java.util.Stack;

/**
 * [PGS] 뒤에 있는 큰 수 찾기 / lv2
 * (2023.09.17) https://school.programmers.co.kr/learn/courses/30/lessons/154539
 */
public class PGS_154539 {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);

        for(int i = 1; i < numbers.length; i++) {
            while(!stack.empty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.peek()] = numbers[i];
                stack.pop();
            }
            stack.push(i);
        }

        while(!stack.empty()) {
            answer[stack.peek()] = -1;
            stack.pop();
        }

        return answer;
    }
}
