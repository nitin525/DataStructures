package practice;

import java.util.Scanner;

public class StringPermutations {
	
	//ASCII character a - 97 , z - 122 ; 26 alphabets
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		int i = input.charAt(0);
		System.out.println(i);
	}

	private String swap(String str, int i, int j){
		char temp = str.charAt(i);
		char charI = str.charAt(j);
		char charJ = str.charAt(temp);
		int asd = str.charAt(0);
		return str;
	}
	
	
}
