package poi.xls.bean;
/**
* @author 作者 louys:
* @version 创建时间：2017年9月14日 下午5:26:06
* 类说明
*/
public class BranchBank {
	private String bank_name;
	private String bank_code;
	private String province;
	private String city;
	private String district;
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public String getBank_code() {
		return bank_code;
	}
	public void setBank_code(String bank_code) {
		this.bank_code = bank_code;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	@Override
	public String toString() {
		return "BranchBank [bank_name=" + bank_name + ", bank_code=" + bank_code + ", province=" + province + ", city="
				+ city + ", district=" + district + "]";
	}
}
