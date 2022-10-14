package kr.co.demo;

import java.util.Random;

public class Practice17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*1. 크기가 0인 정수 배열을 생성 후 Random을 사용하여 배열의 값들을 초기화 한다
 *Random 은 0~100 사이의 난수값이 생성되도록 한다. 배열에는 홀수에 해당하는 값만 5개 저장되도록 한다.
 *동적배열로 문제 풀 것.
 *
 *int odd[]=new int[0];
 */
		int odd[]=new int[0];
		int arr[]=new int[5];
		
		Random random=new Random();
		
		for(int a=0; a<5; a++) {
			int ranChoice=random.nextInt(101);
			if(ranChoice%3==0) {
				arr[a]=ranChoice;
			}
		}
		odd=arr;
		for(int b=0; b<odd.length; b++) {
			System.out.println(odd[b]);
		}
	}

}
