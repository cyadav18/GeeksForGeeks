package SAP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution3 {

	public static void main(String[] args) {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n;
		while (true) {

			try {
				n = Integer.parseInt(in.readLine());
				if (n == 0)
					break;

				String[] x = in.readLine().split(" ", -1);
				Map<String, Map<String, String>> units = new LinkedHashMap<String, Map<String, String>>();
				Map<String, String> base = new LinkedHashMap<>();
				for (int i = 0; i < n; i++) {
					base.put(x[i], -1 + "");
				}
				for (int i = 0; i < n; i++) {
					units.put(x[i], new LinkedHashMap<>(base));
					units.get(x[i]).put(x[i], "" + 1);
				}
				for (int i = 0; i < n - 1; i++) {
					String[] z = in.readLine().split(" ", -1);
					units.get(z[0]).put(z[3], z[2]);
					units.get(z[3]).put(z[0], (1 / Double.parseDouble(z[2]) + ""));
				}
				for (int o = 0; o < 3; o++) {
					for (int i = 0; i < n; i++) {
						propagate(units, units.get(x[i]), x[i]);
					}
				}
				String biggest = "";
				int index = 0;
				for (index = 0; index < n; index++) {
					boolean b = true;
					for (int y = 0; y < n; y++) {
						Double cond1 = Double.parseDouble(units.get(x[index]).get(x[y]));
						b = b && ((cond1.intValue() >= 1) || (cond1.intValue() == -1));
					}
					if (b) {
						biggest = x[index];
						break;
					}
				}
				for (Map.Entry<String, Map<String, String>> unit : units.entrySet()) {
					Map<String, String> value = unit.getValue();
					List<Map.Entry<String, String>> list = new LinkedList<>(value.entrySet());
					Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
						public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
							Double d1 = Double.parseDouble(o1.getValue());
							Double d2 = Double.parseDouble(o2.getValue());
							return (d1).compareTo(d2);
						}
					});
					Map<String, String> temp = new LinkedHashMap<String, String>();
					for (Map.Entry<String, String> aa : list) {
						temp.put(aa.getKey(), aa.getValue());
					}
					units.put(unit.getKey(), temp);
				}

				StringBuilder sb = new StringBuilder();
				Map<String, String> mp = units.get(biggest);
				for (String s : mp.keySet()) {
					Double d = Double.parseDouble(mp.get(s));
					sb.append(Math.round(d) + s + " = ");
				}
				String result = sb.toString();
				System.out.println(result.substring(0, result.length() - 2));

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void propagate(Map<String, Map<String, String>> units, Map<String, String> unit, String key) {

		for (Map.Entry<String, String> m : unit.entrySet()) {
			if (m.getValue().equals("1") || m.getKey().equals(key) || m.getValue().equals("-1")) {
				continue;
			}
			for (Map.Entry<String, String> m1 : units.get(m.getKey()).entrySet()) {
				Double s = Double.parseDouble(m1.getValue());
				if (m1.getKey().equals(m.getKey()) || m1.getKey().equals(key) || (s.intValue() >= 1)
						|| (s.intValue() == -1)) {
					continue;
				}
				Double y = Double.parseDouble(units.get(key).get(m1.getKey()));
				if (y.intValue() == -1) {
					double v1 = Double.parseDouble(m.getValue());
					double m2 = Double.parseDouble(m1.getValue());
					double mul = v1 * m2;
					double div = 1 / mul;
					units.get(key).put(m1.getKey(), mul + "");
					units.get(m1.getKey()).put(key, div + "");
				}
			}
		}
	}

}
