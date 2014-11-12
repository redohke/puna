package fi.omapizzeria.sivusto.bean;

import java.util.ArrayList;

public class Ostoskori {

	private ArrayList<Ostos> ostokset;

	
	public String toString() {
		return "Ostoskori ostokset=" + ostokset;
	}

	public Ostoskori() {
		ostokset = new ArrayList<Ostos>();
	}

	public int tuotteitaKorissa() {
		int tuotteita = 0;

		for (Ostos ostos : ostokset) {
			tuotteita += ostos.getoId();
		}
		return tuotteita;
	}


	int i = 1;

	public void lisaaTuote(Pizza pizza, int lkm, boolean oregano,
			boolean valkosipuli, double rivihinta) {

		int oId = i++;
		Ostos ostos = new Ostos(oId, pizza, lkm, oregano, valkosipuli,
				rivihinta);

		if (ostos != null) {

			ostos.muutaOid(i);

			if (oregano == true && valkosipuli == true) {

				ostokset.add(new Ostos(oId, pizza, lkm, true, true, rivihinta));

			}

			else if (oregano == false && valkosipuli == true) {

				ostokset.add(new Ostos(oId, pizza, lkm, false, true, rivihinta));
			}

			else if (oregano == true && valkosipuli == false) {

				ostokset.add(new Ostos(oId, pizza, lkm, true, false, rivihinta));
			}

			else {

				ostokset.add(new Ostos(oId, pizza, lkm, false, false, rivihinta));
			}

			i = i + 1;
		}

	}

	

	public ArrayList<Ostos> getOstokset() {
		return ostokset;
	}

	public void tyhjenna() {
		ostokset.clear();
	}

	public void poista(Ostos poistettava) {
		Ostos ostos = etsiPoistettava(poistettava);
		try {
			ostokset.remove(ostos);
		} catch (Exception e) {

		}

	}

	private Ostos etsiPoistettava(Ostos etsittava) {
		for (Ostos ostos : ostokset) {
			if (ostos.getoId() == etsittava.getoId()) {

				return ostos;

			}
		}
		return null;
	}

	
	public double getTilauksenHinta() {
		double tilausHinta = 0;

		for (Ostos ostos : ostokset) {
			tilausHinta += ostos.getRivihinta();
		}
		return tilausHinta;
	}
	
	
	
	

	
	/*
	 * public double haeRivihinta() {
	 * 
	 * double rivihinta = 0;
	 * 
	 * for (Ostos pOstos : ostokset) {
	 * 
	 * Pizza pizza = (Pizza) pOstos.getPizza(); rivihinta += (pOstos.getLkm() *
	 * pizza.getHinta()); }
	 * 
	 * return rivihinta; }
	 */

	
	/*
	 * public double hinta() {
		int hinta = 0;

		for (Ostos ostos : ostokset) {
			hinta += ostos.hinta();
		}
		return hinta;
	}*/
	 
	
	
}
