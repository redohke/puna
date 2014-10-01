package fi.omapizzeria.sivusto.dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fi.omapizzeria.sivusto.bean.Tuote;
import fi.omapizzeria.sivusto.bean.Juoma;
import fi.omapizzeria.dao.DAOPoikkeus;
import fi.omapizzeria.dao.Yhteys;

public class TuoteDAO {

	public List<Tuote> haeTuote() throws DAOPoikkeus {

		// luodaan pizzoille arraylist
		ArrayList<Tuote> tuote = new ArrayList<Tuote>();
	
		Connection yhteys = null;

		try {
			
			// ajuri
			Yhteys.lataaAjuri();
			yhteys = Yhteys.avaaYhteys();
			
			// haetaan pizzat
			String sql = "select id, nimi, hinta from pizza";
			Statement haku = yhteys.createStatement();
			ResultSet tulokset = haku.executeQuery(sql);
			
			
			// k‰yd‰‰n haku l‰pi
			while (tulokset.next()) {
				int pid = tulokset.getInt("id");
				String nimi = tulokset.getString("nimi");
				double hinta = tulokset.getDouble("hinta");
				
				String tayte1=null, tayte2=null, tayte3=null, tayte4=null;
				
				// tehd‰‰n uusi haku josta saadaan edellisen haun tuotteen id:n perusteella sen t‰ytteet
				String sql2 = "select ta.nimi from taytepizza t join pizza p on t.pizza_id = p.id join tayte ta on ta.id = t.tayte_id where p.id ="
						+ pid;
				Statement haku2 = yhteys.createStatement();
				ResultSet tulokset2 = haku2.executeQuery(sql2);

				// k‰yd‰‰n t‰ytteet l‰pi
				if (tulokset2.next()) {
					tayte1 = tulokset2.getString("nimi");
					if (tulokset2.next()) {
						tayte2 = tulokset2.getString("nimi");
						if (tulokset2.next()) {
							tayte3 = tulokset2.getString("nimi");
							if (tulokset2.next()) {
								tayte4 = tulokset2.getString("nimi");
							}	
						}
					}
				}

				// sijoitetaan pizzan infot ja taytteen infot constructoriin
						Tuote p = new Tuote(pid, nimi, hinta, tayte1, tayte2, tayte3,
								tayte4);
						tuote.add(p);

			}

		} catch (Exception e) {
			// heit‰ virhe jos virhe
			throw new DAOPoikkeus("Tietokantahaku aiheutti virheen", e);
		} finally {
			// yhteys kii
			Yhteys.suljeYhteys(yhteys);
		}

		// palautetaan pizzat
		return tuote;

	}
	
	public List<Juoma> haeJuoma() throws DAOPoikkeus {
		ArrayList<Juoma> juoma = new ArrayList<Juoma>();
		
		Connection yhteys = null;
		
		try {			
			// ajuri
			Yhteys.lataaAjuri();
			yhteys = Yhteys.avaaYhteys();
			
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
			Yhteys.suljeYhteys(yhteys);
		}

		// palautetaan juomat
		return juoma;
		
	}
}