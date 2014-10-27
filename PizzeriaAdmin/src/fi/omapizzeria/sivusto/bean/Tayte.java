package fi.omapizzeria.sivusto.bean;

public class Tayte {
	int id;
	String nimi;
	
	public Tayte(int id, String nimi) {
		this.id = id;
		this.nimi = nimi;
	}

	@Override
	public String toString() {
		return nimi;
	}

}
