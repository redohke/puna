package fi.omapizzeria.sivusto.service;

import fi.omapizzeria.sivusto.bean.Pizza;
import fi.omapizzeria.sivusto.bean.Tuote;
import fi.omapizzeria.sivusto.bean.Tayte;
import fi.omapizzeria.sivusto.dao.AdminDAO;
import fi.omapizzeria.sivusto.dao.DAOPoikkeus;

public class AdminService {
	
	public AdminService() throws DAOPoikkeus {
		super();
	}
	
	
	public Pizza lisaaTaytteePizzalle() throws DAOPoikkeus{
		
		
		try {
			AdminService aService = new AdminService();
			Pizza uusiPizza = aService.tuoPizza(id);
			
			
			uusiPizza.setTayte(tayte);
			
			
			Tuote uusituote = uusiPizza;
	}

	}
}
	
