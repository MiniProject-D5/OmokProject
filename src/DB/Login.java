package DB;

import java.sql.SQLException;

public class Login extends SqlUtil{
	
	static public boolean LoginCheck(String id, String pwd) throws SQLException {
		boolean flag = false;
		
		sql = "SELECT * FROM OMOK WHERE ID = ? and PWD = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pwd);
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			flag = true;
			System.out.println("로그인 되었습니다.");
		}else {
			flag = false;
			System.out.println("ID와 비밀번호를 확인해주세요.");

		}
	
		
		return flag;
	}
}
