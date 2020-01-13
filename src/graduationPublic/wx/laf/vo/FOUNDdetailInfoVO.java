package graduationPublic.wx.laf.vo;

/**
 * 发布拾物的详情表
 * 
 * @author 马家文
 *
 */
public class FOUNDdetailInfoVO {
	// 主键
	private int id;
	//证件后四位
	private String found_id;

	// 拾物的id
	private String Found_thing_id;
	// 详情主题
	private String found_title;
	// 分类
	private String found_category;
	// 失主姓名
	private String found_lost_name;
	// 拾获日期
	private String found_date;
	// 拾获地点
	private String found_address;
	// 认领状态
	private String found_state;
	// 详情
	private String found_details;
	// 发布日期
	private String send_date;
	// 发布人
	private String found_name;
	private String userId;
	// 联系方式
	private String found_tel;
	// 拾物图
	private String image;
	//标签
	private String found_tag;
	// 详细地址
	private String found_det_address;
	// 身份证上地址
	private String id_address;
	// 微信
	private String found_wx;
	// QQ
	private String found_QQ;

	// 预留字段
	private String def1;
	private String def2;
	private String def3;
	private String def4;
	// 作者信息，直接封装成一个对象
	private userVO user;


	public FOUNDdetailInfoVO(int id, String found_id, String found_thing_id, String found_title, String found_category,
			String found_lost_name, String found_date, String found_address, String found_state, String found_details,
			String send_date, String found_name, String userId, String found_tel, String image, String found_tag,
			String found_det_address, String id_address, String found_wx, String found_QQ, String def1, String def2,
			String def3, String def4, userVO user) {
		super();
		this.id = id;
		this.found_id = found_id;
		Found_thing_id = found_thing_id;
		this.found_title = found_title;
		this.found_category = found_category;
		this.found_lost_name = found_lost_name;
		this.found_date = found_date;
		this.found_address = found_address;
		this.found_state = found_state;
		this.found_details = found_details;
		this.send_date = send_date;
		this.found_name = found_name;
		this.userId = userId;
		this.found_tel = found_tel;
		this.image = image;
		this.found_tag = found_tag;
		this.found_det_address = found_det_address;
		this.id_address = id_address;
		this.found_wx = found_wx;
		this.found_QQ = found_QQ;
		this.def1 = def1;
		this.def2 = def2;
		this.def3 = def3;
		this.def4 = def4;
		this.user = user;
	}

	public FOUNDdetailInfoVO() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFound_id() {
		return found_id;
	}

	public void setFound_id(String found_id) {
		this.found_id = found_id;
	}

	public String getFound_thing_id() {
		return Found_thing_id;
	}

	public void setFound_thing_id(String found_thing_id) {
		Found_thing_id = found_thing_id;
	}

	public String getFound_title() {
		return found_title;
	}

	public void setFound_title(String found_title) {
		this.found_title = found_title;
	}

	public String getFound_category() {
		return found_category;
	}

	public void setFound_category(String found_category) {
		this.found_category = found_category;
	}

	public String getFound_lost_name() {
		return found_lost_name;
	}

	public void setFound_lost_name(String found_lost_name) {
		this.found_lost_name = found_lost_name;
	}

	public String getFound_address() {
		return found_address;
	}

	public void setFound_address(String found_address) {
		this.found_address = found_address;
	}

	public String getFound_state() {
		return found_state;
	}

	public void setFound_state(String found_state) {
		this.found_state = found_state;
	}

	public String getFound_details() {
		return found_details;
	}

	public void setFound_details(String found_details) {
		this.found_details = found_details;
	}

	public String getSend_date() {
		return send_date;
	}

	public void setSend_date(String send_date) {
		this.send_date = send_date;
	}

	public String getFound_name() {
		return found_name;
	}

	public void setFound_name(String found_name) {
		this.found_name = found_name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFound_tel() {
		return found_tel;
	}

	public void setFound_tel(String found_tel) {
		this.found_tel = found_tel;
	}

	public String getFound_date() {
		return found_date;
	}

	public void setFound_date(String found_date) {
		this.found_date = found_date;
	}

	public String getFound_tag() {
		return found_tag;
	}

	public void setFound_tag(String found_tag) {
		this.found_tag = found_tag;
	}

	public String getFound_det_address() {
		return found_det_address;
	}

	public void setFound_det_address(String found_det_address) {
		this.found_det_address = found_det_address;
	}

	public String getId_address() {
		return id_address;
	}

	public void setId_address(String id_address) {
		this.id_address = id_address;
	}

	public String getFound_wx() {
		return found_wx;
	}

	public void setFound_wx(String found_wx) {
		this.found_wx = found_wx;
	}

	public String getFound_QQ() {
		return found_QQ;
	}

	public void setFound_QQ(String found_QQ) {
		this.found_QQ = found_QQ;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public userVO getUser() {
		return user;
	}

	public void setUser(userVO user) {
		this.user = user;
	}

	public String getDef1() {
		return def1;
	}

	public void setDef1(String def1) {
		this.def1 = def1;
	}

	public String getDef2() {
		return def2;
	}

	public void setDef2(String def2) {
		this.def2 = def2;
	}

	public String getDef3() {
		return def3;
	}

	public void setDef3(String def3) {
		this.def3 = def3;
	}

	public String getDef4() {
		return def4;
	}

	public void setDef4(String def4) {
		this.def4 = def4;
	}

}
