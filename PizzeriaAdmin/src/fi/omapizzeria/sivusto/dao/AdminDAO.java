package fi.omapizzeria.sivusto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import fi.omapizzeria.sivusto.bean.Pizza;
import fi.omapizzeria.sivusto.dao.DAOPoikkeus;



public class AdminDAO extends DAO {
	
public AdminDAO() throws DAOPoikkeus {
		

		try {
			Class.forName(
					DBConnectionProperties.getInstance().getProperty("driver"))
					.newInstance();
		} catch (Exception e) {
			throw new DAOPoikkeus("Tietokannan ajuria ei kyetty lataamaan.", e);
		}
	}
	
	
	public void lisaaPizza(Pizza p) throws DAOPoikkeus {

		// avataan yhteys
		Connection yhteys = avaaYhteys();

		// pizzojen haku
		try {
			// sql-lause pohja
			String sql = "insert into pizza(nimi, hinta) values(?,?)";
					
			PreparedStatement lause = yhteys.prepareStatement(sql);

			// t‰ytet‰‰n puuttuvat tiedot
			lause.setString(1, p.getNimi());
			lause.setDouble(2, p.getHinta());

			// suoritetaan lause
			lause.executeUpdate();
			
			String sql2 = "SELECT id from pizza ORDER BY id DESC LIMIT 1";
			Statement haku = yhteys.createStatement();
			ResultSet rs = haku.executeQuery(sql2);
			
			
			new pizzatayte(rs.getString(1), )
			
			
			while (rs.next()) {
				pizzalista.add(new Pizza(rs.getInt("id"), rs.getString("nimi"),
						rs.getDouble("hinta"), false, false));
			}
			



			// consoleen pitsan lis‰ys
			System.out.println("lis‰ttiin seuraavat pizzat: " + p);

		} catch (Exception e) {
			// ehk‰ virhe
			throw new DAOPoikkeus("Pizzan lis‰yksest‰ virhe", e);
		} finally {
			// yhteys kii
			suljeYhteys(yhteys);
		}

	}
	
	public void poistaPizza(Pizza p) throws DAOPoikkeus {

		// avataan yhteys
		Connection yhteys = avaaYhteys();

		try {
			// sql alustus
			String sql = "delete from pizza where id=?";
			PreparedStatement lause = yhteys.prepareStatement(sql);

			// laitetaan pizzan id sql stringiin
			lause.setInt(1, p.getId());

			// suoritus
			lause.executeUpdate();

			// consoleen pizzan poisto
			System.out.println("poistettiin pizza: " + p);

		} catch (Exception e) {
			// ehk‰ virhe
			throw new DAOPoikkeus("Pizzan lis‰yksest‰ virhe", e);
		} finally {
			// yhteys kii
			suljeYhteys(yhteys);
		}
	}
	public ArrayList<Pizza> haePizzatAdmin() throws DAOPoikkeus {

		Connection yhteys = null;
		ArrayList<Pizza> pizzalista = new ArrayList<Pizza>();

		try {
			// avataan yhteys tietokantaan
			yhteys = avaaYhteys();

			// Luodaan sql stringist‰ statement ja suoritetaan sql haku
			String sql = "select id, nimi, hinta from pizza";
			Statement haku = yhteys.createStatement();
			ResultSet rs = haku.executeQuery(sql);

			while (rs.next()) {
				pizzalista.add(new Pizza(rs.getInt("id"), rs.getString("nimi"),
						rs.getDouble("hinta"), false, false));
			}

		} catch (Exception e) {
			// heit‰ virhe jos virhe
			throw new DAOPoikkeus("Tietokantahaku aiheutti virheen", e);
		} finally {
			// yhteys kiinni
			suljeYhteys(yhteys);
		}
		// palautetaan saatu tulos
		return pizzalista;
	}
	
	


}
