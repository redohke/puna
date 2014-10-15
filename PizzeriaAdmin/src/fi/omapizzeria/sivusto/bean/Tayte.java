package fi.omapizzeria.sivusto.bean;

public class Tayte {
	int id;
	String nimi;
	
	public Tayte(String nimi) {
		this.nimi = nimi;
	}

	@Override
	public String toString() {
		return nimi;
	}

}
