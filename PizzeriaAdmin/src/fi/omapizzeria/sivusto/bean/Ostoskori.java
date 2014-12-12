package fi.omapizzeria.sivusto.bean;
import java.util.ArrayList;

/**
 * 
 * T‰m‰ luokka muodostaa ArrayListin Ostos-luokan olioista.
 * @author Aleksi, Elias, Joona
 *
 */

public class Ostoskori {

	private ArrayList<Ostos> ostokset;

	public void setOstokset(ArrayList<Ostos> ostokset) {
		this.ostokset = ostokset;
	}

	public Ostoskori() {
		ostokset = new ArrayList<Ostos>();
	}

	public ArrayList<Ostos> getOstokset() {
		return ostokset;
	}

	/**
	 * Tyhjent‰‰ ArrayListin Ostos olioista.
	 */
	
	
	public void tyhjenna() {
		ostokset.clear();
	}

	

	
	/**
	 * Lis‰‰ k‰ytt‰j‰n valitseman ostoksen ostoskoriin.
	 * Jos Ostos lˆytyy jo korista, kasvatetetaan sen lukum‰‰r‰‰ ja rivin hintaa,
	 * muuten lis‰t‰‰n uusi ostos koriin.

	 * @param ostos Ostoskoriin lis‰tt‰v‰ uusi ostos (eli tilausrivi).
	 */
	
	public void lisaaOstoskoriin(Ostos ostos) {

		//oletetaan, ett‰ samanlaista ostosta (tilausrivi‰) ei lˆydy
		boolean ostosOnUudenlainen = true;

		//k‰yd‰‰n kuitenkin kaikki vanhat ostokset l‰pi
		for (Ostos vanhaOstos : ostokset) {

			//mik‰li samanlainen lˆytyy
			if (ostos.voidaanYhdistaa(vanhaOstos)) {
				//merkit‰‰n lˆydetyksi
				ostosOnUudenlainen = false;
				//kasvatetaan vain vanhan rivin lukum‰‰r‰‰
				int lkm = vanhaOstos.getLkm() + ostos.getLkm();
				vanhaOstos.setLkm(lkm);
				//ja lasketaan uusi hinta
				double hinta = vanhaOstos.getRivihinta() + ostos.getRivihinta();
				vanhaOstos.setRivihinta(hinta);
				//ei tarvitse etsi‰ en‰‰
				break;
			}
		}
		//mik‰li samanlaista ostosta ei lˆytynyt ostoskorista
		if (ostosOnUudenlainen) {
			//lis‰t‰‰n ostos uutena rivin‰
			ostokset.add(ostos);
		}
	}


	/**
	 * Lis‰‰ k‰ytt‰j‰n valitseman ostoksen ostoskoriin.
	 * 
	 * 
	 * @param ostos Koottu Ostos olio.
	 */
/*	 public void lisaaOstoskoriin(Ostos ostos) { 
		 ostokset.add(ostos); 
	 }
*/	 
	 /**
	  * Poistaa k‰ytt‰j‰n valitseman ostoksen ostoskorista.
	  * @param poistettava Vastaanotettu int tietotyyppi
	  */
	 
	public void poistaOstoskorista(int poistettava) {
		ostokset.remove(poistettava);
	}

	
	
	/**
	 * Laskee ostoskorin sis‰lt‰mien ostosten yhteishinnan.
	 * 
	 * @return Ostosten yhteishinnan.
	 */
	
	public double getTilauksenHinta() {
		double tilausHinta = 0;

		for (Ostos ostos : ostokset) {
			tilausHinta += ostos.getRivihinta();
		}
		return tilausHinta;
	}

	@Override
	public String toString() {
		return "Ostoskori [ostokset=" + ostokset + "]";
	}

}
