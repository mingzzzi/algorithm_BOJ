/*
 * 2020.02.18
 * 1339: 단어 수학
 * - 문자열 중복제거 필요(Hashset, arraylist)
 */
import java.util.*;

public class Main {
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] a = new String[n];
		ArrayList<Character> arraylist = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			a[i] = sc.next();
			for (int j = 0; j < a[i].length(); j++) {
				char s = a[i].charAt(j);
				if (!arraylist.contains(s))
					arraylist.add(s);
			}
		}
		Character[] array = arraylist.toArray(new Character[0]);
		int size = array.length;
		int[] number = new int[size];
		for (int i = 0; i < size; i++)
			number[i] = 9 - i;

		int max = 0;
		do {
			int temp = calculate(number, a, array);
			if (max < temp)
				max = temp;
		} while (prev_permutation(number, size));
		System.out.println(max);
	}

	public static int calculate(int[] a, String[] str, Character[] ch) {
		int temp = 0;
		int[] alpha = new int[256];
		for (int i = 0; i < ch.length; i++)
			alpha[ch[i]] = a[i];

		for (int i = 0; i < str.length; i++) {
			String string = str[i];
			int k = 1;
			for (int j = str[i].length() - 1; j >= 0; j--) {
				temp += alpha[string.charAt(j)] * k;
				k *= 10;
			}
		}
		return temp;
	}

	public static boolean prev_permutation(int[] a, int n) {
		int i = n - 1;
		while (i > 0 && a[i - 1] <= a[i])
			i -= 1;
		if (i <= 0)
			return false; // 마지막 순열
		int j = n - 1;
		while (a[i - 1] <= a[j])
			j -= 1;

		// swap(a[i-1], a[j])
		int temp = a[i - 1];
		a[i - 1] = a[j];
		a[j] = temp;

		j = n - 1;
		while (j > i) {
			temp = a[j];
			a[j] = a[i];
			a[i] = temp;
			j -= 1;
			i += 1;
		}

		return true;
	}
}
