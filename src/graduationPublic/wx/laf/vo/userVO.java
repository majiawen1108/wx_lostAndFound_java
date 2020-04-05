package graduationPublic.wx.laf.vo;

/**
 * 用户类
 * 
 * @author 马家文
 *
 */
public class userVO {
	private int id;
	private String sex;
	private String nickName;
	private String city;
	private String province;
	private String country;
	private String def1;
	private String def2;
	private String def3;
	private String def4;
	private String def5;
	private String def6;
	private String def7;

	
	public userVO() {
		super();
	}
	

	public userVO(int id, String sex, String nickName, String city, String province, String country, String def1,
			String def2, String def3, String def4, String def5, String def6, String def7) {
		super();
		this.id = id;
		this.sex = sex;
		this.nickName = nickName;
		this.city = city;
		this.province = province;
		this.country = country;
		this.def1 = def1;
		this.def2 = def2;
		this.def3 = def3;
		this.def4 = def4;
		this.def5 = def5;
		this.def6 = def6;
		this.def7 = def7;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	public String getDef5() {
		return def5;
	}

	public void setDef5(String def5) {
		this.def5 = def5;
	}

	public String getDef6() {
		return def6;
	}

	public void setDef6(String def6) {
		this.def6 = def6;
	}

	public String getDef7() {
		return def7;
	}

	public void setDef7(String def7) {
		this.def7 = def7;
	}

}
