package graduationBgClient;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import graduationPrivate.wx.laf.dao.userDao;
import graduationPublic.wx.laf.vo.userVO;

@WebServlet("/bg_userinfo.do")
public class bg_userinfo extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");

		/* 设置响应头允许ajax跨域访问 */
		resp.setHeader("Access-Control-Allow-Origin", "*");
		/* 星号表示所有的异域请求都可以接受， */
		resp.setHeader("Access-Control-Allow-Methods", "GET,POST");

		// 访问数据库获取所有的博文信息
		List<userVO> list = userDao.getUser();
		// 将数据绑定到请求对象中
		req.setAttribute("list", list);
		req.setAttribute("list6", req.getSession().getAttribute("admin"));
		// 引导用户进入页面
		req.getRequestDispatcher("/WEB-INF/page/userinfo.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}
}
