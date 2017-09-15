package poi.xls.bean;
/**
* @author 作者 louys:
* @version 创建时间：2017年9月14日 下午5:26:06
* 类说明
*/
public class BankConfig {
	private String bank_code;
	private String bank_name;
	private String bank_bin_no;
	private String card_type;
	private String need_branch_bank;
	public String getBank_code() {
		return bank_code;
	}
	public void setBank_code(String bank_code) {
		this.bank_code = bank_code;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public String getBank_bin_no() {
		return bank_bin_no;
	}
	public void setBank_bin_no(String bank_bin_no) {
		this.bank_bin_no = bank_bin_no;
	}
	public String getCard_type() {
		return card_type;
	}
	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}
	public String getNeed_branch_bank() {
		return need_branch_bank;
	}
	public void setNeed_branch_bank(String need_branch_bank) {
		this.need_branch_bank = need_branch_bank;
	}
	@Override
	public String toString() {
		return "BankConfig [bank_code=" + bank_code + ", bank_name=" + bank_name + ", bank_bin_no=" + bank_bin_no
				+ ", card_type=" + card_type + ", need_branch_bank=" + need_branch_bank + "]";
	}
}
