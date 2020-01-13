package graduationPrivate.wx.laf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import graduationPublic.wx.laf.vo.userVO;

/**
 * 存储用户数据库类
 * @author 马家文
 *
 */

public class userDao extends BaseDao {
	


public static int saveUser(String username, userVO user) {
	int i = 0;
	
	Connection con = null;
	PreparedStatement psmt = null;

	try {
		// 1.建立连接
		con = getCon();
		// 2.创建语句
		String sql = "insert into t_user(username) values(?)";
		psmt = con.prepareStatement(sql);
		// 设定参数，替换问号
		psmt.setString(1,username);
		

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


}
