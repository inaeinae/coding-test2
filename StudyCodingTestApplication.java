package inaeinae.studycodingtest;

import inaeinae.studycodingtest.Doit.No20_P2751;
import inaeinae.studycodingtest.PGS.PGS_138476;
import inaeinae.studycodingtest.PGS.PGS_250137;
import inaeinae.studycodingtest.PGS.PGS_42626;
import inaeinae.studycodingtest.PGS.PGS_43105;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class StudyCodingTestApplication {

	public static void main(String[] args) throws IOException {
		PGS_42626 pgs42626 = new PGS_42626();
		System.out.println("expect : -1 , result : " + pgs42626.solution(new int[]{2}, 5));
		System.out.println("expect : -1 , result : " + pgs42626.solution(new int[]{2, 7, 16}, 10000));
		System.out.println("expect : 3 , result : " + pgs42626.solution(new int[]{3, 7, 30, 15, 16, 5}, 30));
		System.out.println("expect : 0 , result : " + pgs42626.solution(new int[]{7, 8, 9, 10, 20}, 3));
		System.out.println("expect : 2 , result : " + pgs42626.solution(new int[]{9, 10, 12, 1, 2, 3}, 7));
	}

}
