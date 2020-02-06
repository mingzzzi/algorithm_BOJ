/*
 * 2020.02.06
 * 10844: 쉬운 계단 수
 */

import java.util.*;

public class Main {
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		long[][] d = new long[n+1][10];
		
		for(int i=1; i<=9; i++) d[1][i]=1;
		for(int i=2; i<n+1; i++) {
			for(int j=0; j<=9; j++) {
				//마지막 수가 0일 경우
				if(j==0)d[i][j]=(d[i-1][j+1])%1000000000;
				//마지막 수가 9일 경우
				else if(j==9) d[i][j]=(d[i-1][j-1])%1000000000;
				else d[i][j]=(d[i-1][j-1]+d[i-1][j+1])%1000000000;
			}
		}
		
		long result=0;
		for(int i=0; i<=9; i++) {
			result+=d[n][i];
		}
		System.out.println(result%1000000000);
	}
}
