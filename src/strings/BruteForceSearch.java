package strings;

public class BruteForceSearch {
	public static void main(String[] args) {
		
		
	}
	
	private int bruteForceSearch(String mainText, String pattern){
		
		int mainLength = mainText.length();
		int patternLength = pattern.length();
		
		for(int i = 0; i <mainLength-patternLength ; i ++){
			int j;
			
			for(j=0; j<patternLength ; j++){	
				if(mainText.charAt(i+j)!=pattern.charAt(j))
					break;
			}
			
			if(j==pattern.length())
				return i;
		}
		
		return -1;
	} 
}
