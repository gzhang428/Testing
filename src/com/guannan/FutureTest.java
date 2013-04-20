package com.guannan;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.google.common.collect.Lists;


public class FutureTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BasicConfigurator.configure();
		Logger logger = Logger.getLogger(FutureTest.class);
		logger.setLevel(Level.INFO);
		List<String> str = Lists.newArrayList("a", "b");
		String string = StringUtils.join(str, "...");
		logger.info(string);
		
	}

}
