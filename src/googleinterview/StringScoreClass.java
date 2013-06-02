package googleinterview;

public class StringScoreClass implements StringScore {

	@Override
	public int score(String s) {
		
		return s.length();
	}

}
