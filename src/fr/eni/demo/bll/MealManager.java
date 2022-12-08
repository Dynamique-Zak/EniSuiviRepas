package fr.eni.demo.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.demo.bo.Meal;
import fr.eni.demo.dal.DAOFactory;
import fr.eni.demo.dal.DAOMeal;

public class MealManager extends ManagerBase {

	/**
	 * Version simple 
	 * @param meal
	 * @return
	 */
	public boolean addMealSimpleVersion(Meal meal) {
		
		boolean success = true;
		
		// RG-8596-02 :: Si l'heure n'es pas valide
		if (meal.getHour() < 0 && meal.getHour() > 23) {
			success = false;
		}
		
		// Si tout est OK
		if (success) {
			// Insert meal
			DAOFactory.getDAOByClass(DAOMeal.class).insert(meal);
		}
		
		return success;
	}
	
	/**
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
	
	public BLLResponse<Meal> getMeal(int Id) {
		Meal meal = new Meal("2022-02-01", 10);
		
		BLLResponse<Meal> response = new BLLResponse<Meal>(200, "Success", meal);
		
		return response;
	}
	
	public BLLResponse<List<Meal>> getAllMeal() {
		List<Meal> meals = new ArrayList<Meal>();
		
		meals.add(new Meal("kqskdjqsjdqsd", 10));
		meals.add(new Meal("Dur", 15));
		
		BLLResponse response = new BLLResponse(200, "Success", meals);
		
		return response;
	}
}
