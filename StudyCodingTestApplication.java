package inaeinae.studycodingtest;

import inaeinae.studycodingtest.Doit.No20_P2751;
import inaeinae.studycodingtest.PGS.PGS_250137;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class StudyCodingTestApplication {

	public static void main(String[] args) throws IOException {
		System.out.println("Hello World");
		No20_P2751 doitNo20 = new No20_P2751();
		doitNo20.solution();
	}

}
