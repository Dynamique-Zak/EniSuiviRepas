package fr.eni.demo.bll;

public class ManagerFactorySimple {

	private static MealManager mealManager = null;
	
	public static MealManager getMealManager() {
		if (mealManager == null) {
			mealManager = new MealManager();
		}
		return mealManager;
	}
}
