package inaeinae.studycodingtest.BaekJoon;

import java.io.*;
import java.util.*;

/**
 * [BJ] 나는야 포켓몬 마스터 이다솜 / silver lv4
 * (2026.01.12) https://www.acmicpc.net/problem/1620
 */
public class BJ_1620 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int pokemonCount = Integer.parseInt(st.nextToken());
        int questionCount = Integer.parseInt(st.nextToken());

        String[] pokemonNumbers = new String[pokemonCount+1];
        HashMap<String, Integer> pokemonNames = new HashMap<>();

        for (int i = 1; i <= pokemonCount; i++) {
            String input = br.readLine();
            pokemonNumbers[i] = input;
            pokemonNames.put(input, i);
        }

        for (int i = 0; i < questionCount; i++) {
            String question = br.readLine();

            if (pokemonNames.containsKey(question)) {
                System.out.println(pokemonNames.get(question));
                continue;
            }

            System.out.println(pokemonNumbers[Integer.parseInt(question)]);
        }
    }
}
