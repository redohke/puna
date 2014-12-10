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
	 * Jos Ostos lˆytyy jo korista, kasvatetetaan sen lukum‰‰r‰‰, muuten lis‰t‰‰n uusi ostos-
	 * 
	 * 
	 * @param ostos Koottu Ostos olio.
	 */
	
	public void lisaaOstoskoriin(Ostos ostos) {

		boolean uusi = true;

		for (Ostos o : ostokset) {
			
			if (o.getTuote().getId() == ostos.getTuote().getId()
					&& o.isOregano() == ostos.isOregano()
					&& o.isValkosipuli() == ostos.isValkosipuli()
					&& o.getTuote().getClass().getSimpleName().equals("Pizza") == 
					ostos.getTuote().getClass().getSimpleName().equals("Pizza")) {

				uusi = false;
				
				int lkm = o.getLkm() + ostos.getLkm();
				o.setLkm(lkm);

				double hinta = o.getRivihinta() + ostos.getRivihinta();
				o.setRivihinta(hinta);
			}
		}
			if (uusi) {
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
