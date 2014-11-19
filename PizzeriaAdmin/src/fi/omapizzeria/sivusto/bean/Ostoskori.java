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

	public void lisaaPizza(Pizza pizza, Juoma juoma, int lkm, boolean oregano, boolean valkosipuli, double rivihinta) {

		int oId = i++;
		Ostos ostos = new Ostos(oId, pizza, null, lkm, oregano, valkosipuli, rivihinta);

		if (ostos != null) {

			ostos.muutaOid(i);

			if (oregano == true && valkosipuli == true) {

				ostokset.add(new Ostos(oId, pizza, null, lkm, true, true,
						rivihinta));

			}

			else if (oregano == false && valkosipuli == true) {

				ostokset.add(new Ostos(oId, pizza, null, lkm, false, true,
						rivihinta));
			}

			else if (oregano == true && valkosipuli == false) {

				ostokset.add(new Ostos(oId, pizza, null, lkm, true, false,
						rivihinta));
			}

			else {

				ostokset.add(new Ostos(oId, pizza, null, lkm, false, false,
						rivihinta));
			}

		}

	}

	*/
	
	
	
	
	public void lisaaOstoskoriin(Tuote tuote, int lkm, double rivihinta) {
		
		Ostos ostos = new Ostos(tuote, lkm, rivihinta);
		ostokset.add(ostos);
		
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
