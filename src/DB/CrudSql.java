package DB;

import javax.swing.*;
import java.sql.SQLException;

public class CrudSql extends SqlUtil{
	
	static public boolean Idcheck(String id) throws SQLException {
		boolean flag = true;
		
		sql = "SELECT ID FROM OMOK WHERE ID = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			System.out.println("중복");
			flag = false;
		}else {
			System.out.println("ID 생성 가능");
			flag = true;
		}
	
		
		return flag;
	}
	
	static public void IdInsert(String id, String pwd) {
		try {
			String strId = id;
			String strPwd = pwd;
			
			sql = "insert into omok(id, pwd) values(?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, strId);
			pstmt.setString(2, strPwd);

			switch (	JOptionPane.showConfirmDialog( null, 
											"회원가입 하시겠습니까?" ,
											"확인",
											 JOptionPane.YES_NO_OPTION ) ) {
				case 0 :  //확인
					break;
	
				case 1 :  // 아니오
					return;
			} // switch end		

			pstmt.executeUpdate();  // 
			
		} catch (Exception e) {		e.printStackTrace();		}		
		JOptionPane.showMessageDialog(null, "가입 완료!");

	}
	
}

