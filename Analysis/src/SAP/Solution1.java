package SAP;

import java.util.Scanner;

public class Solution1 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int Gunnar = 0;
			int Emma = 0;
			for (int i = 0; i < 4; i++)
				Gunnar += sc.nextInt();
			for (int i = 0; i < 4; i++)
				Emma += sc.nextInt();
			extracted(Gunnar, Emma);
		}
	}

	private static void extracted(int Gunnar, int Emma) {
		if (Gunnar > Emma)
			System.out.println("Gunnar");
		else if (Gunnar < Emma)
			System.out.println("Emma");
		else
			System.out.println("Tie");
	}

}
