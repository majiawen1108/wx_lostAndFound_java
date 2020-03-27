package graduationUserClient;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import graduationPrivate.wx.laf.dao.userDao;
import graduationPublic.wx.laf.vo.userVO;

@WebServlet("/userlogin.do")
public class login extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 接受用户提交的登录信息

		// 获取提交数据
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		// 判断系统值是否有该用户
		
		List<userVO> list = userDao.getUser(username, password);
		if (list.size() == 0) {
			req.setAttribute("msg", "用户名或密码错误");
			return;
		}
		//将数据绑定到请求对象中
		req.setAttribute("list", list);
		 //返回值给微信小程序
        Writer out = resp.getWriter();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        out.write(json);
        out.flush();
		/*
		 * 代码执行到这个地方就算是登录成功的 将用户信息放入Session,方便后续使用
		 */
		

	}


}
