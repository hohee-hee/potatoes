package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Deque {
	private int[] array;
	private static final int DEFAULT_SIZE = 64;
	private int size;
	private int rear;
	private int front;
	
	
	// 기본 size를 64로 잡고 rear, front, size 입력
	public Deque() {
		this.array = new int[DEFAULT_SIZE];
		this.size = 0;
		this.front = 0;
		this.rear = 0;
	}
	
	public void resize(int newCapacity) {
		int arrayCapacity = array.length; // 현재 array 크기
		
		int[] newArray = new int[newCapacity]; // 새로운 배열
		
		for(int i=0, j=front+1; i<=size; i++, j++) {
			newArray[i] = array[j % arrayCapacity];
		}
		
		this.array = null;
		this.array = newArray;
		
		front = 0;
		rear = size;
	}
	
	public int size() {
		return size;
	}
	
	// array 초기화(rear와 front도 초기값으로 세팅)
	public void clear() {
		int[] newArray = new int[DEFAULT_SIZE];
		rear = 0;
		front = 0;
		array = newArray;
	}
	
	public boolean offer(int item) {
		return offerLast(item);
	}
	
	public boolean offerLast(int item) {
		if((rear + 1) % array.length == front) {
			resize(array.length * 2);  // 가득 차면 용량을 2배로 늘려준다.
		}
		
		rear = (rear + 1) % array.length;
		array[rear] = item;
		size++;
		
		return true;		
	}
	
	public boolean offerFirst(int item) {
		if((front - 1 + array.length) % array.length == rear) {
			resize(array.length * 2);  // 가득 차면 용량을 2배로 늘려준다.
		}
		
		front = (front - 1 + array.length) % array.length;
		array[front] = item;
		size++;
		
		return true;		
	}
	
	public int pollFirst() {
		if(size == 0) {
			return 0;
		}
		front = (front + 1) % array.length;
		
		int item = (int) array[front];
		
		array[front] = 0;
		size--;
		
		return item;
	}
	
	public int pollLast() {
		if(size == 0) {
			return 0;
		}
			
		rear = (rear - 1 + array.length) % array.length;
		
		int item = (int) array[rear];
		
		array[rear] = 0;
		size--;
		
		return item;
	}
	
	public int peekFirst() {
		if(size == 0) {
			return 0;
		}
		int item = (int) array[(front + 1) % array.length];

		return item;
	}
	public int peekLast() {
		if(size == 0) {
			return 0;
		}
		int item = (int) array[(rear - 1 + array.length) % array.length];

		return item;
	}
	
}
