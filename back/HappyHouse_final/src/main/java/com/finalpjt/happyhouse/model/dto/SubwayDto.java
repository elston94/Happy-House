package com.finalpjt.happyhouse.model.dto;

public class SubwayDto {
	private int no; //역번
    private int stationNo;//역번호
    private int line; //호선
    private String name; //역명
    private String phone;//역전화번호
    private String address; //역주소
    
    
	public SubwayDto() {
		super();
	}


	public SubwayDto(int no, int stationNo, int line, String name, String phone, String address) {
		super();
		this.no = no;
		this.stationNo = stationNo;
		this.line = line;
		this.name = name;
		this.phone = phone;
		this.address = address;
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public int getStationNo() {
		return stationNo;
	}


	public void setStationNo(int stationNo) {
		this.stationNo = stationNo;
	}


	public int getLine() {
		return line;
	}


	public void setLine(int line) {
		this.line = line;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "SubwayDto [no=" + no + ", stationNo=" + stationNo + ", line=" + line + ", name=" + name + ", phone="
				+ phone + ", address=" + address + "]";
	}
    
    
    
}
