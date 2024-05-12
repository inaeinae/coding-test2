package inaeinae.studycodingtest.PGS;


import java.util.*;
import java.util.stream.Collectors;

/**
 * [PGS] 귤 고르기 / lv2
 * (2024.05.12) https://school.programmers.co.kr/learn/courses/30/lessons/138476
 * TO-BE : 테스트 27, 30  시간초과 해결
 */
public class PGS_138476 {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        ArrayList<Integer> tangerineList = Arrays.stream(tangerine).sorted().boxed().collect(Collectors.toCollection(ArrayList::new));
        Integer[] tangerinePackageKeyArr;
        int[] tangerinePackageCountArr;

        tangerinePackageKeyArr = (new HashSet<Integer>(tangerineList)).toArray(new Integer[0]);
        tangerinePackageCountArr = new int[tangerinePackageKeyArr.length];

        for (int i = 0; i < tangerinePackageKeyArr.length; i++) {
            int packageKey = tangerinePackageKeyArr[i];
            int packageCount = 0;

            for (int j = 0; j < tangerine.length; j++) {
                if (tangerine[j] != packageKey) continue;
                packageCount++;
            }

            tangerinePackageCountArr[i] = packageCount;
        }

        Arrays.sort(tangerinePackageCountArr);
        for (int i = tangerinePackageCountArr.length - 1; i >= 0; i--) {
            k = k - tangerinePackageCountArr[i];
            answer++;
            if (k <= 0) break;
        }

        return answer;
    }
}
