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
 * 详情数据库类
 * @author 马家文
 *
 */
public class detailInfoDao extends BaseDao{
/*
	public static List<FOUNDdetailInfoVO> selectAllBlog(FOUNDdetailInfoVO foundDetailInfo) {
		List<FOUNDdetailInfoVO> list = new ArrayList<FOUNDdetailInfoVO>();

		Connection con = null;
		PreparedStatement psmt = null;

		try {
			// 1.建立连接
			con = getCon();
			// 2.创建语句
			String sql = "select found_id,Found_thing_id,"
					+ "found_title,found_category,found_lost_name,"
					+ "get_date,found_address,found_state,found_details,"
					+ "send_date,found_name,found_tel,found_pic "
					+ "from found_info f left join laf_user u "
					+ "on f.user_id=u.user_id where f.user_id=?";
			psmt = con.prepareStatement(sql);
			//替换？
			psmt.setString(1, foundDetailInfo.getUserId());
			
			
			// 执行语句
			ResultSet rs = psmt.executeQuery();
			FOUNDdetailInfoVO foundDetailInfo1 = null;
			userVO author = null;
			while(rs.next()) {
				// 创建对象，使用查询出的数据对对象进行装配
				foundDetailInfo1 = new FOUNDdetailInfoVO();
				author  =new userVO();
				foundDetailInfo1.setFound_title(rs.getString("found_title"));
				foundDetailInfo1.setFound_category(rs.getString("found_category"));
				foundDetailInfo1.setFound_lost_name(rs.getString("found_lost_name"));
				foundDetailInfo1.setGet_date(rs.getString("get_date"));
				foundDetailInfo1.setFound_address(rs.getString("found_address"));
				foundDetailInfo1.setFound_state(rs.getString("found_state"));
				foundDetailInfo1.setFound_details(rs.getString("found_details"));
				foundDetailInfo1.setSend_date(rs.getString("send_date"));
				foundDetailInfo1.setFound_name(rs.getString("found_name"));
				foundDetailInfo1.setFound_tel(rs.getString("found_tel"));
				foundDetailInfo1.setUserId(rs.getString("user_id"));
				foundDetailInfo1.setFound_pic(rs.getString("found_pic"));
				
				
				author.setId(rs.getInt("id"));
				
				//将作者绑定到博文对象中
				foundDetailInfo1.setUser(author);
				list.add(foundDetailInfo1);
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
	*/
	
