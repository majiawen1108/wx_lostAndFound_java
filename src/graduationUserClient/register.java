package graduationUserClient;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import graduationPrivate.wx.laf.dao.userDao;
import graduationPublic.wx.laf.vo.userVO;

@WebServlet("/userregister.do")
public class register extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String openid = req.getParameter("openid");
		String nickName = req.getParameter("nickName");
		String city = req.getParameter("city");
		String province = req.getParameter("province");
		String country = req.getParameter("country");
		String sex = req.getParameter("sex");
		List<userVO> uservo = userDao.getUser(openid);
		if (uservo != null && !uservo.isEmpty()) {
			return;
		}

		int i = userDao.saveUser(openid, nickName, city, province, country, sex);
		
		
	}

}
