package inaeinae.studycodingtest.BaekJoon;

import java.util.*;
import java.io.*;

/**
 * [BJ] 특별한 학교 이름 / lv5
 * (2025.12.11) https://www.acmicpc.net/problem/27889
 */
public class BJ_27889 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<String, String> dictionary = new HashMap<>();
        dictionary.put("NLCS", "North London Collegiate School");
        dictionary.put("BHA", "Branksome Hall Asia");
        dictionary.put("KIS", "Korea International School");
        dictionary.put("SJA", "St. Johnsbury Academy");

        bw.write(dictionary.get(br.readLine()));

        bw.flush();
        bw.close();
    }
}
