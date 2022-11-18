package kr.co.db.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleConnection {
//연결하기 위한 클래스. 각 데모로 만든 것들을
	private final static String ORACLE_DRIVER="oracle.jdbc.driver.OracleDriver";
	private final static String JDBC_URL="jdbc:oracle:thin@";
	
	private Connection conn;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public OracleConnection(String url, String username) throws ClassNotFoundException, SQLException {
		this(url, username, username);// username이지만 pasword로도 사용
	}
	
	public OracleConnection(String url, String username, String password) throws ClassNotFoundException, SQLException {
		Class.forName(ORACLE_DRIVER);//"oracle.jdbc.driver.OracleDriver"이것은 고정이라 변수에 넣어줌.
		//String url="jdbc:oracle:thin:@localhost:1521/XEPDB1";//jdbc:oracle:thin:@이것은 고정이라 뒤에 세개가 필요한
//		String username="dev01";//고정이 아니라 외부에서 설정할 수 있게 만드는 게 좋음
//		String password="dev01";
		this.conn=DriverManager.getConnection(JDBC_URL+url, username, password);
		
	}
	
	public PreparedStatement getPrepared(String query) throws SQLException {
		this.pstat=this.conn.prepareStatement(query);
		return this.pstat;
		
	}
	//쿼리문 만드는 것만 하면 됨. 객체 생성하고 각 인덱스에 값만 넣으면 됨
	
	public ResultSet sendSelect() throws SQLException {//외부에서 클로즈하라고 이것은 뺌
		this.rs=this.pstat.executeQuery();// 외부에서 처리하지 않고 여기서 처리하기 위해 작성
		//return this.pstat.executeQuery();  // 이것을 주석 처리한 것은 외부에서 처리가 아니고 여기서 직접처리하기 위함
		return this.rs;
	}
	
	public int sendInsert() throws SQLException {
		return this.pstat.executeUpdate();//execute는 업데이트 할 때만 사용
	}
	
	public int sendUpdate() throws SQLException {
		return this.pstat.executeUpdate();//execute는 업데이트 할 때만 사용
	}
	public int sendDelete() throws SQLException {
		return this.pstat.executeUpdate();//execute는 업데이트 할 때만 사용
	}
	
	public void close() throws SQLException {
		if(this.rs !=null) {
			this.rs.close();
		}
		
		if(this.pstat !=null) {
			this.pstat.close();
		}
		
		if(this.conn!=null) {
			this.conn.close();
		}
	}
	//이렇게 만들면 데모에서 중첩되는 부분 안 만들고 쓸 수 잇다
}
