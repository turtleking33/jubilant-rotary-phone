package kr.co.run;

import java.sql.SQLException;

import kr.co.manager.EmployeeManager;

public class Run {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		EmployeeManager em = new EmployeeManager();
		em.start();
	}

}

