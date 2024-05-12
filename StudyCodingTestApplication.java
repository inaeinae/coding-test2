package inaeinae.studycodingtest;

import inaeinae.studycodingtest.Doit.No20_P2751;
import inaeinae.studycodingtest.PGS.PGS_138476;
import inaeinae.studycodingtest.PGS.PGS_250137;
import inaeinae.studycodingtest.PGS.PGS_43105;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class StudyCodingTestApplication {

	public static void main(String[] args) throws IOException {
		System.out.println("Hello World");
//		PGS_43105 pgs43105 = new PGS_43105();
//		System.out.println(pgs43105.solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
		PGS_138476 pgs138476 = new PGS_138476();
		System.out.println("expect : 3 , result : " + pgs138476.solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
		System.out.println("expect : 2 , result : " + pgs138476.solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
		System.out.println("expect : 1 , result : " + pgs138476.solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3}));
	}

}
