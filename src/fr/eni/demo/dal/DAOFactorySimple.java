package fr.eni.demo.dal;

public class DAOFactorySimple {

	private static DAOMeal daoMeal = null;
	
	public static DAOMeal getDAOMeal() {
		if (daoMeal == null) {
			daoMeal = new DAOMeal();
		}
		return daoMeal;
	}
}
