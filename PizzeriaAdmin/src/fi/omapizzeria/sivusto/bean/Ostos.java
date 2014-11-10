package fi.omapizzeria.sivusto.bean;
import fi.omapizzeria.sivusto.bean.Pizza;

public class Ostos {
	
	private int oId;
	private Pizza pizza;
	private int lkm;
	boolean valkosipuli;
	boolean oregano;
	
	
	
	public Ostos(int oId, Pizza pizza, int lkm, boolean oregano, boolean valkosipuli) {
		this.oId = oId;
		this.pizza = pizza;
		this.lkm = lkm;
		this.valkosipuli = valkosipuli;
		this.oregano = oregano;
	}
	

	

	
	
	public double hinta() {
		return oId * pizza.getHinta();
	}
	
	

	
	
	public int getoId() {
		return oId;
	}




	public void setoId(int oId) {
		this.oId = oId;
	}




	public Pizza getPizza() {
		return pizza;
	}




	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}




	public int getLkm() {
		return lkm;
	}




	public void setLkm(int lkm) {
		this.lkm = lkm;
	}



	
	
	public String tuotteenNimi() {
		return pizza.getNimi();
	}
	
	
	public int tuotteenId() {
		return pizza.getId();
	}
	
	
	
	public void muutaOid(int muutos) {
		oId += muutos;
	}
	
	



	@Override
	public String toString() {
		return "Ostos [oId=" + oId + ", pizza=" + pizza + ", lkm=" + lkm
				+ ", valkosipuli=" + valkosipuli + ", oregano=" + oregano + "]";
	}


	



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}