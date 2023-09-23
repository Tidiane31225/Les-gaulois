package personnages;

public class Romain {
	private String nom;
	private int force;

	public Romain(String nom, int force) {
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
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
	}

	public static void main(String[] args) {

		// Méthode prendre parole
		Romain cesars = new Romain("Césars", 8);
		String message = cesars.prendreParole();
		// System.out.println(message);

		// Méthode parler
		cesars.parler("Je suis le plus fort !");

		// Méthode recevoirCoup
		cesars.recevoirCoup(3);
		cesars.recevoirCoup(5);
	}
}
