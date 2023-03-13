package potato;

public class P01_quick {
	
		//a 배열 정렬하기
	public static void sort(int[] a) {
		quick(a, 0, a.length-1);
	}
	
	public static void quick (int[] a, int lo, int hi) {
		//왼쪽 = 오른쪽 경우
		if(lo>=hi) {
			return;
		}
		
		//피봇
		int p = part(a, lo, hi);
		//작은 부분
		quick(a, lo, p-1);
		//큰 부분
		quick(a, p+1, hi);
	}
	
	public static int part(int[] a, int l, int r) {
		int lo = l;
		int hi = r;
		int p = a[l];
		
		while(lo <hi) {
			while(a[hi] > p && lo < hi) {
				hi--;
			}
			while (a[lo] <=p && lo < hi) {
				lo++;
			}
			swap(a, lo, hi);
		}
		swap(a, l, lo);
		return lo;
	}
	
	public static void swap(int[]a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
