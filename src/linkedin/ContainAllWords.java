package linkedin;

import java.util.HashMap;
import java.util.Map.Entry;

public class ContainAllWords {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ContainAllWords c = new ContainAllWords();
		String[] words = {"W1", "W2", "W3"};
		String doc = "ha ha W2 foo bar W1 dog W3 fine ok";
		System.out.println(c.containAllWords(doc, words));
	}

	private boolean containAllWords(String doc, String[] words) {
		HashMap<String, Integer> pos = new HashMap<String, Integer>();
		for (String word: words){
			pos.put(word, -1);
		}
		int max = 0;
		int min = 0;
		int length = 0;
		String[] docWords = doc.split(" ");
		for (int i =0; i < docWords.length; i++){
			String w = docWords[i];
			if (pos.containsKey(w)){
				pos.put(w, i);
				for(Entry<String, Integer> e: pos.entrySet()){
					String key = e.getKey();
					int p = e.getValue();
					
					if( p < 0)
						break;
					else{
						
					}
				}
			}
		}
		return false;
	}

}
