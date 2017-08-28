package com.income.tax;

public class CalculatePersonalTaxTest {
	public static void main(String[] args) {
		PersonalTax pt = new PersonalTax("18000", "500", "0", "3500");
		System.out.println(pt.getTaxValue().toString());
	}
}
