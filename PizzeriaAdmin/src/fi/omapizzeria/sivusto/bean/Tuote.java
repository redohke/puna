package fi.omapizzeria.sivusto.bean;

public class Tuote {

	private int id;
	private String nimi;
	private double hinta;
	private String tayte1;
	private String tayte2;
	private String tayte3;
	private String tayte4;
		
	public Tuote(int id, String nimi, double hinta, String tayte1, String tayte2, String tayte3, String tayte4) {
		this.id = id;
		this.nimi = nimi;
		this.hinta = hinta;
		this.tayte1 = tayte1;
		this.tayte2 = tayte2;
		this.tayte3 = tayte3;
		this.tayte4 = tayte4;
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

	public String getTayte4() {
		return tayte4;
	}

	public void setTayte4(String tayte4) {
		this.tayte4 = tayte4;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public double getHinta() {
		return hinta;
	}

	public void setHinta(double hinta) {
		this.hinta = hinta;
	}

	@Override
	public String toString() {
		return "Tuote [id=" + id + ", nimi=" + nimi + ", hinta=" + hinta
				+ ", tayte1=" + tayte1 + ", tayte2=" + tayte2 + ", tayte3="
				+ tayte3 + ", tayte4=" + tayte4 + "]";
	}
	
}
