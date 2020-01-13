package graduationPublic.wx.laf.vo;

public class SEARCHdetailInfoVO {
	// 主键
	private int id;
	// 失物的id
	private String search_thing_id;
	// 详情主题
	private String search_title;
	// 分类
	private String search_category;
	// 详情
	private String search_details;
	// 是否有偿
	private String paid;
	// 有偿金额
	private String money;
	// 丢失日期
	private String search_date;
	// 丢失地点
	private String search_address;
	// 详细地址
	private String search_det_address;
	// 寻找状态
	private String search_state;
	// 发布日期
	private String send_date;
	// 发布人
	private String search_name;
	private String userId;
	// 联系方式
	private String search_tel;
	// 丢失图
	private String image;
	// 微信
	private String search_wx;
	// QQ
	private String search_QQ;

	// 预留字段
	private String def1;
	private String def2;
	private String def3;
	private String def4;
	// 作者信息，直接封装成一个对象
	private userVO user;

	public SEARCHdetailInfoVO() {
		super();
	}

	public SEARCHdetailInfoVO(int id, String search_thing_id, String search_title, String search_category,
			String search_details, String paid, String money, String search_date, String search_address,
			String search_det_address, String search_state, String send_date, String search_name, String userId,
			String search_tel, String image, String search_wx, String search_QQ, String def1, String def2, String def3,
			String def4, userVO user) {
		super();
		this.id = id;
		this.search_thing_id = search_thing_id;
		this.search_title = search_title;
		this.search_category = search_category;
		this.search_details = search_details;
		this.paid = paid;
		this.money = money;
		this.search_date = search_date;
		this.search_address = search_address;
		this.search_det_address = search_det_address;
		this.search_state = search_state;
		this.send_date = send_date;
		this.search_name = search_name;
		this.userId = userId;
		this.search_tel = search_tel;
		this.image = image;
		this.search_wx = search_wx;
		this.search_QQ = search_QQ;
		this.def1 = def1;
		this.def2 = def2;
		this.def3 = def3;
		this.def4 = def4;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSearch_thing_id() {
		return search_thing_id;
	}

	public void setSearch_thing_id(String search_thing_id) {
		this.search_thing_id = search_thing_id;
	}

	public String getSearch_title() {
		return search_title;
	}

	public void setSearch_title(String search_title) {
		this.search_title = search_title;
	}

	public String getSearch_category() {
		return search_category;
	}

	public void setSearch_category(String search_category) {
		this.search_category = search_category;
	}

	public String getSearch_details() {
		return search_details;
	}

	public void setSearch_details(String search_details) {
		this.search_details = search_details;
	}

	public String getPaid() {
		return paid;
	}

	public void setPaid(String paid) {
		this.paid = paid;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getSearch_date() {
		return search_date;
	}

	public void setSearch_date(String search_date) {
		this.search_date = search_date;
	}

	public String getSearch_address() {
		return search_address;
	}

	public void setSearch_address(String search_address) {
		this.search_address = search_address;
	}

	public String getSearch_det_address() {
		return search_det_address;
	}

	public void setSearch_det_address(String search_det_address) {
		this.search_det_address = search_det_address;
	}

	public String getSearch_state() {
		return search_state;
	}

	public void setSearch_state(String search_state) {
		this.search_state = search_state;
	}

	public String getSend_date() {
		return send_date;
	}

	public void setSend_date(String send_date) {
		this.send_date = send_date;
	}

	public String getSearch_name() {
		return search_name;
	}

	public void setSearch_name(String search_name) {
		this.search_name = search_name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSearch_tel() {
		return search_tel;
	}

	public void setSearch_tel(String search_tel) {
		this.search_tel = search_tel;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getSearch_wx() {
		return search_wx;
	}

	public void setSearch_wx(String search_wx) {
		this.search_wx = search_wx;
	}

	public String getSearch_QQ() {
		return search_QQ;
	}

	public void setSearch_QQ(String search_QQ) {
		this.search_QQ = search_QQ;
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

	public userVO getUser() {
		return user;
	}

	public void setUser(userVO user) {
		this.user = user;
	}

}
