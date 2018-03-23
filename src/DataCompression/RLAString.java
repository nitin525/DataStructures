package DataCompression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RLAString {


	public static void main(String[] args) {
		String testString= "AAAVVFFFFHHEEEKKKKSSCNSKFFFWFWFFFFFFFFQQQQQQQQQQQQQQQQQQQQQQQQQQQQQI";
		System.out.println(testString);
		System.out.println(encode(testString));
		System.out.println(decode(encode(testString)));
	}
	
	
	public static String encode(String rawString){	
		StringBuilder encodedString = new StringBuilder();
		for(int i=0; i<rawString.length();i++){
			int charCount = 1;
			//Important, take notice of the construct... the present and the next is always checked.
			while(i+1<rawString.length() && rawString.charAt(i)==rawString.charAt(i+1)){
				charCount++;
				i++;
			}
			encodedString.append(charCount);
			encodedString.append(rawString.charAt(i));
		}
		return encodedString.toString();
	}
 
	public static String decode(String compressedString){
		StringBuilder decodedString = new StringBuilder();
		Pattern pattern = Pattern.compile("[0-9]+|[A-Za-z]");
		Matcher matcher = pattern.matcher(compressedString);
		
		
		while(matcher.find()){
			int runLength = Integer.parseInt(matcher.group());
			
			matcher.find();
			while(runLength != 0 ){
				decodedString.append(matcher.group());
				runLength--;
			}
		}		
		return decodedString.toString();
	}


}