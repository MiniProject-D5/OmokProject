package DB;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SqlUtil {
	static Scanner sc = new Scanner(System.in);
	static Statement stmt = null;
	static ResultSet rs = null;
	static PreparedStatement pstmt = null;
	static Connection conn = ConnectionHelper.getConnection("oracle");
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String sql = null;
}
