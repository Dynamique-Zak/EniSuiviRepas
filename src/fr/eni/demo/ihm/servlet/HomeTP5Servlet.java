package fr.eni.demo.ihm.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.demo.ihm.helper.CookieHelper;

/**
 * Servlet implementation class HomeTP5Servlet
 */
@WebServlet("/home-tp5-servlet")
public class HomeTP5Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// Dictionnaire couleur
	HashMap<String, String> colors = new HashMap<String, String>(){{
		put("bleu", "#006cff");
		put("rouge", "#ff0000");
		put("vert", "#00ff00");
		put("noir", "#000000");
	}};
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeTP5Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Traitement Cookie
		Cookie[] cookies = request.getCookies();
		// Si n'existe pas il sera = null
		Cookie cookieCompteur = CookieHelper.getCookieByName("compteur", cookies);
		
		// PARTIE 1 :: Premiere fois cookie compteur
		// Premiere navigateur
		if (cookieCompteur == null) {
			cookieCompteur = new Cookie("compteur", "1");
		}
		else {
			// On increment de 1
			// ex : Un moment getValue() return 12 donc 12 + 1
			int count = Integer.parseInt(cookieCompteur.getValue()) + 1;
			
			// On remplace
			cookieCompteur.setValue(Integer.toString(count));
		}
		// Repush dans la réponse pour le mettre à jour dans le navigateur
		response.addCookie(cookieCompteur);
		
		// Pour le mettre dans la JSP
		request.setAttribute("compteur", cookieCompteur.getValue());
		request.setAttribute("colors", colors);
		
		// PARTIE 2
		Cookie cookieColorTheme = CookieHelper.getCookieByName("colorTheme", cookies);
		// Par defaut si premier fois noir
		if (cookieColorTheme == null) {
			cookieColorTheme = new Cookie("colorTheme", colors.get("noir"));
			
			// Repush dans la réponse pour le mettre à jour dans le navigateur
			response.addCookie(cookieColorTheme);
		}

		// Mettre la couleur du theme dans le front
		request.setAttribute("colorTheme", cookieColorTheme.getValue());
		
		// Afficher page Home
		RequestDispatcher rd = request.getRequestDispatcher("tp5/home.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récpérer la selection de la couleur
		String selectedColor = request.getParameter("selectedColor");
		
		// Mettre ) jour le cookie)
		response.addCookie(new Cookie("colorTheme", selectedColor));
		
		// Rediriger sur home-tp5-servlet du get
		response.sendRedirect("home-tp5-servlet");
	}

}
