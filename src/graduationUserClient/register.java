package graduationUserClient;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import graduationPrivate.wx.laf.dao.userDao;

@WebServlet("/userregister.do")
public class register extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String nickName = req.getParameter("nickName");
		String city = req.getParameter("city");
		String province = req.getParameter("province");
		String country = req.getParameter("country");
		String sex = req.getParameter("sex");
		
		
		int i = userDao.saveUser(username,password,nickName,city,province,country,sex);
		Writer out = resp.getWriter();
		out.write("123");
        out.flush();
	}


}
