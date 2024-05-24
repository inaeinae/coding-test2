package inaeinae.studycodingtest.PGS;

import java.util.*;
import java.util.stream.Collectors;

/**
 * [PGS] 디스크 컨트롤러 / lv3
 * (2024.05.25) https://school.programmers.co.kr/learn/courses/30/lessons/42627
 */
public class PGS_42627 {
    ArrayList<ArrayList<Integer>> jobArrayList = new ArrayList<>();
    int lastEndTime = 0;

    public int solution(int[][] jobs) {
        int sum = 0;
//        jobArrayList = new ArrayList<>();
//        lastEndTime = 0;

        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]!=o2[0] ? o1[0]-o2[0] : o1[1]-o2[1];
            }
        });

        for (int i = 0; i < jobs.length; i++) {
            ArrayList<Integer> job = new ArrayList<>();
            job.add(jobs[i][0]);
            job.add(jobs[i][1]);
            jobArrayList.add(job);
        }

        while (jobArrayList.size() > 0) {
            ArrayList<Integer> targetJob = jobArrayList.get(0);
            int insertTime = 0;
            int workTime = 0;
            int waitingTime = 0;

            if (lastEndTime >= targetJob.get(0) && jobArrayList.size() > 1) {
                ArrayList<Integer> replaceJob = (ArrayList<Integer>) jobArrayList.stream()
                        .filter(job -> job.get(0) <= lastEndTime)
                        .min((j1,j2) -> j1.get(1) - j2.get(1))
                        .orElse(null);
                if (replaceJob != null) {
                    targetJob = replaceJob;
                }
            }

            jobArrayList.remove(targetJob);
            insertTime = targetJob.get(0);
            workTime = targetJob.get(1);

            waitingTime = (insertTime < lastEndTime) ? lastEndTime - insertTime : 0;
            lastEndTime = (insertTime < lastEndTime) ? lastEndTime + workTime : insertTime + workTime;
            sum += (waitingTime + workTime);
        }

        return (int) sum / jobs.length;
    }
}
