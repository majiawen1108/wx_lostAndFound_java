package graduationClient;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import graduationPrivate.wx.laf.dao.detailInfoDao;
/**
 * 修改自己已发布的拾物招领的状态
 * @author 马家文
 *
 */
@WebServlet("/update.do")
public class update extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		String def1 = req.getParameter("def1");
		
		if(def1 == null) {
			return;
		}
		
		detailInfoDao.updateBlog(id, def1);
	}
}
