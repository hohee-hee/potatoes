package com.ssafy.ws.step4;

public class RestaurantManager {
	private static final int MAX_RESTAURANT_SIZE = 100;
	private static final int MAX_REVIEW_SIZE = 1000;
	
	private Restaurant[] restaurants = new Restaurant[MAX_RESTAURANT_SIZE];
	private Review[] reviews = new Review[MAX_REVIEW_SIZE];
	
	private int restaurantSize;
	private int reviewSize;
	
	public boolean addRestaurant(Restaurant restaurant) {
		if (restaurantSize<MAX_RESTAURANT_SIZE) {
			restaurants[restaurantSize++] = restaurant;
			return true;
		}
		return false;
	}
	
	public boolean updateRestaurant(Restaurant restaurant) {
		for(int i=0; i<restaurantSize; i++) {
			if(restaurants[i].getResId() == restaurant.getResId()) {
				restaurants[i] = restaurant;
				return true;
			}
		}
		return false;
	}
	
	public boolean removeRestaurant(int resId) {
		int idx=0;
		Restaurant[] remainList = new Restaurant[MAX_RESTAURANT_SIZE];
		for(int i=0; i<restaurantSize; i++) {
			if(restaurants[i].getResId()!=resId) {
				remainList[idx] = restaurants[i];
				idx++; restaurantSize--;
			}
		}
		restaurants = remainList;
		return false;
	}
	
	public Restaurant getRestaurant(int resId) {
		Restaurant res = new Restaurant();
		for(int i=0; i<restaurantSize; i++) {
			if(restaurants[i].getResId()==resId) {
				res = restaurants[i];
			}
		}
		return res;
	}
	
	public Restaurant[] getRestaurantList() {
		int idx=0;
		Restaurant[] resList = new Restaurant[restaurantSize];
		for(int i=0; i<restaurantSize; i++) {
			resList[idx] = restaurants[i];
			idx++;
		}
		return resList;
	}

	public boolean addReview(Review review) {
		if (reviewSize<MAX_REVIEW_SIZE) {
			reviews[reviewSize++] = review;
			return true;
		}
		return false;
	}
	
	public boolean removeReview(int reviewId) {
		int idx=0;
		Review[] remainList = new Review[MAX_REVIEW_SIZE];
		for(int i=0; i<reviewSize; i++) {
			if(reviews[i].getReviewId()!=reviewId) {
				remainList[idx] = reviews[i];
				idx++; reviewSize--;
			}
		}
		reviews = remainList;
		return false;
	}
	
	public Review[] getRestaurantReview(int resId) {
		int count=0; int idx=0;
		for(int i=0; i<reviewSize; i++) {
			if(reviews[i].getResId()==resId) {
				count++;
			}
		}
		Review[] revList = new Review[count];
		for(int i=0; i<reviewSize; i++) {
			if(reviews[i].getResId()==resId) {
				revList[idx] = reviews[i];
				idx++;
			}
		}
		return revList;
	}
}
