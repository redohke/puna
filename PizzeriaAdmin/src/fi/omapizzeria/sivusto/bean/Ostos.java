package fi.omapizzeria.sivusto.bean;
import fi.omapizzeria.sivusto.bean.Pizza;

public class Ostos {
	
	private int lkm;
	private Pizza pizza;
	
	
	
	public Ostos(Pizza pizza) {
		this.lkm = 1;
		this.pizza = pizza;
	}
	

	
	
	public double hinta() {
		return lkm * pizza.getHinta();
	}
	
	
	
	public int lukumaara() {
		return lkm;
	}
	
	
	public String tuotteenNimi() {
		return pizza.getNimi();
	}
	
	
	public int tuotteenId() {
		return pizza.getId();
	}
	
	public void muutaLukumaaraa(int muutos) {
		lkm += muutos;
		if (lkm<0) lkm = 0;
	}




	@Override
	public String toString() {
		return "Ostos [lkm=" + lkm + ", pizza=" + pizza + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}