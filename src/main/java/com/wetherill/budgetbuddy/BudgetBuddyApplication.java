package com.wetherill.budgetbuddy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

@SpringBootApplication
public class BudgetBuddyApplication {

	public static void main(String[] args) {

		boolean guiFlag = false;
		boolean webFlag = false;

		for (String arg : args) {
			arg = arg.toLowerCase().trim();
			if (arg.equals("gui")) {
				guiFlag = true;
			}
			if (arg.equals("web")) {
				webFlag = true;
			}
		}

		if (guiFlag) {

		}

		if (webFlag) {
			SpringApplication.run(BudgetBuddyApplication.class, args);
		}
	}

}
