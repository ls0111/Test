package com.income.tax;

import java.math.BigDecimal;

public class PersonalTax {
	private static final BigDecimal T_1500 = new BigDecimal("0");
	private static final BigDecimal T_1500_4500 = new BigDecimal("105");
	private static final BigDecimal T_4500_9000 = new BigDecimal("555");
	private static final BigDecimal T_9000_35000 = new BigDecimal("1005");
	private static final BigDecimal T_35000_55000 = new BigDecimal("2755");
	private static final BigDecimal T_55000_80000 = new BigDecimal("5505");
	private static final BigDecimal T_80000 = new BigDecimal("13505");
	
	private static final BigDecimal TP_1500 = new BigDecimal("0.03");
	private static final BigDecimal TP_1500_4500 = new BigDecimal("0.10");
	private static final BigDecimal TP_4500_9000 = new BigDecimal("0.20");
	private static final BigDecimal TP_9000_35000 = new BigDecimal("0.25");
	private static final BigDecimal TP_35000_55000 = new BigDecimal("0.30");
	private static final BigDecimal TP_55000_80000 = new BigDecimal("0.35");
	private static final BigDecimal TP_80000 = new BigDecimal("0.45");
	
	private BigDecimal salary;
	private BigDecimal insurance;
	private BigDecimal housingFund;
	private BigDecimal taxStartPoint;
	
	//已知个税求工资
	private BigDecimal taxValue;
	
	public PersonalTax(String salary, String insurance, String housingFund, String taxStartPoint){
		this.salary = new BigDecimal(salary);
		this.insurance = new BigDecimal(insurance);
		this.housingFund = new BigDecimal(housingFund);
		this.taxStartPoint = new BigDecimal(taxStartPoint);
	}
	
	public PersonalTax(String salary, String insurance, String housingFund, String taxStartPoint, String taxValue){
		this.salary = new BigDecimal(salary);
		this.insurance = new BigDecimal(insurance);
		this.housingFund = new BigDecimal(housingFund);
		this.taxStartPoint = new BigDecimal(taxStartPoint);
		this.taxValue = new BigDecimal(taxValue);
	}
	
	public BigDecimal getSalary() {
		return salary;
	}

	public BigDecimal getInsurance() {
		return insurance;
	}

	public BigDecimal getHousingFund() {
		return housingFund;
	}
	
	/**
	 * 获取个人所得税
	 * 
	 * 应纳个人所得税税额=应纳税所得额×适用税率-速算扣除数
	 * @return
	 */
	public BigDecimal getTaxValue() {
		BigDecimal taxValue = salary.subtract(insurance).subtract(housingFund);
		return calculate(taxValue);
	}

	public void setTaxValue(BigDecimal taxValue) {
		this.taxValue = taxValue;
	}

	private BigDecimal calculate(BigDecimal taxValue) {
		if(taxValue.compareTo(taxStartPoint)<0){
			return taxValue;
		}else if(taxValue.compareTo(new BigDecimal("4500"))<0){
			return taxValue.subtract(taxStartPoint).multiply(TP_1500_4500).subtract(T_1500_4500);
		}else if(taxValue.compareTo(new BigDecimal("9000"))<0){
			return taxValue.subtract(taxStartPoint).multiply(TP_4500_9000).subtract(T_4500_9000);
		}else if(taxValue.compareTo(new BigDecimal("35000"))<0){
			return taxValue.subtract(taxStartPoint).multiply(TP_9000_35000).subtract(T_9000_35000);
		}else if(taxValue.compareTo(new BigDecimal("55000"))<0){
			return taxValue.subtract(taxStartPoint).multiply(TP_35000_55000).subtract(T_35000_55000);
		}else if(taxValue.compareTo(new BigDecimal("80000"))<0){
			return taxValue.subtract(taxStartPoint).multiply(TP_55000_80000).subtract(T_55000_80000);
		}else if(taxValue.compareTo(new BigDecimal("80000"))>=0){
			return taxValue.subtract(taxStartPoint).multiply(TP_80000).subtract(T_80000);
		}
		return null;
	}
}
