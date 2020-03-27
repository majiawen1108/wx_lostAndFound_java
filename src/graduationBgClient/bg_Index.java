package graduationBgClient;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import graduationPrivate.wx.laf.dao.detailInfoDao;
import graduationPrivate.wx.laf.dao.searchInfoDao;
import graduationPrivate.wx.laf.dao.userDao;
import graduationPublic.wx.laf.vo.FOUNDdetailInfoVO;
import graduationPublic.wx.laf.vo.SEARCHdetailInfoVO;
import graduationPublic.wx.laf.vo.adminVo;

@WebServlet("/admin.do")
public class bg_Index extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");

		/* 设置响应头允许ajax跨域访问 */
		resp.setHeader("Access-Control-Allow-Origin", "*");
		/* 星号表示所有的异域请求都可以接受， */
		resp.setHeader("Access-Control-Allow-Methods", "GET,POST");

		// 访问数据库获取所有的博文信息
		List<FOUNDdetailInfoVO> list = detailInfoDao.selectAllBlog();
		// 将数据绑定到请求对象中
		req.setAttribute("list", list);
		// 访问数据库获取所有的博文信息
		List<SEARCHdetailInfoVO> list1 = searchInfoDao.selectAllBlog();
		// 将数据绑定到请求对象中
		req.setAttribute("list1", list1);
		
		
		//用户数
		int m = userDao.userNums();
		req.setAttribute("list5", m);
		//拾物条数
		int i = detailInfoDao.adminNums();
		req.setAttribute("list2", i);
		//失物条数
		int j = searchInfoDao.adminNums();
		req.setAttribute("list3", j);
		//总条数
		int sum = i + j;
		req.setAttribute("list4", sum);
		
		
		req.setAttribute("list6", req.getSession().getAttribute("admin"));
		
		// 引导用户进入页面
		req.getRequestDispatcher("/WEB-INF/page/index.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}
}
