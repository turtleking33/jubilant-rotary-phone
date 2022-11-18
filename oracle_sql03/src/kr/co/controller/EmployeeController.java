package kr.co.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.dao.EmployeeDAO;
import kr.co.db.vo.EmployeeVO;
import kr.co.view.EmployeeView;

public class EmployeeController {
	
	private EmployeeView ev=new EmployeeView();
	private EmployeeDAO empDao=new EmployeeDAO();
	
	public EmployeeController() throws ClassNotFoundException, SQLException{
		this.empDao=new EmployeeDAO();
	}
	
	public void getAll(){
		
		ArrayList<EmployeeVO> datas=empDao.selectAll();
		ev.print(datas);
		
	}
}
