package fi.omapizzeria.sivusto.bean;

import java.util.List;

public class Pizza extends Tuote {

	private int id;
	private String nimi;
	private double hinta;
	boolean oregano;
	boolean valkosipuli;
	private List<Tayte> taytteet;
		
	
	
	
	public Pizza(int id, String nimi, double hinta, boolean oregano,
			boolean valkosipuli) {
		super();
		this.id = id;
		this.nimi = nimi;
		this.hinta = hinta;
		this.oregano = oregano;
		this.valkosipuli = valkosipuli;
	}
	
	

	public boolean isOregano() {
		return oregano;
	}



	public void setOregano(boolean oregano) {
		this.oregano = oregano;
	}



	public boolean isValkosipuli() {
		return valkosipuli;
	}



	public void setValkosipuli(boolean valkosipuli) {
		this.valkosipuli = valkosipuli;
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
