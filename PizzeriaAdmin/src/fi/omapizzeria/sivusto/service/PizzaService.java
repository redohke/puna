package fi.omapizzeria.sivusto.service;

import java.util.ArrayList;
import java.util.List;

import fi.omapizzeria.sivusto.bean.Juoma;
import fi.omapizzeria.sivusto.bean.Pizza;
import fi.omapizzeria.sivusto.dao.DAOPoikkeus;
import fi.omapizzeria.sivusto.dao.TuoteDAO;

/**
 * Tämä luokka välittää pyyntöjä MenuServletin ja TuoteDAO:n välillä
 * @author Aleksi, Joona
 *
 */

public class PizzaService {

	public PizzaService() throws DAOPoikkeus {
		super();
	}

	/**
	 * Välittää TuoteDAO:lle pyynnön hakea pitsa ja täytelistat, sekä kokoaa ne yhdeksi listaksi.
	 * @return palauttaa TuoteDAO:lta saaduista tiedoista kootun pizzalistan.
	 * @throws DAOPoikkeus
	 */
	// hakee pizzalistan dao:lta
	public List<Pizza> haePizzaLista() throws DAOPoikkeus {
		
		TuoteDAO dao = new TuoteDAO();

		ArrayList<Pizza> pizzalista = dao.haePizzat();
		
		//suorittaan täytehaun tietokannasta ja yhdistää ne pizzaolioon
		for(Pizza p : pizzalista) {
			p.setTaytteet(dao.haeTaytteetPizzalle(p.getId()));
		}
		return pizzalista;
	}
	
	/**
	 * Välittää TuoteDAO:lle pyynnön hakea juomalistan.
	 * @return palauttaa TuoteDAO:lta saadun juomalistan.
	 * @throws DAOPoikkeus
	 */
	// hakee juomalistan dao:lta
	public List<Juoma> haeJuomaLista() throws DAOPoikkeus {
		
		TuoteDAO dao = new TuoteDAO();
		
		ArrayList<Juoma> juomalista = dao.haeJuomat();
		
		return juomalista;
	}
 
	/**
	 * Tämä metodi välittää hakupyynnön TuoteDAO:lle, asiakkaan lisätessä yksittäisen tuotteen ostoskoriin.
	 * @param id Tuotteen id.
	 * @return Palauttaa id:n perusteella tuodun pizzan.
	 * @throws DAOPoikkeus
	 */
	
	public Pizza tuoPizza(int id) throws DAOPoikkeus {
		
		TuoteDAO dao = new TuoteDAO();
		
		Pizza pizza = dao.haePizza(id);
		pizza.setTaytteet(dao.haeTaytteetPizzalle(pizza.getId()));
		
		return pizza;
	}
	
	/**
	 * Tämä metodi välittää hakupyynnön TuoteDAO:lle, asiakkaan lisätessä yksittäisen tuotteen ostoskoriin.
	 * @param id Tuotteen id.
	 * @return Palauttaa id:n perusteella tuodun juoman.
	 * @throws DAOPoikkeus
	 */
	
	public Juoma tuoJuoma(int id) throws DAOPoikkeus {
		
		TuoteDAO dao = new TuoteDAO();
		
		Juoma juoma = dao.haeJuoma(id);
		
		return juoma;
	}
	
}
