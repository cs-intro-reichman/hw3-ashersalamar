/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String s1 = preProcess(str1);
		String s2 = preProcess(str2);
		
		if(s1.length() != s2.length()) return false;

		//problemas en la implementación del algoritmo: 1. char en i puede ser char repetidos en j 2. cómo devolver un boolean true
		boolean[] used = new boolean[s2.length()];

		for (int i = 0; i < s1.length(); i++){
			boolean found = false;

			for (int j = 0; j < s2.length(); j++){
				if (!used[j] && s1.charAt(i) == s2.charAt(j)){
					used [j] = true;
					found = true;
					break;
				}
			} if (!found) return false;
		} return true;
}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String s = "";
		for (int i = 0; i < str.length(); i++){
			char c = str.charAt(i);
			
			if (c >='A' && c <= 'Z'){
				c = (char)(c+32);
			}  
			if (c == 32){
				continue;
			}
			if (c >= 'a' && c <= 'z'){
				s += c;
			}
		} return s;
	 
	} 




	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String s1 = preProcess(str);
		String s2 = "";
		boolean[] used = new boolean[s1.length()];
		
		for (int i = 0; i < s1.length(); i++){
			int j;
			do {
				j = (int)(Math.random()*s1.length()); 
			} while (used[j]);
				used [j] = true;
				
			char c = s1.charAt(j);
			s2 += c;
			} return s2;
	}
	

}
