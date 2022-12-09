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
import fr.eni.demo.bll.ManagerFactorySimple;
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
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Appeler la BLL/Manager poru récuperer tout les repas
		List<Meal> meals = ManagerFactorySimple.getMealManager().getAllMeal();
		
		// Envoyer la liste des repas dans le front/vue/jsp
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
