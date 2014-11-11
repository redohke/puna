package fi.omapizzeria.sivusto.bean;

public class Tilausrivi {
	
	private Asiakas asiakas;
	private Ostoskori ostoskori;
	private double hinta;
	

	public Tilausrivi(Asiakas asiakas, Ostoskori ostoskori, double hinta) {
		super();
		this.asiakas = asiakas;
		this.ostoskori = ostoskori;
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
		return "Tilausrivi [asiakas=" + asiakas + ", ostoskori=" + ostoskori
				+ ", hinta=" + hinta + "]";
	}

}
