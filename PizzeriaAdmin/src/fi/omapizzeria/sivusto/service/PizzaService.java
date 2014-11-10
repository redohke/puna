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

	// hakee pizzalistan dao:lta
	public List<Pizza> haePizzaLista() throws DAOPoikkeus {
		
		TuoteDAO dao = new TuoteDAO();

		ArrayList<Pizza> pizzalista = dao.haePizzat();
		for(Pizza p : pizzalista) {
			p.setTaytteet(dao.haeTaytteetPizzalle(p.getId()));
		}
		return pizzalista;
	}
	
	// hakee juomalistan dao:lta
	public List<Juoma> haeJuomaLista() throws DAOPoikkeus {
		
		TuoteDAO dao = new TuoteDAO();
		
		ArrayList<Juoma> juomalista = dao.haeJuomat();
		
		return juomalista;
	}
 
	
	public Pizza tuoPizza(int id) throws DAOPoikkeus {
		
		TuoteDAO dao = new TuoteDAO();
		
		Pizza pizza = dao.haePizza(id);
		
		return pizza;
	}
}
