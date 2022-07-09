package com.algonquin.loggy;

import java.util.Random;

public class ShortCodeGenerator {

	private static ShortCodeGenerator shortCodeGenerator;

	private static boolean initialized = false;

	private ShortCodeGenerator() {

	}

	public static synchronized ShortCodeGenerator getInstance() {

		if (initialized)
			return shortCodeGenerator;

		shortCodeGenerator = new ShortCodeGenerator();
		initialized = true;

		return shortCodeGenerator;

	}

	String shortCode() {

		return randomChars(3) + "-" + randomChars(3) + "-" + randomChars(3);
	}

	private String randomChars(int n) {

		String randomChars = "";
		String chars = "abcdefghijklmnopqrstuvwxyz1234567890";
		Random rnd = new Random();

		for (int i = 0; i < n; i++)
			randomChars += chars.charAt(rnd.nextInt(chars.length()));

		return randomChars;
	}

}
