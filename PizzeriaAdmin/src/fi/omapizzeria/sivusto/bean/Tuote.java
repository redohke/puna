package fi.omapizzeria.sivusto.bean;

public class Tuote {

	Tuote tuote;
	int id;
	String nimi;
	double hinta;
	boolean oregano;
	boolean valkosipuli;

	
	
	
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

	@Override
	public String toString() {
		return "Tuote [tuote=" + tuote + "]";
	}



	
	
}
