package graduationClient;



import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import graduationPrivate.wx.laf.dao.detailInfoDao;
import graduationPublic.wx.laf.vo.FOUNDdetailInfoVO;

/**
 * 
 * @author 马家文
 *	查询我发布的
 */
@WebServlet("/minepush.do")
public class minePush  extends HttpServlet {

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");

			String i = req.getParameter("id");
			System.out.println(i);
			 /* 设置响应头允许ajax跨域访问 */
	        resp.setHeader("Access-Control-Allow-Origin", "*");
	        /* 星号表示所有的异域请求都可以接受， */
	        resp.setHeader("Access-Control-Allow-Methods", "GET,POST");
 
	        String user = req.getParameter("def1");
	        
			//访问数据库获取所有的博文信息
			List<FOUNDdetailInfoVO> list = detailInfoDao.selectMineBlog(user);
			//将数据绑定到请求对象中
			req.setAttribute("list", list);
			 //返回值给微信小程序
	        Writer out = resp.getWriter();
	        Gson gson = new Gson();
	        String json = gson.toJson(list);
	        out.write(json);
	        out.flush();
			
			
		}
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doGet(req, resp);
		}
	


}
