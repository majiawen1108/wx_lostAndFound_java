package graduationPrivate.wx.laf.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 * 数据库基础类
 * @author 马家文
 *
 */
public class BaseDao {

	private static final String URL = "jdbc:mysql://localhost:3306/wx_laf?useUnicode=true&characterEncoding=UTF-8&userSSL=false&serverTimezone=GMT%2B8";
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 获取数据库的连接
	 * 
	 * @returnConnection 数据库的连接
	 */
	public static Connection getCon() {
		Connection con = null;
		try {
			// 1.建立连接
			con = DriverManager.getConnection(URL, "root", "stx12345");
		} catch (SQLException e) {

			System.out.println("获取连接失败?");
		}
		return con;
	}
/**
 * 释放资源
 * @param con 数据库连�?
 * @param psmt 预编译语�?
 */
	public static void closeCon(Connection con, PreparedStatement psmt) {
		try {
			// 释放资源
			if (psmt != null) {
				psmt.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	
}
