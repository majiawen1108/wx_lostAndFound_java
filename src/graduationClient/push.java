package graduationClient;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import graduationPrivate.wx.laf.dao.detailInfoDao;
import graduationPublic.wx.laf.vo.FOUNDdetailInfoVO;
import graduationPublic.wx.laf.vo.userVO;
/**
 * 发布拾物招领
 * @author 马家文
 *
 */
@WebServlet("/push.do")
public class push extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String img = req.getParameter("image");
		String image = img.substring(2, img.length()-2);
		String found_title = req.getParameter("found_title");
		String found_category = req.getParameter("found_category");
		String found_state = req.getParameter("found_state");
		String found_date = req.getParameter("found_date");
		String found_address = req.getParameter("found_address"); 
		String found_id = req.getParameter("found_id");
		String found_lost_name = req.getParameter("found_lost_name");
		String found_tag = req.getParameter("found_tag");
		String found_det_address = req.getParameter("found_det_address");
		String id_address = req.getParameter("id_address");
		String found_details = req.getParameter("found_details");
		String found_name = req.getParameter("found_name");
		String found_tel = req.getParameter("found_tel");
		String found_wx = req.getParameter("found_wx");
		String found_QQ = req.getParameter("found_QQ");
		String def1 = req.getParameter("def1");
		String def2 = req.getParameter("def2");
		
		FOUNDdetailInfoVO foundVO = new FOUNDdetailInfoVO();
		foundVO.setDef1(def1);
		foundVO.setDef2(def2);
		foundVO.setFound_address(found_address);
		foundVO.setFound_category(found_category);
		foundVO.setFound_details(found_details);
		foundVO.setFound_id(found_id);
		foundVO.setFound_lost_name(found_lost_name);
		foundVO.setFound_name(found_name);
		foundVO.setImage(image);
		foundVO.setFound_state(found_state);
		foundVO.setFound_tel(found_tel);
		foundVO.setFound_title(found_title);
		foundVO.setFound_date(found_date);
		foundVO.setFound_QQ(found_QQ);
		foundVO.setFound_tag(found_tag);
		foundVO.setFound_wx(found_wx);
		foundVO.setId_address(id_address);
		foundVO.setFound_det_address(found_det_address);
		
		userVO vo = new userVO();
		vo.setDef1(def1);
		int  i = detailInfoDao.saveBlog(foundVO, vo);
		
}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
	}

}
