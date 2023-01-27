package com.ssafy.ws.step4;

public class Review {
	int reviewId;
	int resId;
	String writer;
	String content;
	
	public Review() {
		this(424, 24, "Jang", "너무 맛있어요");
	}

	public Review(int reviewId, int resId, String writer, String content) {
		this.reviewId = reviewId;
		this.resId = resId;
		this.writer = writer;
		this.content = content;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public int getResId() {
		return resId;
	}

	public void setResId(int resId) {
		this.resId = resId;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return String.format("Review [ReviewId=%d, ResId=%s, Writer=%s, Content=%s]"
				, reviewId, resId, writer, content);
	}
	
}
