package string_processor;
import java.util.*;
import java.util.StringTokenizer;

public class StringProcessor {

	private String string;
	private String[] numberWords = {"zero","one","two","three","four","five","six","seven","eight","nine"};
	private char[] vowels = {'a','e','i','o','u'};
	
	public StringProcessor() {
		
	}
	
	public StringProcessor(String s) {
		string = s;
	}
	
	public void setString(String s) {
		string = s;
	}
	
	public String getString() {
		return string;
	}

	public int wordCount() {
		String clean = string.trim();
		String[] tokens = clean.split(" ");
		
		return tokens.length;
	}

	public int uppercaseCount() {
		char currentChar;
		int numUppercase = 0;
		
		for(int i=0; i<string.length(); i++) {
			currentChar = string.charAt(i);
			if(Character.isUpperCase(currentChar)) {
				numUppercase++;
			}
		}
		
		return numUppercase;
	}
	
	public int digitCount() {
		char currentChar;
		int numDigits = 0;
		
		for(int i=0; i < string.length(); i++) {
			currentChar = string.charAt(i);
			if(Character.isDigit(currentChar)) {
				numDigits++;
			}
		}
		
		return numDigits;
	}
	
	public int digitWordCount() {
		StringBuilder lcString = new StringBuilder(string.trim());
		String clean;
		char currentChar;
		String currentWord;
		String currentNumberWord;
		int numMatches = 0;
		
		for(int i=0; i<string.length(); i++) {
			currentChar = string.charAt(i);
			lcString.setCharAt(i, Character.toLowerCase(currentChar));
		}
		
		clean = lcString.toString();
		String[] words = clean.split(" ");
		
		for(int i=0; i<words.length; i++) {
			currentWord = words[i];
			for(int k=0; k<numberWords.length; k++) {
				currentNumberWord = numberWords[k];
				if(currentWord.equals(currentNumberWord)) {
					numMatches++;
				}
			}
		}
		
		return numMatches;
	}
	
	public String getNoSpaceString() {
		StringTokenizer tokenizer = new StringTokenizer(string.trim()," ");
		String stringWithoutSpaces = "";
		
		while(tokenizer.hasMoreTokens()) {
			stringWithoutSpaces += tokenizer.nextToken();
		}
		
		return stringWithoutSpaces;
	}
	
	public String getNoVowelString() {
		char currentChar;
		StringBuilder newString = new StringBuilder(string);
		
		for(int i=0; i<string.length(); i++) {
			currentChar = string.charAt(i);
			currentChar = Character.toLowerCase(currentChar);
			if(currentChar == 'a' || currentChar == 'e' || currentChar == 'i' || currentChar == 'o' || currentChar == 'u') {
				newString.replace(i, (i+1), "-");
			}
		}
		
		return newString.toString();
	}
	
	public String getNoDigitWordString() {
		StringBuilder lcString = new StringBuilder(string);
		String clean;
		char currentChar;
		String currentWord;
		String currentNumberWord;
		
		for(int i=0; i<string.length(); i++) {
			currentChar = string.charAt(i);
			lcString.setCharAt(i, Character.toLowerCase(currentChar));
		}
		
		clean = lcString.toString();
		String[] words = clean.split(" ");
		
		for(int i=0; i<words.length; i++) {
			currentWord = words[i];
			for(int k=0; k<numberWords.length; k++) {
				currentNumberWord = numberWords[k];
				if(currentWord.equals(currentNumberWord)) {
					words[i] = String.valueOf(k);
				}
			}
		}
		
		clean = "";
		for(int i=0; i<words.length; i++) {
			clean += words[i];
			if(i < (words.length - 1)) {
				clean += " ";
			}
		}
		
		
		return clean;
	}
}
