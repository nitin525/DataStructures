package strings;

import java.util.HashMap;
import java.util.Map;

public class BoyceMoore {

	private String text;
	private String pattern;
	Map<Character, Integer> misMatchText;
	
	public BoyceMoore(String text, String pattern) {
		this.text = text;
		this.pattern = pattern;
		this.misMatchText = new HashMap<Character, Integer>();
	}

	public static void main(String[] args) {
		
	}
	
	
}
