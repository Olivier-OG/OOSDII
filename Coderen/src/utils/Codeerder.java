package utils;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Codeerder {
	private final static Character[] MEDEKLINKERS = { 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q',
			'r', 's', 't', 'v', 'w', 'x', 'z' };

	public static String codeer(String bericht) {
		Set<Character> medeklinkers = new HashSet<Character>(Arrays.asList(MEDEKLINKERS));
		ArrayDeque<Character> reeksMetMedeklinkers = new ArrayDeque<>();
		String resultaat = "";

		for (int i = 0; i < bericht.length(); i++) {
			char letter = bericht.charAt(i);
			if (medeklinkers.contains(letter))
				reeksMetMedeklinkers.push(letter);
			else {
				while (!reeksMetMedeklinkers.isEmpty()) {
					resultaat += reeksMetMedeklinkers.pop();
				}
				resultaat += letter;
			}
		}
		while (!reeksMetMedeklinkers.isEmpty()) {
			resultaat += reeksMetMedeklinkers.pop();
		}
		return resultaat;
	}

}
