package fr.eni.demo.ihm.servlet.simple;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.demo.bll.ManagerFactorySimple;
import fr.eni.demo.bll.MealManager;
import fr.eni.demo.bo.Meal;

/**
 * Servlet implementation class AddMealSimpleServlet
 */
@WebServlet("/add-meal-simple")
public class AddMealSimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMealSimpleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
  
   
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Afficher page Add Meal
		RequestDispatcher rd = request.getRequestDispatcher("simple/add-meal-simple.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Instancer meal grace aux données du formulaire
    	Meal meal = new Meal(request.getParameter("date"), Integer.parseInt(request.getParameter("hour")));
    			
    	// Je récupère le meal manager
    	MealManager mealManager = ManagerFactorySimple.getMealManager();
    	
    	// j'utilise le meal manager (Ajouter un Repas)
    	boolean success = mealManager.addMealSimpleVersion(meal);
		
		if (success) {
			response.getWriter().append("Meal added successfully");
		}
		else {
			response.getWriter().append("Meal error");
		}
	}
		

}
