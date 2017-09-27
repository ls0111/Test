package fastxml.jackson.bean;

/**
 * @author 作者 louys:
 * @version 创建时间：2017年9月26日 下午3:32:37 类说明
 */
public class User {
	private String email;
	private String telephone;
	private String address;
	private String gender;
	private String userName;
	private String realName;
	private String password;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [email=" + email + ", telephone=" + telephone + ", address=" + address + ", gender=" + gender
				+ ", userName=" + userName + ", realName=" + realName + ", password=" + password + "]";
	}
}
