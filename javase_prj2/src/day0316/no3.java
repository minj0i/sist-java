package day0316;

public class no3 {
	public String solution(String word) {
		String result = "";
		String[] upperCase = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
				"S", "T", "U", "V", "W", "X", "Y", "Z" };
		String[] lowerCase = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
				"s", "t", "u", "v", "w", "x", "y", "z" };
		String flag = "";
		String[] answer = new String[word.length()];

		for (int i = 0; i < word.length(); i++) {
			flag = word.substring(i, i + 1);
			if (flag.equals(" ")) {
				result += " ";
			} else {
				for (int j = 0; j < 26; j++) {
					if (flag.equals(upperCase[j])) {
						result += upperCase[25 - j];
					} else if (flag.equals(lowerCase[j])) {
						result += lowerCase[25 - j];
					} else {
						result += "";
					}
				}
			}
		}
		System.out.println(result);
		return result;
	}

	public static void main(String[] args) {
		no3 no3 = new no3();
		no3.solution("I love you");
	}

}
