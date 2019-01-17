package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class DuplicateCharInAString {

	public static void main(String[] args) {
		
		int i = 0;
		while(i < 1024) {
			System.out.println(i + "-" + (char)i);
			i++;
		}
		
		
		String input = "REVANTHKRISHNAKUMAR";
		Map<Character, Integer> occurence = new HashMap<Character, Integer>();
		for (char c : input.toCharArray()) {
			int val = occurence.get(c) == null ? 0 : occurence.get(c);
			occurence.put(c, ++val);
		}
		
		for(Entry<Character, Integer> entry : occurence.entrySet()) {
			if(entry.getValue() > 1) {
				System.out.println(entry.getKey());
			}
		}
	}

}
