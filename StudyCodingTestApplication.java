package inaeinae.studycodingtest;

import inaeinae.studycodingtest.Doit.No20_P2751;
import inaeinae.studycodingtest.PGS.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class StudyCodingTestApplication {

	public static void main(String[] args) throws IOException {
		PGS_42885 pgs42885 = new PGS_42885();
		System.out.println("expect : 3, result : " + pgs42885.solution(new int[]{70, 50, 80, 50}, 100));
		System.out.println("expect : 3, result : " + pgs42885.solution(new int[]{70, 80, 50}, 100));
	}

}
