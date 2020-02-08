/*
 * 2020.02.08
 * 11054: 가장 긴 바이토닉 부분 수열
 */
import java.util.*;

public class Main {
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arrayi = new int[n];
		int[] arrayd = new int[n];
		for (int i = 0; i < n; i++) {
			int temp = sc.nextInt();
			arrayi[i] = temp;
			arrayd[n - 1 - i] = temp; // 감소하는 수열 만들기 위해 반대로 저장
		}

		int[] di = new int[n];
		int[] dd = new int[n];

		di = makeArray(arrayi, n);
		dd = makeArray(arrayd, n);

		int max = 0;
		for (int i = 0; i < n - 1; i++) {
			int temp = di[i] + dd[n - (i + 1)] - 1;
			if (max < temp)
				max = temp;
		}
		if(n==1) System.out.println("1");
		else System.out.println(max);
	}

	public static int[] makeArray(int[] array, int n) {
		int[] d = new int[n];
		d[0] = 1;
		for (int i = 1; i < n; i++) {
			d[i] = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (array[i] > array[j] && d[i] < d[j] + 1)
					d[i] = d[j] + 1;
			}
		}
		return d;
	}
}
