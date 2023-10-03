package histoire;

import personnages.Druide;
import personnages.Gaulois;
import personnages.Romain;

public class Scenario {

	public static void main(String[] args) {
		// Arrivée D'Asterix
		Gaulois asterix = new Gaulois("Astérix", 8);
		Gaulois obelix = new Gaulois("Obélix", 25);
		// System.out.println("Le Gaulois " + asterix.getNom() + " arrive.");
		Druide panoramix = new Druide("Panoramix", 5, 10);

		// Minus découvre Asterix
		Romain minus = new Romain("Minus", 6);
		// System.out.println("Le Romain " + minus.getNom() + " s'aperçoit de l'arrivée
		// du Gaulois.");

		// scénario
		panoramix.preparerPotion();
		panoramix.booster(obelix, panoramix);
		obelix.parler("Par Bélénos, ce n'est pas juste !");
		panoramix.booster(asterix, panoramix);
		// asterix.boirePotion(preparerPotion);
		asterix.parler("Bonjour ! ");
		minus.parler("UN GAU... UN GAUGAU...");
		asterix.frapper(minus);

	}

}
