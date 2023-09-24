package histoire;

import personnages.Gaulois;
import personnages.Romain;

public class Scenario {

	public static void main(String[] args) {
		// Arrivée D'Asterix
		Gaulois asterix = new Gaulois("Astérix", 8);
		System.out.println("Le Gaulois " + asterix.getNom() + " arrive.");

		// Minus découvre Asterix
		Romain minus = new Romain("Minus", 6);
		System.out.println("Le Romain " + minus.getNom() + " s'aperçoit de l'arrivée du Gaulois.");

		// scénario
		asterix.parler("Bonjour à tous ! ");
		minus.parler("UN GAU... UN GAUGAU...");
		asterix.frapper(minus);
		asterix.frapper(minus);
		asterix.frapper(minus);

	}

}
