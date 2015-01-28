package fi.omapizzeria.sivusto.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import fi.omapizzeria.sivusto.dao.DAOPoikkeus;
import fi.omapizzeria.sivusto.dao.DBConnectionProperties;
/**
 * T‰m‰n luokka sis‰lt‰‰ metodit jotka avaavat tai sulkevat yhteyden tietokantaan.
 * @author Aleksi, Joona
 *
 */
//testi‰
// MMMMMMMMMMM
public abstract class DAO {

	
/**
 * T‰m‰ metodi avaa yhteyden tietokantaan	.
 * @throws DAOPoikkeus Antaa virheilmoituksen jos tietokantayhteyden avaaminen ep‰onnistuu.
 */
	// metodi, joka avaa yhteyden tietokantaan
	
	public Connection avaaYhteys() throws DAOPoikkeus {
		try {
			return DriverManager.getConnection(DBConnectionProperties
					.getInstance().getProperty("url"), DBConnectionProperties
					.getInstance().getProperty("username"),
					DBConnectionProperties.getInstance()
							.getProperty("password"));
		} catch (Exception e) {
			throw new DAOPoikkeus("Tietokantayhteyden avaaminen ep‰onnistui", e);
		}
	}

/**
 * T‰m‰ metodi sulkee avatun tietokantayhdeyden.
 * @param yhteys Vastaanotettu yhteys
 * @throws DAOPoikkeus Antaa virheilmoituksen jos tietokantayhteyden sulkeminen ep‰onnistuu.
 */
	// sulje yhteys tietokantaan
	public void suljeYhteys(Connection yhteys) throws DAOPoikkeus {
		try {
			if (yhteys != null && !yhteys.isClosed())
				yhteys.close();
		} catch (Exception e) {
			throw new DAOPoikkeus(
					"Tietokantayhteys ei jostain syyst‰ mene kiinni.", e);
		}
	}

}
