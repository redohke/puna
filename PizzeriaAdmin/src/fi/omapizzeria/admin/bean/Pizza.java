package fi.omapizzeria.admin.bean;

public class Pizza {

	private int id;
	private String nimi;
	private double hinta;
			
	public Pizza(int id, String nimi, double hinta) {
		this.id = id;
		this.nimi = nimi;
		this.hinta = hinta;
	}
		
	//id get ja set
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	//nimi get ja set
	public String getNimi() {
		return nimi;
	}
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	
	//hinta get ja set
	public double getHinta() {
		return hinta;
	}
	public void setHinta(double hinta) {
		this.hinta = hinta;
	}
	
	//toString
	public String toString() {
		return "id: " + id + ", nimi: " + nimi + ", hinta: " + hinta;
	}
}