import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int L;
	static int C;
	static String[] arr;
	static String[] sel;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// l개의 알파벳 소문자
		L = sc.nextInt();
		// 최소 두개의 자음으로 구성
		// 알파벳은 증가하는 순서로 배열

		// C가지의 암호 종류가 있다.
		C = sc.nextInt();
		arr = new String[C];
		sel = new String[L];
		for (int i = 0; i < C; i++) {
			arr[i] = sc.next();
		}
		Arrays.sort(arr);

		combi(0, 0);

	}

	public static void combi(int idx, int sidx) {
		if (sidx == L) {
			// 최소 한개의 모음, 두개의 자음으로 구성
			if(isValid()) {
				for(int i =0; i<L; i++) {
					System.out.print(sel[i]);
				}
				System.out.println();
			}
			return;
		}

		
		for(int i =idx; i<C; i++) {
		sel[sidx] = arr[i];
		combi(i + 1, sidx + 1);
		}

	}
	
	  public static boolean isValid() {
	        int mo = 0;
	        int ja = 0;

	        for (String x : sel) {
	            if (x.equals("a") || x.equals("e") || x.equals("i") || x.equals("o") || x.equals("u")) {
	                mo++;
	            } else {
	                ja++;
	            }
	        }

	        if (mo >= 1 && ja >= 2) {
	            return true;
	        }
	        return false;
	    }

}