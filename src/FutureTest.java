import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.google.common.collect.Lists;


public class FutureTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BasicConfigurator.configure();
		Logger log = Logger.getLogger(FutureTest.class);
		List<String> str = Lists.newArrayList("a", "b");
		String string = StringUtils.join(str, "...");
		log.info(string);
		
	}

}
