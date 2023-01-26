package Practice5_4;

import java.util.Scanner;

public class RestaurantTest {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		RestaurantManager RM = RestaurantManager.getInstance();
		
		Restaurant r1 = new Restaurant(1, "수원왕갈비통닭", "서울특별시 마포구", "왕갈비통닭", 5);
		Restaurant r2 = new Restaurant(2, "메밀향그집", "서울특별시 종로구", "치즈닭갈비", 4);
		Restaurant r3 = new Restaurant(3, "칠기", "서울특별시 동작구", "마라샹궈", 5);
		Restaurant r4 = new Restaurant(4, "대청마루", "경기도 부천시", "감자탕", 5);
		
		boolean a = RM.addRestaurant(r1);
		boolean b = RM.addRestaurant(r2);
		boolean c = RM.addRestaurant(r3);
		boolean d = RM.addRestaurant(r4);

		Review v1 = new Review(10001, 1, "마약반", "맛에 비해 너무 비쌈 다신 안갈듯");
		Review v2 = new Review(10002, 2, "니진", "치즈폭탄 최고ㅠ");
		Review v3 = new Review(10003, 3, "마라처돌이", "샹궈에 꿔바로우랑 칭따오까지 무족권 시키세요");
		Review v4 = new Review(10004, 4, "AA", "성공하신 사장님,,,, 일욜에 쉬니 참고하세용");
		Review v5 = new Review(10005, 1, "강력반", "럭셔리치킨!! 다시 가고 싶음");
		
		boolean e = RM.addReview(v1);
		boolean f = RM.addReview(v2);
		boolean g = RM.addReview(v3);
		boolean h = RM.addReview(v4);
		boolean x = RM.addReview(v5);
		
		Restaurant[] res = RM.getRestaurantList();
		
		//맛집 리스트 조회
		System.out.println("**********************************맛집 리스트**********************************");
		for(int i = 0 ; i < res.length ; i++) {
			System.out.println(res[i].toString());
		}
		System.out.println();
		
		//ID로 맛집 조회
		System.out.println("**********************************맛집 조회**********************************");
		System.out.println("식당 ID를 입력하세요  : ");
		int Id = sc.nextInt();
		Restaurant find = RM.getRestaurant(Id);
		System.out.println(find.toString());
		System.out.println();
		
		//맛집 리뷰 조회
		System.out.println("**********************************리뷰 조회**********************************");
		System.out.println("식당 ID를 입력하세요  : ");
		Id = sc.nextInt();
		Review[] rev = RM.getRestaurantReview(Id);
		if(rev.length == 0)
			System.out.println("리뷰 정보가 없습니다.");
		else {
			for(int i = 0 ; i < rev.length ; i++) {
				System.out.println(rev[i].toString());
			}
		}
		System.out.println();
		
		
		//맛집 정보 수정
		System.out.println("**********************************정보 수정**********************************");
		System.out.println("수정할 식당 ID를 입력하세요 : ");
		int uId = sc.nextInt();
		sc.nextLine();
		System.out.println("수정할 식당 이름을 입력하세요 : ");
		String uName = sc.nextLine();
		System.out.println("수정할 식당 주소를 입력하세요 : ");
		String uAddress = sc.nextLine();
		System.out.println("수정할 시그니처 메뉴 이름을 입력하세요 : ");
		String uMenu = sc.nextLine();
		System.out.println("수정할 별점을 입력하세요 : ");
		int uRate = sc.nextInt();	
		Restaurant modi = new Restaurant(uId, uName, uAddress, uMenu, uRate);
		boolean update = RM.updateRestaurant(modi);
		System.out.println();
		
		//맛집 리스트 조회
		System.out.println("**********************************맛집 리스트**********************************");
		res = RM.getRestaurantList();
		for(int i = 0 ; i < res.length ; i++) {
			System.out.println(res[i].toString());
		}
		System.out.println();
		
		//맛집 정보 삭제
		System.out.println("**********************************맛집 삭제**********************************");
		System.out.println("삭제할 ID를 입력해주세요 : ");
		int rId = sc.nextInt();
		boolean remove = RM.removeRestaurant(rId);
		System.out.println();
		
		//맛집 리스트 조회
		System.out.println("**********************************맛집 리스트**********************************");
		res = RM.getRestaurantList();
		for(int i = 0 ; i < res.length ; i++) {
			System.out.println(res[i].toString());
		}
		System.out.println();
		
		//리뷰 정보 삭제
		System.out.println("**********************************리뷰 삭제**********************************");
		System.out.println("삭제할 리뷰 ID를 입력해주세요 : ");
		int vId = sc.nextInt();
		boolean vremove = RM.removeReview(vId);
		if(vremove==false)
			System.out.println("잘못된 리뷰 번호를 입력하셨습니다. 다음 단계로 넘어갑니다.");
		System.out.println();
		
		//리뷰 정보 조회		
		System.out.println("**********************************리뷰 조회**********************************");
		System.out.println("식당 ID를 입력하세요  : ");
		Id = sc.nextInt();
		rev = RM.getRestaurantReview(Id);
		if(rev.length == 0)
			System.out.println("리뷰 정보가 없습니다.");
		else {
			for(int i = 0 ; i < rev.length ; i++) {
				System.out.println(rev[i].toString());
			}
		}
		System.out.println();
		
	}

}
