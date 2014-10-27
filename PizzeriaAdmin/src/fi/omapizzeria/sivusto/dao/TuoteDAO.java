package fi.omapizzeria.sivusto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import fi.omapizzeria.sivusto.bean.Juoma;
import fi.omapizzeria.sivusto.bean.Pizza;
import fi.omapizzeria.sivusto.bean.Tayte;

public class TuoteDAO extends DAO {

	public TuoteDAO() throws DAOPoikkeus {
		

		try {
			Class.forName(
					DBConnectionProperties.getInstance().getProperty("driver"))
					.newInstance();
		} catch (Exception e) {
			throw new DAOPoikkeus("Tietokannan ajuria ei kyetty lataamaan.", e);
		}
	}

	public ArrayList<Pizza> haePizzat() throws DAOPoikkeus {

		// alkuarvot
		Connection yhteys = null;
		ArrayList<Pizza> pizzalista = new ArrayList<Pizza>();

		try {
			// avataan yhteys tietokantaan
			yhteys = avaaYhteys();

			// Luodaan sql stringistä statement ja suoritetaan sql haku
			String sql = "select id, nimi, hinta from pizza";
			Statement haku = yhteys.createStatement();
			ResultSet rs = haku.executeQuery(sql);

			while (rs.next()) {
				pizzalista.add(new Pizza(rs.getInt("id"), rs.getString("nimi"),
						rs.getDouble("hinta")));
			}

		} catch (Exception e) {
			// heitä virhe jos virhe
			throw new DAOPoikkeus("Tietokantahaku aiheutti virheen", e);
		} finally {
			// yhteys kiinni
			suljeYhteys(yhteys);
		}
		// palautetaan saatu tulos
		return pizzalista;
	}

	public ArrayList<Tayte> haeTaytteetPizzalle(int pizzaId) throws DAOPoikkeus {

		ArrayList<Tayte> taytteet = new ArrayList<Tayte>();
		// alkuarvo yhteydelle
		Connection yhteys = null;
			
		try {
			// avataan yhteys tietokantaan
			yhteys = avaaYhteys();
			
			// haetaan taytteet tietokannasta statementillä laitetaan haun tulokset ResultSetiksis
			String sql = "select ta.nimi, ta.id from taytepizza t join tayte ta on ta.id = t.tayte_id where t.pizza_id = ?";
			PreparedStatement ps = yhteys.prepareStatement(sql);
			ps.setInt(1, pizzaId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				taytteet.add(new Tayte(rs.getInt("id"), rs.getString("nimi")));
			}
		
		} catch (Exception e) {
			// heitä virhe jos virhe
			throw new DAOPoikkeus("Tietokantahaku aiheutti virheen", e);
		} finally {
			// yhteys kii
			suljeYhteys(yhteys);
		}
		// palautetaan täytteet
		return taytteet;
	}

	public ArrayList<Juoma> haeJuomat() throws DAOPoikkeus {
		
		ArrayList<Juoma> juomalista = new ArrayList<Juoma>();
		Connection yhteys = null;

		try {
			yhteys = avaaYhteys();

			// haetaan juomat
			String sql = "select id, nimi, hinta from juoma";
			Statement haku = yhteys.createStatement();
			ResultSet rs = haku.executeQuery(sql);
			
			while (rs.next()) {
				juomalista.add(new Juoma(rs.getInt("id"), rs.getString("nimi"),
						rs.getDouble("hinta")));
			}
		

		} catch (Exception e) {
			// heitä virhe jos virhe
			throw new DAOPoikkeus("Tietokantahaku aiheutti virheen", e);
		} finally {
			// yhteys kii
			suljeYhteys(yhteys);
		}
		// palautetaan juomat
		return juomalista;

	}
}