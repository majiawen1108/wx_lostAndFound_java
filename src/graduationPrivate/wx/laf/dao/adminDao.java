package graduationPrivate.wx.laf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import graduationPublic.wx.laf.vo.adminVo;

public class adminDao extends BaseDao{
	/***
	 * 新增管理员
	 * @param username
	 * @param user
	 * @return
	 */
	public static int saveUser(String username, String password) {
		int i = 0;
		
		Connection con = null;
		PreparedStatement psmt = null;

		try {
			// 1.建立连接
			con = getCon();
			// 2.创建语句
			String sql = "insert into laf_admin(username,password) values(?,?)";
			psmt = con.prepareStatement(sql);
			// 设定参数，替换问号
			psmt.setString(1,username);
			psmt.setString(2,password);

			// 执行语句
			i = psmt.executeUpdate();

			// 处理结果
			System.out.println(i);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeCon(con, psmt);
		}
		
		return i;
	}
/***
 * 根据前台输入的账号密码到数据库中查询数据库中是否存在该账号，即判断该账号是否已注册或者已存在
 * @param username
 * @param password
 * @return
 */
	public static adminVo getUser(String username, String password) {
		// TODO Auto-generated method stub
		adminVo adminvo =null;

		Connection con = null;
		PreparedStatement psmt = null;

		try {
			// 1.建立连接
			con = getCon();
			// 2.创建语句
			String sql = "select id,username,password from laf_admin where username=?and password = ?";
			psmt = con.prepareStatement(sql);
			//替换？
			psmt.setString(1, username);
			psmt.setString(2, password);
			
			
			// 执行语句
			ResultSet rs = psmt.executeQuery();
			if(rs.next()) {
				// 创建对象，使用查询出的数据对对象进行装配
				adminvo = new adminVo();
				adminvo.setId(rs.getInt("id"));
				adminvo.setUsername(rs.getString("username"));
				adminvo.setPassword(rs.getString("password"));
			}
			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeCon(con, psmt);
		}
		// 返回放数据的容器
		return adminvo;
		
	}
	
	
}
