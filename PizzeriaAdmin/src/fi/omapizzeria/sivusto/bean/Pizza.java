package fi.omapizzeria.sivusto.bean;

import java.util.List;

public class Pizza extends Tuote {

	
	private List<Tayte> taytteet;
		
	
	
	
	public Pizza(int id, String nimi, double hinta) {
		super();
		this.id = id;
		this.nimi = nimi;
		this.hinta = hinta;
		
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

	public List<Tayte> getTaytteet() {
		return taytteet;
	}

	public void setTaytteet(List<Tayte> taytteet) {
		this.taytteet = taytteet;
	}
		
	@Override
	public String toString() {
		return id + nimi +  hinta + taytteet;
	}
		
}
