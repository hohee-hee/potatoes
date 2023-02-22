package Practice5_4;

import java.util.Arrays;


public class RestaurantManager {
	private final int MAX_RESTAURANT_SIZE = 100;
	private final int MAX_REVIEW_SIZE = 100;

	private Restaurant[] restaurants = new Restaurant[MAX_RESTAURANT_SIZE];
	private Review[] reviews = new Review[MAX_REVIEW_SIZE];
	private int restaurantSize = 0;
	private int reviewSize = 0;
	
	//싱글턴
	private static RestaurantManager instance = new RestaurantManager();
	
	private RestaurantManager() {}
	
	public static RestaurantManager getInstance() {
		return instance;
	}
	
	public boolean addRestaurant(Restaurant restaurant) {
		restaurants[restaurantSize++] = restaurant;		
		return false;
		
	}
	
	public boolean addReview(Review review) {
		reviews[reviewSize++] = review;
		return false;
	}
	
	
	/*restaurant ID가 각 식당의 고유번호라고 생각하여
	 * resId가 같은 식당을 찾아 정보를 변경하는 코드로 작성
	 */
	
	public boolean updateRestaurant(Restaurant restaurant) {
		for(int i = 0 ; i < restaurantSize ; i++) {
			if(restaurants[i].getResId() == restaurant.getResId()) {
				restaurants[i] = restaurant;
				break;
			}
		}
		return false;		
	}
	
	public boolean removeRestaurant(int resId) {
		int i = 0;
		for(i = 0 ; i < restaurantSize ; i++) {
			if(restaurants[i].getResId() == resId) {
				restaurants[i] = null;
				for(int j = i ; j < restaurantSize - 1; j++) {
					restaurants[j] = restaurants[j+1];
					restaurants[j+1] = null;
				}
				restaurantSize--;
				break;
			}
		}		
		return false;
	}
	
	public boolean removeReview(int reviewId) {
		for(int i = 0 ; i < reviewSize ; i++) {
			if(reviews[i].getReviewId() == reviewId) {
				reviews[i] = null;
				for(int j = i ; j < reviewSize - 1; j++) {
					reviews[j] = reviews[j+1];
					reviews[j+1] = null;
				}
				reviewSize--;
				return true;
			}
		}		
		return false;
	}
	
	public Restaurant searchByresId(int resId) {
		Restaurant find = new Restaurant();
		for(int i = 0 ; i < restaurantSize ; i++) {
			if(resId == restaurants[i].getResId()) {
				find = restaurants[i];
			}
		}
		return find; 
	}
	
	public Restaurant[] getRestaurantList() {
		
		return Arrays.copyOf(restaurants, restaurantSize);
	}
	
	public Review[] getRestaurantReview(int resId) {
		Review[] find = new Review[MAX_REVIEW_SIZE];
		int idx = 0;
		for(int i = 0 ; i < reviewSize ; i++) {
			if(resId == reviews[i].getResId()) {
				find[idx++] = reviews[i];
			}
		}
		return Arrays.copyOfRange(find,0,idx);
	}
	
	public Restaurant getRestaurant (int resId) {
		Restaurant find = new Restaurant();
		for(int i = 0 ; i < restaurantSize ; i++) {
			if(resId == restaurants[i].getResId()) {
				find = restaurants[i];
			}
		}
		return find;
	}
	
}
