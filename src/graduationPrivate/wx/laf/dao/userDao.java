package graduationPrivate.wx.laf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import graduationPublic.wx.laf.vo.FOUNDdetailInfoVO;
import graduationPublic.wx.laf.vo.userVO;

/**
 * 存储用户数据库类
 * 
 * @author 马家文
 *
 */

public class userDao extends BaseDao {

	public static int saveUser(String openid,String nickName,String city,String province,String country,String sex) {
		int i = 0;

		Connection con = null;
		PreparedStatement psmt = null;

		try {
			// 1.建立连接
			con = getCon();
			// 2.创建语句
			String sql = "insert into laf_user(nickName,sex,city,province,country,def1) values(?,?,?,?,?,?)";
			psmt = con.prepareStatement(sql);
			// 设定参数，替换问号
			psmt.setString(1, nickName);
			psmt.setString(2,sex);
			psmt.setString(3, city);
			psmt.setString(4, province);
			psmt.setString(5, country);
			psmt.setString(6, openid);
			

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
	 * 
	 * @param openid
	 * @return
	 */
	public static List<userVO> getUser(String openid) {
		List<userVO> list = new ArrayList<userVO>();

		Connection con = null;
		PreparedStatement psmt = null;

		try {
			// 1.建立连接
			con = getCon();
			// 2.创建语句
			String sql = "select * from laf_user where def1=?";
			psmt = con.prepareStatement(sql);
			// 替换？
			psmt.setString(1, openid);
			
			// 执行语句
			ResultSet rs = psmt.executeQuery();
			userVO uservo = null;
			while (rs.next()) {
				// 创建对象，使用查询出的数据对对象进行装配
				uservo = new userVO();
				uservo.setId(rs.getInt("id"));
				uservo.setDef1(rs.getString("def1"));
				uservo.setNickName(rs.getString("nickName"));
				uservo.setCity(rs.getString("city"));
				uservo.setSex(rs.getString("sex"));
				uservo.setProvince(rs.getString("province"));
				uservo.setCountry(rs.getString("country"));
				list.add(uservo);
			}
			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeCon(con, psmt);
		}
		// 返回放数据的容器
		return list;
	}
/**
 * 用户数
 * @return
 */
	
	public static int userNums() {
		Connection con = null;
		PreparedStatement psmt = null;
		int i = 0;
		try {
			// 1.建立连接
			con = getCon();
			// 2.创建语句
			String sql = "select count(id) from laf_user";
			psmt = con.prepareStatement(sql);
			// 替换？
			// 3.执行语句 b   
			ResultSet j = psmt.executeQuery();
			j .first();
			 i = j.getInt(1);
			// 4.处理结果
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			closeCon(con,psmt);
		}
		return i;
	}
	/**
	 * 后台管理系统用的全部查询
	 * @return
	 */
	public static List<userVO> getUser() {
		List<userVO> list = new ArrayList<userVO>();

		Connection con = null;
		PreparedStatement psmt = null;

		try {
			// 1.建立连接
			con = getCon();
			// 2.创建语句
			String sql = "select * from laf_user";
			psmt = con.prepareStatement(sql);
			
			// 执行语句
			ResultSet rs = psmt.executeQuery();
			userVO uservo = null;
			while (rs.next()) {
				// 创建对象，使用查询出的数据对对象进行装配
				uservo = new userVO();
				uservo.setId(rs.getInt("id"));
				uservo.setNickName(rs.getString("nickName"));
				uservo.setCity(rs.getString("city"));
				uservo.setSex(rs.getString("sex"));
				uservo.setProvince(rs.getString("province"));
				uservo.setCountry(rs.getString("country"));
				uservo.setDef1(rs.getString("def1"));
				uservo.setDef3(rs.getString("def3"));
				list.add(uservo);
			}
			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeCon(con, psmt);
		}
		// 返回放数据的容器
		return list;
	}
	
	
	/**
	 * 后台管理删除功能
	 * @param id
	 *
	 */
	public static void adminDelete(String id) {
		Connection con = null;
		PreparedStatement psmt = null;
		
		try {
			
			// 1.建立连接
			con = getCon();
			// 2.创建语句
			String sql = "delete from laf_user where id = ?";
			psmt = con.prepareStatement(sql);
			// 替换？
			
			psmt.setString(1, id);
			
			// 3.执行语句
			psmt.executeUpdate();
			
			// 4.处理结果
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			closeCon(con,psmt);
		}
	}
	
}

