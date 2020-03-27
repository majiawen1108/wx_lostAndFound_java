package graduationBgClient;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import graduationPrivate.wx.laf.dao.detailInfoDao;
import graduationPrivate.wx.laf.dao.searchInfoDao;

/**
 * 删除自己已发布的拾物招领
 * 
 * @author 马家文
 *
 */
@WebServlet("/admin_delete_search.do")
public class adminDelete_search extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");

		searchInfoDao.adminDelete(id);
		// 删除博文结束后哦重定向回主页
		resp.sendRedirect("search.do");
	}
}
