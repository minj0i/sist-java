package day1205;

import java.util.StringTokenizer;

public class Homework22 {
	public Homework22() {
		String names = "이재찬,이재현.공선의,정택성~이재현!최지우.김희철,이재찬,이재찬,정택성.공선의";
		StringTokenizer stk = new StringTokenizer(names, ",.!~", false);
		while (stk.hasMoreTokens()) {
			System.out.print(stk.nextToken() + " ");
		}
		System.out.println();
	}

	public int[] Lotto() {
		int[] lotto = new int[6];
		int value;
		for (int i = 0; i < lotto.length; i++) {
			value = (int) ((Math.random() * 45) + 1);
			lotto[i] = value;

			for (int j = 0; j < i; j++) {
				if (lotto[i] == lotto[j]) {
					i--;
					break;
				} // end if
			} // end for j
		} // end for i
		for (int i = 0; i < lotto.length; i++) {
			System.out.print(lotto[i] + " ");
		}
		return lotto;
	}

	public static void main(String[] args) {
		new Homework22().Lotto();

	}

}
