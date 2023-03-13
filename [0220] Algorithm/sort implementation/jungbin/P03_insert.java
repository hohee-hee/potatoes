package potato;

public class P03_insert {
	
	public static void insert(int[] a) {
		insert(a, a.length);
	}
	
	private static void insert(int[] a, int size) {
		for(int i=1; i<size; i++) {
			int target = a[i];
			int j = i-1;
			//일치 할 때 그 자리에 넣어주기 나머지 들은 자리를 메꿔주기
			while(j>=0 && target < a[j]) {
				a[j+1] = a[j];
				j--;
			}
			
			a[j+1] = target;
		}
	}

}
