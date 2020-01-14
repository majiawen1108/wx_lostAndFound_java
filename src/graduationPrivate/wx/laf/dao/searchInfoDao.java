package graduationPrivate.wx.laf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import graduationPublic.wx.laf.vo.FOUNDdetailInfoVO;
import graduationPublic.wx.laf.vo.SEARCHdetailInfoVO;
import graduationPublic.wx.laf.vo.userVO;
/**
 * 发表失物详情数据库类
 * @author 马家文
 *
 */
public class searchInfoDao extends BaseDao{
	
	/***
	 * 
	 * @param id
	 * @return
	 * 	查询单条数据
	 */
	public static List<SEARCHdetailInfoVO> queryOne(String id) {
		List<SEARCHdetailInfoVO> list = new ArrayList<SEARCHdetailInfoVO>();

		Connection con = null;
		PreparedStatement psmt = null;

		try {
			// 1.建立连接
			con = getCon();
			// 2.创建语句
			String sql = "select * from laf_search f left join laf_user u on f.def1=u.def1 where f.id = "+id+"";
			psmt = con.prepareStatement(sql);
			
			// 执行语句
			ResultSet rs = psmt.executeQuery();
			SEARCHdetailInfoVO searcHdetailInfoVO = null;
			userVO author = null;
			while(rs.next()) {
				// 创建对象，使用查询出的数据对对象进行装配
				searcHdetailInfoVO = new SEARCHdetailInfoVO();
				author  =new userVO();
				searcHdetailInfoVO.setSearch_title(rs.getString("search_title"));
				searcHdetailInfoVO.setSearch_category(rs.getString("search_category"));
				searcHdetailInfoVO.setSearch_details(rs.getString("search_details"));
				searcHdetailInfoVO.setPaid(rs.getString("paid"));
				searcHdetailInfoVO.setMoney(rs.getString("money"));
				searcHdetailInfoVO.setSearch_date(rs.getString("search_date"));
				searcHdetailInfoVO.setSearch_address(rs.getString("search_address"));
				searcHdetailInfoVO.setSearch_det_address(rs.getString("search_det_address"));
				searcHdetailInfoVO.setSearch_state(rs.getString("search_state"));
				searcHdetailInfoVO.setSend_date(rs.getString("search_create_date"));
				searcHdetailInfoVO.setSearch_name(rs.getString("search_name"));
				searcHdetailInfoVO.setSearch_tel(rs.getString("search_tel"));
				searcHdetailInfoVO.setSearch_wx(rs.getString("search_wx"));
				searcHdetailInfoVO.setSearch_QQ(rs.getString("search_QQ"));
				searcHdetailInfoVO.setImage(rs.getString("search_image"));
				
				
//				author.setDef1(def1);
				//将作者绑定到博文对象中
				searcHdetailInfoVO.setUser(author);
				list.add(searcHdetailInfoVO);
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
/***
 * 
 * @param def1
 * @return
 * 	查询我所发布的所有
 */
	//def1暂时用来代替openid作为微信小程序用户的唯一标示
	public static List<SEARCHdetailInfoVO> selectMineBlog(String def1) {
		List<SEARCHdetailInfoVO> list = new ArrayList<SEARCHdetailInfoVO>();

		Connection con = null;
		PreparedStatement psmt = null;

		try {
			// 1.建立连接
			con = getCon();
			// 2.创建语句
			String sql = "select * from laf_search f left join laf_user u on f.def1=u.def1 where u.def1 = "+def1+" order by search_create_date desc,id desc";
			psmt = con.prepareStatement(sql);
			
			// 执行语句
			ResultSet rs = psmt.executeQuery();
			SEARCHdetailInfoVO searcHdetailInfoVO = null;
			userVO author = null;
			while(rs.next()) {
				// 创建对象，使用查询出的数据对对象进行装配
				searcHdetailInfoVO = new SEARCHdetailInfoVO();
				author  =new userVO();
				searcHdetailInfoVO.setSearch_title(rs.getString("search_title"));
				searcHdetailInfoVO.setSearch_category(rs.getString("search_category"));
				searcHdetailInfoVO.setSearch_details(rs.getString("search_details"));
				searcHdetailInfoVO.setPaid(rs.getString("paid"));
				searcHdetailInfoVO.setMoney(rs.getString("money"));
				searcHdetailInfoVO.setSearch_date(rs.getString("search_date"));
				searcHdetailInfoVO.setSearch_address(rs.getString("search_address"));
				searcHdetailInfoVO.setSearch_det_address(rs.getString("search_det_address"));
				searcHdetailInfoVO.setSearch_state(rs.getString("search_state"));
				searcHdetailInfoVO.setSend_date(rs.getString("search_create_date"));
				searcHdetailInfoVO.setSearch_name(rs.getString("search_name"));
				searcHdetailInfoVO.setSearch_tel(rs.getString("search_tel"));
				searcHdetailInfoVO.setSearch_wx(rs.getString("search_wx"));
				searcHdetailInfoVO.setSearch_QQ(rs.getString("search_QQ"));
				searcHdetailInfoVO.setImage(rs.getString("search_image"));
				
				
//				author.setUserId(rs.getString("user_id"));
				author.setDef1(def1);
				//将作者绑定到博文对象中
				searcHdetailInfoVO.setUser(author);
				list.add(searcHdetailInfoVO);
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
	 * 	主页用的，查询所有账号下面的发布内容
	 * @return
	 */
		public static List<SEARCHdetailInfoVO> selectAllBlog() {
			List<SEARCHdetailInfoVO> list = new ArrayList<SEARCHdetailInfoVO>();

			Connection con = null;
			PreparedStatement psmt = null;

			try {
				// 1.建立连接
				con = getCon();
				// 2.创建语句
				String sql = "select * from laf_search order by search_create_date desc,id desc";
				psmt = con.prepareStatement(sql);
				
				// 执行语句
				ResultSet rs = psmt.executeQuery();
				SEARCHdetailInfoVO searcHdetailInfoVO = null;
				userVO author = null;
				while(rs.next()) {
					// 创建对象，使用查询出的数据对对象进行装配
					searcHdetailInfoVO = new SEARCHdetailInfoVO();
					author  =new userVO();
					searcHdetailInfoVO.setSearch_title(rs.getString("search_title"));
					searcHdetailInfoVO.setSearch_category(rs.getString("search_category"));
					searcHdetailInfoVO.setSearch_details(rs.getString("search_details"));
					searcHdetailInfoVO.setPaid(rs.getString("paid"));
					searcHdetailInfoVO.setMoney(rs.getString("money"));
					searcHdetailInfoVO.setSearch_date(rs.getString("search_date"));
					searcHdetailInfoVO.setSearch_address(rs.getString("search_address"));
					searcHdetailInfoVO.setSearch_det_address(rs.getString("search_det_address"));
					searcHdetailInfoVO.setSearch_state(rs.getString("search_state"));
					searcHdetailInfoVO.setSend_date(rs.getString("search_create_date"));
					searcHdetailInfoVO.setSearch_name(rs.getString("search_name"));
					searcHdetailInfoVO.setSearch_tel(rs.getString("search_tel"));
					searcHdetailInfoVO.setSearch_wx(rs.getString("search_wx"));
					searcHdetailInfoVO.setSearch_QQ(rs.getString("search_QQ"));
					searcHdetailInfoVO.setImage(rs.getString("search_image"));
			
					//将作者绑定到博文对象中
					searcHdetailInfoVO.setUser(author);
					list.add(searcHdetailInfoVO);
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
		 * 	主页用的，查询所有账号下面的发布内容根据tag
		 * @return
		 */
			public static List<SEARCHdetailInfoVO> selectAllBlogBytag(String found_category) {
				List<SEARCHdetailInfoVO> list = new ArrayList<SEARCHdetailInfoVO>();

				Connection con = null;
				PreparedStatement psmt = null;

				try {
					// 1.建立连接
					con = getCon();
					// 2.创建语句
					String sql = "";
					if(found_category.equals("首页")) {
						sql = "select * from laf_search";
					}else {
						sql = "select * from laf_search where found_category = '"+found_category+"'";
						
					}
					
					psmt = con.prepareStatement(sql);
					
					// 执行语句
					ResultSet rs = psmt.executeQuery();
					SEARCHdetailInfoVO searcHdetailInfoVO = null;
					userVO author = null;
					while(rs.next()) {
						// 创建对象，使用查询出的数据对对象进行装配
						searcHdetailInfoVO = new SEARCHdetailInfoVO();
						author  =new userVO();
						searcHdetailInfoVO.setSearch_title(rs.getString("search_title"));
						searcHdetailInfoVO.setSearch_category(rs.getString("search_category"));
						searcHdetailInfoVO.setSearch_details(rs.getString("search_details"));
						searcHdetailInfoVO.setPaid(rs.getString("paid"));
						searcHdetailInfoVO.setMoney(rs.getString("money"));
						searcHdetailInfoVO.setSearch_date(rs.getString("search_date"));
						searcHdetailInfoVO.setSearch_address(rs.getString("search_address"));
						searcHdetailInfoVO.setSearch_det_address(rs.getString("search_det_address"));
						searcHdetailInfoVO.setSearch_state(rs.getString("search_state"));
						searcHdetailInfoVO.setSend_date(rs.getString("search_create_date"));
						searcHdetailInfoVO.setSearch_name(rs.getString("search_name"));
						searcHdetailInfoVO.setSearch_tel(rs.getString("search_tel"));
						searcHdetailInfoVO.setSearch_wx(rs.getString("search_wx"));
						searcHdetailInfoVO.setSearch_QQ(rs.getString("search_QQ"));
						searcHdetailInfoVO.setImage(rs.getString("search_image"));
						
				
						//将作者绑定到博文对象中
						searcHdetailInfoVO.setUser(author);
						list.add(searcHdetailInfoVO);
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
		
		
/***
 * 
 * @param foundVO
 * @param vo
 * @return
 * 	发表后往数据库中存储
 */
	public static int saveBlog(SEARCHdetailInfoVO searchVO,userVO vo) {
		
		int i = 0;
		
		Connection con = null;
		PreparedStatement psmt = null;

		try {
			// 1.建立连接
			con = getCon();
			// 2.创建语句
			String sql = "insert into laf_search"
					+ "(search_image,search_title,search_category,search_details,paid,money,search_date,"
					+ "search_address,search_det_address,search_state,search_name,"
					+ "search_tel,search_wx,search_QQ,def1) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			psmt = con.prepareStatement(sql);
			// 设定参数，替换问号
			psmt.setString(1,searchVO.getImage());
			psmt.setString(2,searchVO.getSearch_title());
			psmt.setString(3,searchVO.getSearch_category());
			psmt.setString(4,searchVO.getSearch_details());
			psmt.setString(5, searchVO.getPaid());
			psmt.setString(6, searchVO.getMoney());
			psmt.setString(7,searchVO.getSearch_date());
			psmt.setString(8, searchVO.getSearch_address());
			psmt.setString(9,searchVO.getSearch_det_address());
			psmt.setString(10, searchVO.getSearch_state());
			psmt.setString(11,searchVO.getSearch_name());
			psmt.setString(12, searchVO.getSearch_tel());
			psmt.setString(13, searchVO.getSearch_wx());
			psmt.setString(14, searchVO.getSearch_QQ());
			psmt.setString(15, searchVO.getDef1());

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
	/**
	 * 删除功能
	 * @param id
	 * @param def1
	 */
	public static void deleteBlog(String id, String def1) {
		Connection con = null;
		PreparedStatement psmt = null;
		
		try {
			
			// 1.建立连接
			con = getCon();
			// 2.创建语句
			String sql = "delete from laf_search where id = ? and def1 = ?";
			psmt = con.prepareStatement(sql);
			// 替换？
			
			psmt.setString(1, id);
			psmt.setString(2, def1);
			
			// 3.执行语句
			psmt.executeUpdate();
			
			// 4.处理结果
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			closeCon(con,psmt);
		}
	}
//	public static int addThumb(String blogId) {
//		
//		int i=0;
//	
//		Connection con = null;
//		PreparedStatement psmt = null;
//
//		try {
//
//			// 1.建立连接
//			con = getCon();
//			// 2.创建语句
//			String sql = "update t_blog set thumb=thumb+1 where blog_id = ?";
//			psmt = con.prepareStatement(sql);
//			// 替换？
//			
//			psmt.setString(1, blogId);
//
//			// 3.执行语句
//			 i = psmt.executeUpdate();
//
//			// 4.处理结果
//			
//
//		} catch (SQLException e) {
//
//			e.printStackTrace();
//		} finally {
//
//			closeCon(con,psmt);
//		}
//		return i;
//}
//
//
//	public static int insertComment(int userId, int blogId, String comment) {
//		Connection con = null;
//		PreparedStatement psmt = null;
//
//		try {
//			// 1.建立连接
//			con = getCon();
//
//			// 2.创建语句
//			String sql = "insert into t_comment(user_id, blog_id, comment) values(?,?,?)";
//			psmt = con.prepareStatement(sql);
//			// 设定参数，替换？
//			psmt.setInt(1, userId);
//			psmt.setInt(2, blogId);
//			psmt.setString(3, comment);
//
//			// 3.执行语句
//			int i = psmt.executeUpdate();
//
//			// 4.处理结果
//			return i;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			// 5.释放资源
//			closeCon(con, psmt);
//		}
//		return 0;
//	}
//
//	public static TBlog selBlogByPrimaryKey(int blogId) {
//		Connection con = null;
//		PreparedStatement psmt = null;
//		TBlog blog = null;
//
//		try {
//			// 1.建立连接
//			con = getCon();
//			// 2.创建语句
//			String sql = "select * from t_blog where blog_id = ?";
//			psmt = con.prepareStatement(sql);
//			// 替换问号
//			psmt.setInt(1, blogId);
//
//			// 3.执行语句
//			ResultSet rs = psmt.executeQuery();
//
//			if (rs.next()) {
//				// 创建对象，使用查询出的数据对对象进行装配
//				blog = new TBlog();
//				blog.setBlogId(rs.getInt("blog_id"));
//				blog.setBlogContent(rs.getString("blog_content"));
//				blog.setCreateAt(rs.getString("create_at"));
//				blog.setUserId(rs.getInt("user_id"));
//				blog.setThumb(rs.getInt("thumb"));
//			}
//			rs.close();
//
//		} catch (SQLException e) {
//
//			e.printStackTrace();
//		} finally {
//
//			closeCon(con, psmt);
//		}
//		// 返回放数据的容器
//		return blog;
//	}
//
//	public static List<TBlog> selectAllBlog(int loginUserId) {
//		List<TBlog> list = new ArrayList<TBlog>();
//
//		Connection con = null;
//		PreparedStatement psmt = null;
//
//		try {
//			// 1.建立连接
//			con = getCon();
//			// 2.创建语句
//			String sql = "select blog_id,blog_content,fans_id,s_user_id,d_user_id,b.create_at,b.user_id,username,thumb from t_blog b left join t_user u on u.user_id=b.user_id left join user_fans f on u.user_id=f.d_user_id order by create_at desc";
//			psmt = con.prepareStatement(sql);
//			
//			
//			
//			// 执行语句
//			ResultSet rs = psmt.executeQuery();
//			TBlog blog = null;
//			TUser author = null;
//			int sUserId = -1;
//			while(rs.next()) {
//				author = new TUser();
//				// 创建对象，使用查询出的数据对对象进行装配
//				blog = new TBlog();
//				blog.setBlogId(rs.getInt("blog_id"));
//				blog.setBlogContent(rs.getString("blog_content"));
//				blog.setCreateAt(rs.getString("create_at"));
//				blog.setUserId(rs.getInt("user_id"));
//				blog.setUsername(rs.getString("username"));
//				blog.setThumb(rs.getInt("thumb"));
//				
//				//判断当前登录用户是否为博文作者的粉丝
//				sUserId = rs.getInt("s_user_id");
//				if(sUserId==loginUserId){
//					author.setLoginFans(1);
//				}
//				author.setUserId(rs.getInt("user_id"));
//				//将作者绑定到博文对象中
//				blog.setAuthor(author);
//				list.add(blog);
//			}
//			rs.close();
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			closeCon(con, psmt);
//		}
//		// 返回放数据的容器
//		return list;
//	}
	
}
