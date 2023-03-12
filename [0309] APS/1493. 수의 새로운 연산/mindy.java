import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt(); 
		
		for(int t=1; t<=tests; t++) {
			int ans = 0;
			int p = sc.nextInt(), q = sc.nextInt();
			
			//n(n+1)/2 := p
			int pX = 1, pY = 1;
			while(pX*(pX+1)/2 < p) { pX++; } 
			int tmp = pX*(pX+1)/2 - p;
			pX -= tmp; pY += tmp;
			// System.out.println("pX: "+pX+", pY: "+pY);
			int qX = 1, qY = 1;
			while(qX*(qX+1)/2 < q) { qX++; } 
			tmp = qX*(qX+1)/2 - q;
			qX -= tmp; qY += tmp;
			
			pX += qX; pY += qY;
			ans = pX*(pX+1)/2;
			for(int i=1; i<pY; i++) ans += pX++; // 이게 좀 더러움.. 
			
			
			System.out.println("#"+t+" "+ans);
		}
	}
}