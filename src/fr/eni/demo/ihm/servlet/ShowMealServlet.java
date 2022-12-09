package fr.eni.demo.ihm.servlet;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class ShowMealServlet
 */
@WebServlet("/show-meal")
public class ShowMealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowMealServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Afficher page Show Meal
	
		// un Objet
		BLLResponse<Meal> responseBLL = ManagerFactory.getManagerByClass(MealManager.class).getMeal(1);
		
		Meal meal = responseBLL.getObject();
		
		// Liste
		BLLResponse<List<Meal>> responseBLL2 = ManagerFactory.getManagerByClass(MealManager.class).getAllMeal();
		List<Meal> meals = responseBLL2.getObject();

		request.setAttribute("meals", meals);
		
		// Afficher la page repas
		RequestDispatcher rd = request.getRequestDispatcher("show-meal.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
