package kr.co.manager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import kr.co.controller.EmployeeController;

public class EmployeeManager {

	private Scanner sc = new Scanner(System.in);
	private EmployeeController ec;
//	private DepartmentController dc;
//	private JobController jc;
	
	public EmployeeManager() throws ClassNotFoundException, SQLException {
		this.ec = new EmployeeController();
	}
	
	public void start() {
		while(true) {
			this.printMenu();
			System.out.print("메뉴 번호 입력 : ");
			int menuNumber = 0;
			if(sc.hasNextInt()) {
				menuNumber = sc.nextInt();	sc.nextLine();
				this.selectMenu(menuNumber);
			}
		}
	}

	private void printMenu() {
		System.out.println("[1] 모든 사원 정보 출력");
		System.out.println("[2] 모든 부서 정보 출력");
		System.out.println("[3] 모든 직무 정보 출력");
		System.out.println("[4] 사원 등록 수정 삭제");
		System.out.println("[5] 부서 등록 수정 삭제");
		System.out.println("[6] 직무 등록 수정 삭제");
		System.out.println("[7] 프로그램 종료");
	}

	private void selectMenu(int menuNumber) {
		switch(menuNumber) {
			case 1:
				// 모든 사원 정보 출력
				//ec.getAll(); 
				this.empSearchMenu();
				break;
			case 2:
				// 모든 부서 정보 출력
				//dc.getAll();
				this.deptSearchMenu();
				break;
			case 3:
				// 모든 직무 정보 출력
				//jc.getAll();
				this.jobSearchMenu();
				break;
			case 4:
				// 사원 등록, 수정, 삭제
				break;
			case 5:
				// 부서 등록, 수정, 삭제
				break;
			case 6:
				// 직무 등록, 수정, 삭제
				break;
			case 7:
				// 종료
				System.exit(0);
		}
	}
	private void jobSearchMenu() {
		
	}
	private void deptSearchMenu() {
		
	}
	
	private void empSearchMenu() {
		System.out.println("1 전체 조회");
		
		int menuNumber=0;
		while(true) {
			System.out.print("번호선택 : ");
			if(sc.hasNext()) {
				menuNumber=sc.nextInt();
				sc.nextLine();
				this.selectMenu(menuNumber);
				break;
			}
		}
		
		switch(menuNumber) {
		case 1:
			ec.getAll();
			break;
		case 2:
			System.out.print("사번 입력 : ");
			int id=sc.nextInt();
			sc.nextLine();
			ec.getId(id);
			break;
		case 3:
			ec.getAll();
			break;
		case 4:
			ec.getAll();
			break;
		case 5:
			ec.getAll();
			break;
		}
		
	}

}

