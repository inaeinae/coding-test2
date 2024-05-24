package inaeinae.studycodingtest;

import inaeinae.studycodingtest.Doit.No20_P2751;
import inaeinae.studycodingtest.PGS.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class StudyCodingTestApplication {

	public static void main(String[] args) throws IOException {
		PGS_42627 pgs42627 = new PGS_42627();
		System.out.println("expect : 9, result : " + pgs42627.solution(new int[][]{{1, 9}, {0, 3}, {2, 6}}));
		System.out.println("expect : 72, result : " + pgs42627.solution(new int[][]{{24, 10}, {28, 39}, {43, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43}, {26, 1}}));
		System.out.println("expect : 6, result : " + pgs42627.solution(new int[][]{{0, 5}, {2, 10}, {10000, 2}}));
	}
}
