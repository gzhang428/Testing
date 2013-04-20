package com.guannan.learning;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class AnotherTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BasicConfigurator.configure();
		Logger logger = Logger.getLogger(AnotherTest.class);
		String str = "hello";
		logger.debug(str);
	}

}
