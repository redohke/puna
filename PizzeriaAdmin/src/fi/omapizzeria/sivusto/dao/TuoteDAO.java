package fi.omapizzeria.sivusto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fi.omapizzeria.sivusto.bean.Pizza;
import fi.omapizzeria.sivusto.bean.Juoma;
import fi.omapizzeria.sivusto.bean.Tayte;
import fi.omapizzeria.yhteys.DAOPoikkeus;
import fi.omapizzeria.yhteys.DBConnectionProperties;
import fi.omapizzeria.yhteys.Yhteys;

public class TuoteDAO extends Yhteys{
	
	public TuoteDAO() throws DAOPoikkeus {
		try {
			Class.forName(DBConnectionProperties.getInstance().getProperty("driver")).newInstance();
		} catch(Exception e) {
			throw new DAOPoikkeus("Tietokannan ajuria ei kyetty lataamaan.", e);
		}
	}

	public List<Pizza> haeTuote() throws DAOPoikkeus {

		// luodaan pizzoille arraylist
		ArrayList<Pizza> tuote = new ArrayList<Pizza>();
	
		Connection yhteys = null;

		try {
			
			// avataan yhteys tietokantaan
			yhteys = avaaYhteys();
			
			// haetaan pizzat tietokannasta statementill‰
			String sql = "select id, nimi, hinta from pizza";
			Statement haku = yhteys.createStatement();
			ResultSet tulokset = haku.executeQuery(sql);
						
			// k‰yd‰‰n haku l‰pi
			while (tulokset.next()) {
				int pid = tulokset.getInt("id");
				String nimi = tulokset.getString("nimi");
				double hinta = tulokset.getDouble("hinta");
				
				// alkuarvo t‰ytteille
				List<Tayte> taytteet = new ArrayList<Tayte>();
				
				// tehd‰‰n uusi haku josta saadaan edellisen haun tuotteen id:n perusteella sen t‰ytteet
				String sql2 = "select ta.nimi from taytepizza t join pizza p on t.pizza_id = p.id join tayte ta on ta.id = t.tayte_id where p.id ="
						+ pid;
				Statement haku2 = yhteys.createStatement();
				ResultSet tulokset2 = haku2.executeQuery(sql2);

				// k‰yd‰‰n t‰ytteet l‰pi
				while (tulokset2.next()) {
					taytteet.add(new Tayte(tulokset2.getString("nimi")));
				}

				// sijoitetaan pizzan infot ja taytteen infot constructoriin
						Pizza p = new Pizza(pid, nimi, hinta, taytteet);
						System.out.println(p);
						tuote.add(p);

			}

		} catch (Exception e) {
			// heit‰ virhe jos virhe
			throw new DAOPoikkeus("Tietokantahaku aiheutti virheen", e);
		} finally {
			// yhteys kii
			suljeYhteys(yhteys);
		}

		// palautetaan pizzat
		return tuote;

	}
	
	public List<Juoma> haeJuoma() throws DAOPoikkeus {
		ArrayList<Juoma> juoma = new ArrayList<Juoma>();
		
		Connection yhteys = null;
		
		try {			
			yhteys = avaaYhteys();
			
			// haetaan juomat
			String sql = "select id, nimi, hinta from juoma";
			Statement haku = yhteys.createStatement();
			ResultSet tulokset = haku.executeQuery(sql);

			// k‰yd‰‰n haku l‰pi
			while (tulokset.next()) {
				int id = tulokset.getInt("id");
				String nimi = tulokset.getString("nimi");
				double hinta = tulokset.getDouble("hinta");

				// lis‰t‰‰n juoma listaan
				Juoma j = new Juoma(id, nimi, hinta);
				juoma.add(j);
			}

		} catch (Exception e) {
			// heit‰ virhe jos virhe
			throw new DAOPoikkeus("Tietokantahaku aiheutti virheen", e);
		} finally {
			// yhteys kii
			suljeYhteys(yhteys);
		}

		// palautetaan juomat
		return juoma;
		
	}
}