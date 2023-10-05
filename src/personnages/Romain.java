package personnages;

public class Romain {
	private String nom;
	private int force;

	public Romain(String nom, int force) {
		this.nom = nom;
		assert force >= 0 : "La force d'un Romain doit être positive ou nulle.";
		this.force = force;

	}

	// private String texte;

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
		assert force >= 0 : "La force d'un Romain doit être positive ou nulle.";
		int actuf = force;
		force -= forceCoup;
		assert actuf > force : "La force du Romain doit diminuée.";
		if (force > 0) {
		parler("Aïe");
		} else {
		parler("J'abandonne...");
		}

	}


	public static void main(String[] args) {

		// Méthode prendre parole
		Romain minus = new Romain("Minus", 6);

		// Méthode parler
		minus.parler("Je suis le plus fort !");

		// Méthode recevoirCoup
		minus.recevoirCoup(1);
		minus.recevoirCoup(5);
	}
}
