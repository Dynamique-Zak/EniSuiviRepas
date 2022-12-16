package fr.eni.demo.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.demo.bo.Meal;
import fr.eni.demo.dal.DAOFactory;
import fr.eni.demo.dal.DAOFactorySimple;
import fr.eni.demo.dal.DAOMeal;

public class MealManager extends ManagerBase {

	/**
	 * Version simple 
	 * RG-8596
	 * @param meal
	 * @return
	 */
	public boolean addMealSimpleVersion(Meal meal) {
		// je récupère DAO meal
		DAOMeal daoMeal = DAOFactorySimple.getDAOMeal();
		
		// j'utilise l'insert de dao MEAL
		daoMeal.insert(meal);
		
		return true;
	}
	
	/**
	 * Version generique
	 * RG-8596
	 * @param meal
	 * @return
	 */
	public BLLResponse addMeal(Meal meal) {
		// Partie 1 : Verification métier
		// Préparer une réponse valide
		BLLResponse response = new BLLResponse(200, "Meal addedd successfully");

		// RG-8596-02 :: Si l'heure n'es pas valide
		if (meal.getHour() < 0 && meal.getHour() > 23) {
			response.setCode(700);
			response.setMessage("Hour can't exceed 24 or less 0");
		}
		
		// Partie 2 : Access DAO
		// Si tout est OK
		if (response.isSuccess()) {
			// Insert meal
			DAOFactory.getDAOByClass(DAOMeal.class).insert(meal);
		}
		
		return response;
	}
	
	// =========================================================== //
	// PARTIE 2 - SIMPLE //
	// =========================================================== //
	public List<Meal> getAllMeal(){
		// Select all meal depuis la BDD (la DAO)
		List<Meal> meals = DAOFactorySimple.getDAOMeal().selectAll();
		
		return meals;
	}
	
	// =========================================================== //
	// PARTIE 2 - IGNORER //
	// =========================================================== //
	public BLLResponse<Meal> getMeal(int Id) {
		Meal meal = new Meal("2022-06-01", 10);
		
		BLLResponse<Meal> response = new BLLResponse<Meal>(200, "Success", meal);
		
		System.out.println("Test 5");
		
		return response;
	}
	
	public BLLResponse<List<Meal>> getAllMealGodVersion() {
		List<Meal> meals = new ArrayList<Meal>();
		
		meals.add(new Meal("kqskdjqsjdqsd", 10));
		meals.add(new Meal("Dur", 15));
		
		BLLResponse<List<Meal>> response = new BLLResponse<List<Meal>>(200, "Success", meals);
		
		return response;
	}
}
