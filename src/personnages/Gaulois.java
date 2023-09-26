package personnages;

/**
 * 
 */
public class Gaulois {
	private String nom;
	private int force;
	@SuppressWarnings("unused")
	private int effetPotion = 1;

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
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		romain.recevoirCoup(force / 3);
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}

	public int effetPotion = 1;

	public void boirePotion(Druide preparerPotion) {
		System.out.println("Merci Druide je sens que ma force est " + preparerPotion + " fois plus forte qu'avant");
	}

	public static void main(String[] args) {
		// TODO créer un main permettant de tester la classe Gaulois }

		Gaulois asterix = new Gaulois("Asterix", 8);
		System.out.println(asterix);
		System.out.println(asterix.getNom());

		// Appel de la méthode prendreParole
		String message = asterix.prendreParole();
		// System.out.println(message);

		// Appel de la méthode parler
		asterix.parler("Je vais tous vous battre !");

		// Appel de la méthode frapper
		Romain minus = new Romain("Minus", 8);
		asterix.frapper(minus);

	}
}
