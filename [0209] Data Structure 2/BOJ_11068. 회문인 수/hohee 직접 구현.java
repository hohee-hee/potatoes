
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Main{
	static ArrayList<Integer> chars = new ArrayList<>(); //회문 판별을 하기 위하여 각 char를 넣을 어레이
	
	public static void main(String args[]) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			boolean flag = true;
			int num = Integer.parseInt(br.readLine());
			
			//2진법부터 64진법까지 확인할 반복문
			for(int j = 2 ; j <= 64 ; j++) {				
				//회문 가능 여부를 확인할 불리안타입 변수
				flag = true;
				chars.clear();
				//j진법으로 바꾸기
				int n = num;
				while(n >= j) {
					chars.add(n%j);
					n/= j;
				}
				chars.add(n);
				
				int len = chars.size();
				//앞과 뒤를 확인할 반복문
				for(int k = 0 ; k < (len+1) / 2 ; k++) {
					//만약 앞과 뒤가 같으면 poll하기
					if(get_rear(chars) == get_front(chars)) {
						remove_rear(chars);
						remove_front(chars);
					}
					//같지 않다면 j진법은 회문이 불가능하므로 flag를 false로 바꾸고 반복문 종료
					else  {
						flag = false;
						break;
					}					
				}
				//만약 flag가 참으로 유지되었다면 회문인 것이기 때문에 더 이상 j진법을 검사하지 않는다
				if(flag) {
					break;
				}
			}
			
			//종료 후 flag 가 참이면 1, false면 0 저장
			if(flag) {
				sb.append("1").append("\n");
			}
			else {
				sb.append("0").append("\n");
			}
		}
		
		System.out.println(sb);
	}
	

	//맨 끝 요소 갖고오기
	static int get_rear(ArrayList<Integer> arr) {
		return arr.get(arr.size()-1);
	}
	
	//맨 앞 요소 갖고오기
	static int get_front(ArrayList<Integer> arr) {
		return arr.get(0);		
	}
	
	//맨 끝에 요소 추가하기
	static void add_rear(ArrayList<Integer> arr, int c){
		if(arr.isEmpty()) {
			arr.add(0, c);
		}
		else {
			arr.add(c);
		}
	}
	
	//맨 앞에 요소 추가하기
	static void add_front(ArrayList<Integer> arr, int c) {
		arr.add(0, c);
	}

	//맨 끝 요소 삭제
	static void remove_rear(ArrayList<Integer> arr) {
		if(!arr.isEmpty()) {
			arr.remove(arr.size()-1);
		}
	}

	//맨 앞 요소 삭제
	static void remove_front(ArrayList<Integer> arr) {
		if(!arr.isEmpty()) {
			arr.remove(0);
		}
	}
}