package fi.omapizzeria.sivusto.bean;

import java.util.ArrayList;

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

	public void tyhjenna() {
		ostokset.clear();
	}

	/*
	//jos lisaa pitsu+limsu ja sitten limsu niin kosh
	//syy: servletissä ostokseen oregano/valkosipuli oli ostos mikävaan
	public void lisaaOstoskoriin(Ostos ostos) {

		boolean uusi = true;

		for (Ostos o : ostokset) {
			if (o.getTuote().getId() == ostos.getTuote().getId()
					&& o.isOregano() == ostos.isOregano()
					&& o.isValkosipuli() == ostos.isValkosipuli()
					&& ostos.getTuote().getClass().getSimpleName()
							.equals("Pizza")) {

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
*/

	 public void lisaaOstoskoriin(Ostos ostos) { 
		 ostokset.add(ostos); 
	 }
	 
	public void poistaOstoskorista(int poistettava) {
		ostokset.remove(poistettava);
	}

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
