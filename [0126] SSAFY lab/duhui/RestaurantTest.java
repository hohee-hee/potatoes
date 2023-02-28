package com.ssafy.ws.step4;

public class RestaurantTest {
	public static void main(String[] args) {
		Restaurant rs1 = new Restaurant();
		Restaurant rs2 = new Restaurant(13, "찐맛집", "서초구", "파스타", 5);
		
		Review rv1 = new Review();
		Review rv2 = new Review(442, 24, "kang", "5번째 방문 중!");
		Review rv3 = new Review(245, 13, "choi", "별 다섯개★★★★★");

		
		RestaurantManager rm = new RestaurantManager();
		
		rm.addRestaurant(rs1);
		rm.addRestaurant(rs2);
		
		rm.addReview(rv1);
		rm.addReview(rv2);
		rm.addReview(rv3);
		
		System.out.println("--------------------식당리스트--------------------");
		for(Restaurant r:rm.getRestaurantList()) {
			System.out.println(r);
		}
		
		System.out.println("--------------------식당제거--------------------");
		rm.removeRestaurant(24);
		for(Restaurant r:rm.getRestaurantList()) {
			System.out.println(r);
		}
		System.out.println("--------------------식당추가 후 24번 검색--------------------");
		rm.addRestaurant(rs1);
		System.out.println(rm.getRestaurant(24));
		System.out.println("--------------------24번 식당 리뷰 검색--------------------");
		
		for(Review r:rm.getRestaurantReview(24)) {
			System.out.println(r);
		}
		
	}
}
