package fi.omapizzeria.sivusto.bean;

import java.util.List;

public class Tuote {

	Tuote tuote;
	int id;
	String nimi;
	double hinta;
	int tarjolla;
	private List<Tayte> taytteet;
	
	public Tuote(int id, String nimi, double hinta, int tarjolla) {
		super();
		this.id = id;
		this.nimi = nimi;
		this.hinta = hinta;
		this.tarjolla = tarjolla;
	}

	public Tuote getTuote() {
		return tuote;
	}
	
	public Tuote() {
		super();
	}

	public void setTuote(Tuote tuote) {
		this.tuote = tuote;
	}

	public Tuote(Tuote tuote) {
		super();
		this.tuote = tuote;
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
	
	public int getTarjolla() {
		return tarjolla;
	}

	public void setTarjolla(int tarjolla) {
		this.tarjolla = tarjolla;
	}

	public List<Tayte> getTaytteet() {
		return taytteet;
	}

	public void setTaytteet(List<Tayte> taytteet) {
		this.taytteet = taytteet;
	}

	@Override
	public String toString() {
		return "Tuote [tuote=" + tuote + ", id=" + id + ", nimi=" + nimi
				+ ", hinta=" + hinta + ", tarjolla=" + tarjolla + ", taytteet="
				+ taytteet + "]";
	}





	
	
}
