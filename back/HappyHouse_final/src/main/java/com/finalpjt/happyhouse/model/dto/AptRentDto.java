package com.finalpjt.happyhouse.model.dto;

public class AptRentDto {
	int no;
	String rentMoney;
	String jibun;
	String code;
	String dealYear;
	String dealMonth;
	String dong;
	String floor;
	String dealDay;
	String deposit;
	String aptName;
	String buildYear;
	String area;
	public AptRentDto(int no, String rentMoney, String jibun, String code, String dealYear, String dealMonth,
			String dong, String floor, String dealDay, String deposit, String aptName, String buildYear, String area) {
		super();
		this.no = no;
		this.rentMoney = rentMoney;
		this.jibun = jibun;
		this.code = code;
		this.dealYear = dealYear;
		this.dealMonth = dealMonth;
		this.dong = dong;
		this.floor = floor;
		this.dealDay = dealDay;
		this.deposit = deposit;
		this.aptName = aptName;
		this.buildYear = buildYear;
		this.area = area;
	}
	public AptRentDto() {
		super();
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getRentMoney() {
		return rentMoney;
	}
	public void setRentMoney(String rentMoney) {
		this.rentMoney = rentMoney;
	}
	public String getJibun() {
		return jibun;
	}
	public void setJibun(String jibun) {
		this.jibun = jibun;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDealYear() {
		return dealYear;
	}
	public void setDealYear(String dealYear) {
		this.dealYear = dealYear;
	}
	public String getDealMonth() {
		return dealMonth;
	}
	public void setDealMonth(String dealMonth) {
		this.dealMonth = dealMonth;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getDealDay() {
		return dealDay;
	}
	public void setDealDay(String dealDay) {
		this.dealDay = dealDay;
	}
	public String getDeposit() {
		return deposit;
	}
	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}
	public String getAptName() {
		return aptName;
	}
	public void setAptName(String aptName) {
		this.aptName = aptName;
	}
	public String getBuildYear() {
		return buildYear;
	}
	public void setBuildYear(String buildYear) {
		this.buildYear = buildYear;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	@Override
	public String toString() {
		return "AptRentDto [no=" + no + ", rentMoney=" + rentMoney + ", jibun=" + jibun + ", code=" + code
				+ ", dealYear=" + dealYear + ", dealMonth=" + dealMonth + ", dong=" + dong + ", floor=" + floor
				+ ", dealDay=" + dealDay + ", deposit=" + deposit + ", aptName=" + aptName + ", buildYear=" + buildYear
				+ ", area=" + area + "]";
	}
	
	
}
