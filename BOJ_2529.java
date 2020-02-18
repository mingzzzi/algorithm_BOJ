/*
 * 2020.02.18
 * 2529: 부등호
 */
import java.util.*;

public class Main {
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);

		int k = sc.nextInt();
		String[] str = new String[k];
		for (int i = 0; i < k; i++)
			str[i] = sc.next();

		// 최대, 최소가 될 수 있는 숫자 지정
		int[] max = new int[k + 1];
		int[] min = new int[k + 1];
		for (int i = 0; i < k + 1; i++) {
			min[i] = i;
			max[i] = 9 - i;
		}
		
		//최대 구하기
		do {
			boolean flag = true;
			for (int i = 0; i < k; i++) {
				if ((str[i].equals("<") && max[i] < max[i + 1]) || (str[i].equals(">") && max[i] > max[i + 1]))
					continue;
				else {
					flag = false;
					break;
				}
			}
			if (flag == true)
				break;
		} while (pre_permutation(max, k + 1));

		//최소 구하기
		do {
			boolean flag = true;
			for (int i = 0; i < k; i++) {
				if ((str[i].equals("<") && min[i] < min[i + 1]) || (str[i].equals(">") && min[i] > min[i + 1]))
					continue;
				else {
					flag = false;
					break;
				}
			}
			if (flag == true)
				break;
		} while (next_permutation(min, k + 1));

		//결과 출력
		for (int i = 0; i < k + 1; i++)
			System.out.print(max[i]);

		System.out.println("");
		for (int i = 0; i < k + 1; i++)
			System.out.print(min[i]);

	}

	public static boolean next_permutation(int a[], int n) {
		int i = n - 1;
		while (i > 0 && a[i - 1] >= a[i])
			i -= 1;
		if (i <= 0)
			return false; // 마지막 순열
		int j = n - 1;
		while (a[j] <= a[i - 1])
			j -= 1;
		int temp = a[i - 1];
		a[i - 1] = a[j];
		a[j] = temp;
		j = n - 1;
		while (i < j) {
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i += 1;
			j -= 1;
		}
		return true;
	}

	public static boolean pre_permutation(int a[], int n) {
		int i = n - 1;
		while (i > 0 && a[i - 1] <= a[i])
			i -= 1;
		if (i <= 0)
			return false; // 첫번째 순열

		int j = n - 1;
		while (a[j] >= a[i - 1])
			j -= 1;
		int temp = a[i - 1];
		a[i - 1] = a[j];
		a[j] = temp;
		j = n - 1;
		while (i < j) {
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i += 1;
			j -= 1;
		}
		return true;
	}
}
