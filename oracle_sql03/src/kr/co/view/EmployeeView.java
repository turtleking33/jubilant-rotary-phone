package kr.co.view;

import java.util.ArrayList;

import kr.co.db.vo.EmployeeVO;

public class EmployeeView {

	public void print(ArrayList<EmployeeVO> datas) {
		for(EmployeeVO emp: datas) {
		System.out.println(emp);
		}
	}

}
