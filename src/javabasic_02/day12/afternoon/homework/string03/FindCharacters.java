package javabasic_02.day12.afternoon.homework.string03;

public class FindCharacters {

	
	public static void main(String[] args) {
		FindCharacters fc=new FindCharacters();
		int count=fc.countChar("Boys, be ambitious", 'b');
		System.out.println(count);

	}
	public int countChar(String str, char c) {
		// Method를 완성하세요...
		int[] asciiCount = new int[128];
		for (char ch : str.toCharArray()) {
			asciiCount[ch]++;
		}
		return asciiCount[c];
	}
}
