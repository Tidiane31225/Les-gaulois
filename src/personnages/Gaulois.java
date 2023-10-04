package personnages;

/**
 * 
 */

public class Gaulois {
	private String nom;
	private int force;
	@SuppressWarnings("unused")
	public int effetPotion = 1;

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");

	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";

	}


	public void frapper(Romain romain) {
		int forceCoup = force / 3 * effetPotion;
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		romain.recevoirCoup(forceCoup);
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}



	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merci Druide je sens que ma force est " + effetPotion + " fois plus forte qu'avant");
	}

	public static void main(String[] args) {
		// TODO créer un main permettant de tester la classe Gaulois }

		Gaulois asterix = new Gaulois("Asterix", 8);
		System.out.println(asterix);
		System.out.println(asterix.getNom());

		// Appel de la méthode prendreParole
		String message = asterix.prendreParole();
		System.out.println(message);

		// Appel de la méthode parler
		asterix.parler("Je vais tous vous battre !");

		// Appel de la méthode BoirePotion
		Druide panoramix = new Druide("Panoramix", 5, 10);
		panoramix.preparerPotion();
		// asterix.boirePotion(panoramix);

		// Appel de la méthode frapper
		Romain minus = new Romain("Minus", 8);
		asterix.frapper(minus);

	}
}
