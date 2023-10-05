package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois;
	private int nbVillageoisMaximum;

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.nbVillageoisMaximum = nbVillageoisMaximum;
		this.villageois = new Gaulois[nbVillageoisMaximum];
		this.nbVillageois = 0;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
}

	public String getNom() {
		return nom;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois <= nbVillageoisMaximum) {
			villageois[nbVillageois] = gaulois;
			System.out.println(gaulois.getNom() + " à été ajouté au " + nom);
			nbVillageois++;
		} else {
			System.out.println("Le village est plein !!!");
		}

	}

	public Gaulois trouverHabitant(int numero) {
		if (numero >= 0 && numero < nbVillageois) {
			return villageois[numero];
		} else {
			System.out.println("Numéro de villageois invalide.");
			return null;
		}

	}

	public void afficherVillageois() {
		System.out.println("Dans le village du Chef " + chef.getNom() + " vivent les légendaires gaulois :");
		for (int i = 0; i < nbVillageois; i++) {
			Gaulois villageois1 = villageois[i];
			if (villageois != null) {
				System.out.println("- " + villageois1.getNom());
			}
		}
	}

	public static void main(String[] args) {
		Village levillage = new Village("Village des Irréductibles", 30);
		// Gaulois gaulois = village.trouverHabitant(30); Numero de villageois invalide
		Chef abraracourcix = new Chef("Abraracourcix", 6, levillage);
		levillage.setChef(abraracourcix);
		Gaulois asterix = new Gaulois("Astérix", 8);
		Gaulois obelix = new Gaulois("Obélix", 25);
		levillage.ajouterHabitant(asterix);
		levillage.ajouterHabitant(obelix);
		// Gaulois gaulois = village.trouverHabitant(1);System.out.println(gaulois); Il
		// n'existe pas de villageois gaulois a la pos 1 du tab
		levillage.afficherVillageois();

	}
}
