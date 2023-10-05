package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;

	public Romain(String nom, int force) {
		this.nom = nom;
		assert force >= 0 : "La force d'un Romain doit être positive ou nulle.";
		this.force = force;
		this.equipements = new Equipement[2];

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

	// Méthode pour équiper le Romain
	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 0:
			equipements[nbEquipement] = equipement;
			nbEquipement++;
			parler("s'équipe avec un " + equipement.getNom() + ".");
			break;
		case 1:
			if (equipements[0] == equipement) {
				parler("possède déjà un " + equipement.getNom() + " !");
			} else {
				equipements[nbEquipement] = equipement;
				nbEquipement++;
				parler("s'équipe avec un " + equipement.getNom() + ".");
			}
			break;
		case 2:
			parler("est déjà bien protégé !");
			break;
		}
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

		// Enum equipements
		Equipement casque = Equipement.CASQUE;
		Equipement bouclier = Equipement.BOUCLIER;

		System.out.println("Equipement 1 : " + casque);
		System.out.println("Equipement 2 : " + bouclier);

		// Méthode prendre parole
		Romain minus = new Romain("Minus", 6);

		// Romain s'equipe
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);

		// Méthode parler
		minus.parler("Je suis le plus fort !");

		// Méthode recevoirCoup
		minus.recevoirCoup(1);
		minus.recevoirCoup(5);
	}
}
