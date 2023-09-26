package histoire;

import personnages.Druide;
import personnages.Gaulois;
import personnages.Romain;

public class Scenario {

	public static void main(String[] args) {
		// Arrivée D'Asterix
		Gaulois asterix = new Gaulois("Astérix", 8);
		System.out.println("Le Gaulois " + asterix.getNom() + " arrive.");
		Druide druide = new Druide("Panoramix", 1, 10);

		// Minus découvre Asterix
		Romain minus = new Romain("Minus", 6);
		System.out.println("Le Romain " + minus.getNom() + " s'aperçoit de l'arrivée du Gaulois.");

		// scénario
		druide.preparerPotion();
		// asterix.boirePotion(preparerPotion);
		asterix.parler("Bonjour à tous ! ");
		minus.parler("UN GAU... UN GAUGAU...");
		asterix.frapper(minus);
		asterix.frapper(minus);
		asterix.frapper(minus);

	}

}
