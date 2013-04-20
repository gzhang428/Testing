import org.apache.commons.lang3.StringUtils;


public class FutureTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] str = {"a", "b"};
		String string = StringUtils.join(str, "...");
		System.out.println(string);
		
	}

}
