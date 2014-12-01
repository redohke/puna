package fi.omapizzeria.sivusto.bean;

public class Tilaus {
	
	private Asiakas asiakas;
	private Ostoskori ostoskori;
	private double hinta;

	

	public Tilaus(Asiakas asiakas, Ostoskori ostoskori, double hinta) {
		super();
		this.asiakas = asiakas;
		this.ostoskori = ostoskori;
		this.hinta = hinta;

	}
	
	
	
	
	public double getHinta() {
		return hinta;
	}
	public void setHinta(double hinta) {
		this.hinta = hinta;
	}
	public Asiakas getAsiakas() {
		return asiakas;
	}
	public void setAsiakas(Asiakas asiakas) {
		this.asiakas = asiakas;
	}
	public Ostoskori getOstoskori() {
		return ostoskori;
	}
	public void setOstoskori(Ostoskori ostoskori) {
		this.ostoskori = ostoskori;
	}

	@Override
	public String toString() {
		return "Tilaus [asiakas=" + asiakas + ", ostoskori=" + ostoskori
				+ ", hinta=" + hinta + "]";
	}

}
