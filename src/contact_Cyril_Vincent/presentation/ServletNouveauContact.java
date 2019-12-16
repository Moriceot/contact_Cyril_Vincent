package contact_Cyril_Vincent.presentation;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import contact_Cyril_Vincent.entites.Personne;
import contact_Cyril_Vincent.services.PersonneService;

/**
 * Servlet implementation class ServletNouveauContact
 */
@WebServlet("/ServletNouveauContact")
public class ServletNouveauContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB private PersonneService serv;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletNouveauContact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("ServletListeClient");
		
		
		String nom=request.getParameter("Nom");
		String prenom=request.getParameter("Prenom");
		String civilite=request.getParameter("Civilite");
		
		Personne p=new Personne(civilite, nom, prenom);
		
		serv.ajoutPersonne(p);
	
		dispatcher.forward(request, response);
		
	}

}
