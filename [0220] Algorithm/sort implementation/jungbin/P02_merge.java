package potato;

public class P02_merge {
	private static int[] sorted;
	
	public static void merge(int[] a) {
		
		sorted = new int[a.length];
		merge(a, 0, a.length-1);
		sorted = null;
	}
	
	private static void merge(int[] a, int left, int right) {
		if(left==right) return;
		int mid=(left+right)/2;
		merge(a, left, mid);
		merge(a, mid+1, right);
		merge(a, left, mid, right);
	}
	
	private static void merge(int[] a, int left, int mid, int right) {
		int l = left;
		int r = mid +1;
		int idx=left;
		
		while (l <= mid && r<= right) {
			if(a[l] <= a[r]) {
				sorted[idx] = a[l];
				idx++;
				l++;
			}
			else {
				sorted[idx] = a[r];
				idx++;
				r++;
			}
		}
		
		if(l > mid) {
			while(r <= right) {
				sorted[idx] = a[r];
				idx++;
				r++;
			}
		}
		else {
			while(l<=mid) {
				sorted[idx] = a[l];
				idx++;
				l++;
			}
		}
		for(int i=left; i<=right; i++) {
			a[i] = sorted[i];
		}
	}
}
