package fr.eni.demo.bll;

import java.util.ArrayList;
import java.util.List;

public class ManagerFactory {

	private static List<ManagerBase> ManagerInstances = new ArrayList<ManagerBase>();
	
	@SuppressWarnings("unchecked")
	public static <T extends ManagerBase> T getManagerInList(Class<T> type) {
		for (ManagerBase managerBase : ManagerInstances) {
			if (managerBase.getClass() == type) {
				return (T) managerBase;
			}
		}
		// Si pas trouvé = null
		return null;
	}
	
	/**
	 * T extends ManagerBase = Une classe qui doit au moins hérité de ManagerBase
	 * A partir du "type" tout les T vont être remplacé par la valeur de "type" equi est un nom de classe
	 * Example : ManagerPerson
	 * @param type Le nom de la classe attendu
	 * @return Le Manager entrée en parametre
	 */
	public static <T extends ManagerBase> T getManagerByClass(Class<T> type) {
		
		// Par défaut on essaie de prendre une dao deja instancié
		// Si pas trouvé = sinon c'est null
		T object = getManagerInList(type);
		
		try {
			// Si l'objet est null (donc pas trouvé)
			if (object == null) {
				// On instance le manager
				// J'appel le constructeur par défaut de la classe mis en parametre
				object = (T) type.newInstance();
				
				// Ajouter à la liste des maanager instanciés
				ManagerInstances.add(object);
			}
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		// Retourne la manager casté
		return type.cast(object);
	}
}
