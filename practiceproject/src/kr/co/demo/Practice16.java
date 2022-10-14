package kr.co.demo;

import java.util.Random;

public class Practice16 {

	public static void main(String[] args) {
		int arr[]=new int[10];
		int arr1[]=new int[10];
		int sum=0;
		Random random=new Random();
		for(int a=0; a<10; a++) {
			int ran=random.nextInt(101);
			arr[a]=ran;
		}
		for(int b=0; b<10; b++) {
			if(arr[b]%2==0) {
				for(int c=0; c<10; c++) {
					arr1[c]=arr[c];
				}
			sum +=1;
			System.out.println(arr1[b]);
			}
		}
		System.out.printf("총 %d개의 짝수", sum);
	}

}
