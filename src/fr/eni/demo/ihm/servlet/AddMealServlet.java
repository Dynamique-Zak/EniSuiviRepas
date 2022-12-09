package fr.eni.demo.ihm.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.demo.bll.BLLResponse;
import fr.eni.demo.bll.ManagerFactory;
import fr.eni.demo.bll.MealManager;
import fr.eni.demo.bo.Meal;

/**
 * Servlet implementation class AddMealServlet
 */
@WebServlet("/add-meal")
public class AddMealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMealServlet() {
        super();
    }

    /**
     * Version avancée
     * @param request
     * @param response
     * @throws IOException 
     */
    protected void versionAvancee(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	// Instancer meal grace aux données du formulaire
		Meal meal = new Meal(request.getParameter("date"), Integer.parseInt(request.getParameter("hour")));
    		
    	// Ajouter repas
		BLLResponse responseBLL = ManagerFactory.getManagerByClass(MealManager.class).addMeal(meal);
	
		// Ok
		if (responseBLL.isSuccess()) {
			response.getWriter().append(responseBLL.getMessage());
		}
		// Pas OK
		else {
			response.getWriter().append(responseBLL.getMessage());
		}
    }
    
    /**
     * VersionSimple 
     * @param request
     * @param response
     * @throws IOException 
     */
    protected void versionSimple(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	// Instancer meal grace aux données du formulaire
    	Meal meal = new Meal(request.getParameter("date"), Integer.parseInt(request.getParameter("hour")), request.getParameter("aliments"));
    	
    	// Appel la BLL/Manager
    	boolean success = ManagerFactory.getManagerByClass(MealManager.class).addMealSimpleVersion(meal);
		
		if (success) {
			response.getWriter().append("Meal addedd successfully");
		}
		else {
			// refait
			if (meal.getHour() < 0 && meal.getHour() > 24) {
				response.getWriter().append("Hour can't exceed 24 or less 0");
			}
			else {
				response.getWriter().append("Meal error");
			}
		}
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Afficher page Add Meal
		RequestDispatcher rd = request.getRequestDispatcher("add-meal.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Version Simple
		versionSimple(request, response);
		
		// Version Réponse Métier avancée
		// versionAvancee(request, response);
	}

}
