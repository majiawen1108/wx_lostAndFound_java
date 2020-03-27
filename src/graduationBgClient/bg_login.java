package graduationBgClient;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import graduationPrivate.wx.laf.dao.adminDao;
import graduationPublic.wx.laf.vo.adminVo;

@WebServlet("/admin_login.do")
public class bg_login extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 引导用户进入页面
		req.getRequestDispatcher("/WEB-INF/page/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 接受用户提交的登录信息

		// 获取提交数据
		String username = req.getParameter("username");

		// 根据正则表达式判断用户名格式是否有问题
		if (username == null || username.trim().length() == 0) {
			req.setAttribute("msg", "请输入用户名");
			req.getRequestDispatcher("/WEB-INF/page/login.jsp").forward(req, resp);
			return;
		} else if (!username.matches("^\\d{3,}$")) {
			req.setAttribute("msg", "用户名至少为三个数字");
			req.getRequestDispatcher("/WEB-INF/page/login.jsp").forward(req, resp);
			return;
		}

		String password = req.getParameter("password");

		// 判断系统值是否有该用户
		adminVo adminvo = adminDao.getUser(username, password);
		if (adminvo == null) {
			req.setAttribute("msg", "用户名或密码错误");
			req.getRequestDispatcher("/WEB-INF/page/login.jsp").forward(req, resp);
			return;
		}
		/*
		 * 代码执行到这个地方就算是登录成功的 将用户信息放入Session,方便后续使用
		 */
		req.getSession().setAttribute("admin", adminvo);
		

		resp.sendRedirect("admin.do");

	}

}
