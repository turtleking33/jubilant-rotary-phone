package kr.co.demo01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class Demo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String username="dev01";// 직접 만들어준 아이디, 비번
		String password="dev01";//아래는 오라클 디비에 넣은 것 씀
		Connection conn=DriverManager.getConnection(url, "dev01", "dev01");
		//연결이 먼저되어야 아래 객체 생성
		
		Statement stat=conn.createStatement();
		//PreparedStatement pstat=conn.prepareStatement("");
		
		String query="SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, HIRE_DATE FROM EMPLOYEES"; // 바뀌면 여기 쿼리문이 바뀔 것임
		// 쿼리 문자열에 세미콜론 넣지 말 것
		
		ResultSet rs= stat.executeQuery(query);
		
		SimpleDateFormat df=new SimpleDateFormat("yyyy년 MM월 dd일");
		//레코드 셋에 여러 레코드 있으니 추출위해 반복문 사용..()로추출할 레코드가 있는지 확인. 다음 레코드잇으면 참
		//레코드 셋이 자바jdbc에서는 resultset이라 함. next()로 반복을 진행할 수 있는 레코드가 있는지 확인
		// next()로 커서가 다음으로 이동해 값이 있냐에 따라 true, false반환. 레코드 셋에서
		System.out.println();
		while(rs.next()) {
			
			int id=rs.getInt("EMPLOYEE_ID");
			String fName=rs.getString("FIRST_NAME");//값을 추출
			String lName=rs.getString("LAST_NAME");//값을 추출
			Date hireDate = rs.getDate("HIRE_DATE");
			//날짜는 date로 반환됨
			
			System.out.printf("| %d | %15s | %15s | %s | \n", id, fName, lName, hireDate);//추출한 값을 추출
			//System.out.printf("| %d | %15s | %15s | %s | \n", id, fName, lName, df.format(hireDate));
			//System.out.printf("| %d | %15s | %15s | \n", id, fName, lName);
		}
		
		rs.close();//리절트 셋 클로즈
		stat.close();
		conn.close();//커넥션 클로즈
		//닫을 때는 역순으로 닫음. 가장 마지막에 것이 먼저 닫힘
		
	}

}
