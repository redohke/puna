package fi.omapizzeria.sivusto.service;

import java.util.ArrayList;
import java.util.List;

import fi.omapizzeria.sivusto.bean.Juoma;
import fi.omapizzeria.sivusto.bean.Pizza;
import fi.omapizzeria.sivusto.dao.DAOPoikkeus;
import fi.omapizzeria.sivusto.dao.TuoteDAO;

public class PizzaService {

	public PizzaService() throws DAOPoikkeus {
		super();
	}

	public List<Pizza> haePizzaLista() throws DAOPoikkeus {
		
		TuoteDAO dao = new TuoteDAO();

		ArrayList<Pizza> pizzalista = dao.haePizzat();
		for(Pizza p : pizzalista) {
			p.setTaytteet(dao.haeTaytteetPizzalle(p.getId()));
		}
		return pizzalista;
	}
	

	public List<Juoma> haeJuomaLista() throws DAOPoikkeus {
		
		TuoteDAO dao = new TuoteDAO();
		
		ArrayList<Juoma> juomalista = dao.haeJuomat();
		
		return juomalista;
	}
 

	/*
	 * // k�yd��n haku l�pi while (tulokset.next()) { int id =
	 * tulokset.getInt("id"); String nimi = tulokset.getString("nimi"); double
	 * hinta = tulokset.getDouble("hinta");
	 * 
	 * // lis�t��n juoma listaan Juoma j = new Juoma(id, nimi, hinta);
	 * juoma.add(j); }
	 */
}