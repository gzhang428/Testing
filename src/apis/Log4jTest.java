package apis;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.google.common.collect.Lists;

public class Log4jTest {
	private static Logger logger = LogManager.getLogger(Log4jTest.class);
	
	public static void main(String[] args) {
		//BasicConfigurator.configure();
		PropertyConfigurator.configure("config/log4j.properties");
		logger.info("hello, world");
		List<String> str = Lists.newArrayList("a", "b");
		String string = StringUtils.join(str, "...");
		logger.warn(string);
	}

	
}
