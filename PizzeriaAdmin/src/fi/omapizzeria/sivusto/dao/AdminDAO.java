package fi.omapizzeria.sivusto.dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import fi.omapizzeria.sivusto.bean.Juoma;
import fi.omapizzeria.sivusto.bean.Pizza;
import fi.omapizzeria.sivusto.bean.Tayte;
import fi.omapizzeria.sivusto.bean.Tuote;
import fi.omapizzeria.sivusto.dao.DAOPoikkeus;
 
 
/**
 *  T‰m‰n luokka v‰litt‰‰ tietoa Servletin ja Servicen v‰lill‰.
 * @author Aleksi, Joona, Markus
 *
 */

public class AdminDAO extends DAO {
       
	
/**
 * T‰m‰ metodi lataa tietokanta Ajurin ja luo uuden instanssin.
 * 
 * @throws DAOPoikkeus Antaa virheilmoituksen jos ajuria ei kyet‰ lataamaan.
 */
	
public AdminDAO() throws DAOPoikkeus {
                
                try {
                        Class.forName(
                                        DBConnectionProperties.getInstance().getProperty("driver"))
                                        .newInstance();
                } catch (Exception e) {
                        throw new DAOPoikkeus("Tietokannan ajuria ei kyetty lataamaan.", e);
                }
        }
       
/**
 * 
 * T‰m‰ metodi hakee tietokannasta pizzalistan admin paneliin katseltavaksi.
 * @return Palauttaa tietokannasta haetun pizzalistan.
 * @throws DAOPoikkeus Antaa virheilmoituksen jos pizzalistan haku ep‰onnistuu.
 */      
        public ArrayList<Tuote> haePizzatAdmin() throws DAOPoikkeus {
 
                Connection yhteys = null;
                ArrayList<Tuote> pizzalista = new ArrayList<Tuote>();
 
                try {
                        // avataan yhteys tietokantaan
                        yhteys = avaaYhteys();
 
                        // Luodaan sql stringist‰ statement ja suoritetaan sql haku
                        String sql = "select id, nimi, hinta, tarjolla from pizza";
                        Statement haku = yhteys.createStatement();
                        ResultSet rs = haku.executeQuery(sql);
 
                        while (rs.next()) {
                                pizzalista.add(new Tuote(rs.getInt("id"), rs.getString("nimi"),
                                                rs.getDouble("hinta"), rs.getInt("tarjolla")));
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
 * T‰m‰ metodi hakee tietokannasta juomalistan admin paneliin katseltavaksi.
 * @return Palauttaa tietokannasta haetun juomalistan.
 * @throws DAOPoikkeus Antaa virheilmoituksen jos juomalistan haku ep‰onnistuu.
 */
        public ArrayList<Tuote> haeJuomatAdmin() throws DAOPoikkeus {

     		Connection yhteys = null;
     		ArrayList<Tuote> juomalista = new ArrayList<Tuote>();

     		try {
     			// avataan yhteys tietokantaan
     			yhteys = avaaYhteys();

     			// Luodaan sql stringist‰ statement ja suoritetaan sql haku
     			String sql2 = "select id, nimi, hinta, tarjolla from juoma";
     			Statement haku = yhteys.createStatement();
     			ResultSet rs = haku.executeQuery(sql2);

     			while (rs.next()) {
     				juomalista.add(new Tuote(rs.getInt("id"), rs.getString("nimi"),
     						rs.getDouble("hinta"), rs.getInt("tarjolla")));
     			}

     		} catch (Exception e) {
     			// heit‰ virhe jos virhe
     			throw new DAOPoikkeus("Tietokantahaku aiheutti virheen", e);
     		} finally {
     			// yhteys kiinni
     			suljeYhteys(yhteys);
     		}
     		// palautetaan saatu tulos
     		return juomalista;
     	}

/**
 * T‰m‰ metodi hakee tietokannasta t‰ytelistan admin paneliin katseltavaksi.     
 * @return Palauttaa tietokannasta haetun t‰ytelistan.
 * @throws DAOPoikkeus Antaa virheilmoituksen jos t‰ytelistan haku ep‰onnistuu.
 */
        public ArrayList<Tayte> haeTaytelista() throws DAOPoikkeus {

    		Connection yhteys = null;
    		ArrayList<Tayte> taytteet = new ArrayList<Tayte>();
    			
    		try {
    			// avataan yhteys tietokantaan
    			yhteys = avaaYhteys();
    			
    			// haetaan taytteet tietokannasta statementill‰ laitetaan haun tulokset ResultSetiksis
    			String sql = "select id, nimi from tayte";
    			PreparedStatement ps = yhteys.prepareStatement(sql);
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
  * T‰m‰ metodi lis‰‰ tietokantaan AdminServletist‰ l‰hetetyn pizzan.
  * @param p AdminServicelt‰ vastaanotettu lis‰tt‰v‰ Pizza olio.
  * @param tayteLista AdminServicelt‰ vastaanotettu t‰ytelista.
  * @throws DAOPoikkeus Antaa virheilmoituksen jos pizzan lis‰ys ep‰onnistuu.
  */
        public void lisaaPizza(Pizza p, List<Integer> tayteLista) throws DAOPoikkeus {
 
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
                       
                        //haetaan uuden pizzan id
                        String sql2 = "SELECT id from pizza ORDER BY id DESC LIMIT 1";
                        Statement haku = yhteys.createStatement();
                        ResultSet rs = haku.executeQuery(sql2);
                        int pId = 0;
                       
                        if (rs.next()){
                                pId = rs.getInt("id");
                        }
                                                            
                for(int i = 0; i < tayteLista.size(); i++) {
                               
                        //tietokantaan uusi pizza t‰ytteill‰
                        String sql3 = "insert into pizzatayte(pizza_id, tayte_id) values (?,?)";
                        PreparedStatement lause2 = yhteys.prepareStatement(sql3);
               
                       
                        // t‰ytet‰‰n puuttuvat tiedot
                        lause2.setInt(1, pId);
                        lause2.setInt(2, tayteLista.get(i));
                       
                        //suoritetaan lause
                        lause2.executeQuery();
               
                        }
             
                        // consoleen pitsan lis‰ys
                        System.out.println("lis‰ttiin seuraavat pizzat: " + p);
 
                } catch (Exception e) {
                        e.printStackTrace();
                        throw new DAOPoikkeus("Pizzan lis‰yksest‰ virhe", e);
                } finally {
                        // yhteys kii
                        suljeYhteys(yhteys);
                }
 
        }
     
 /**
  * T‰m‰ metodi poistaa MenuServletist‰ valitun pizzan       
  * @param p AdminServicelt‰ vastaanotettu poistettava Pizza olio.
  * @throws DAOPoikkeus Antaa virheilmoituksen jos pizzan poisto ep‰onnistuu.
  */
        public void poistaPizza(Pizza p) throws DAOPoikkeus {
 
                // avataan yhteys
                Connection yhteys = avaaYhteys();
 
                try {
                	
                		int pId = p.getId();
                		
                		
                	
                		String sql = "select id from pizzatayte where pizza_id=?";   
                		PreparedStatement haku = yhteys.prepareStatement(sql);
                		haku.setInt(1, pId);
                		ResultSet rs = haku.executeQuery();
                		
                		
                		while (rs.next()) {
                		
                			String poisto = "delete from pizzatayte where id=?";
                			PreparedStatement poistoStatement = yhteys.prepareStatement(poisto);
                			
                			poistoStatement.setInt(1, rs.getInt("id"));
                			
                			poistoStatement.executeUpdate();
                		}
                	           	
                        // sql alustus
                        String sql2 = "delete from pizza where id=?";
                        PreparedStatement lause = yhteys.prepareStatement(sql2);
 
                        // laitetaan pizzan id sql stringiin
                        lause.setInt(1, p.getId());
 
                        // suoritus
                        lause.executeUpdate();
 
                        // consoleen pizzan poisto
                        System.out.println("poistettiin pizza: " + p);
 
                } catch (Exception e) {
                        // ehk‰ virhe
                		e.printStackTrace();
                        throw new DAOPoikkeus("Pizzan poistamisessa virhe", e);
                } finally {
                        // yhteys kii
                        suljeYhteys(yhteys);
                }
        }

/**
* T‰m‰ metodi piilottaa pizzan Pizzerian ruokalistalta siten ettei sit‰ voi valita ostoskoriin.    
* @param p AdminServicelt‰ vastaanotettu piilotettava Pizza olio.
* @throws DAOPoikkeus Antaa virheilmoituksen jos pizzan piilotus ep‰onnistuu.
*/      
        
        public void piilotaPizza(Pizza p ) throws DAOPoikkeus {


            		// avataan yhteys
            		Connection yhteys = avaaYhteys();

            		try {
            			// sql alustus
            			String sql = "update pizza set tarjolla = '0' where id=?";
            			PreparedStatement lause = yhteys.prepareStatement(sql);

            			// laitetaan pizzan id sql stringiin
            			lause.setInt(1, p.getId());

            			// suoritus
            			lause.executeUpdate();

            			// consoleen juoman piilotus
            			System.out.println("piilotettiin pizza: " + p);

            		} catch (Exception e) {
            			// ehk‰ virhe
            			throw new DAOPoikkeus("Pizzan piilotuksessa virhe", e);
            		} finally {
            			// yhteys kii
            			suljeYhteys(yhteys);
            		}
            	}
      	
 /**
* T‰m‰ metodi palauttaa pizzan Pizzerian ruokalistalle jotta sen voi valita ostoskoriin.    
* @param p AdminServicelt‰ vastaanotettu palautettava Pizza olio.
* @throws DAOPoikkeus Antaa virheilmoituksen jos pizzan palautus ep‰onnistuu.
*/        
        public void palautaPizza(Pizza p) throws DAOPoikkeus {

            		// avataan yhteys
            		Connection yhteys = avaaYhteys();

            		try {
            			// sql alustus
            			String sql = "update pizza set tarjolla = '1' where id=?";
            			PreparedStatement lause = yhteys.prepareStatement(sql);

            			// laitetaan pizzan id sql stringiin
            			lause.setInt(1, p.getId());

            			// suoritus
            			lause.executeUpdate();

            			// consoleen juoman palautus
            			System.out.println("palautettin pizza: " + p);

            		} catch (Exception e) {
            			// ehk‰ virhe
            			throw new DAOPoikkeus("Pizzan palautuksessa virhe", e);
            		} finally {
            			// yhteys kii
            			suljeYhteys(yhteys);
            		}
            	}
             
 /**
  * T‰m‰ metodi lis‰‰ tietokantaan AdminServletist‰ l‰hetetyn juoman.
  * @param j AdminServicelt‰ vastaanotettu lis‰tt‰v‰ Juoma olio.
  * @throws DAOPoikkeus Antaa virheilmoituksen jos juoman lis‰ys ep‰onnistuu.
  */
     
        public void lisaaJuoma(Juoma j) throws DAOPoikkeus {

    		// avataan yhteys
    		Connection yhteys = avaaYhteys();

    		// pizzojen haku
    		try {
    			// sql-lause pohja
    			String sql = "insert into juoma(nimi, hinta) values(?,?)";
    					
    			PreparedStatement lause = yhteys.prepareStatement(sql);

    			// t‰ytet‰‰n puuttuvat tiedot
    			lause.setString(1, j.getNimi());
    			lause.setDouble(2, j.getHinta());
    			

    			// suoritetaan lause
    			lause.executeUpdate();
    			
    			// consoleen pitsan lis‰ys
    			System.out.println("lis‰ttiin seuraavat juomat: " + j);

    		} catch (Exception e) {
    			// ehk‰ virhe
    			throw new DAOPoikkeus("Juoman lis‰yksest‰ virhe", e);
    		} finally {
    			// yhteys kii
    			suljeYhteys(yhteys);
    		}

    	}
        
/**
 * T‰m‰ metodi poistaa MenuServletist‰ valitun juoman.        
 * @param j AdminServicelt‰ vastaanotettu poistettava Juoma olio.
 * @throws DAOPoikkeus Antaa virheilmoituksen jos juoman poisto ep‰onnistuu.
 */
        
        public void poistaJuoma(Juoma j) throws DAOPoikkeus {

    		// avataan yhteys
    		Connection yhteys = avaaYhteys();

    		try {
    			// sql alustus
    			String sql = "delete from juoma where id=?";
    			PreparedStatement lause = yhteys.prepareStatement(sql);

    			// laitetaan pizzan id sql stringiin
    			lause.setInt(1, j.getId());

    			// suoritus
    			lause.executeUpdate();

    			// consoleen pizzan poisto
    			System.out.println("poistettiin juoma: " + j);

    		} catch (Exception e) {
    			// ehk‰ virhe
    			throw new DAOPoikkeus("Juoman poistamisessa virhe", e);
    		} finally {
    			// yhteys kii
    			suljeYhteys(yhteys);
    		}
    	}
            
/**
 * T‰m‰ metodi piilottaa juoman Pizzerian ruokalistalta siten ettei sit‰ voi valita ostoskoriin.    
 * @param j AdminServicelt‰ vastaanotettu piilotettava Juoma olio.
 * @throws DAOPoikkeus Antaa virheilmoituksen jos juoman piilotus ep‰onnistuu.
 */
        public void piilotaJuoma(Juoma j ) throws DAOPoikkeus {

    		// avataan yhteys
    		Connection yhteys = avaaYhteys();

    		try {
    			// sql alustus
    			String sql = "update juoma set tarjolla = '0' where id=?";
    			PreparedStatement lause = yhteys.prepareStatement(sql);

    			// laitetaan pizzan id sql stringiin
    			lause.setInt(1, j.getId());

    			// suoritus
    			lause.executeUpdate();

    			// consoleen juoman piilotus
    			System.out.println("piilotettiin juoma: " + j);

    		} catch (Exception e) {
    			// ehk‰ virhe
    			throw new DAOPoikkeus("Juoman piilotuksessa virhe", e);
    		} finally {
    			// yhteys kii
    			suljeYhteys(yhteys);
    		}
    	}
/**
 * T‰m‰ metodi palauttaa juoman Pizzerian ruokalistalle jotta sen voi valita ostoskoriin.    
 * @param j AdminServicelt‰ vastaanotettu palautettava Juoma olio.
 * @throws DAOPoikkeus Antaa virheilmoituksen jos juoman palautus ep‰onnistuu.
 */
    	public void palautaJuoma(Juoma j) throws DAOPoikkeus {

    		// avataan yhteys
    		Connection yhteys = avaaYhteys();

    		try {
    			// sql alustus
    			String sql = "update juoma set tarjolla = '1' where id=?";
    			PreparedStatement lause = yhteys.prepareStatement(sql);

    			// laitetaan pizzan id sql stringiin
    			lause.setInt(1, j.getId());

    			// suoritus
    			lause.executeUpdate();

    			// consoleen juoman palautus
    			System.out.println("palautettin juoma: " + j);

    		} catch (Exception e) {
    			// ehk‰ virhe
    			throw new DAOPoikkeus("Juoman palautuksessa virhe", e);
    		} finally {
    			// yhteys kii
    			suljeYhteys(yhteys);
    		}
    	}
}	
