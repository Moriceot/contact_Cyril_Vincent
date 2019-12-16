package contact_Cyril_Vincent.presentation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class ServletListeClient
 */
@WebServlet("/ServletListeClient")
public class ServletListeClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB private PersonneService serv;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListeClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("listecontact.jsp");
		
		
		List<Personne> listeContact=new ArrayList<Personne>();
		listeContact=serv.afficherContacts();
		
		request.setAttribute("liste", listeContact);
	
		System.out.println("ok");
		dispatcher.forward(request, response);
	}

}
