package com.mindali.zeev.question;

import com.mindali.zeev.question.util.Art;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuestionApplication {

	public static void main(String[] args) {
		//run our awesome startup , and show it to mom :)
		SpringApplication.run(QuestionApplication.class, args);
		//prints banner to indicate server is running
		System.out.println(Art.banner);
	}


}
