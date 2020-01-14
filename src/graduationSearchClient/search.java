package graduationSearchClient;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import graduationPrivate.wx.laf.dao.searchInfoDao;
import graduationPublic.wx.laf.vo.SEARCHdetailInfoVO;
import graduationPublic.wx.laf.vo.userVO;
/**
 * 发布失物
 * @author 马家文
 *
 */
@WebServlet("/search.do")
public class search extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String image = req.getParameter("image");
		String search_title = req.getParameter("search_title");
		String search_category = req.getParameter("search_category");
		String search_details = req.getParameter("search_details");
		String paid = req.getParameter("paid");
		String money = req.getParameter("money");
		String search_date = req.getParameter("search_date");
		String search_address = req.getParameter("search_address");
		String search_det_address = req.getParameter("search_det_address");
		String search_state = req.getParameter("search_state");
		String search_name = req.getParameter("search_name");
		String search_tel = req.getParameter("search_tel");
		String search_wx = req.getParameter("search_wx");
		String search_QQ = req.getParameter("search_QQ");
		String def1 = req.getParameter("def1");
		
		SEARCHdetailInfoVO searchVO = new SEARCHdetailInfoVO();
		searchVO.setImage(image);
		searchVO.setSearch_title(search_title);
		searchVO.setSearch_category(search_category);
		searchVO.setSearch_details(search_details);
		searchVO.setPaid(paid);
		searchVO.setMoney(money);
		searchVO.setSearch_date(search_date);
		searchVO.setSearch_address(search_address);
		searchVO.setSearch_det_address(search_det_address);
		searchVO.setSearch_state(search_state);
		searchVO.setSearch_name(search_name);
		searchVO.setSearch_tel(search_tel);
		searchVO.setSearch_wx(search_wx);
		searchVO.setSearch_QQ(search_QQ);
		searchVO.setDef1(def1);
		userVO vo = new userVO();
		vo.setDef1(def1);
		searchInfoDao.saveBlog(searchVO, vo);
		
}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
	}

}
