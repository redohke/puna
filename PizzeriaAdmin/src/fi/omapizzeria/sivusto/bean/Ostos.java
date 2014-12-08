package fi.omapizzeria.sivusto.bean;
import fi.omapizzeria.sivusto.bean.Tuote;



/**
 * 
 * Tämän luokka sisältää Ostos olion tietosisällön.
 * @author Aleksi, Elias, Joona
 *
 */



public class Ostos {
	

	Tuote tuote;
	int lkm;
	double rivihinta;
	boolean oregano, valkosipuli;
	
	
	
	public Ostos(Tuote tuote, int lkm, double rivihinta, boolean oregano, boolean valkosipuli) {

		this.tuote = tuote;
		this.lkm = lkm;
		this.rivihinta = rivihinta; // lkm * tuote.getHinta()
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




	public Tuote getTuote() {
		return tuote;
	}



	public void setTuote(Tuote tuote) {
		this.tuote = tuote;
	}



	public int getLkm() {
		return lkm;
	}



	public void setLkm(int lkm) {
		this.lkm = lkm;
	}



	public double getRivihinta() {
		return rivihinta;
	}



	public void setRivihinta(double rivihinta) {
		this.rivihinta = rivihinta;
	}



	@Override
	public String toString() {
		return "Ostos [tuote=" + tuote + ", lkm=" + lkm + ", rivihinta="
				+ rivihinta + "]";
	}
	
	

	
	
}