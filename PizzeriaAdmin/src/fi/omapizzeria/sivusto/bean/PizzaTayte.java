package fi.omapizzeria.sivusto.bean;

public class PizzaTayte  {
	
	

	private int id;
	private String tayte;
	private String tayte1;
	private String tayte2;
	private String tayte3;
	
	
	public PizzaTayte(int id, String tayte, String tayte1, String tayte2,
			String tayte3) {
		super();
		this.id = id;
		this.tayte = tayte;
		this.tayte1 = tayte1;
		this.tayte2 = tayte2;
		this.tayte3 = tayte3;
	}
	@Override
	public String toString() {
		return "PizzaTayte [id=" + id + ", tayte=" + tayte + ", tayte1="
				+ tayte1 + ", tayte2=" + tayte2 + ", tayte3=" + tayte3 + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTayte() {
		return tayte;
	}
	public void setTayte(String tayte) {
		this.tayte = tayte;
	}
	public String getTayte1() {
		return tayte1;
	}
	public void setTayte1(String tayte1) {
		this.tayte1 = tayte1;
	}
	public String getTayte2() {
		return tayte2;
	}
	public void setTayte2(String tayte2) {
		this.tayte2 = tayte2;
	}
	public String getTayte3() {
		return tayte3;
	}
	public void setTayte3(String tayte3) {
		this.tayte3 = tayte3;
	}
	


}