	/***
	 * 
	 * @param id
	 * @return
	 * 	查询单条数据
	 */
	public static List<FOUNDdetailInfoVO> queryOne(String id) {
		List<FOUNDdetailInfoVO> list = new ArrayList<FOUNDdetailInfoVO>();

		Connection con = null;
		PreparedStatement psmt = null;

		try {
			// 1.建立连接
			con = getCon();
			// 2.创建语句
			String sql = "select image,found_title,found_category,"
					+ "found_state,found_date,found_address,found_id,"
					+ "found_lost_name,found_tag,found_det_address,"
					+ "id_address,found_details,found_name,found_tel,"
					+ "found_wx,found_QQ ,found_create_date "
					+ "from laf_pageinfo f left join laf_user u on f.def1=u.def1 where f.id = "+id+"";
			psmt = con.prepareStatement(sql);
			
			// 执行语句
			ResultSet rs = psmt.executeQuery();
			FOUNDdetailInfoVO foundDetailInfo1 = null;
			userVO author = null;
			while(rs.next()) {
				// 创建对象，使用查询出的数据对对象进行装配
				foundDetailInfo1 = new FOUNDdetailInfoVO();
				author  =new userVO();
//				foundDetailInfo1.setId(rs.getInt("id"));
				foundDetailInfo1.setFound_title(rs.getString("found_title"));
				foundDetailInfo1.setFound_category(rs.getString("found_category"));
				foundDetailInfo1.setFound_lost_name(rs.getString("found_lost_name"));
				foundDetailInfo1.setFound_date(rs.getString("found_date"));
				foundDetailInfo1.setFound_address(rs.getString("found_address"));
				foundDetailInfo1.setFound_state(rs.getString("found_state"));
				foundDetailInfo1.setFound_details(rs.getString("found_details"));
				foundDetailInfo1.setSend_date(rs.getString("found_create_date"));
				foundDetailInfo1.setFound_det_address(rs.getString("found_det_address"));
				foundDetailInfo1.setFound_tag(rs.getString("found_tag"));
				foundDetailInfo1.setFound_id(rs.getString("found_id"));
				foundDetailInfo1.setId_address(rs.getString("id_address"));
				foundDetailInfo1.setFound_name(rs.getString("found_name"));
				foundDetailInfo1.setFound_tel(rs.getString("found_tel"));
				foundDetailInfo1.setFound_wx(rs.getString("found_wx"));
				foundDetailInfo1.setFound_QQ(rs.getString("found_QQ"));

				foundDetailInfo1.setImage(rs.getString("image"));
				
				
//				author.setDef1(def1);
				//将作者绑定到博文对象中
				foundDetailInfo1.setUser(author);
				list.add(foundDetailInfo1);
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
	public static List<FOUNDdetailInfoVO> selectMineBlog(String def1) {
		List<FOUNDdetailInfoVO> list = new ArrayList<FOUNDdetailInfoVO>();

		Connection con = null;
		PreparedStatement psmt = null;

		try {
			// 1.建立连接
			con = getCon();
			// 2.创建语句
			String sql = "select f.id,image,found_title,found_category,"
					+ "found_state,found_date,found_address,found_id,"
					+ "found_lost_name,found_tag,found_det_address,"
					+ "id_address,found_details,found_name,found_tel,"
					+ "found_wx,found_QQ ,found_create_date "
					+ "from laf_pageinfo f left join laf_user u on f.def1=u.def1 where u.def1 = "+def1+" order by found_create_date desc,id desc";
			psmt = con.prepareStatement(sql);
			
			// 执行语句
			ResultSet rs = psmt.executeQuery();
			FOUNDdetailInfoVO foundDetailInfo1 = null;
			userVO author = null;
			while(rs.next()) {
				// 创建对象，使用查询出的数据对对象进行装配
				foundDetailInfo1 = new FOUNDdetailInfoVO();
				author  =new userVO();
				foundDetailInfo1.setId(rs.getInt("id"));
				foundDetailInfo1.setFound_title(rs.getString("found_title"));
				foundDetailInfo1.setFound_category(rs.getString("found_category"));
				foundDetailInfo1.setFound_lost_name(rs.getString("found_lost_name"));
				foundDetailInfo1.setFound_date(rs.getString("found_date"));
				foundDetailInfo1.setFound_address(rs.getString("found_address"));
				foundDetailInfo1.setFound_state(rs.getString("found_state"));
				foundDetailInfo1.setFound_details(rs.getString("found_details"));
				foundDetailInfo1.setSend_date(rs.getString("found_create_date"));
				foundDetailInfo1.setFound_name(rs.getString("found_name"));
				foundDetailInfo1.setFound_tel(rs.getString("found_tel"));
				foundDetailInfo1.setFound_tel(rs.getString("found_wx"));
				foundDetailInfo1.setFound_tel(rs.getString("found_QQ"));

//				foundDetailInfo1.setUserId(rs.getString("user_id"));
				foundDetailInfo1.setImage(rs.getString("image"));
				
				
//				author.setUserId(rs.getString("user_id"));
				author.setDef1(def1);
				//将作者绑定到博文对象中
				foundDetailInfo1.setUser(author);
				list.add(foundDetailInfo1);
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
		public static List<FOUNDdetailInfoVO> selectAllBlog() {
			List<FOUNDdetailInfoVO> list = new ArrayList<FOUNDdetailInfoVO>();

			Connection con = null;
			PreparedStatement psmt = null;

			try {
				// 1.建立连接
				con = getCon();
				// 2.创建语句
				String sql = "select id,image,found_title,found_category,"
						+ "found_state,found_date,found_address,found_id,"
						+ "found_lost_name,found_tag,found_det_address,"
						+ "id_address,found_details,found_name,found_tel,"
						+ "found_wx,found_QQ ,found_create_date "
						+ "from laf_pageinfo order by found_create_date desc,id desc";
				psmt = con.prepareStatement(sql);
				
				// 执行语句
				ResultSet rs = psmt.executeQuery();
				FOUNDdetailInfoVO foundDetailInfo1 = null;
				userVO author = null;
				while(rs.next()) {
					// 创建对象，使用查询出的数据对对象进行装配
					foundDetailInfo1 = new FOUNDdetailInfoVO();
					author  =new userVO();
					foundDetailInfo1.setId(rs.getInt("id"));
					foundDetailInfo1.setFound_title(rs.getString("found_title"));
					foundDetailInfo1.setFound_category(rs.getString("found_category"));
					foundDetailInfo1.setFound_lost_name(rs.getString("found_lost_name"));
					foundDetailInfo1.setFound_date(rs.getString("found_date"));
					foundDetailInfo1.setFound_address(rs.getString("found_address"));
					foundDetailInfo1.setFound_state(rs.getString("found_state"));
					foundDetailInfo1.setFound_details(rs.getString("found_details"));
					foundDetailInfo1.setSend_date(rs.getString("found_create_date"));
					foundDetailInfo1.setFound_name(rs.getString("found_name"));
					foundDetailInfo1.setFound_tel(rs.getString("found_tel"));
					foundDetailInfo1.setFound_tel(rs.getString("found_wx"));
					foundDetailInfo1.setFound_tel(rs.getString("found_QQ"));
					foundDetailInfo1.setImage(rs.getString("image"));

//					foundDetailInfo1.setUserId(rs.getString("user_id"));
					
			
					//将作者绑定到博文对象中
					foundDetailInfo1.setUser(author);
					list.add(foundDetailInfo1);
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
			public static List<FOUNDdetailInfoVO> selectAllBlogBytag(String found_category) {
				List<FOUNDdetailInfoVO> list = new ArrayList<FOUNDdetailInfoVO>();

				Connection con = null;
				PreparedStatement psmt = null;

				try {
					// 1.建立连接
					con = getCon();
					// 2.创建语句
					String sql = "";
					if(found_category.equals("首页")) {
						sql = "select id,image,found_title,found_category,"
								+ "found_state,found_date,found_address,found_id,"
								+ "found_lost_name,found_tag,found_det_address,"
								+ "id_address,found_details,found_name,found_tel,"
								+ "found_wx,found_QQ ,found_create_date "
								+ "from laf_pageinfo order by found_create_date desc,id desc";
					}else {
						sql = "select id,image,found_title,found_category,"
								+ "found_state,found_date,found_address,found_id,"
								+ "found_lost_name,found_tag,found_det_address,"
								+ "id_address,found_details,found_name,found_tel,"
								+ "found_wx,found_QQ ,found_create_date "
								+ "from laf_pageinfo where found_category = '"+found_category+"' order by found_create_date desc,id desc";
						
					}
					
					psmt = con.prepareStatement(sql);
					
					// 执行语句
					ResultSet rs = psmt.executeQuery();
					FOUNDdetailInfoVO foundDetailInfo1 = null;
					userVO author = null;
					while(rs.next()) {
						// 创建对象，使用查询出的数据对对象进行装配
						foundDetailInfo1 = new FOUNDdetailInfoVO();
						author  =new userVO();
						foundDetailInfo1.setId(rs.getInt("id"));
						foundDetailInfo1.setFound_title(rs.getString("found_title"));
						foundDetailInfo1.setFound_category(rs.getString("found_category"));
						foundDetailInfo1.setFound_lost_name(rs.getString("found_lost_name"));
						foundDetailInfo1.setFound_date(rs.getString("found_date"));
						foundDetailInfo1.setFound_address(rs.getString("found_address"));
						foundDetailInfo1.setFound_state(rs.getString("found_state"));
						foundDetailInfo1.setFound_details(rs.getString("found_details"));
						foundDetailInfo1.setSend_date(rs.getString("found_create_date"));
						foundDetailInfo1.setFound_name(rs.getString("found_name"));
						foundDetailInfo1.setFound_tel(rs.getString("found_tel"));
						foundDetailInfo1.setFound_tel(rs.getString("found_wx"));
						foundDetailInfo1.setFound_tel(rs.getString("found_QQ"));
						foundDetailInfo1.setImage(rs.getString("image"));

//						foundDetailInfo1.setUserId(rs.getString("user_id"));
						
				
						//将作者绑定到博文对象中
						foundDetailInfo1.setUser(author);
						list.add(foundDetailInfo1);
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
	public static int saveBlog(FOUNDdetailInfoVO foundVO,userVO vo) {
		
		int i = 0;
		
		Connection con = null;
		PreparedStatement psmt = null;

		try {
			// 1.建立连接
			con = getCon();
			// 2.创建语句
			String sql = "insert into laf_pageinfo"
					+ "(image,found_title,found_category,found_state,found_date,"
					+ "found_address,found_id,found_lost_name,found_tag,"
					+ "found_det_address,id_address,found_details,found_name,"
					+ "found_tel,found_wx,found_QQ,def1) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			psmt = con.prepareStatement(sql);
			// 设定参数，替换问号
			psmt.setString(1,foundVO.getImage());
			psmt.setString(2,foundVO.getFound_title());
			psmt.setString(3,foundVO.getFound_category());
			psmt.setString(4,foundVO.getFound_state());
			psmt.setString(5,foundVO.getFound_date());
			psmt.setString(6, foundVO.getFound_address());
			psmt.setString(7, foundVO.getFound_id());
			psmt.setString(8, foundVO.getFound_lost_name());
			psmt.setString(9, foundVO.getFound_tag());
			psmt.setString(10,foundVO.getFound_det_address());
			psmt.setString(11,foundVO.getId_address());
			psmt.setString(12, foundVO.getFound_details());
			psmt.setString(13,foundVO.getFound_name());
			psmt.setString(14, foundVO.getFound_tel());
			psmt.setString(15, foundVO.getFound_wx());
			psmt.setString(16, foundVO.getFound_QQ());
			psmt.setString(17, foundVO.getDef1());

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
			String sql = "delete from laf_pageinfo where id = ? and def1 = ?";
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
