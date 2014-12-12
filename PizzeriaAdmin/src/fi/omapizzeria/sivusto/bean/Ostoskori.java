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

		// Oletusarvona lis‰tt‰v‰ ostos olisi uniikki
		boolean ostosOnUudenlainen = true;

		// K‰yd‰‰n kaikki jo ostoskorissa olevat ostokset l‰pi
		for (Ostos vanhaOstos : ostokset) {

			// Jos luuppi lˆyt‰‰ ostoksen joka t‰ytt‰‰ ehdot
			
			if (ostos.voidaanYhdistaa(vanhaOstos)) {
				//  Ostos ei ole uudenlainen
				ostosOnUudenlainen = false;
				// Haetaan vanha ostoksen (tilausrivin) lukum‰‰r‰ ja kasvatetaan sit‰ lis‰tt‰v‰n ostoksen lukum‰‰r‰ll‰
				int lkm = vanhaOstos.getLkm() + ostos.getLkm();
				vanhaOstos.setLkm(lkm);
				
				// Haetaan vanhan ostoksen (tilausrivin) hinta ja lis‰t‰‰n siihen lis‰tt‰v‰n ostoksen hinta
				double hinta = vanhaOstos.getRivihinta() + ostos.getRivihinta();
				vanhaOstos.setRivihinta(hinta);
				
				// Muutosten j‰lkeen luuppia on turha jatkaa joten se voidaan katkaista
				break;
			}
		}
		// Mik‰li luuppi ei lˆyd‰ samanlaista ostosta (tilausrivi‰),
		if (ostosOnUudenlainen) {
			// lis‰t‰‰n ostos uutena rivin‰.
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
