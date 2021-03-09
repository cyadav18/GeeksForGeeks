package SAP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution2 {

	public static void main(String[] args) {
		String s = null;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			s = in.readLine();
			s = s.toLowerCase();
			StringBuilder sb = new StringBuilder();
			Map<String, String> translator = new HashMap<>();
			fillTranslator(translator);
			for (int i = 0; i < s.length(); i++) {
				if (translator.get(s.charAt(i) + "") != null) {
					sb.append(translator.get((s.charAt(i) + "")));
				} else {
					sb.append(s.charAt(i));
				}
			}
			System.out.println(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void fillTranslator(Map<String, String> translator) {
		translator.put("a", "@");
		translator.put("b", "8");
		translator.put("c", "(");
		translator.put("d", "|)");
		translator.put("e", "3");
		translator.put("f", "#");
		translator.put("g", "6");
		translator.put("h", "[-]");
		translator.put("i", "|");
		translator.put("j", "_|");
		translator.put("k", "|<");
		translator.put("l", "1");
		translator.put("m", "[]\\/[]");
		translator.put("n", "[]\\[]");
		translator.put("o", "0");
		translator.put("p", "|D");
		translator.put("q", "(,)");
		translator.put("r", "|Z");
		translator.put("s", "$");
		translator.put("t", "']['");
		translator.put("u", "|_|");
		translator.put("v", "\\/");
		translator.put("w", "\\/\\/");
		translator.put("x", "}{");
		translator.put("y", "`/");
		translator.put("z", "2");
	}
}
