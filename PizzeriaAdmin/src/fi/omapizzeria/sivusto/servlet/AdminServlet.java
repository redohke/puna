package fi.omapizzeria.sivusto.servlet;
 
import java.io.IOException;
import java.util.ArrayList;
 

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 

import fi.omapizzeria.sivusto.bean.Juoma;
import fi.omapizzeria.sivusto.bean.Pizza;
 
import fi.omapizzeria.sivusto.bean.Tayte;
import fi.omapizzeria.sivusto.dao.DAOPoikkeus;
import fi.omapizzeria.sivusto.dao.AdminDAO;
import fi.omapizzeria.sivusto.service.AdminService;

 
/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
        /**
         * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                // TODO Auto-generated method stub
 
 
                                // pizzat listaan
                                ArrayList<Pizza> pizzat;
                                ArrayList<Tayte> taytteet;
                                ArrayList<Juoma> juomat;
                                try {
                                        // tietokannasta pizzat ja taytelista
                                        AdminDAO dao = new AdminDAO();
                                        
                                        pizzat = dao.haePizzatAdmin();                     
                                        taytteet = dao.haeTaytelista();
                                        juomat = dao.haeJuomatAdmin();
                                        
                                } catch (DAOPoikkeus e) {
                                        throw new ServletException(e);
                                }
 
                                // lista requestin attribuutiksi
                                request.setAttribute("plista", pizzat);
                                request.setAttribute("tayte", taytteet);
                                request.setAttribute("jlista", juomat);
 
                                // forwardi .jsp:lle
                                request.getRequestDispatcher("list.jsp").forward(request, response);
 
        }
 
        /**
         * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                // TODO Auto-generated method stub
 
 
                // jos tuleva parametri action on del ajetaan poisto else lisäys
               
             	
                	
                if (request.getParameter("action").equals("add")) {
                		
                	
                // infot formista
                String syotettyNimi = request.getParameter("pizza");
                String syotettyHinta = request.getParameter("hinta");
                int id = 0;
                String valitutTaytteet[];
               
                // hinta stringistä doubleksi
                double d = Double.parseDouble(syotettyHinta);
               
                // html:stä tulleet infot pitsaksi
                Pizza p = new Pizza(id, syotettyNimi, d);
               
                // Checkboxeista tulleet täytteet listaksi
                valitutTaytteet = request.getParameterValues("tayte");
               
               
                try {
                        AdminService aService = new AdminService();
                        // olio lisaysmetodiin
                        aService.viePizza(p, valitutTaytteet);
                       
                       
                } catch (DAOPoikkeus e) {
                        throw new ServletException(e);
                }
               
                // pitsa lisätty -> redirect added parameterillä
                response.sendRedirect("admin?added=true");
               
                }
                 
 
                if (request.getParameter("action").equals("del")){
                    
                    // id formista                 
                    String syotettyId = request.getParameter("id");
                    String nimi = null;
                    double d = 0;
             
                   
                    // int stringistä intiksi
                    int id = Integer.parseInt(syotettyId);
                                           
                    // infot olioksi
                    Pizza p = new Pizza(id, nimi, d);
                   System.out.println(p);
                    
                    try {
                            // uus pizzadao
                            AdminDAO dao = new AdminDAO();
                            // olio poistometodiin
                            dao.poistaPizza(p);
                    } catch (DAOPoikkeus e) {
                            throw new ServletException(e);
                    }
                   
                    // pitsa poistettu -> redirect removed parameterillä
                    response.sendRedirect("admin?removed=true");
                   
            }              
                                       
                if (request.getParameter("action").equals("del2")){
    				
        			// id formista			
        			String syotettyId = request.getParameter("id");
        			String nimi = null;
        			double d = 0;
        			
        			// int stringistä intiksi
        			int id = Integer.parseInt(syotettyId);
        						
        			// infot olioksi
        			Juoma j = new Juoma(id, nimi, d);
        			
        			try {
        				// uus pizzadao
        				AdminDAO dao = new AdminDAO();
        				// olio poistometodiin
        				dao.poistaJuoma(j);
        			} catch (DAOPoikkeus e) {
        				throw new ServletException(e);
        			}
        			
        			// pitsa poistettu -> redirect removed parameterillä
        			response.sendRedirect("admin?removed=true");
        			
        		}
        		 
        		 if (request.getParameter("action").equals("add2")){
        		
        		
        		// infot formista
        		String syotettyNimi = request.getParameter("juoma");

        		String syotettyHinta = request.getParameter("hinta");
        		int id = 0;
        		
        		// hinta stringistä doubleksi
        		double d = Double.parseDouble(syotettyHinta);
        		

        		// infot olioksi
        		Juoma j = new Juoma(id, syotettyNimi, d);
        				

        				
        				try {
        					// uus pizzadao
        					AdminDAO dao = new AdminDAO();
        					// olio lisaysmetodiin
        					dao.lisaaJuoma(j);
        				} catch (DAOPoikkeus e) {
        					throw new ServletException(e);
        				}
        				
        				// pitsa lisätty -> redirect added parameterillä
        				response.sendRedirect("admin?added=true");
        				
        				}



        		 if (request.getParameter("action").equals("piilota")){
        					 
        					// id formista			
        						String syotettyId = request.getParameter("id");
        						String nimi = null;
        						double d = 0;
        						
        						// int stringistä intiksi
        						int id = Integer.parseInt(syotettyId);
        									
        						// infot olioksi
        						Juoma j = new Juoma(id, nimi, d);
        						
        						try {
        							// uus pizzadao
        							AdminDAO dao = new AdminDAO();
        							// olio poistometodiin
        							dao.piilotaJuoma(j);
        						} catch (DAOPoikkeus e) {
        							throw new ServletException(e);
        						}
        						
        						// pitsa piilotettu -> redirect removed parameterillä
        						response.sendRedirect("admin?piilotettu=true");
        	} 
        		 
        		
        		 
        		 if (request.getParameter("action").equals("piilota2")){
					 
 					// id formista			
 						String syotettyId = request.getParameter("id");
 						String nimi = null;
 						double d = 0;
 						
 						// int stringistä intiksi
 						int id = Integer.parseInt(syotettyId);
 									
 						// infot olioksi
 						Pizza p = new Pizza(id, nimi, d);
 						
 						try {
 							// uus pizzadao
 							AdminDAO dao = new AdminDAO();
 							// olio poistometodiin
 							dao.piilotaPizza(p);
 						} catch (DAOPoikkeus e) {
 							throw new ServletException(e);
 						}
 						
 						// pitsa piilotettu -> redirect removed parameterillä
 						response.sendRedirect("admin?piilotettu=true");
 	} 
        		 
        		 if (request.getParameter("action").equals("palauta")){
					 
  					// id formista			
  						String syotettyId = request.getParameter("id");
  						String nimi = null;
  						double d = 0;
  						
  						// int stringistä intiksi
  						int id = Integer.parseInt(syotettyId);
  									
  						// infot olioksi
  						Juoma j = new Juoma(id, nimi, d);
  						
  						try {
  							// uus pizzadao
  							AdminDAO dao = new AdminDAO();
  							// olio poistometodiin
  							dao.palautaJuoma(j);
  						} catch (DAOPoikkeus e) {
  							throw new ServletException(e);
  						}
  						
  						// pitsa piilotettu -> redirect removed parameterillä
  						response.sendRedirect("admin?palautettu=true");
  	} 
 		 
 		 if (request.getParameter("action").equals("palauta2")){
				 
				// id formista			
					String syotettyId = request.getParameter("id");
					String nimi = null;
					double d = 0;
					
					// int stringistä intiksi
					int id = Integer.parseInt(syotettyId);
								
					// infot olioksi
					Pizza p = new Pizza(id, nimi, d);
					
					try {
						// uus pizzadao
						AdminDAO dao = new AdminDAO();
						// olio poistometodiin
						dao.palautaPizza(p);
					} catch (DAOPoikkeus e) {
						throw new ServletException(e);
					}
					
					// pitsa piilotettu -> redirect removed parameterillä
					response.sendRedirect("admin?palautettu=true");
} 
        		 
        }
                
 
        }
    