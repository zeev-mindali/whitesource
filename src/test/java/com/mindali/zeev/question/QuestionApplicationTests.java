package com.mindali.zeev.question;

import com.mindali.zeev.question.service.UserData;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import java.util.Arrays;
import java.util.TreeSet;

class QuestionApplicationTests {

	private QuestionApplicationTests(TestInfo testInfo){
		System.out.println("Working on test "+testInfo.getDisplayName());
	}

	@SneakyThrows
	@Tag("DEV")
	@Test
	void testSystem() {
		System.out.println("testing the system");
		UserData userData = new UserData();
		String input = "" +
				"{" +
				"\"e1\": \"1\"," +
				"\"graph\": \"digraph graphname {\\n0->1\\n0->2\\n2->1\\n3->4\\n}\"" +
				"}";

		Assertions.assertEquals(new TreeSet<>(Arrays.asList(3,4)),new UserData().nonReach(input));
		System.out.println((new UserData()).nonReach(input));
	}

}
