package common;

public class Trie {

	public TrieNode createTrie(){
		return new TrieNode('\0', false);
	}
	
	public void insertWord (TrieNode root, String word){
		char offset = 'a';
		char[] letters = word.toCharArray();
		int length = letters.length;
		TrieNode current = root;
		
		for (int i = 0; i < length; i++){
			int pos = letters[i] - offset;
			if (current.links[pos] == null){
				current.links[pos]  = new TrieNode(letters[i], (i == length -1)? true: false);
			}
			current = current.links[pos];
		}
	}
	
	/**
	 * corret: i==length, current != null; full = true;
	 * 
	 * @param root
	 * @param word
	 * @return
	 */
	public boolean find(TrieNode root, String word){
		char[] letters = word.toCharArray();
		int length = letters.length;
		char offset ='a';
		TrieNode current = root;
		
		int i;
		for (i = 0; i < length; i++){
			int pos = letters[i] - offset;
			if(current == null){
				return false;
			}
			
			current = current.links[pos];
			
		}
		
		if(i == length && current == null)
			return false;
		
		if( current != null && !current.fullWord)
			return false;
		
		return true;
	}
	
	public void printTrie(TrieNode root, int level, char[] buf){
		if(root == null){
			return;
		}
		
		for (int i = 0; i< root.links.length; i++){
			buf[level] = root.letter;
			printTrie(root.links[i], level + 1, buf);
			
		}
		
		if(root.fullWord){
			for(int j = 1; j<=level; j++)
				System.out.print(buf[j]);
			System.out.println();
		}
		
	}
	
	public static void main(String[] args){
		Trie t = new Trie();
		TrieNode root = t.createTrie();
		t.insertWord(root, "hello");
		t.insertWord(root, "hi");
		t.insertWord(root, "nihao");
		boolean found = t.find(root, "hell");
		char[] buffer = new char[6];
		t.printTrie(root, 0, buffer);
	}
}
