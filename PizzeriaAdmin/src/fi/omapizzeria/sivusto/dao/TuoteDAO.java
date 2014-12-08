package fi.omapizzeria.sivusto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import fi.omapizzeria.sivusto.bean.Juoma;
import fi.omapizzeria.sivusto.bean.Pizza;
import fi.omapizzeria.sivusto.bean.Tayte;

/**
 * T‰m‰ luokka luokka sis‰lt‰‰ metodeja jotka hakevat tietokannasta dataa.
 * 
 * @author Aleksi, Joona
 *
 */
public class TuoteDAO extends DAO {

	/**
	 * T‰m‰ metodi lataa tietokanta Ajurin ja luo uuden instanssin.
	 * @throws DAOPoikkeus Antaa virheilmoituksen jos ajuria ei kyet‰ lataamaan.
	 */
	
	public TuoteDAO() throws DAOPoikkeus {
		

		try {
			Class.forName(
					DBConnectionProperties.getInstance().getProperty("driver"))
					.newInstance();
		} catch (Exception e) {
			throw new DAOPoikkeus("Tietokannan ajuria ei kyetty lataamaan.", e);
		}
	}

	/**
	 * T‰m‰ metodi hakee tietokannasta pizzalistan menuun katseltavaksi.
	 * @return Palauttaa tietokannasta haetun pizzalistan.
	 * @throws DAOPoikkeus Antaa virheilmoituksen jos pizzalistan haku ep‰onnistuu.
	 */
	
	public ArrayList<Pizza> haePizzat() throws DAOPoikkeus {

		Connection yhteys = null;
		ArrayList<Pizza> pizzalista = new ArrayList<Pizza>();

		try {
			// avataan yhteys tietokantaan
			yhteys = avaaYhteys();

			// Luodaan sql stringist‰ statement ja suoritetaan sql haku
			String sql = "select id, nimi, hinta from pizza where tarjolla = 1";
			Statement haku = yhteys.createStatement();
			ResultSet rs = haku.executeQuery(sql);

			while (rs.next()) {
				pizzalista.add(new Pizza(rs.getInt("id"), rs.getString("nimi"),
						rs.getDouble("hinta")));
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
/**
 * T‰m‰ metodi hakee tietokannasta t‰ytteet parametrina saadulle pizzalle.
 * @param pizzaId Pizzan id
 * @return Palauttaa halutulle pizzalle t‰ytteet
 * @throws DAOPoikkeus Antaa virheilmoituksen jos tietokantahaku aiheuttaa virheen.
 */
	public ArrayList<Tayte> haeTaytteetPizzalle(int pizzaId) throws DAOPoikkeus {

		Connection yhteys = null;
		ArrayList<Tayte> taytteet = new ArrayList<Tayte>();
			
		try {
			// avataan yhteys tietokantaan
			yhteys = avaaYhteys();
			
			// haetaan taytteet tietokannasta statementill‰ laitetaan haun tulokset ResultSetiksis
			String sql = "select ta.nimi, ta.id from pizzatayte t join tayte ta on ta.id = t.tayte_id where t.pizza_id = ?";
			PreparedStatement ps = yhteys.prepareStatement(sql);
			ps.setInt(1, pizzaId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				taytteet.add(new Tayte(rs.getInt("id"), rs.getString("nimi")));
			}
		
		} catch (Exception e) {
			// heit‰ virhe jos virhe
			throw new DAOPoikkeus("Tietokantahaku aiheutti virheen", e);
		} finally {
			// yhteys kii
			suljeYhteys(yhteys);
		}
		// palautetaan t‰ytteet
		return taytteet;
	}

/**
 * T‰m‰ metodi hakee tietokannasta juomalistan menuun katseltavaksi.
 * @return Palauttaa tietokannasta haetun juomalistan.
 * @throws DAOPoikkeus Antaa virheilmoituksen jos juomalistan haku ep‰onnistuu.
 */
	public ArrayList<Juoma> haeJuomat() throws DAOPoikkeus {
		
		ArrayList<Juoma> juomalista = new ArrayList<Juoma>();
		Connection yhteys = null;

		try {
			yhteys = avaaYhteys();

			// haetaan juomat
			String sql = "select id, nimi, hinta from juoma where tarjolla = 1";
			Statement haku = yhteys.createStatement();
			ResultSet rs = haku.executeQuery(sql);
			
			while (rs.next()) {
				juomalista.add(new Juoma(rs.getInt("id"), rs.getString("nimi"),
						rs.getDouble("hinta")));
			}
		

		} catch (Exception e) {
			// heit‰ virhe jos virhe
			throw new DAOPoikkeus("Tietokantahaku aiheutti virheen", e);
		} finally {
			// yhteys kii
			suljeYhteys(yhteys);
		}
		// palautetaan juomat
		return juomalista;

	}
	
/**
 * T‰m‰ metodi hakee pizzan MenuServletist‰ vastaanotetun id:n perusteella.	
 * @param id Pizzan id
 * @return Palauttaa tietokannasta haetun pizzan tiedot oliona.
 * @throws DAOPoikkeus Antaa virheilmoituksen jos pizzan haku ep‰onnistuu.
 */
	public Pizza haePizza(int id) throws DAOPoikkeus {

		Pizza pizza = null;
		Connection yhteys = null;
		

		try {
			// avataan yhteys tietokantaan
			yhteys = avaaYhteys();

			// Luodaan sql stringist‰ statement ja suoritetaan sql haku
			String sql = "select id, nimi, hinta from pizza where id = ?";
			
			PreparedStatement ps = yhteys.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
			
			pizza = new Pizza(rs.getInt("id"), rs.getString("nimi"),rs.getDouble("hinta"));
			}

		} catch (Exception e) {
			// heit‰ virhe jos virhe
			throw new DAOPoikkeus("Tietokantahaku aiheutti virheen", e);
		} finally {
			// yhteys kiinni
			suljeYhteys(yhteys);
		}
		// palautetaan saatu tulos
			return pizza;
	}

/**
 * T‰m‰ metodi hakee juoman MenuServletist‰ vastaanotetun id:n perusteella.	
 * @param id Juoman id
 * @return Palauttaa tietokannasta haetun juoma tiedot oliona.
 * @throws DAOPoikkeus Antaa virheilmoituksen jos juoman haku ep‰onnistuu.
 */
	public Juoma haeJuoma(int id) throws DAOPoikkeus {

		Juoma juoma = null;
		Connection yhteys = null;
		

		try {
			// avataan yhteys tietokantaan
			yhteys = avaaYhteys();

			// Luodaan sql stringist‰ statement ja suoritetaan sql haku
			String sql = "select id, nimi, hinta from juoma where id = ?";
			
			PreparedStatement ps = yhteys.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
			
			juoma = new Juoma(rs.getInt("id"), rs.getString("nimi"),rs.getDouble("hinta"));
			}

		} catch (Exception e) {
			// heit‰ virhe jos virhe
			throw new DAOPoikkeus("Tietokantahaku aiheutti virheen", e);
		} finally {
			// yhteys kiinni
			suljeYhteys(yhteys);
		}
		// palautetaan saatu tulos
			return juoma;
	}
	
	
	
}