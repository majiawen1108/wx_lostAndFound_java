package graduationClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login.do")
public class login extends HttpServlet {

	// AppID(小程序ID)
	private String appid = "wx93f44843e351cfa9";
	// AppSecret(小程序密钥)
	private String secretKey = "778d0fc32e2907279204321f8e72c50f";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String operFlag = req.getParameter("operFlag");
		String results = "";
		if ("getOpenid".equals(operFlag)) {
			// 拿到微信小程序传过来的code
			String code = req.getParameter("code");
//			String code = "001jmfWX01LYdX1CHkWX09DEWX0jmfWY";

			System.out.println(code);

			// 接口地址
			String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret=" + secretKey
					+ "&js_code=" + code + "&grant_type=authorization_code";
			System.out.println("url" + url);
			// 发送http请求
			results = sendGetReq(url);
			System.out.println("results" + results);
		}
		resp.setContentType("application/json;charset=UTF-8");
		resp.setHeader("catch-control", "no-catch");
		PrintWriter out = resp.getWriter();
		out.write(results);
		out.flush();
		out.close();

	}

	private String sendGetReq(String url) {
		String result = "";
		BufferedReader in = null;
		try {
			String urlNameString = url;
			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 建立实际的连接
			connection.connect();
			// 获取所有响应头字段
			java.util.Map<String, List<String>> map = connection.getHeaderFields();
			// 遍历所有的响应头字段
			for (String key : map.keySet()) {
				System.out.println(key + "--->" + map.get(key));
			}
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		} // 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;

	}
}
