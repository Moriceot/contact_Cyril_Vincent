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
* @author Cyril Mailh� et Vincent Bourgueil
* Servlet implementation class ServletNouveauContact
* Cette servlet est appel�e lorsque l'on clique sur le bouton "Supprimer" dans la liste des contact (dans la page d'accueil).
* Elle permet de supprimer contact en base. 
* 
* @author Cyril Mailh� et Vincent Bourgueil 
*/
@WebServlet("/ServletSuppressionContact")
public class ServletSuppressionContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * L'attribut serv permet d'utiliser les m�thodes de la classe "PersonneService" dans la servlet.
	 * L'utilisation de l'annotation "EJB" d�l�gue la gestion de ce attribut au serveur et rend toute instanciation inutile.
	 */   
	@EJB private PersonneService serv;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSuppressionContact() {
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
	 * Cette m�thode supprime un contact en r�cup�rant l'id pr�sent sur la ligne
	 * puis redirige vers la page d'accueil
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//R�cup�ration de la personne s�lectionn�e
		long id=Integer.parseInt(request.getParameter("id"));
		
		//Suppression du contact
		serv.supprimerPersonne(id);
		
		//Redirection vers la page d'accueil
		RequestDispatcher dispatcher=request.getRequestDispatcher("ServletListeClient");
		dispatcher.forward(request, response);
	}

}
