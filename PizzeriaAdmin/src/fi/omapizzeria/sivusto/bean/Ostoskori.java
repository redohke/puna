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

	
	public void lisaaOstoskoriin(Tuote tuote, int lkm, double rivihinta) {
		
		Ostos ostos = new Ostos(tuote, lkm, rivihinta);
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
