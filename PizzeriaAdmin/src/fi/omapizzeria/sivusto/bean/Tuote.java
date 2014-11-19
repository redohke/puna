package fi.omapizzeria.sivusto.bean;

public class Tuote {

	Tuote tuote;

	
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

	@Override
	public String toString() {
		return "Tuote [tuote=" + tuote + "]";
	}



	
	
}
