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


	/**
	 * Tarkistaa, että toinen ostos (tilausrivi) on tarpeeksi samanlainen, jotta rivit voidaan yhdistää
	 * @param toinen ostos, johon verrataan
	 * @return true mikäli sama pizza ja oregano ja valkosipuli matchaa tai sama juoma. Muutoin false.
	 */
	
	
		//Ehtometodi samanlaisen ostoksen (tilausrivin) yhdistämistä varten 
	public boolean voidaanYhdistaa(Ostos toinen) {

			// Tarkastetellaan ehtoja:
		
					// Verrataan jos tuotteen ID löytyy jo jostain ostoskorin sisältävästä tuotteesta
		return toinen.getTuote().getId() == getTuote().getId() &&		
					// Pizzalla ja Juomalla voi olla sama ID, joten täytyy tarkistaa kumpaa niistä tarkoitetaan
				toinen.getTuote().getClass().equals(getTuote().getClass()) &&
					// Tarkastetaan eri Pizzan mausteiden variaatiot
				toinen.isOregano() == isOregano() && 
				toinen.isValkosipuli() == isValkosipuli();
				
	}

	@Override
	public String toString() {
		return "Ostos [tuote=" + tuote + ", lkm=" + lkm + ", rivihinta="
				+ rivihinta + "]";
	}
	
	

	
	
}