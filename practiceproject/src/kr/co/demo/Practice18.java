package kr.co.demo;

import java.util.Scanner;

public class Practice18 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("배열크기를 입력해주세요");
		int arrInput=sc.nextInt();
		
		int arr[]=new int[arrInput];
		int sum=0;
		double avg;
		
		for(int a=0; a<arr.length; a++) {
			System.out.printf("%d번째 정수값을 입력해주세요", a+1);
			int arrInput2=sc.nextInt();
			if(arrInput2!=-1) {
				arr[a]=arrInput2;
				sum +=arr[a];
			}else if(arrInput2==-1){
				break;
			}
		}
		avg=(double)sum/arr.length;
		System.out.printf("총합 : %d\n평균 : %.2f", sum, avg);
	}

}
