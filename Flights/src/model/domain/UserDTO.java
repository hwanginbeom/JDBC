package model.domain;


public class UserDTO {
	private int admin;
	private String id;
	private String pw;
	private int mark1;
	private int mark2;
	private int mark3;
	private int mark4;
	private int mark5;
	public UserDTO(int admin, String id, String pw, int mark1, int mark2, int mark3, int mark4, int mark5) {
		super();
		this.admin = admin;
		this.id = id;
		this.pw = pw;
		this.mark1 = mark1;
		this.mark2 = mark2;
		this.mark3 = mark3;
		this.mark4 = mark4;
		this.mark5 = mark5;
	}
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public int getMark1() {
		return mark1;
	}
	public void setMark1(int mark1) {
		this.mark1 = mark1;
	}
	public int getMark2() {
		return mark2;
	}
	public void setMark2(int mark2) {
		this.mark2 = mark2;
	}
	public int getMark3() {
		return mark3;
	}
	public void setMark3(int mark3) {
		this.mark3 = mark3;
	}
	public int getMark4() {
		return mark4;
	}
	public void setMark4(int mark4) {
		this.mark4 = mark4;
	}
	public int getMark5() {
		return mark5;
	}
	public void setMark5(int mark5) {
		this.mark5 = mark5;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserDTO [admin=");
		builder.append(admin);
		builder.append(", id=");
		builder.append(id);
		builder.append(", pw=");
		builder.append(pw);
		builder.append(", mark1=");
		builder.append(mark1);
		builder.append(", mark2=");
		builder.append(mark2);
		builder.append(", mark3=");
		builder.append(mark3);
		builder.append(", mark4=");
		builder.append(mark4);
		builder.append(", mark5=");
		builder.append(mark5);
		builder.append("]");
		return builder.toString();
	}
	

	
}