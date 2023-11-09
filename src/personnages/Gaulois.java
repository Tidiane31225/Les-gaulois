package personnages;

/**
 * 
 */

public class Gaulois {
	private String nom;
	private int force;
	private int nbtrophees;
	private Equipement[] trophees = new Equipement[100];
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

	/*
	 * private String prendreParole() { return "Le gaulois " + nom + " : ";
	 * 
	 * }
	 */
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";

	}


	/*
	 * public void frapper(Romain romain) { int forceCoup = force / 3 * effetPotion;
	 * System.out.println(nom + " envoie un grand coup dans la mâchoire de " +
	 * romain.getNom()); romain.recevoirCoup(forceCoup); }
	 */
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] trophees1 = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; trophees1 != null && i < trophees1.length; i++, nbtrophees++) {
			this.trophees[nbtrophees] = trophees1[i];

		}

	}


	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merci Druide je sens que ma force est " + effetPotion + " fois plus forte qu'avant");
	}

	public void faireUneDonation(Musee musee) {
		 if (trophees.length > 0) {
				StringBuilder annonce = new StringBuilder(
						"Le gaulois " + this.getNom() + " : « Je donne au musée tous mes trophées :");
		        for (Trophee trophee : trophees) {
		            if (trophee != null) {
		                Equipement equipement = trophee.getEquipement();
		                annonce.append("\n- ").append(equipement.name());
		            }
		        }
		        annonce.append(" »");

		        musee.donnerTrophees(this, trophees);
		        trophees = new Trophee[200];  // Réinitialise le tableau de trophées du Gaulois
		        System.out.println(annonce.toString());
		    }
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
