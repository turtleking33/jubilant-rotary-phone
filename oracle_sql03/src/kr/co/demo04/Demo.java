package kr.co.demo04;

import java.sql.Connection;
import java.sql.Date;//동일한 클래스 이름은 임포터 불가
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class Demo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String username="dev01";// 직접 만들어준 아이디, 비번
		String password="dev01";//아래는 오라클 디비에 넣은 것 씀
		Connection conn=DriverManager.getConnection(url, "dev01", "dev01");
		//연결이 먼저되어야 아래 객체 생성
		
		//PreparedStatement pstat=conn.prepareStatement(query);
		// 스테이트 객체 만들고 했는데
		//쿼리 먼자 만들고 프리페어드 객체 생성해야
		//PreparedStatement pstat=conn.prepareStatement(""); 
		
		int empId=207; //직접 값을 쓰지 않고 이렇게 변수에 저장해서 쓴다
		String jobId="IT_PROG"; // 문자열 데이터라 따옴표 들어가야 함 안들어가면 오류생김. 이건 자바에서 쓰이는 타입
		Date hireDate=new Date(new java.util.Date().getTime());//()에 long 타입 요구.밀리초(java.util.Date로 얻을 수 있다)
		//new java.util.Date().getTime();//long 타입의 밀리초 나옴
		
		String query="INSERT INTO EMPLOYEES VALUES(?,?,?,?,?,?,?,?,?,?,?)"; // 바뀌면 여기 쿼리문이 바뀔 것임
		// 쿼리 문자열에 세미콜론 넣지 말 것
		//query +="WHERE EMPLOYEE_ID=100"; //ID가 100인 걸 조회
//		query +=" WHERE EMPLOYEE_ID=?";// 문자열 결합에서는 결합될 때 띄어쓰기를 고려해야 한다
//		// 오류에서와 같이 문자열이 붙어서 오류가 생길 수 있다
//		query +="	OR JOB_ID=?";// 여기에 작은 따옴표 표시해 줌. ?는 holder라고 함.?가 알아서 타입 맞춰줌. 따옴표 등도 알아서 처리해 줌
//		// insert, delete 다 할 수 있다. 첫번째 ?는 index1, 두번째 ?는 index2
		PreparedStatement pstat=conn.prepareStatement(query);
		pstat.setInt(1, empId);//(홀더위치, 홀더에 들어갈 데이터값)
		//INSERT 작업시 컬럼 순서 지켜야
		pstat.setString(2, "길동");
		pstat.setString(3, "홍");
		pstat.setString(4, "HGILDONG");
		pstat.setString(5, "515.123.1234");
		pstat.setDate(6, hireDate);
		pstat.setString(7, jobId);
		pstat.setInt(8, 2800);
		pstat.setDouble(9, 0);
		pstat.setInt(10, 103);// 이것들이 ?에 각가 대입되는
		pstat.setInt(11, 60);
		
		//ResultSet rs= pstat.executeQuery();//퀄리가 이미 프리페어드에 들어가 있어서 ()안에 쿼리 지움
		//select는 이거인데
		int rs= pstat.executeUpdate();//insert, update,delet 할대 사용.int로 반환. insert 등 작업에 반영된 행의 갯수가 int인
		// insert는 반영된 행의 갯수가 1개. update는 반영된 행의 갯수가0~n개. delete는 0~n개. update, delete는 조건을 설정하니 잘못설정하면 0개나 아주 많이 수정가능하니
		
		if(rs>=1) {
			System.out.println(rs+" 개 행이 반영되었다");
		}else {
			System.out.println("0개 행이 반영되었다(쿼리에 문제 있을수도)");
			
		}
//		SimpleDateFormat df=new SimpleDateFormat("yyyy년 MM월 dd일");
//		//레코드 셋에 여러 레코드 있으니 추출위해 반복문 사용..()로추출할 레코드가 있는지 확인. 다음 레코드잇으면 참
//		//레코드 셋이 자바jdbc에서는 resultset이라 함. next()로 반복을 진행할 수 있는 레코드가 있는지 확인
//		// next()로 커서가 다음으로 이동해 값이 있냐에 따라 true, false반환. 레코드 셋에서
//		System.out.println();
////		while(rs.next()) {
//			
//			int id=rs.getInt("EMPLOYEE_ID");
//			String fName=rs.getString("FIRST_NAME");//값을 추출
//			String lName=rs.getString("LAST_NAME");//값을 추출
//			Date hireDate = rs.getDate("HIRE_DATE");
//			//날짜는 date로 반환됨
//			
//			System.out.printf("| %d | %15s | %15s | %s | \n", id, fName, lName, hireDate);//추출한 값을 추출
//			//System.out.printf("| %d | %15s | %15s | %s | \n", id, fName, lName, df.format(hireDate));
//			//System.out.printf("| %d | %15s | %15s | \n", id, fName, lName);
//		}
		
//		rs.close();//리절트 셋 클로즈
		pstat.close();
		conn.close();//커넥션 클로즈
		//닫을 때는 역순으로 닫음. 가장 마지막에 것이 먼저 닫힘
		//이것은 실행 시 1번만 해야함. 2번째 부터는 에러 남. 두번재 실행하면 무결성제약조건 에러남
		//delete, update도 이렇게 하면 됨.
	}

}
