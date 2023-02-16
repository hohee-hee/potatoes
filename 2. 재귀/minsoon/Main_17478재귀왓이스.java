

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		again(n);
		}
	
	//재귀를 만들기
	static String line = "";
		public static void again(int n){
			// 값을 지정해줘야 마지막 값이 빠진다고 한다.
			
			String line1 = line;
			
			// 맨 마지막줄
			if(n==0) {
			System.out.println(line1 +"\"재귀함수가 뭔가요?\"");
			System.out.println(line1 +"\"재귀함수는 자기 자신을 호출하는 함수라네\"");
			System.out.println(line1 +"라고 답변하였지.");
			return;
			}
			// 재귀의 반복 
			
			System.out.println(line1 +"\"재귀함수가 뭔가요?\"");
			System.out.println(line1 +"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
			System.out.println(line1 +"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
			System.out.println(line1 +"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
			//줄이 추가되지 않는다.
			line +="____";
			
			//줄을 추가하면서 반복 횟수를 줄여가야한다.
			again(n-1);
			
			// 마지막 줄이 감소하지 않는다.
			System.out.println(line1 +"라고 답변하였지.");
	
}
}
